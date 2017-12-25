package com.softserve.edu.opencart.tests.reviews;

import com.softserve.edu.opencart.data.products.IProduct;
import com.softserve.edu.opencart.data.products.ProductRepository;
import com.softserve.edu.opencart.data.reviews.IReview;
import com.softserve.edu.opencart.data.reviews.ReviewRepository;
import com.softserve.edu.opencart.db.service.ReviewService;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.tests.TestRunnerChromeWithoutUI;
import org.testng.Assert;
import org.testng.annotations.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.softserve.edu.opencart.tests.TestContextAttributes.REVIEW_FIELD_MESSAGE;

public class NegativeUserLogoutTest extends TestRunnerChromeWithoutUI {
    private ReviewService reviewService;

    @DataProvider
    public Object[][] productData() {
        return new Object[][]{
                {ProductRepository.get().macBook(), ReviewRepository.get().validNameValidTextWithRating()},
        };
    }

    @BeforeClass
    public void beforeDB() {
        reviewService = new ReviewService();
    }

    @AfterClass(alwaysRun = true)
    public void cleanDB() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String sDate = sdf.format(new Date());
        reviewService.deleteByDay(sDate);
    }

    @Test(dataProvider = "productData")
    public void testValidFields(IProduct product, IReview myReview) {
        String message = String.format(REVIEW_FIELD_MESSAGE.toString(), product.getName(),
                myReview.getCriterion());
        logger.info(message);
        reporter.info(message);

        flexAssert.assertTrue(Application.get().loadHomePage().goToProductPage(product).validReviewFieldsUserLogOut(myReview));
        //Assert.assertTrue(Application.get().loadHomePage().goToProductPage(product).validReviewFieldsUserLogOut(myReview));
    }
}