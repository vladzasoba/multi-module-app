package caching;

import caching.cache.Cache;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CacheableInvocationHandler<K, V> implements InvocationHandler {
    private final Map<String, Method> methods = new HashMap<>();
    private final Map<String, Cache<K, V>> caches = new HashMap<>();
    private Object targetObj;


    public CacheableInvocationHandler(Cacheable cacheable) throws CacheException {
        targetObj = cacheable;
        CacheableMethod annotation;
        for (Method method: cacheable.getClass().getDeclaredMethods()) {
            annotation = method.getAnnotation(CacheableMethod.class);

            if (annotation != null) {
                int size = annotation.size();
                Class strategy = annotation.strategy();
                Class[] interfaces = strategy.getInterfaces();

                Cache<K, V> cache = null;
                if (interfaces.length != 0) {
                    try {
                        for (Class inf : interfaces) {
                            if (inf.equals(Cache.class)) {
                                Constructor constructor = strategy.getConstructor(int.class);
                                cache = (Cache<K, V>) constructor.newInstance(size);
                                break;
                            }
                        }
                    } catch (NoSuchMethodException e) {
                        throw new CacheException(String.format("No constructor of type '%s' defined in class %s",
                                strategy.getSimpleName(), strategy.getSimpleName()));
                    } catch (InstantiationException | InvocationTargetException e) {
                        throw  new CacheException(String.format("Cannot invoke constructor of class '%s'", strategy.getSimpleName()));
                    } catch (IllegalAccessException e) {
                        throw new CacheException(String.format("Constructor of class '%s' must have public access",
                                strategy.getSimpleName()));
                    }
                }
                if (cache == null) {
                    throw  new CacheException(String.format("Class '%s' must implement 'Cache' interface",
                            strategy.getSimpleName()));
                }

                this.methods.put(method.getName(), method);
                this.caches.put(method.getName(), cache);
            }
        }
        if (methods.size() == 0) {
            throw new CacheException(String.format(
                    "The are no methods annotated by '@CacheableMethod' annotation in '%s' class",
                    cacheable.getClass().getSimpleName()));
        }
    }

    public V invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method methodOfClass = this.methods.get(method.getName());
        Cache cache = this.caches.get(method.getName());

        Object o = cache.get(args[0]);
        if (o == null) {
            o = methodOfClass.invoke(targetObj, args);
            cache.put(args[0], o);
        }

        return (V) o;
    }
}
