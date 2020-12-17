package model.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends AbstractPage {

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailField;

    public String getUserEmail() {
        return emailField.getText();
    }

    protected ProfilePage(RemoteWebDriver driver) {
        super(driver);
    }


    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException("");
    }
}
