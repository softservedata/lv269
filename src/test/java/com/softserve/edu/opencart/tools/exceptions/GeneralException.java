package com.softserve.edu.opencart.tools.exceptions;

import com.softserve.edu.opencart.pages.Application;

public class GeneralException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private static final String GENERAL_EXCEPTION = "GeneralException: %s";

    // Classic constructor with a message of error.
    public GeneralException(String message) {
        super(message);
        performLogging(message);
    }

    public GeneralException(String message, Throwable e) {
        super(message, e);
        performLogging(message);
    }

    private void performLogging(String message) {
        // TODO Add Loggers
        Application.get().reporter().error(String.format(GENERAL_EXCEPTION, message));
    }

}
