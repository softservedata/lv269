package com.softserve.edu.opencart.data.applications;

public class ApplicationSourceRepository {

    private static volatile ApplicationSourceRepository instance = null;

    private ApplicationSourceRepository() {
    }

    public static ApplicationSourceRepository get() {
        if (instance == null) {
            synchronized (ApplicationSourceRepository.class) {
                if (instance == null) {
                    instance = new ApplicationSourceRepository();
                }
            }
        }
        return instance;
    }

    public IApplicationSource base() {
        return chromeServer7();
    }

    public String geckoDriverPath() {
        return ApplicationSourceRepository.class
                .getResource("/lib/geckodriver.exe").getPath().substring(1);
    }

    public String chromeDriverPath() {
        return ApplicationSourceRepository.class
                .getResource("/lib/chromedriver").getPath();//.substring(1);
    }

    public IApplicationSource chromeServer7() {
        //System.out.println("Full Path = " + ApplicationSourceRepository.class
        //        .getResource("/lib/geckodriver.exe").getPath());
        System.out.println("Path = " + chromeDriverPath());
        return new ApplicationSource("chrome", chromeDriverPath(),
                10L, 30L, 10L, 5L,
                "http://server7.pp.ua",
                "http://server7.pp.ua/index.php?route=account/login",
                "http://server7.pp.ua/index.php?route=account/logout",
                "http://server7.pp.ua/admin/",
                "http://server7.pp.ua/admin/index.php?route=common/logout");
    }

    public IApplicationSource firefoxServer7() {
        System.out.println("Full Path = " + ApplicationSourceRepository.class
                .getResource("/lib/geckodriver.exe").getPath());
        //System.out.println("Path = " + chromeDriverPath());
        return new ApplicationSource("firefox", geckoDriverPath(),
                10L, 30L, 10L, 5L,
                "http://server7.pp.ua",
                "http://server7.pp.ua/index.php?route=account/login",
                "http://server7.pp.ua/index.php?route=account/logout",
                "http://server7.pp.ua/admin/",
                "http://server7.pp.ua/admin/index.php?route=common/logout");
    }


}
