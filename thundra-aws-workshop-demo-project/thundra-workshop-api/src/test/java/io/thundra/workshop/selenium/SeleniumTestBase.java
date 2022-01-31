package io.thundra.workshop.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SeleniumTestBase {

    private WebDriver driver;

    public SeleniumTestBase() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
    }

    protected void init() {
        if(driver == null) {
            DesiredCapabilities caps = DesiredCapabilities.chrome();

            caps.setCapability("chrome.switches", new String[]{"--disable-extensions"});
            caps.setCapability("version", "latest");
            caps.setCapability("platform", "Windows 10");
            caps.setCapability("screenResolution", "1280x1024");
            caps.setCapability("record_video", "false");

            this.driver = new ChromeDriver(caps);
        }
    }

    protected void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }
    public WebDriver getDriver() {
        return driver;
    }
}
