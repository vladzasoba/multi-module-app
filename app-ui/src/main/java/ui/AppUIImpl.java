package ui;

import dao.AppDaoImpl;
import org.slf4j.LoggerFactory;
import service.AppService;
import service.AppServiceImpl;

import java.text.ParseException;
import org.slf4j.Logger;
import service.CacheableService;

public class AppUIImpl implements AppUI {
    private static final Logger logger = LoggerFactory.getLogger(AppUIImpl.class);

    public static void main(String[] args) {
        if (args.length == 0) {
            logger.error("No arguments passed");
            return;
        }
        logger.info("Input argument: " +  args[0]);

        AppService appService = new AppServiceImpl();
        appService.setDao(new AppDaoImpl());

        AppService cacheableService = new CacheableService(appService);

        try {
            //String dayOfWeek = appService.getDayOfWeek(args[0]);
            String dayOfWeek = cacheableService.getDayOfWeek(args[0]);
            System.out.println(dayOfWeek);
        } catch (ParseException e) {
            logger.error("Date string isn't valid. Usage: dd.MM.YYYY\n Exception caught: ", e);
        }
    }
}
