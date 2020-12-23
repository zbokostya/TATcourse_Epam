package model.test;

import model.page.FilterPage;
import model.page.HomePage;
import model.service.TestDataReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class EZooTest extends CommonConditions {

    public static final String TESTDATA_FILTER_BREED = "testdata.filter.breed";
    public static final String TESTDATA_SEARCH_TEXT = "testdata.search.text";
    public static final String TESTDATA_FILTER_SIZE = "testdata.filter.size";
    public static final String TESTDATA_FILTER_COMPANY1 = "testdata.filter.company1";
    public static final String TESTDATA_FILTER_COMPANY2 = "testdata.filter.company2";


    @Test
    public void addToCartTest() {
        String actualCartValue = new HomePage(driver)
                .openPage()
                .searchInputText(TestDataReader.getTestData(TESTDATA_SEARCH_TEXT))
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
                .searchInputText(TestDataReader.getTestData(TESTDATA_SEARCH_TEXT))
                .openSearchPage()
                .getListElements();
        Assert.assertFalse(actualSearchElements.isEmpty());
    }

    @Test
    public void selectItemByFiltersTest() {
        List<WebElement> items = new FilterPage(driver)
                .openPage()
                .selectFilters(new String[]{
                        TestDataReader.getTestData(TESTDATA_FILTER_COMPANY1),
                        TestDataReader.getTestData(TESTDATA_FILTER_COMPANY2)})
                .selectSizeOption(TestDataReader.getTestData(TESTDATA_FILTER_BREED),
                        TestDataReader.getTestData(TESTDATA_FILTER_SIZE))
                .openFilteredItemsPage()
                .getListItems();
        Assert.assertFalse(items.isEmpty());
    }


}
