package com.softserve.edu.opencart.data.pathnames;


import com.softserve.edu.opencart.data.pagination.IPagination;

import java.util.List;

public interface IPathnames {

    List <String> getSBarPatnamesList ();

    List<StoreSettingOptionSet> getStoreSettingOptionSets();

    int getCurrentSBarPathnameNumber ();

    int getCurrentStoreSettingOptionSet ();

    IPathnames setCurrentSBarPathnameNumber (int currentSBarPathnameNumber);

    IPathnames setCurrentStoreSettingOptionSet (int currentStoreSettingOptionSetNumber);

    public List<StoreSettingOptionSet> getDefaultStoreSettingOptionSets();

    public Pathnames addDefaultStoreSettingOptionSet(StoreSettingOptionSet storeSettingOptionSet);

}
