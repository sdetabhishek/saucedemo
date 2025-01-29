package automate.pages;

import automate.basetest.BaseTest;
import automate.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomePage extends BaseTest {


    public HomePage() {

        PageFactory.initElements(driver, this);
    }


    @FindBy(className = "btn_primary")
    WebElement addToCartButton;


    @FindBy(className = "shopping-cart")
    WebElement shoppingCartButton;

    @FindBy(className = "product_sort_container")
    WebElement filterDropdown;


    public void addProductsToCart() throws InterruptedException {


        addToCartButton.click();
        Thread.sleep(2000);


    }


    public void filterProduct(String filterName) {

        Utils.selectDropdownOption(filterDropdown, filterName);

        List<WebElement> allProducts = driver.findElements(By.className("inventory_item_price"));

        List<Double> list = new ArrayList<Double>();

        for (WebElement allProduct : allProducts) {

            list.add(Double.valueOf(allProduct.getText().replace("$", "")));


        }
        System.out.println(list);


    }

}