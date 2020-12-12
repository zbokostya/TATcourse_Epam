package model.test;

import model.page.EZooFilterPage;
import model.page.EZooHomePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EZooTest {

    private RemoteWebDriver driver;

    @Before
    public void browserUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "87.0");
        Map<String, Object> cnt = new HashMap<>();
        cnt.put("enableVNC", true);
        cnt.put("enableVideo", false);
        capabilities.setCapability("selenoid:options", cnt);
        driver = new RemoteWebDriver(
                URI.create("http://51.15.53.117:8080/wd/hub").toURL(),
                capabilities
        );
    }

    @Test
    public void addToCartTest() {
        String actualCartValue = new EZooHomePage(driver)
                .openPage()
                .searchInputText("Brit care")
                .openSearchPage()
                .addItemToCart()
                .openCart()
                .getCartCountMessage();
        Assert.assertEquals("1 шт", actualCartValue);
    }

    @Test
    public void selectItemByFiltersTest() {
        String[] filters = {"Acana", "Orijen"};
        List<WebElement> items = new EZooFilterPage(driver)
                .openPage()
                .selectFilters(filters)
                .selectSizeOption()
                .openFilteredItemsPage()
                .getListItems();
        Assert.assertFalse(items.isEmpty());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
