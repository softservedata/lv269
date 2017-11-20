package com.softserve.edu.opencart.data.pathnames;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StoreSettingOptionSet {
    //TODO add implementation

    private String storeUrl;
    private List<IStoreSettingOption> storeSettingOptionsSetList;
    private List<StoreSettingOption> defaultStoreSettingOptionsSetList;

    public StoreSettingOptionSet(String storeUrl) {
        storeSettingOptionsSetList = new ArrayList<>();
        defaultStoreSettingOptionsSetList = new ArrayList<>();
        this.storeUrl = storeUrl;
    }

    public String getStoreUrl() {
        return storeUrl;
    }

    public List<IStoreSettingOption> getStoreSettingOptionsSetList() {
        return storeSettingOptionsSetList;
    }

    public StoreSettingOptionSet addDefaultStoreSettingOption(String optionName, String optionTab, String optionValue) {
        defaultStoreSettingOptionsSetList.add(new StoreSettingOption(optionName, optionTab, optionValue));
        return this;
    }

    public StoreSettingOptionSet addDefaultStoreSettingOption (String optionName, String optionTab, Boolean optionFlag) {
        defaultStoreSettingOptionsSetList.add(new StoreSettingOption(optionName, optionTab, optionFlag));
        return this;
    }

    public StoreSettingOptionSet addDefaultStoreSettingOption (String optionName, String optionTab, Map<String, Boolean> flagsSet) {
        defaultStoreSettingOptionsSetList.add(new StoreSettingOption(optionName, optionTab, flagsSet));
        return this;
    }

    public List<StoreSettingOption> getDefaultStoreSettingOptionsSetList() {
        return defaultStoreSettingOptionsSetList;
    }


    public StoreSettingOptionSet addStoreSettingOption(String optionName, String optionTab, String optionValue) {
        storeSettingOptionsSetList.add(new StoreSettingOption(optionName, optionTab, optionValue));
        return this;
    }

    public StoreSettingOptionSet addStoreSettingOption(String optionName, String optionTab, Boolean optionFlag) {
        storeSettingOptionsSetList.add(new StoreSettingOption(optionName, optionTab, optionFlag));
        return this;
    }

    public StoreSettingOptionSet addStoreSettingOption(String optionName, String optionTab,
                                                       Map<String, Boolean> flagsSet) {
        storeSettingOptionsSetList.add(new StoreSettingOption(optionName, optionTab, flagsSet));
        return this;
    }

    //--------------------------------------------------------------------------------------------
    public interface IStoreSettingOption {
        String getOptionName();
        String getOptionTab();
        String getOptionValue();
        Boolean getOptionFlag();
        Map<String, Boolean> getOptionflagsSet();
        }

    //--------------------------------------------------------------------------------------------

    private class StoreSettingOption implements IStoreSettingOption {
        private String optionName;
        private String optionTab;
        private String optionValue;
        private Boolean optionFlag;
        private Map<String, Boolean> optionflagsSet;

        StoreSettingOption(String optionName, String optionTab, String optionValue) {
            setDefaultFields(optionName, optionTab);
            this.optionValue = optionValue;
        }

        StoreSettingOption(String optionName, String optionTab, Boolean optionFlag) {
            setDefaultFields(optionName, optionTab);
            this.optionFlag = optionFlag;
        }

        StoreSettingOption(String optionName, String optionTab, Map<String, Boolean> flagsSet) {
            setDefaultFields(optionName, optionTab);
            this.optionflagsSet = flagsSet;
        }

        private void setDefaultFields(String optionName, String optionTab) {
            this.optionName = optionName;
            this.optionTab = optionTab;
        }

        public String getOptionName() {
            return optionName;
        }

        public String getOptionTab() {
            return optionTab;
        }

        public String getOptionValue() {
            return optionValue;
        }

        public Boolean getOptionFlag() {
            return optionFlag;
        }

        public Map<String, Boolean> getOptionflagsSet() {
            return optionflagsSet;
        }
    }

}
