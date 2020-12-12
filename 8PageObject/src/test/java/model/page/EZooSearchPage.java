package model.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EZooSearchPage extends AbstractPage {

    @FindBy(css = ".product__variant-submit")
    private WebElement addItemToCart;

    @FindBy(className = "basket-field__icon")
    private WebElement openBucketButton;

    protected EZooSearchPage(RemoteWebDriver driver) {
        super(driver);
    }

    @Override
    public EZooSearchPage openPage() {
        throw new RuntimeException("This page can't be open without parameters");
    }

    public EZooSearchPage addItemToCart() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECOND);
        addItemToCart.click();
        return this;
    }

    public EZooCartPage openCart() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECOND);
        openBucketButton.click();
        return new EZooCartPage(driver);
    }


}
