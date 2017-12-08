package com.softserve.edu.opencart.tests.reviews;

import com.softserve.edu.opencart.data.products.IProduct;
import com.softserve.edu.opencart.data.products.ProductRepository;
import com.softserve.edu.opencart.data.reviews.IReview;
import com.softserve.edu.opencart.data.reviews.ReviewRepository;
import com.softserve.edu.opencart.pages.Application;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Serhiienko.
 */
public class PositiveUserLoginTest extends ALoginForTest {

    @DataProvider
    public Object[][] productData() {
        return new Object[][]{
                {ProductRepository.get().macBook(), ReviewRepository.get().validNameValidTextWithRating()},
        };
    }

    @Test(dataProvider = "productData")
    public void testValidFields(IProduct product, IReview myReview) {
        logger.info("Check valid fields when user is login");
        reporter.info("Check valid fields when user is login");

        Application.get().loadHomePage().goToProductPage(product)
                .validReviewFields(myReview);
    }

}
