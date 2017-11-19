package com.softserve.edu.opencart.tests.reviews;

import com.softserve.edu.opencart.data.products.ProductRepository;
import com.softserve.edu.opencart.data.reviews.IReview;
import com.softserve.edu.opencart.data.reviews.ReviewRepository;
import com.softserve.edu.opencart.data.users.UserRepository;
import com.softserve.edu.opencart.pages.Application;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Serhiienko.
 */
public class FieldText {

    @DataProvider
    public Object[][] notValidTextData() {
        return new Object[][]{
                {ProductRepository.get().macBook().getName(), ReviewRepository.get().validNameNotValidShortTextWithRating()},
                {ProductRepository.get().macBook().getName(), ReviewRepository.get().validNameNotValidLongTextWithRating()},
                {ProductRepository.get().macBook().getName(), ReviewRepository.get().validNameOnlySpaceForTextWithRating()},
                {ProductRepository.get().macBook().getName(), ReviewRepository.get().validNameOnlySpecialCharactersForTextWithRating()},
        };
    }

    @DataProvider
    public Object[][] validTextData() {
        return new Object[][]{
                {ProductRepository.get().macBook().getName(), ReviewRepository.get().validNameValidShortTextWithRating()},
                {ProductRepository.get().macBook().getName(), ReviewRepository.get().validNameValidLongTextWithRating()},
        };
    }

    @BeforeClass
    public static void precondition() {
        Application.get().login().gotoLoginForLoginPageToMyAccountPage(UserRepository.get().valid());
    }

    @AfterClass
    public static void logOut() {
        Application.get().getApplicationSources().getUserLogoutUrl();
        Application.remove();
    }

    @Test(dataProvider = "notValidTextData")
    public void notValid(String productName, IReview myReview) {
        Application.get().loadHomePage().goToProductPage(productName).notValidReviewFields(myReview);
    }

    @Test(dataProvider = "validTextData")
    public void valid(String productName, IReview myReview) {
        Application.get().loadHomePage().goToProductPage(productName).validReviewFields(myReview);
    }

}
