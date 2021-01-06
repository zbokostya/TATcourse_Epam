package model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends AbstractPage {

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailField;

    @FindBy(xpath = "//*[text()='Изменить данные']")
    private WebElement changeDataWindow;

    @FindBy(xpath = "//input[@name='address']")
    private WebElement addressField;

    @FindBy(xpath = "//input[@name='address']")
    private WebElement address;

    public String getUserEmail() {
        return emailField.getAttribute("value");
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
        addressField.clear();
        addressField.sendKeys(address);
        return this;
    }

    public ProfilePage saveChanges() {
        WebElement saveButton = new WebDriverWait(driver, 10).until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//input[@class='btn js-account-save-input']")));
        saveButton.click();
        return this;
    }

    public String getAddress() {
        return address.getAttribute("value");
    }

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException("");
    }
}
