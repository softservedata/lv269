package com.softserve.edu.opencart.data.pathnames;

import java.util.List;

public interface IStoreSettingOptionSet {

//TODO Protection against changes except repository

    interface IStoreSettingOption {

    }

    abstract class StoreSettingOption {

    }


    List<StoreSettingOptionSet.IStoreSettingOption> getStoreSettingOptionsSetList();


}
