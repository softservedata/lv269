package com.softserve.edu.opencart.tools.exceptions;

// TODO Change after develop AssertWrapper class
public final class ErrorUtils {

    private ErrorUtils() {
    }

    public static void createCustomException(boolean isThrown, String message) {
        if (isThrown) {
            // TODO Develop Custom Exception
            //throw new GeneralException(message);
            throw new ScreenCaptureException(message);
        }
    }

    public static void createSubListIsEmptyException(boolean isThrown, String message) {
        if (isThrown) {
            // TODO Develop Custom Exception
            throw new GeneralException(message);
        }
    }

    public static void createOptionNotFoundInSBarException(boolean isThrown, String message) {
        if (isThrown) {
            // TODO Develop Custom Exception
            throw new GeneralException(message);
        }
    }

    public static void createInputDataIsEmptyException(boolean isThrown, String message) {
        if (isThrown) {
            // TODO Develop Custom Exception
            throw new GeneralException(message);
        }
    }

    public static void createElementIsNotDisplayedException(boolean isThrown, String message) {
        if (isThrown) {
            // TODO Develop Custom Exception
            throw new ScreenCaptureException(message);
        }
    }

    public static void createValueNotFoundException(boolean isThrown, String message) {
        if (isThrown) {
            // TODO Develop Custom Exception
            throw new ScreenCaptureException(message);
        }
    }

    public static void createWrongTextToDropdown(boolean isThrown, String message) {
        if (isThrown) {
            // TODO Develop Custom Exception
            throw new GeneralException(message);
        }
    }

    public static void createElementNotClickableException(boolean isThrown, String message) {
        if (isThrown) {
            // TODO Develop Custom Exception
            throw new GeneralException(message);
        }
    }

    public static void createInitPaginationBeforeGetException(boolean isThrown, String message) {
        if (isThrown) {
            // TODO Develop Custom Exception
            throw new ScreenCaptureException(message);
        }
    }

    public static void createWrongStringStructureException(boolean isThrown, String message) {
        if (isThrown) {
            // TODO Develop Custom Exception
            throw new GeneralException(message);
        }
    }

    public static void createWrongParameterSizeException(boolean isThrown, String message) {
        if (isThrown) {
            // TODO Develop Custom Exception
            throw new GeneralException(message);
        }
    }

    public static void createSQLException(boolean isThrown, String message) {
        if (isThrown) {
            // TODO Develop Custom Exception
            throw new GeneralException(message);
        }
    }


}