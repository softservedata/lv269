package com.softserve.edu.opencart.tests.smoke;

import com.softserve.edu.opencart.data.products.ProductRepository;
import com.softserve.edu.opencart.data.users.UserRepository;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.pages.user.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Serhiienko.
 */
public class ProductPageTest {

    @BeforeClass
    public static void precondition() {
        Application.get().login().loginForLoginPageToMyAccountPage(UserRepository.get().valid().getEmail(),
                UserRepository.get().valid().getPassword());
    }

    @AfterClass
    public static void logOut() {
        Application.get().logout();
        Application.remove();
    }

    @Test
    public void testCheckProductPage() {

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
