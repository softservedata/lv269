package com.softserve.edu.opencart.tests.smoke;

import com.softserve.edu.opencart.data.products.ProductRepository;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.pages.user.ProductPage;
import com.softserve.edu.opencart.tests.TestRunnerChromeWithoutUI;
import org.testng.annotations.Test;

/**
 * Created by Serhiienko.
 */
public class ProductPageTest extends TestRunnerChromeWithoutUI {

    @Test
    public void testCheckProductPage() {
        logger.info("Check ProductPage.");
        reporter.info("Check ProductPage.");

        ProductPage productPage = Application.get().loadHomePage()
                .goToProductPage(ProductRepository.get().macBook())
                .checkClickToAddToCart().checkClickToAddToWish();

        productPage.clickReview();
        productPage.clickReviewNameField();
        productPage.setReviewNameField("check");
        productPage.clearReviewNameField();

        productPage.clickReviewTextField();
        productPage.setReviewTextField("check");
        productPage.clearReviewTextField();

        productPage.setReviewRating(1);

        productPage.clickReviewButton();

        productPage.clickQuantityField();
        productPage.setQuantityField("1");
        productPage.clearQuantityField();

        productPage.clickSpecification();
        productPage.clickDescription();

    }
}