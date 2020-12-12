package model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class EZooItemsPage extends AbstractPage{

    protected EZooItemsPage(RemoteWebDriver driver) {
        super(driver);
    }

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException("");
    }

    public List<WebElement> getListItems(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECOND);
        List<WebElement> items = driver.findElements(By.xpath("//div[@class='catalog__item js-catalog-item']"));
        return items;
    }

}
