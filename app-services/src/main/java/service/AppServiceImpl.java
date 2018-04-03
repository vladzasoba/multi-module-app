package service;

import caching.Cacheable;
import caching.CacheableMethod;
import caching.cache.LRUCache;
import dao.AppDao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AppServiceImpl implements AppService, Cacheable {
    private AppDao dao;

    @CacheableMethod(strategy = LRUCache.class, size = 12)
    public String getDayOfWeek(String dateString) throws ParseException {
        Locale.setDefault(new Locale("en_US"));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        simpleDateFormat.setLenient(false);
        Date date = simpleDateFormat.parse(dateString);

        return dao.getDayOfWeek(date);
    }

    public void setDao(AppDao dao) {
        this.dao = dao;
    }
}
