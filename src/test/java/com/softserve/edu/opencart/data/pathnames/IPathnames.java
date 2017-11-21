package com.softserve.edu.opencart.data.pathnames;


import com.softserve.edu.opencart.data.pagination.IPagination;

import java.util.List;

public interface IPathnames {

    List<String> getsBarPathnamesList ();

    IStoreSettingOptionSet getStoreSettingOptionSet();

    String getStoreUrl();

}
