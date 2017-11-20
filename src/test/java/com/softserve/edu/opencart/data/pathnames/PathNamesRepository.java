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

    public IPathnames pagination() {
        return new Pathnames()
                .addSBarPathnamesList("System/Settings")
                .addSBarPathnamesList("Catalog/Products")
                .addSBarPathnamesList("System/Settings")
                .addStoreSettingOptionSet(
                        new StoreSettingOptionSet(ApplicationSourceRepository.get().base().getBaseUrl())
                                .addStoreSettingOption("Default Items Per Page (Admin)", "Option",
                                        ""))
                .addStoreSettingOptionSet(
                        new StoreSettingOptionSet(ApplicationSourceRepository.get().base().getBaseUrl())
                                .addStoreSettingOption("Default Items Per Page (Admin)", "Option",
                                        ""));
    }
}

