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
        return chromeImplicitServer7();
    }

    public String phantomJSDriverPathWindows() {
        return ApplicationSourceRepository.class
                .getResource("/lib/phantomjs.exe").getPath().substring(1);
    }

    public String phantomJSDriverPathLinux() {
        return ApplicationSourceRepository.class
                .getResource("/lib/phantomjs").getPath();
    }

    public String geckoDriverPath() {
        return ApplicationSourceRepository.class
                .getResource("/lib/geckodriver.exe").getPath().substring(1);
    }

    public String chromeDriverPathWindows() {
        return ApplicationSourceRepository.class
                .getResource("/lib/chromedriver.exe").getPath().substring(1);
    }

    public String chromeDriverPathLinux() {
        //return ApplicationSourceRepository.class
        //        .getResource("/lib/chromedriver").getPath();
        return "/var/lib/jenkins/workspace/chromedriver";
    }

    public String chromeDriver215PathLinux() {
        //return ApplicationSourceRepository.class
        //        .getResource("/lib/chromedriver").getPath();
        return "/var/lib/jenkins/workspace/chromedriver215";
    }

    public IApplicationSource chromeImplicitServer7() {
        //System.out.println("Full Path = " + ApplicationSourceRepository.class
        //        .getResource("/lib/geckodriver.exe").getPath());
        System.out.println("Path = " + chromeDriverPathWindows());
        return new ApplicationSource("ChromeTemporary", chromeDriverPathWindows(),
                10L, 30L, 10L, 5L,
                "Implicit", true,
                "http://server7.pp.ua",
                "http://server7.pp.ua/index.php?route=account/login",
                "http://server7.pp.ua/index.php?route=account/logout",
                "http://server7.pp.ua/admin/",
                "http://server7.pp.ua/admin/index.php?route=common/logout");
    }

    public IApplicationSource chromeImplicitServer7WithoutUIWindows() {
        //System.out.println("Full Path = " + ApplicationSourceRepository.class
        //        .getResource("/lib/geckodriver.exe").getPath());
        System.out.println("Path = " + chromeDriverPathWindows());
        return new ApplicationSource("ChromeWithoutUI", chromeDriverPathWindows(),
                10L, 30L, 10L, 5L,
                "Implicit", true,
                "http://server7.pp.ua",
                "http://server7.pp.ua/index.php?route=account/login",
                "http://server7.pp.ua/index.php?route=account/logout",
                "http://server7.pp.ua/admin/",
                "http://server7.pp.ua/admin/index.php?route=common/logout");
    }

    public IApplicationSource chromeImplicitServer7WithoutUILinux() {
        //System.out.println("Full Path = " + ApplicationSourceRepository.class
        //        .getResource("/lib/geckodriver.exe").getPath());
        System.out.println("\t*** Path = " + chromeDriverPathLinux());
        return new ApplicationSource("ChromeWithoutUI", chromeDriverPathLinux(),
                40L, 40L, 40L, 10L,
                "Implicit", true,
                "http://server7.pp.ua",
                "http://server7.pp.ua/index.php?route=account/login",
                "http://server7.pp.ua/index.php?route=account/logout",
                "http://server7.pp.ua/admin/",
                "http://server7.pp.ua/admin/index.php?route=common/logout");
    }

    public IApplicationSource chromeImplicitServer7WithoutUILinux215() {
        //System.out.println("Full Path = " + ApplicationSourceRepository.class
        //        .getResource("/lib/geckodriver.exe").getPath());
        System.out.println("\t*** Path = " + chromeDriver215PathLinux());
        return new ApplicationSource("ChromeWithoutUI", chromeDriver215PathLinux(),
                40L, 40L, 40L, 10L,
                "Implicit", true,
                "http://server7.pp.ua",
                "http://server7.pp.ua/index.php?route=account/login",
                "http://server7.pp.ua/index.php?route=account/logout",
                "http://server7.pp.ua/admin/",
                "http://server7.pp.ua/admin/index.php?route=common/logout");
    }

    public IApplicationSource chromeVisibleServer7() {
        //System.out.println("Full Path = " + ApplicationSourceRepository.class
        //        .getResource("/lib/geckodriver.exe").getPath());
        System.out.println("Path = " + chromeDriverPathWindows());
        return new ApplicationSource("ChromeTemporary", chromeDriverPathWindows(),
                10L, 30L, 10L, 5L,
                "Visible", true,
                "http://server7.pp.ua",
                "http://server7.pp.ua/index.php?route=account/login",
                "http://server7.pp.ua/index.php?route=account/logout",
                "http://server7.pp.ua/admin/",
                "http://server7.pp.ua/admin/index.php?route=common/logout");
    }

    public IApplicationSource firefoxImplicitServer7() {
        System.out.println("Full Path = " + ApplicationSourceRepository.class
                .getResource("/lib/geckodriver.exe").getPath());
        //System.out.println("Path = " + chromeDriverPath());
        return new ApplicationSource("FireFox5xTemporary", geckoDriverPath(),
                10L, 30L, 10L, 5L,
                "Implicit", true,
                "http://server7.pp.ua",
                "http://server7.pp.ua/index.php?route=account/login",
                "http://server7.pp.ua/index.php?route=account/logout",
                "http://server7.pp.ua/admin/",
                "http://server7.pp.ua/admin/index.php?route=common/logout");
    }

    public IApplicationSource phantomJSImplicitServer7Windows() {
        //System.out.println("Full Path = " + ApplicationSourceRepository.class
        //        .getResource("/lib/geckodriver.exe").getPath());
        //System.out.println("Path = " + chromeDriverPath());
        return new ApplicationSource("phantomJS", phantomJSDriverPathWindows(),
                10L, 30L, 10L, 5L,
                "Implicit", true,
                "http://server7.pp.ua",
                "http://server7.pp.ua/index.php?route=account/login",
                "http://server7.pp.ua/index.php?route=account/logout",
                "http://server7.pp.ua/admin/",
                "http://server7.pp.ua/admin/index.php?route=common/logout");
    }

    public IApplicationSource phantomJSImplicitServer7Linux() {
        //System.out.println("Full Path = " + ApplicationSourceRepository.class
        //        .getResource("/lib/geckodriver.exe").getPath());
        //System.out.println("Path = " + chromeDriverPath());
        return new ApplicationSource("phantomJS", phantomJSDriverPathLinux(),
                10L, 30L, 10L, 5L,
                "Implicit", true,
                "http://server7.pp.ua",
                "http://server7.pp.ua/index.php?route=account/login",
                "http://server7.pp.ua/index.php?route=account/logout",
                "http://server7.pp.ua/admin/",
                "http://server7.pp.ua/admin/index.php?route=common/logout");
    }

}
