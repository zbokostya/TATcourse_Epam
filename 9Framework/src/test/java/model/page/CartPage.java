package model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends AbstractPage {
    private final String cartMessage = "//div[@class='summ-count-all row-table']/div[@class='col-table value']";

    protected CartPage(RemoteWebDriver driver) {
        super(driver);
    }

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException("This page can't be open without parameters");
    }

    public String getCartCountMessage() {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(cartMessage)))
                .getText();
    }
}
