package com.softserve.edu.opencart.data.pathnames;

import java.util.List;
import java.util.Map;

public interface IStoreSettingOptionSet {

//TODO Protection against changes except repository

    interface IStoreSettingOption {
    }
    StoreSettingOptionSet addDefaultStoreSettingOption(String optionName, String optionTab, String optionValue);
    StoreSettingOptionSet addDefaultStoreSettingOption (String optionName, String optionTab, Boolean optionFlag);
    StoreSettingOptionSet addDefaultStoreSettingOption (String optionName, String optionTab,
                                                        Map<String, Boolean> flagsSet);

    List<IStoreSettingOption> getDefaultStoreSettingOptionsSetList();
    List<IStoreSettingOption> getStoreSettingOptionsSetList();
    String getStoreUrl();


}
