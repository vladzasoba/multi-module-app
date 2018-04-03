package ui;

import caching.CacheableProxy;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.AppService;

import java.text.ParseException;
import org.slf4j.Logger;

public class AppUIImpl implements AppUI {
    private static final Logger logger = LoggerFactory.getLogger(AppUIImpl.class);

    public static void main(String[] args) {
        if (args.length == 0) {
            logger.error("No arguments passed");
            return;
        }
        logger.info("Input argument: " +  args[0]);

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-config.xml");
        CacheableProxy<String, String> cacheProxy = (CacheableProxy<String, String>) applicationContext.getBean("cacheProxy");
        AppService serviceProxy = (AppService) cacheProxy.getProxy();


        try {
            String dayOfWeek1 = serviceProxy.getDayOfWeek("01.03.2018");
            System.out.println(dayOfWeek1);
        } catch (ParseException e) {
            logger.error("Date string isn't valid. Usage: dd.MM.YYYY\n Exception caught: ", e);
        }
    }
}
