package dao;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Calendar;
import java.util.Locale;

public class AppDaoTest {
    private AppDaoImpl appDaoImpl = new AppDaoImpl();

    @BeforeClass
    public static void setUp() {
        Locale.setDefault(new Locale("en_US"));
    }

    @Test
    public void getDayOfWeek_returnsFullDayName_Test() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, Calendar.MARCH, 1);
        String dayOfWeek = appDaoImpl.getDayOfWeek(calendar.getTime());

        Assert.assertTrue(dayOfWeek.length() > 3);
    }
}
