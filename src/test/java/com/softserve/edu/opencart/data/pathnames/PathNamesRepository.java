package com.softserve.edu.opencart.data.pathnames;

import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;

public class PathNamesRepository {

    private static volatile PathNamesRepository instance = null;

    private PathNamesRepository() {
    }

    public static PathNamesRepository get() {
        if (instance == null) {
            synchronized (PathNamesRepository.class) {
                if (instance == null) {
                    instance = new PathNamesRepository();
                }
            }
        }
        return instance;
    }


    public IPathnames openProductAdminPagePathnames() {
        return new Pathnames()
                .addSBarPathname("Catalog/Products");
    }

    public IPathnames paginationPathnames() {
        return new Pathnames()
                .addSBarPathname("System/Settings")
                .addSBarPathname("Catalog/Products")
                .addSBarPathname("System/Settings")
                .setStoreUrl(ApplicationSourceRepository.get().base().getBaseUrl())
                .setStoreSettingOptionSet(
                        new StoreSettingOptionSet()
                                .addStoreSettingOption("Default Items Per Page (Admin)", "Option",
                                        ""));
    }

    public IPathnames sortPathnames() {
        return new Pathnames()
                .addSBarPathname("System/Settings")
                .addSBarPathname("Catalog/Products")
                .addSBarPathname("System/Settings")
                .setStoreUrl(ApplicationSourceRepository.get().base().getBaseUrl())
                .setStoreSettingOptionSet(
                        new StoreSettingOptionSet()
                                .addStoreSettingOption("Default Items Per Page (Admin)", "Option",
                                        ""));
    }

    public IPathnames filterPathnames() {
        return new Pathnames()
                .addSBarPathname("Catalog/Products");
    }
}

