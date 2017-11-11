package com.softserve.edu.opencart.testng.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class NumberUtils {

    private final static String EXTRACT_NUMBER_MESSAGE = "NumberFormatException for pattern =  %s text =  %s";

    private NumberUtils() {
    }

    public static int extractNumber(String pattern, String text) {
        int result = -1;
        Matcher matcher = Pattern.compile(pattern).matcher(text);
        if (matcher.find()) {
            try {
                result = Integer.parseUnsignedInt(text.substring(matcher.start(), matcher.end()));

            } catch (NumberFormatException e) {
                // TODO Develop Custom Exception
                throw new RuntimeException(String.format(EXTRACT_NUMBER_MESSAGE, pattern, text));
            }
        }
        return result;
    }
}
