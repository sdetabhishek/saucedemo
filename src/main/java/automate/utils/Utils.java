package automate.utils;

import automate.basetest.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils extends BaseTest {

    public static long timeUnit = 10;


    public static void explicitWait(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeUnit));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void selectDropdownOption(WebElement dropDown, String visiableText){

        Select select = new Select(dropDown);
        select.selectByVisibleText(visiableText);
    }
}
