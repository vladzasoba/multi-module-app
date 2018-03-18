package service;

import dao.AppDao;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.util.Locale;

public class AppServiceIntegrationTest {
    private AppService appService = new AppService();
    private AppDao appDao = new AppDao();

    @Test(expected = ParseException.class)
    public void getDayOfWeek_ParseException_test() throws ParseException {
        appService.getDayOfWeek("01/03/2018");
    }

    @Test
    public void getDayOfWeek_returnsString_test() throws ParseException {
        appService.setDao(appDao);

        Locale aDefault = Locale.getDefault();
        if (!aDefault.getLanguage().equals("en_US")) {
            Locale.setDefault(new Locale("en_US"));
        }

        String dayOfWeekActual = appService.getDayOfWeek("01.03.2018");

        Locale.setDefault(aDefault);

        Assert.assertEquals("Thursday", dayOfWeekActual);
    }
}
