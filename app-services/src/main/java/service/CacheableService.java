package service;

import caching.Cache;
import caching.CacheFactory;
import caching.Cacheable;
import caching.CachingStrategy;
import dao.AppDao;

import java.lang.reflect.Method;
import java.text.ParseException;

public class CacheableService implements AppService {
    private Cache<String, String> cache;
    private AppService appService;

    public CacheableService(AppService appService) {
        this.appService = appService;
        Class<? extends AppService> aClass = appService.getClass();

        try {
            Method getDayOfWeek = aClass.getMethod("getDayOfWeek", String.class);
            Cacheable annotation = getDayOfWeek.getAnnotation(Cacheable.class);
            CachingStrategy strategy = annotation.strategy();
            int size = annotation.size();

            cache = new CacheFactory<String, String>().getCache(strategy, size);
        } catch (NoSuchMethodException e) {

        }
    }

    public String getDayOfWeek(String dateString) throws ParseException {
        String dayOfWeek =  cache.get(dateString);
        if (dayOfWeek == null) {
            dayOfWeek = appService.getDayOfWeek(dateString);
            cache.put(dateString, dayOfWeek);
        }
        return dayOfWeek;
    }

    public void setDao(AppDao dao) {
        appService.setDao(dao);
    }

    public Cache<String, String> getCache() {
        return cache;
    }

    public void setCache(Cache<String, String> cache) {
        this.cache = cache;
    }
}
