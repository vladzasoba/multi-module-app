package service;

import dao.AppDaoImpl;
import org.junit.*;
import org.junit.rules.ExpectedException;

import java.text.ParseException;
import java.util.Locale;

public class AppServiceIntegrationTest {
    private AppServiceImpl appService = new AppServiceImpl();
    private AppDaoImpl appDaoImpl = new AppDaoImpl();
    private String expectedDayOfWeek = "Thursday";
    private String dateString = "01.03.2018";

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() {
        appService.setDao(appDaoImpl);
        Locale.setDefault(new Locale("en_US"));
    }

    @Test
    public void getDayOfWeek_ParseException_test() throws ParseException {
        thrown.expect(ParseException.class);
        appService.getDayOfWeek("01/03/2018");
    }

    @Test
    public void getDayOfWeek_returnsString_test() throws ParseException {
        String dayOfWeekActual = appService.getDayOfWeek(dateString);

        Assert.assertEquals(expectedDayOfWeek, dayOfWeekActual);
    }
}
