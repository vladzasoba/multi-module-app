package service;

import dao.AppDao;

import java.text.ParseException;

public interface AppService {
    String getDayOfWeek(String dateString) throws ParseException;
    void setDao(AppDao dao);
}
