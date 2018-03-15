package service;

import dao.AppDao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AppService {
    private AppDao dao = new AppDao();

    public String getDayOfWeek(String dateString) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        simpleDateFormat.setLenient(false);

        Date date = null;

        try {
            date = simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (date == null) {
            return "Invalid date format";
        }

        return dao.getDayOfWeek(date);
    }
}
