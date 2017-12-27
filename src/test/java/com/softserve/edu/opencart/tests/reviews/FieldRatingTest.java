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
@Epic("Test for Rating field in Review Form when user is authenticated.")
public class FieldRatingTest extends ATestRunnerReview {

    @DataProvider
    public Object[][] ratingData() {
        return new Object[][]{
                {ProductRepository.get().macBook(), ReviewRepository.get().validNameValidTextWithRating()},
        };
    }

    @DataProvider
    public Object[][] withOutRatingData() {
        return new Object[][]{
                {ProductRepository.get().macBook(), ReviewRepository.get().validNameValidTextWithOutRating()},
        };
    }

    @Description("Only Rating field is in Review Form.")
    @Test(dataProvider = "ratingData")
    public void testOnlyRatingData(IProduct product, IReview myReview) {
        String message = String.format(REVIEW_FIELD_MESSAGE.toString(), product.getName(),
                myReview.getCriterion());
        logger.info(message);
        reporter.info(message);

        //flexAssert.assertTrue(Application.get().loadHomePage().goToProductPage(product).onlyReviewRating(myReview));
        //Assert.assertTrue(Application.get().loadHomePage().goToProductPage(product).onlyReviewRating(myReview));
        Application.get().loadHomePage().goToProductPage(product).onlyReviewRating(myReview);
    }

    @Description("Valid string fields and Rating is absent in Review Form.")
    @Test(dataProvider = "withOutRatingData")
    public void testValidDataWithOutRating(IProduct product, IReview myReview) {
        String message = String.format(REVIEW_FIELD_MESSAGE.toString(), product.getName(),
                myReview.getCriterion());
        logger.info(message);
        reporter.info(message);

        //flexAssert.assertTrue(Application.get().loadHomePage().goToProductPage(product).reviewWithOutRating(myReview));
        //Assert.assertTrue(Application.get().loadHomePage().goToProductPage(product).reviewWithOutRating(myReview));
        Application.get().loadHomePage().goToProductPage(product).reviewWithOutRating(myReview);
    }

}