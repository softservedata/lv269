package com.softserve.edu.opencart.tests.reviews;

import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.data.products.IProduct;
import com.softserve.edu.opencart.data.products.ProductRepository;
import com.softserve.edu.opencart.data.reviews.IReview;
import com.softserve.edu.opencart.data.reviews.ReviewRepository;
import com.softserve.edu.opencart.db.service.ReviewService;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.tests.ATestRunnerReview;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import static com.softserve.edu.opencart.tests.TestContextAttributes.REVIEW_FIELD_MESSAGE;

@Epic("Test Review Form when user is NOT authenticated.")
public class NegativeUserLogoutTest extends ATestRunnerReview {

    @Override
    @BeforeClass
    public void beforeClass(ITestContext context) {
        logger.info("@BeforeClass for " + this.getClass().getName());
        Application.get(ApplicationSourceRepository.get().chromeImplicitServer7WithoutUIWindows());
        reporter = Application.get().reporter();
        //flexAssert = Application.get().flexAssert();

        reviewService = new ReviewService();
    }

    @Override
    @AfterClass(alwaysRun = true)
    public void afterClass() {
        logger.info("@AfterClass for " + this.getClass().getName());
        Application.remove();
    }

    @DataProvider
    public Object[][] productData() {
        return new Object[][]{
                {ProductRepository.get().macBook(), ReviewRepository.get().validNameValidTextWithRating()},
        };
    }

    @Description("Use valid data in fields.")
    @Test(dataProvider = "productData")
    public void testValidFields(IProduct product, IReview myReview) {
        String message = String.format(REVIEW_FIELD_MESSAGE.toString(), product.getName(),
                myReview.getCriterion());
        logger.info(message);
        reporter.info(message);

        //flexAssert.assertTrue(Application.get().loadHomePage().goToProductPage(product).validReviewFieldsUserLogOut(myReview));
        //Assert.assertTrue(Application.get().loadHomePage().goToProductPage(product).validReviewFieldsUserLogOut(myReview));
        Application.get().loadHomePage().goToProductPage(product).validReviewFieldsUserLogOut(myReview);
    }
}