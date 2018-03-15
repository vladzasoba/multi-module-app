package ui;

import service.AppService;

public class AppUI {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No arguments passed");
            return;
        }

        AppService appService = new AppService();
        System.out.println(appService.getDayOfWeek(args[0]));
    }
}
