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
public class FieldTextTest extends ALoginForTest {

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

    @Test(dataProvider = "notValidTextData")
    public void testNotValidData(IProduct product, IReview myReview) {
        Application.get().loadHomePage().goToProductPage(product).notValidReviewFields(myReview);
    }

    @Test(dataProvider = "validTextData")
    public void testValidData(IProduct product, IReview myReview) {
        Application.get().loadHomePage().goToProductPage(product).validReviewFields(myReview);
    }

}
