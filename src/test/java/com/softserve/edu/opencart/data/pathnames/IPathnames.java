package com.softserve.edu.opencart.data.pathnames;


import java.util.List;

public interface IPathnames extends Cloneable {

    List<String> getsBarPathnamesList();

    IStoreSettingOptionSet getStoreSettingOptionSet();

    String getStoreUrl();

    Object clone();

}
