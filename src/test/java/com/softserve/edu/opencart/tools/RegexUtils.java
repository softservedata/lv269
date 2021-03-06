package com.softserve.edu.opencart.tools;

import com.softserve.edu.opencart.tools.exceptions.ErrorUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class RegexUtils {

    private final static String EXTRACT_NUMBER_MESSAGE = "NumberFormatException for pattern =  %s text =  %s";
    private final static String PARSE_NUMBER_EXCEPTION_MESSAGE = "NumberFormatException for text =  %s";
    private final static String EMPTY_TEXT_RECIEVED_MESSAGE = "An empty string was recieved";

    private RegexUtils() {    }


    public static int stringToInt(String text) {
        ErrorUtils.createCustomException((text == null), EMPTY_TEXT_RECIEVED_MESSAGE);
        int result;
        try {
            result = Integer.parseUnsignedInt(text);
        } catch (NumberFormatException e) {
            // TODO Develop Custom Exception
            throw new RuntimeException(String.format(String.format(PARSE_NUMBER_EXCEPTION_MESSAGE), text));
        }
        return result;
    }

    public static String extractString(String pattern, String text) {
        String result = new String();
        Matcher matcher = Pattern.compile(pattern).matcher(text);
        if (matcher.find()) {
            result = text.substring(matcher.start(), matcher.end());
        }
        return result;
    }

    public static int extractNumber(String pattern, String text) {
        int result = -1;
        String extractText = extractString(pattern, text);
        if (!extractText.isEmpty()) {
            try {
                result = Integer.parseUnsignedInt(extractText);

            } catch (NumberFormatException e) {
                // TODO Develop Custom Exception
                throw new RuntimeException(String.format(EXTRACT_NUMBER_MESSAGE, pattern, text));
            }
        }
        return result;
    }

    public static double extractDouble(String pattern, String text) {
        double result = -1;
        String extractText = extractString(pattern, text);
        if (!extractText.isEmpty()) {
            try {
                result = Double.parseDouble(extractText);

            } catch (NumberFormatException e) {
                // TODO Develop Custom Exception
                throw new RuntimeException(String.format(EXTRACT_NUMBER_MESSAGE, pattern, text));
            }
        }
        return result;
    }

    public static char extractSymbol(String pattern,  String text) {
        char result = '\u0000';
        String extractText = extractString(pattern, text);
        if(!text.isEmpty()) {
            result = extractText.charAt(0);
        }
        return result;
    }


    public static String extractPathWithoutServer(String pattern, String text) {
        String result = text;
        Matcher matcher = Pattern.compile(pattern).matcher(text);
        if (matcher.find()) {
                result = text.substring(matcher.end()-1);
        }
        return result;
    }

}
