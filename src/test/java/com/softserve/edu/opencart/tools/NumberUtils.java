package com.softserve.edu.opencart.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class NumberUtils {

    private final static String EXTRACT_NUMBER_MESSAGE = "NumberFormatException for pattern =  %s text =  %s";

    private NumberUtils() {
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
    public static String extractSymbol(String pattern,  String text) {
		String result = null;
		String extractText = extractString(pattern, text);
		if(!text.isEmpty()) {
			result = extractText;
		}
		return result;
	}
}
