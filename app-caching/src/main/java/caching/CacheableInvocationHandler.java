package caching;

import caching.cache.Cache;
import caching.cache.CacheFactory;
import caching.cache.CacheStrategy;

import java.lang.reflect.InvocationHandler;
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
                CacheStrategy strategy = annotation.strategy();
                this.methods.put(method.getName(), method);
                this.caches.put(method.getName(), new CacheFactory<K, V>().getCache(strategy, size));
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
