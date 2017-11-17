package com.softserve.edu.opencart.tools;

import java.util.Arrays;
import java.util.List;

public final class TextUtils {

    private final static String EMPTY_STRING_FOR_SPLIT = "Empty string was reciaved for split";
    private final static String EMPTY_STRING_FOR_SEARCH = "Empty string was reciaved for search";

    private TextUtils() {
    }

    public static List<String> splittoList(String text, String splitter) {
        ErrorUtils.createCustomException((text== null), EMPTY_STRING_FOR_SPLIT);
        return Arrays.asList(text.split(splitter));
    }

}
