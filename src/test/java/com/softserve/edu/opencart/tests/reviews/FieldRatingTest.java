package com.softserve.edu.opencart.tests.reviews;

import com.softserve.edu.opencart.data.products.IProduct;
import com.softserve.edu.opencart.data.products.ProductRepository;
import com.softserve.edu.opencart.data.reviews.IReview;
import com.softserve.edu.opencart.data.reviews.ReviewRepository;
import com.softserve.edu.opencart.pages.Application;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.softserve.edu.opencart.tests.TestContextAttributes.REVIEW_FIELD_MESSAGE;


/**
 * Created by Serhiienko.
 */

public class FieldRatingTest extends ALoginForTest {

    @DataProvider
    public Object[][] ratingData() {
        return new Object[][]{
                {ProductRepository.get().macBook(), ReviewRepository.get().validNameValidTextWithRating()},
        };
    }

    @Test(dataProvider = "ratingData")
    public void testOnlyRatingData(IProduct product, IReview myReview) {
        logger.info(String.format(REVIEW_FIELD_MESSAGE.toString(), product.getName(),
                myReview.getCriterion()));
        reporter.info(String.format(REVIEW_FIELD_MESSAGE.toString(), product.getName(),
                myReview.getCriterion()));

        Application.get().loadHomePage().goToProductPage(product).onlyReviewRating(myReview);
    }

    @Test(dataProvider = "ratingData")
    public void testValidDataWithOutRating(IProduct product, IReview myReview) {
        logger.info(String.format(REVIEW_FIELD_MESSAGE.toString(), product.getName(),
                myReview.getCriterion()));
        reporter.info(String.format(REVIEW_FIELD_MESSAGE.toString(), product.getName(),
                myReview.getCriterion()));

        Application.get().loadHomePage().goToProductPage(product).reviewWithOutRating(myReview);
    }

}