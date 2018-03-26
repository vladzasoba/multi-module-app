package service;

import dao.AppDao;
import dao.AppDaoImpl;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.text.ParseException;
import java.util.Locale;

public class CacheableServiceIntegrationTest {
    private AppDao appDao = new AppDaoImpl();
    private String dateString = "01.03.2018";
    private String expectedDayOfWeek = "Thursday";

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeClass
    public static void setUp() {
        Locale.setDefault(new Locale("en_US"));
    }

    @Test
    public void getDayOfWeek_ParseExecption_test() throws ParseException {
        AppService appService = new AppServiceImpl();
        CacheableService cacheableService = new CacheableService(appService);

        thrown.expect(ParseException.class);
        cacheableService.getDayOfWeek("01/03/2018");
    }

    @Test
    public void getDayOfWeek_returnsString_test() throws ParseException {
        AppService appService = new AppServiceImpl();
        appService.setDao(appDao);
        AppService cacheableService = new CacheableService(appService);

        String dayOfWeekActual = cacheableService.getDayOfWeek(dateString);

        Assert.assertEquals(expectedDayOfWeek, dayOfWeekActual);
    }
}
