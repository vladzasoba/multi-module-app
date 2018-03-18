package service;

import dao.AppDao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AppService {
    private AppDao dao;

    public String getDayOfWeek(String dateString) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        simpleDateFormat.setLenient(false);

        Date date = simpleDateFormat.parse(dateString);

        return dao.getDayOfWeek(date);
    }

    public void setDao(AppDao dao) {
        this.dao = dao;
    }
}
