package ui;

import caching.CacheableProxy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.AppService;

import java.text.ParseException;

public class AppUIImpl implements AppUI {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No arguments passed");
            return;
        }
        System.out.println("Input argument: " +  args[0]);

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-config.xml");
        CacheableProxy<String, String> cacheProxy = (CacheableProxy<String, String>) applicationContext.getBean("cacheProxy");
        AppService serviceProxy = (AppService) cacheProxy.getProxy();


        try {
            String dayOfWeek1 = serviceProxy.getDayOfWeek("01.03.2018");
            System.out.println(dayOfWeek1);
        } catch (ParseException e) {
            System.out.println("Date string isn't valid. Usage: dd.MM.YYYY\n Exception caught: " + e);
        }
    }
}
