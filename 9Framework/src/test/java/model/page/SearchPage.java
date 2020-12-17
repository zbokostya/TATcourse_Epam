package model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage extends AbstractPage {

    @FindBy(css = ".product__variant-submit")
    private WebElement addItemToCart;

    @FindBy(className = "basket-field__icon")
    private WebElement openBucketButton;

    protected SearchPage(RemoteWebDriver driver) {
        super(driver);
    }

    @Override
    public SearchPage openPage() {
        throw new RuntimeException("This page can't be open without parameters");
    }

    public SearchPage addItemToCart() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECOND);
        addItemToCart.click();
        return this;
    }

    public List<WebElement> getListElements() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECOND);
        return driver.findElements(By.className("catalog__item js-catalog-item"));
    }

    public CartPage openCart() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECOND);
        openBucketButton.click();
        return new CartPage(driver);
    }


}
