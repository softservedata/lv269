package com.softserve.edu.opencart.tests.reviews;

import com.softserve.edu.opencart.data.products.IProduct;
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
public class FieldTextTest {

    @DataProvider
    public Object[][] notValidTextData() {
        return new Object[][]{
                {ProductRepository.get().macBook(), ReviewRepository.get().validNameNotValidShortTextWithRating()},
                {ProductRepository.get().macBook(), ReviewRepository.get().validNameNotValidLongTextWithRating()},
                {ProductRepository.get().macBook(), ReviewRepository.get().validNameOnlySpaceForTextWithRating()},
                {ProductRepository.get().macBook(), ReviewRepository.get().validNameOnlySpecialCharactersForTextWithRating()},
        };
    }

    @DataProvider
    public Object[][] validTextData() {
        return new Object[][]{
                {ProductRepository.get().macBook(), ReviewRepository.get().validNameValidShortTextWithRating()},
                {ProductRepository.get().macBook(), ReviewRepository.get().validNameValidLongTextWithRating()},
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
    public void testNotValidData(IProduct product, IReview myReview) {
        Application.get().loadHomePage().goToProductPage(product).notValidReviewFields(myReview);
    }

    @Test(dataProvider = "validTextData")
    public void testValidData(IProduct product, IReview myReview) {
        Application.get().loadHomePage().goToProductPage(product).validReviewFields(myReview);
    }

}
