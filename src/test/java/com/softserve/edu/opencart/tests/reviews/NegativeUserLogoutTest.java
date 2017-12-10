package com.softserve.edu.opencart.tests.reviews;

import com.softserve.edu.opencart.data.products.IProduct;
import com.softserve.edu.opencart.data.products.ProductRepository;
import com.softserve.edu.opencart.data.reviews.IReview;
import com.softserve.edu.opencart.data.reviews.ReviewRepository;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.tests.TestRunner;
import com.softserve.edu.opencart.tests.TestRunnerPhantomJS;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.softserve.edu.opencart.tests.TestContextAttributes.REVIEW_FIELD_MESSAGE;

public class NegativeUserLogoutTest extends TestRunnerPhantomJS {


    @DataProvider
    public Object[][] productData() {
        return new Object[][]{
                {ProductRepository.get().macBook(), ReviewRepository.get().validNameValidTextWithRating()},
        };
    }

    @Test(dataProvider = "productData")
    public void testValidFields(IProduct product, IReview myReview) {
        logger.info(String.format(REVIEW_FIELD_MESSAGE.toString(), product.getName(),
                myReview.getCriterion()));
        reporter.info(String.format(REVIEW_FIELD_MESSAGE.toString(), product.getName(),
                myReview.getCriterion()));

        Application.get().loadHomePage().goToProductPage(product)
                .validReviewFieldsUserLogOut(myReview);
    }
}