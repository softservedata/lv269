package com.softserve.edu.opencart.data.pathnames;

import java.util.ArrayList;
import java.util.List;

public class Pathnames implements IPathnames {

    //TODO make protection from wrong input


    private List<String> sBarPathnamesList;

    private IStoreSettingOptionSet storeSettingOptionSet;

    private String storeUrl;

    public Pathnames() {
        sBarPathnamesList = new ArrayList<>();
    }

    public String getStoreUrl() {
        return storeUrl;
    }

    public List<String> getsBarPathnamesList() {
        return sBarPathnamesList;
    }

    public IStoreSettingOptionSet getStoreSettingOptionSet() {
        return storeSettingOptionSet;
    }

    public Pathnames addSBarPathname(String sBarPathname) {
        sBarPathnamesList.add(sBarPathname);
        return this;
    }

    public Pathnames setStoreSettingOptionSet(IStoreSettingOptionSet storeSettingOptionSet) {
        this.storeSettingOptionSet = storeSettingOptionSet;
        return this;
    }

    public Pathnames setStoreUrl(String storeUrl) {
        this.storeUrl = storeUrl;
        return this;
    }

    public Object clone() {
        IPathnames result = null;
        try {
            result = (Pathnames) super.clone();
        } catch (CloneNotSupportedException e) {
        }
        return result;
    }
}
