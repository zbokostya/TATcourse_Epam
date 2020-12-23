package model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ItemsPage extends AbstractPage{

    protected ItemsPage(RemoteWebDriver driver) {
        super(driver);
    }

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException("This page can't be open without parameters");
    }

    public List<WebElement> getListItems(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECOND);
        List<WebElement> items = driver.findElements(By.xpath("//div[@class='catalog__item js-catalog-item']"));
        return items;
    }

}
