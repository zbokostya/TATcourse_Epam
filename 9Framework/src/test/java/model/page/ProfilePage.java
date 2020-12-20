package model.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends AbstractPage {

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailField;

    @FindBy(className = "account__control-link js-account-data-edit-link")
    private WebElement changeDataWindow;
    @FindBy(xpath = "//input[@name='address']")
    private WebElement addressField;
    @FindBy(className = "btn js-account-save-input")
    private WebElement saveButton;
    @FindBy(xpath = "//input[@name='address']")
    private WebElement address;

    public String getUserEmail() {
        return emailField.getText();
    }

    protected ProfilePage(RemoteWebDriver driver) {
        super(driver);
    }


    public ProfilePage openChangeDataWindow() {
        new WebDriverWait(driver, 10);
        changeDataWindow.click();
        return this;
    }

    public ProfilePage changeAddress(String address) {
        new WebDriverWait(driver, 10);
        addressField.sendKeys(address);
        return this;
    }

    public ProfilePage saveChanges() {
        new WebDriverWait(driver, 10);
        saveButton.click();
        return this;
    }

    public String getAddress() {
        new WebDriverWait(driver, 10);
        return address.getText();
    }

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException("");
    }
}
