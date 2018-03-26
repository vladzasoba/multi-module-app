package caching;

public class CacheFactory<K, V> {
    public Cache<K, V> getCache(CachingStrategy cachingStrategy, int size) {
        switch (cachingStrategy) {
            case LRU:
                return new LRUCache<>(size);
                default: return null;
        }
    }
}
