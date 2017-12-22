package com.softserve.edu.opencart.tools;

import com.softserve.edu.opencart.tools.exceptions.ErrorUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class TextUtils {

    private final static String EMPTY_STRING_FOR_SPLIT = "Empty string was recieved for split";

    private TextUtils() {
    }

    public static List<String> splitToList(String text, String splitter) {
        ErrorUtils.createCustomException((text== null), EMPTY_STRING_FOR_SPLIT);
        return Arrays.asList(text.split(splitter));
    }
    public static String extractUrls(String text)
    {
        List<String> containedUrls = new ArrayList<String>();
        String urlRegex = "((https?|ftp|gopher|telnet|file):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
        Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
        Matcher urlMatcher = pattern.matcher(text);

        while (urlMatcher.find())
        {
            containedUrls.add(text.substring(urlMatcher.start(0),
                    urlMatcher.end(0)));
        }

        return containedUrls.get(0);
    }

}
