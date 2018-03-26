package dao;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class AppDaoIntegrationTest {
    private AppDaoImpl appDaoImpl = new AppDaoImpl();
    private String[] expectedDaysOfWeek = new String[] {
            "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
    };

    @BeforeClass
    public static void setUp() {
        Locale.setDefault(new Locale("en_US"));
    }

    @Test
    public void getDayOfWeek_allWeekDays_Test() {
        String[] actualDaysOfWeek = new String[7];

        Calendar calendar = Calendar.getInstance();

        for (int i = 0; i < actualDaysOfWeek.length; i++) {
            calendar.set(2018, Calendar.MARCH, 5 + i);
            Date time = calendar.getTime();
            actualDaysOfWeek[i] = appDaoImpl.getDayOfWeek(time);
        }

        Assert.assertArrayEquals(expectedDaysOfWeek, actualDaysOfWeek);
    }
}
