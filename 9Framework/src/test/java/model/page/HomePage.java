package model.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

    private static final String HOME_PAGE_URL = "https://e-zoo.by/";

    @FindBy(xpath = "//input[@class='search-field__input js-search-autocomplete']")
    private WebElement searchField;

    @FindBy(className = "account-field__name-link")
    private WebElement profileButton;

    @FindBy(xpath = "//button[@class='search-field__btn']")
    private WebElement searchButton;

    @FindBy(className = "account-field__control-link")
    private WebElement loginButton;

    @FindBy(xpath = "//a[text()='Регистрация']")
    private WebElement registerButton;

    public HomePage(RemoteWebDriver driver) {
        super(driver);
    }

    public HomePage openPage() {
//        logger.info(driver);
        driver.navigate().to(HOME_PAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECOND);
        logger.info("Main page opened");
        return this;
    }

    public HomePage searchInputText(String text) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECOND);
        searchField.sendKeys("Brit care");
        return this;
    }

    public SearchPage openSearchPage() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECOND);
        searchButton.click();
        return new SearchPage(driver);
    }

    public ProfilePage openProfilePage() {
        profileButton.click();
        return new ProfilePage(driver);
    }

    public LoginPage openSignInPage() {
        loginButton.click();
        return new LoginPage(driver);
    }

    public RegisterPage openRegisterPage() {
        registerButton.click();
        return new RegisterPage(driver);
    }

}
