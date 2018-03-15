package dao;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AppDao {
    public String getDayOfWeek(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE");
        String format = dateFormat.format(date);

        return format;
    }
}