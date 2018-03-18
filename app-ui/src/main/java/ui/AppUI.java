package ui;

import dao.AppDao;
import org.slf4j.LoggerFactory;
import service.AppService;

import java.text.ParseException;
import org.slf4j.Logger;

public class AppUI {
    private static final Logger logger = LoggerFactory.getLogger(AppUI.class);

    public static void main(String[] args) {
        if (args.length == 0) {
            logger.error("No arguments passed");
            return;
        }
        logger.info("Input argument: " +  args[0]);

        AppService appService = new AppService();
        appService.setDao(new AppDao());
        try {
            String dayOfWeek = appService.getDayOfWeek(args[0]);
            System.out.println(dayOfWeek);
        } catch (ParseException e) {
            logger.error("Date string isn't valid. Usage: dd.MM.YYYY\n Exception caught: ", e);
        }
    }
}
