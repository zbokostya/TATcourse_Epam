package model.test;

import model.driver.DriverSingleton;
import model.util.TestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;


import java.net.MalformedURLException;

@Listeners({TestListener.class})
public class CommonConditions {
    private final Logger logger = LogManager.getRootLogger();

    protected RemoteWebDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}
