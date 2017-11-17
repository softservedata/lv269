package com.softserve.edu.opencart.tools;

import com.softserve.edu.opencart.pages.RegexPatterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class TextUtils {

    private TextUtils() {
    }

    public static boolean respondsPattern(String actualText, String textToRespond){
        Pattern pattern = Pattern.compile(RegexPatterns.ANY_NUMBER_OF_SYMBOLS +
                textToRespond + RegexPatterns.ANY_NUMBER_OF_SYMBOLS);
        Matcher m = pattern.matcher(actualText);
        return m.matches();
    }
}
