import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestAddToCart {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://e-zoo.by/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testCreatePaste() throws InterruptedException {
        if (driver.findElements(By.xpath("//div[@id='your_city-window']")).size() != 0) {
            WebElement cityButton = waitForElementLocatedBy(driver, By.xpath("//div[@id='your_city-window']/form[@class='js-validation-form tex-center center']/button[@class='btn'][1]"));
            cityButton.click();
        }

        WebElement searchInput = waitForElementLocatedBy(driver, By.xpath("//input[@class='search-field__input js-search-autocomplete']"));
        searchInput.sendKeys("Brit care");

        WebElement searchButton = waitForElementLocatedBy(driver, By.xpath("//button[@class='search-field__btn']"));
        searchButton.click();

        WebElement addToBucket = waitForElementLocatedBy(driver, By.xpath("//div[@class='catalog__item js-catalog-item'][2]/div[@class='cart js-cart']/div[@class='cart__inner']/div[@class='product__variant-table product__variant-table-small']/form[@class='product__variant js-cart-basket-submit']/div[@class='product__variant-cell product__variant-submit']/button[@class='btn btn_small basket-btn product__basket-btn js-cart-basket-btn ']"));
        addToBucket.click();

        WebElement goToBucket = waitForElementLocatedBy(driver, By.className("basket-field__icon"));
        goToBucket.click();

        WebElement actual = waitForElementLocatedBy(driver, By.xpath("//div[@class='summ-count-all row-table']/div[@class='col-table value']"));

        String expected = "1 шт";
        String actualString = actual.getText();

        Assert.assertEquals(expected, actualString);
    }

    private static WebElement waitForElementLocatedBy(WebDriver webDriver, By by) {
        return new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private static WebElement waitForElementLocatedById(WebDriver webDriver, String id) {
        return new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
    }

}
