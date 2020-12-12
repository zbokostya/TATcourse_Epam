package model.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EZooHomePage extends AbstractPage {

    private static final String HOME_PAGE_URL = "https://e-zoo.by/";

    @FindBy(xpath = "//input[@class='search-field__input js-search-autocomplete']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@class='search-field__btn']")
    private WebElement searchButton;

    public EZooHomePage(RemoteWebDriver driver) {
        super(driver);
    }

    public EZooHomePage openPage() {
        driver.get(HOME_PAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECOND);
        return this;
    }

    public EZooHomePage searchInputText(String text) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECOND);
        searchField.sendKeys("Brit care");
        return this;
    }

    public EZooSearchPage openSearchPage() {
        new WebDriverWait(driver,WAIT_TIMEOUT_SECOND);
        searchButton.click();
        return new EZooSearchPage(driver);
    }

}
