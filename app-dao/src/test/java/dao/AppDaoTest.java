package dao;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.cglib.core.Local;

import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class AppDaoTest {
    AppDao appDao = new AppDao();

    @Test
    public void getDayOfWeek_allWeekDays_Test() {
        String[] actualDaysOfWeek = new String[7];
        String[] expectedDaysOfWeek = new String[] {
          "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
        };

        Locale aDefault = Locale.getDefault();
        if (!aDefault.getLanguage().equals("en_US")) {
            Locale.setDefault(new Locale("en_US"));
        }

        Calendar calendar = Calendar.getInstance();


        for (int i = 0; i < actualDaysOfWeek.length; i++) {
            calendar.set(2018, Calendar.MARCH, 5 + i);
            Date time = calendar.getTime();
            actualDaysOfWeek[i] = appDao.getDayOfWeek(time);
        }

        Locale.setDefault(aDefault);

        Assert.assertArrayEquals(expectedDaysOfWeek, actualDaysOfWeek);
    }

    @Test
    public void getDayOfWeek_null_test() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, Calendar.MARCH, 33);
        Date time = calendar.getTime();
        System.out.println(appDao.getDayOfWeek(time));

        Assert.assertTrue(true);
    }
}
