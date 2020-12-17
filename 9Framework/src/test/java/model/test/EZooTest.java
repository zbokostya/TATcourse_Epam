package model.test;

import model.driver.DriverSingleton;
import model.page.FilterPage;
import model.page.HomePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EZooTest extends CommonConditions {

    @Test
    public void addToCartTest() {
        String actualCartValue = new HomePage(driver)
                .openPage()
                .searchInputText("Brit care")
                .openSearchPage()
                .addItemToCart()
                .openCart()
                .getCartCountMessage();
        Assert.assertEquals("1 шт", actualCartValue);
    }

    @Test
    public void searchProductTest() {
        List<WebElement> actualSearchElements = new HomePage(driver)
                .openPage()
                .searchInputText("Brit care")
                .openSearchPage()
                .getListElements();
        Assert.assertFalse(actualSearchElements.isEmpty());
    }

    @Test
    public void selectItemByFiltersTest() {
        String[] filters = {"Acana", "Orijen"};
        List<WebElement> items = new FilterPage(driver)
                .openPage()
                .selectFilters(filters)
                .selectSizeOption()
                .openFilteredItemsPage()
                .getListItems();
        Assert.assertFalse(items.isEmpty());
    }



    @After
    public void tearDown() {
        DriverSingleton.closeDriver();
    }
}
