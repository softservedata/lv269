package com.softserve.edu.opencart.data.pathnames;

import com.softserve.edu.opencart.tools.exceptions.GeneralException;
import java.util.ArrayList;
import java.util.List;

public class Pathnames implements IPathnames {

    private final String OBJECT_CANT_BE_COPIED = "%s object can't be copired";

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
            throw new GeneralException (String.format(OBJECT_CANT_BE_COPIED, this.getClass().getName()));
        }
        return result;
    }
}
