package com.softserve.edu.opencart.tests.reviews;

import com.softserve.edu.opencart.data.products.ProductRepository;
import com.softserve.edu.opencart.data.reviews.IReview;
import com.softserve.edu.opencart.data.reviews.ReviewRepository;
import com.softserve.edu.opencart.pages.Application;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NegativeUserLogout {


    @DataProvider
    public Object[][] productData() {
        return new Object[][]{
                {ProductRepository.get().macBook().getName(), ReviewRepository.get().validNameValidTextWithRating()},
        };
    }

    @AfterClass
    public static void logOut() {
        Application.remove();
    }

    @Test(dataProvider = "productData")
    public void validFields(String productName, IReview myReview) {
        Application.get().loadHomePage().goToProductPage(productName)
                .validReviewFieldsUserLogOut(myReview);
    }
}