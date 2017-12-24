package com.softserve.edu.opencart.tests.reviews;

import com.softserve.edu.opencart.data.products.IProduct;
import com.softserve.edu.opencart.data.products.ProductRepository;
import com.softserve.edu.opencart.data.reviews.IReview;
import com.softserve.edu.opencart.data.reviews.ReviewRepository;
import com.softserve.edu.opencart.pages.Application;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.softserve.edu.opencart.tests.TestContextAttributes.REVIEW_FIELD_MESSAGE;

/**
 * Created by Serhiienko.
 */

public class FieldNameTest extends ALoginForTest {

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

    @Test(dataProvider = "notValidNameData")
    public void testNotValidData(IProduct product, IReview myReview) {
        String message = String.format(REVIEW_FIELD_MESSAGE.toString(), product.getName(),
                myReview.getCriterion());
        logger.info(message);
        reporter.info(message);

        flexAssert.assertTrue(Application.get().loadHomePage().goToProductPage(product).notValidReviewFields(myReview));
        //Assert.assertTrue(Application.get().loadHomePage().goToProductPage(product).notValidReviewFields(myReview));
    }

    @Test(dataProvider = "validNameData")
    public void testValidData(IProduct product, IReview myReview) {
        String message = String.format(REVIEW_FIELD_MESSAGE.toString(), product.getName(),
                myReview.getCriterion());
        logger.info(message);
        reporter.info(message);

        flexAssert.assertTrue(Application.get().loadHomePage().goToProductPage(product).validReviewFields(myReview));
        //Assert.assertTrue(Application.get().loadHomePage().goToProductPage(product).validReviewFields(myReview));
    }

}
