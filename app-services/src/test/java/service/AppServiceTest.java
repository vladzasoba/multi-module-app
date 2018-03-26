package service;

import dao.AppDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import java.text.ParseException;
import java.util.Date;

public class AppServiceTest {
    private AppService appService = new AppServiceImpl();
    private AppDao appDaoImplMock = Mockito.mock(AppDao.class);
    private String expectedDayOfWeek = "Thursday";
    private String dateString = "01.03.2018";

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() {
        appService.setDao(appDaoImplMock);
    }

    @Test
    public void getDayOfWeek_ParseException_test() throws ParseException {
        thrown.expect(ParseException.class);
        appService.getDayOfWeek("01/03/2018");
    }

    @Test
    public void getDayOfWeek_returnsString_test() throws ParseException {
        Mockito.when(appDaoImplMock.getDayOfWeek(Mockito.any(Date.class))).thenReturn(expectedDayOfWeek);
        Mockito.when(appService.getDayOfWeek(dateString)).thenReturn(expectedDayOfWeek);
        String dayOfWeekActual = appService.getDayOfWeek(dateString);

        Assert.assertEquals(expectedDayOfWeek, dayOfWeekActual);
    }

}
