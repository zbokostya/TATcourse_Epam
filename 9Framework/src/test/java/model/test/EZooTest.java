package model.test;

import model.page.FilterPage;
import model.page.HomePage;
import model.service.TestDataReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

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
        Assert.assertEquals(actualCartValue, "1 шт");
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
        List<WebElement> items = new FilterPage(driver)
                .openPage()
                .selectFilters(new String[]{
                        "Acana"
                        , "Orijen"})
                .selectSizeOption("Для всех пород", "250")
                .openFilteredItemsPage()
                .getListItems();
        Assert.assertFalse(items.isEmpty());
    }


}
