package service;

import caching.Cacheable;
import caching.CachingStrategy;
import dao.AppDao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AppServiceImpl implements AppService {
    private AppDao dao;

    @Cacheable(strategy = CachingStrategy.LRU, size = 5)
    public String getDayOfWeek(String dateString) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        simpleDateFormat.setLenient(false);
        Date date = simpleDateFormat.parse(dateString);

        return dao.getDayOfWeek(date);
    }

    public void setDao(AppDao dao) {
        this.dao = dao;
    }
}
