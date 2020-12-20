package model.driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class DriverSingleton {
    private static final Logger logger = LogManager.getRootLogger();
    private static RemoteWebDriver driver;
    // chrome
    // "87.0"


    private DriverSingleton() {
    }

    public static RemoteWebDriver getDriver() throws MalformedURLException {
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
        logger.info("get driver");
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
