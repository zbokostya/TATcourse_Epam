package model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FilterPage extends AbstractPage {
    private static final String HOME_PAGE_URL = "https://e-zoo.by/catalog/sobaki-suhie-korma";


    public FilterPage(RemoteWebDriver driver) {
        super(driver);
    }

    public FilterPage selectFilters(String[] filters) {
        for (String filter : filters) {
            new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
                    .until(ExpectedConditions
                            .presenceOfElementLocated(
                                    By.xpath("//div[@class='jq-checkbox js-styler js-filter-brands-checkbox']/following-sibling::a[text()='" + filter + "']")))
                    .click();
        }
        return this;
    }

    public FilterPage selectSizeOption() {
        WebElement selectElement = driver.findElement(By.name("250"));
        Select select = new Select(selectElement);
        select.selectByValue("Для всех пород");
        return this;
    }

    public ItemsPage openFilteredItemsPage() {
        WebElement filterButton = new WebDriverWait(driver,WAIT_TIMEOUT_SECOND)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//a[@class='sidebar-filter__tooltip js-sidebar-filter-tooltip is-visible']")));
        filterButton.click();
        return new ItemsPage(driver);
    }

    @Override
    public FilterPage openPage() {
        driver.get(HOME_PAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECOND);
        return this;
    }
}
