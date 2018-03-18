package service;

import dao.AppDao;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.text.ParseException;
import java.util.Date;

public class AppServiceTest {
    private AppService appService = new AppService();

    @Test(expected = ParseException.class)
    public void getDayOfWeek_ParseException_test() throws ParseException {
        appService.getDayOfWeek("01/03/2018");
    }

    @Test
    public void getDayOfWeek_returnsString_test() throws ParseException {
        AppDao appDaoMock = Mockito.mock(AppDao.class);
        appService.setDao(appDaoMock);

        Mockito.when(appDaoMock.getDayOfWeek(Mockito.any(Date.class))).thenReturn("Thursday");
        String dayOfWeekActual = appService.getDayOfWeek("01.03.2018");

        Assert.assertEquals("Thursday", dayOfWeekActual);
    }

}
