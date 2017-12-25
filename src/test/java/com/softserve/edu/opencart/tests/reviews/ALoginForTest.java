package com.softserve.edu.opencart.tests.reviews;

import com.softserve.edu.opencart.data.users.UserRepository;
import com.softserve.edu.opencart.db.service.ReviewService;
import com.softserve.edu.opencart.pages.Application;

import com.softserve.edu.opencart.tests.TestRunnerChromeWithoutUI;
import org.testng.annotations.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Serhiienko.
 */
public abstract class ALoginForTest extends TestRunnerChromeWithoutUI {
    private ReviewService reviewService;

    @BeforeClass(alwaysRun = true)
    public void precondition() {
        Application.get().login().gotoLoginForLoginPageToMyAccountPage(UserRepository.get().valid());
        reviewService = new ReviewService();
    }

    @AfterClass(alwaysRun = true)
    public void logOut() {
        Application.get().logout();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String sDate = sdf.format(new Date());
        reviewService.deleteByDay(sDate);
    }

}
