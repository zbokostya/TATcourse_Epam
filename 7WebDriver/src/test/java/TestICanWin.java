import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestICanWin {
    WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://pastebin.com");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testCreatePaste() {
        WebElement pasteExpiration = waitForElementUntilAppearLocatedById(driver, By.xpath("//*[@id='w0']/div[5]/div[1]/div[2]/div/span/span[1]/span"));
        pasteExpiration.click();

        WebElement selectExpiration = waitForElementUntilAppearLocatedById(driver, By.xpath("//*[contains(@id,'select2-postform-expiration-result-') and contains(@id,'-10M')]"));
        selectExpiration.click();

        WebElement input = waitForElementLocatedById(driver, "postform-text");
        input.sendKeys("Hello from WebDriver");

        WebElement title = waitForElementLocatedById(driver, "postform-name");
        title.sendKeys("helloweb");

        WebElement createPaste = waitForElementUntilAppearLocatedById(driver, By.xpath("//div[@class='form-group form-btn-container']/button[@class='btn -big']"));
        createPaste.click();
    }

    private static WebElement waitForElementLocatedBy(WebDriver webDriver, By by) {
        return new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private static WebElement waitForElementLocatedById(WebDriver webDriver, String id) {
        return new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
    }

    private static WebElement waitForElementUntilAppearLocatedById(WebDriver webDriver, By by) {
        return new WebDriverWait(webDriver, 20).until(ExpectedConditions.elementToBeClickable(by));
    }
}
