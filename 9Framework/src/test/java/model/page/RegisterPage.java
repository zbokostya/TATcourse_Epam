package model.page;

import model.model.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends AbstractPage {

    @FindBy(xpath = "//input[@name='name']")
    private WebElement nameField;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()='Регистрация']")
    private WebElement registerButton;

    @FindBy(className = "js-styler js-filter-brands-checkbox error")
    private WebElement checkBox;


    public HomePage register() {
        registerButton.click();
        return new HomePage(driver);
    }

    public RegisterPage inputRegisterInForm(User user) {
        nameField.sendKeys(user.getName());
        emailField.sendKeys(user.getEmail());
        passwordField.sendKeys(user.getPassword());
        return this;
    }

    protected RegisterPage(RemoteWebDriver driver) {
        super(driver);
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }
}
