package com.softserve.edu.opencart.data.pathnames;

import com.softserve.edu.opencart.data.pagination.IPagination;

import java.util.ArrayList;
import java.util.List;

public class Pathnames implements IPathnames {

    //TODO make protection from wrong input



    private List<String> sBarPatnamesList;

    private List<StoreSettingOptionSet> storeSettingOptionSets;

    private List<StoreSettingOptionSet> defaultStoreSettingOptionSets;

    private int currentSBarPathnameNumber;

    private int currentStoreSettingOptionSet;

    public Pathnames() {
        sBarPatnamesList = new ArrayList<>();
        storeSettingOptionSets = new ArrayList<>();
        currentSBarPathnameNumber = -1;
        currentStoreSettingOptionSet = -1;
    }

    public List<String> getSBarPatnamesList() {
        return sBarPatnamesList;
    }

    public List<StoreSettingOptionSet> getStoreSettingOptionSets() {
        return storeSettingOptionSets;
    }

    public int getCurrentSBarPathnameNumber() {
        return currentSBarPathnameNumber;
    }

    public int getCurrentStoreSettingOptionSet() {
        return currentStoreSettingOptionSet;
    }

    public Pathnames setCurrentSBarPathnameNumber(int currentSBarPathnameNumber) {
        this.currentSBarPathnameNumber = currentSBarPathnameNumber;
        return this;
    }

    public Pathnames setCurrentStoreSettingOptionSet(int currentStoreSettingOptionSetNumber) {
        this.currentStoreSettingOptionSet = currentStoreSettingOptionSetNumber;
        return this;
    }

    public Pathnames addSBarPathnamesList(String sBarPathnameList) {
        getSBarPatnamesList().add(sBarPathnameList);
        return this;
    }

    public Pathnames addStoreSettingOptionSet(StoreSettingOptionSet storeSettingOptionSet) {
        getStoreSettingOptionSets().add(storeSettingOptionSet);
        return this;
    }

    public List<StoreSettingOptionSet> getDefaultStoreSettingOptionSets() {
        return defaultStoreSettingOptionSets;
    }

    public Pathnames addDefaultStoreSettingOptionSet(StoreSettingOptionSet storeSettingOptionSet) {
        getDefaultStoreSettingOptionSets().add(storeSettingOptionSet);
        return this;
    }



}
