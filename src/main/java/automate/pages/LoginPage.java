package automate.pages;

import automate.basetest.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {


    public LoginPage() {

        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    WebElement username;

    @FindBy(id = "password")
    WebElement userpassword;

    @FindBy(id = "login-button")
    WebElement loginbutton;


    public HomePage loginApplication(String user, String pwd) {

        username.sendKeys(user);
        userpassword.sendKeys(pwd);
        loginbutton.click();
        return new HomePage();


    }

}
