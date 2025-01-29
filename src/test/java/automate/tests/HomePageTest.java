package automate.tests;

import automate.basetest.BaseTest;
import automate.pages.HomePage;
import automate.pages.LoginPage;
import automate.utils.Utils;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

public class HomePageTest extends BaseTest {

    public LoginPage loginPage;
    public HomePage homePage;


    public HomePageTest() {
        super();
    }


    @BeforeMethod
    public void setUp() {
        launcher();

    }


    @Test(dataProvider = "getData")
    public void productAddToCartTest(HashMap<String, String> input) throws InterruptedException {
        loginPage = new LoginPage();
        homePage = loginPage.loginApplication(input.get("userid"), input.get("userpwd"));
        homePage.addProductsToCart();


    }

    @Test(dataProvider = "getData")
    public void filterFeatureTest(HashMap<String, String> input) {
        loginPage = new LoginPage();
        homePage = loginPage.loginApplication(input.get("userid"), input.get("userpwd"));
        homePage.filterProduct("Price (low to high)");

    }


    @DataProvider
    public Object[][] getData() {

        HashMap<Object, Object> map = new HashMap<Object, Object>();
        map.put("userid", "standard_user");
        map.put("userpwd", "secret_sauce");


        return new Object[][]{{map}};

    }


}
