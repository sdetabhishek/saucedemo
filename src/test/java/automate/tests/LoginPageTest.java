package automate.tests;

import automate.Retry.Retryer;
import automate.basetest.BaseTest;
import automate.pages.LoginPage;
import automate.utils.Utils;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.HashMap;

public class LoginPageTest extends BaseTest {

    public LoginPage loginPage;


    public LoginPageTest() {
        super();
    }


    @BeforeMethod
    public void setUp() {
        launcher();

    }

    @Test(dataProvider = "getData")
    public void loginApplicationTest(HashMap<String, String> input) {
        loginPage = new LoginPage();
        loginPage.loginApplication(input.get("userid"), input.get("userpwd"));
        Utils.explicitWait(driver.findElement(By.className("app_logo")));

    }


    @Test(dataProvider = "getInvalidData", retryAnalyzer = Retryer.class)
    public void loginApplicationTestInvalidDetails(HashMap<String, String> input) {
        loginPage = new LoginPage();
        loginPage.loginApplication(input.get("userid"), input.get("userpwd"));
        WebElement errorMessage = driver.findElement(By.xpath("//h3[text()='Username and password do not match any user in this service']"));
        Assert.assertEquals(errorMessage.getText(), "Epic sadface: Username and password do not match any user in this service");

    }


    @AfterMethod
    public void tearDown() {
        driver.close();
    }


    @DataProvider
    public Object[][] getData() {

        HashMap<Object, Object> map = new HashMap<Object, Object>();
        map.put("userid", "standard_user");
        map.put("userpwd", "secret_sauce");

        HashMap<Object, Object> map1 = new HashMap<Object, Object>();
        map1.put("userid", "problem_user");
        map1.put("userpwd", "secret_sauce");

        return new Object[][]{{map}, {map1}};

    }


    @DataProvider
    public Object[][] getInvalidData() {

        HashMap<Object, Object> map = new HashMap<Object, Object>();
        map.put("userid", "invalid_user");
        map.put("userpwd", "secret_sauce");


        return new Object[][]{{map}};

    }
}
