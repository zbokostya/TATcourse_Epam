package model.page;

import model.model.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit' and text()='Вход']")
    private WebElement singInButton;

    protected LoginPage(RemoteWebDriver driver) {
        super(driver);
    }

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException("");
    }


    public HomePage signIn(User user) {
        inputSignInForm(user);
        singInButton.click();
        return new HomePage(driver);
    }

    public LoginPage inputSignInForm(User user) {
        emailField.sendKeys(user.getEmail());
        passwordField.sendKeys(user.getPassword());
        return this;
    }


}
