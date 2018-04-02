package caching.cache;

public class CacheFactory<K, V> {
    public Cache<K, V> getCache(CacheStrategy strategy, int size) {
        switch (strategy) {
            case LRU:
                return new LRUCache<>(size);
                default:
                    return null;
        }
    }
}
