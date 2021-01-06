package model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
        addItemToCart.click();
        return this;
    }

    public List<WebElement> getListElements() {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECOND).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='catalog__item js-catalog-item']")));
    }

    public CartPage openCart() {
        openBucketButton.click();
        return new CartPage(driver);
    }


}
