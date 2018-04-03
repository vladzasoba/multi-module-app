package caching;

import java.lang.reflect.Proxy;

public class CacheableProxy<K, V> {
    private Object proxy;

    public CacheableProxy(Cacheable cacheable, Class type) throws CacheException {
        proxy = Proxy.newProxyInstance(
                CacheableInvocationHandler.class.getClassLoader(),
                new Class[] { type },
                new CacheableInvocationHandler<K, V>(cacheable));
    }

    public Object getProxy() {
        return proxy;
    }
}
