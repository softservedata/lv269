package com.softserve.edu.opencart.tools;

import com.softserve.edu.opencart.tools.exceptions.ScreenCapturingException;

// TODO Change after develop AssertWrapper class
public final class ErrorUtils {

    private ErrorUtils() {
    }

    public static void createCustomException(boolean isThrown, String message) {
        if (isThrown) {
            // TODO Develop Custom Exception
            //throw new GeneralException(message);
            throw new ScreenCapturingException(message);
        }
    }

}
