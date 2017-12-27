package com.softserve.edu.opencart.tests.reviews;

import com.softserve.edu.opencart.pages.Application;
import io.qameta.allure.Attachment;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class MyListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Attachment(value = "{0}", type = "image/png")
    private byte[] saveImageAttach() {
        try {
            return toByteArray(Application.get().browser().getScreenshot());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    /*@Attachment(value = "{0}", type = "text/html")
    private byte[] saveSourceCodeAttach() {
        try {
            return toByteArray(Application.get().browser().getSourceCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new byte[0];
    }*/

    private byte[] toByteArray(File file) throws IOException {
        return Files.readAllBytes(Paths.get(file.getPath()));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        saveImageAttach();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        saveImageAttach();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        saveImageAttach();
    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
