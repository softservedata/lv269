package com.softserve.edu.opencart.tools;

public final class ErrorUtils {

    private ErrorUtils() {
    }

    public static void createCustomException(boolean isThrown, String message) {
        if (isThrown) {
            // TODO Develop Custom Exception
            throw new RuntimeException(message);
        }
    }

}
