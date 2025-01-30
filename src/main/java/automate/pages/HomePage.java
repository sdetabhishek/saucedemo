package automate.pages;

import automate.basetest.BaseTest;
import automate.utils.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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


    }


    public void filterProduct(String filterName) {

        Utils.selectDropdownOption(filterDropdown, filterName);


    }

}