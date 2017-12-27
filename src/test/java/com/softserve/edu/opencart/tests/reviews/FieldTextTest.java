package com.softserve.edu.opencart.tests.reviews;

import com.softserve.edu.opencart.data.products.IProduct;
import com.softserve.edu.opencart.data.products.ProductRepository;
import com.softserve.edu.opencart.data.reviews.IReview;
import com.softserve.edu.opencart.data.reviews.ReviewRepository;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.tests.ATestRunnerReview;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.softserve.edu.opencart.tests.TestContextAttributes.REVIEW_FIELD_MESSAGE;

/**
 * Created by Serhiienko.
 */
@Epic("Test for Text field in Review Form when user is authenticated and other fields is valid.")
public class FieldTextTest extends ATestRunnerReview {

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

    @Description("Use NOT valid data in field for Product {0} with {1}.")
    @Test(dataProvider = "notValidTextData")
    public void testNotValidData(IProduct product, IReview myReview) {
        String message = String.format(REVIEW_FIELD_MESSAGE.toString(), product.getName(),
                myReview.getCriterion());
        logger.info(message);
        reporter.info(message);

        //flexAssert.assertTrue(Application.get().loadHomePage().goToProductPage(product).notValidReviewFields(myReview));
        //Assert.assertTrue(Application.get().loadHomePage().goToProductPage(product).notValidReviewFields(myReview));
        Application.get().loadHomePage().goToProductPage(product).notValidReviewFields(myReview);
    }

    @Description("Use valid data in field.")
    @Test(dataProvider = "validTextData")
    public void testValidData(IProduct product, IReview myReview) {
        String message = String.format(REVIEW_FIELD_MESSAGE.toString(), product.getName(),
                myReview.getCriterion());
        logger.info(message);
        reporter.info(message);

        //flexAssert.assertTrue(Application.get().loadHomePage().goToProductPage(product).validReviewFields(myReview));
        //Assert.assertTrue(Application.get().loadHomePage().goToProductPage(product).validReviewFields(myReview));
        Application.get().loadHomePage().goToProductPage(product).validReviewFields(myReview);
    }

}
