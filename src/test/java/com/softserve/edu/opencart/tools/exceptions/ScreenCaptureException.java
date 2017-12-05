package com.softserve.edu.opencart.tools.exceptions;

import com.softserve.edu.opencart.pages.Application;

public class ScreenCaptureException extends GeneralException {
    private static final long serialVersionUID = 1L;

    // Classic constructor with a message of error.
    public ScreenCaptureException(String message) {
        super(message);
        performCapture();
    }

    public ScreenCaptureException(String message, Throwable e) {
        super(message, e);
        performCapture();
    }

    private void performCapture() {
        Application.get().reporter().addHtmlSourceCode();
        Application.get().reporter().addScreenShot();
    }

}
