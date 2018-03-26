package service;

import caching.Cache;
import dao.AppDao;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class CacheableServiceTest {
    private AppService appService = Mockito.mock(AppService.class);
    private Cache cache = Mockito.mock(Cache.class);
    private AppDao appDao = Mockito.mock(AppDao.class);
    private String dateString = "01.03.2018";
    private String expectedDayOfWeek = "Thursday";

    @Test
    public void getDayOfWeek_cacheReturnsString_test() throws ParseException {
        CacheableService cacheableService = new CacheableService(new AppServiceImpl());
        cacheableService.setCache(cache);
        Mockito.when(cache.get(dateString)).thenReturn(expectedDayOfWeek);

        String dayOfWeekActual = cacheableService.getDayOfWeek(dateString);

        Assert.assertEquals(expectedDayOfWeek, dayOfWeekActual);
    }

    @Test
    public void getDayOfWeek_cacheReturnsNull_test() throws ParseException {
        AppService service = new AppServiceImpl();
        CacheableService cacheableService = new CacheableService(service);
        service.setDao(appDao);;

        Mockito.when(appDao.getDayOfWeek(Mockito.any(Date.class))).thenReturn(expectedDayOfWeek);
        Mockito.when(cache.get(dateString)).thenReturn(null);
        Mockito.when(this.appService.getDayOfWeek(dateString)).thenReturn(null);

        String dayOfWeek = cacheableService.getDayOfWeek(dateString);

        Assert.assertEquals(expectedDayOfWeek, dayOfWeek);
    }

}
