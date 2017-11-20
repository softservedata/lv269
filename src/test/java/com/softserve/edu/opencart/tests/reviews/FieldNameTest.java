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

public class FieldNameTest {

    @DataProvider
    public Object[][] notValidNameData() {
        return new Object[][]{
                {ProductRepository.get().macBook(), ReviewRepository.get().notValidShortNameValidTextWithRating()},
                {ProductRepository.get().macBook(), ReviewRepository.get().notValidLongNameValidTextWithRating()},
                {ProductRepository.get().macBook(), ReviewRepository.get().onlySpaceForNameValidTextWithRating()},
                {ProductRepository.get().macBook(), ReviewRepository.get().onlySpecialCharactersForNameValidTextWithRating()},
        };
    }

    @DataProvider
    public Object[][] validNameData() {
        return new Object[][]{
                {ProductRepository.get().macBook(), ReviewRepository.get().validShortNameValidTextWithRating()},
                {ProductRepository.get().macBook(), ReviewRepository.get().validLongNameValidTextWithRating()},
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

    @Test(dataProvider = "notValidNameData")
    public void testNotValidData(IProduct product, IReview myReview) {
        Application.get().loadHomePage().goToProductPage(product).notValidReviewFields(myReview);
    }

    @Test(dataProvider = "validNameData")
    public void testValidData(IProduct product, IReview myReview) {
        Application.get().loadHomePage().goToProductPage(product).validReviewFields(myReview);
    }
}
