package io.thundra.workshop.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.nio.file.Paths;

import io.thundra.workshop.common.Constants;

public class SeleniumTestBase {


    private final DesiredCapabilities capabilities;
    private final String osName;

    protected WebDriver driver;
    protected String baseUrl;

    public SeleniumTestBase() {
        this.osName = System.getProperty("os.name");
        String driverPath = Paths.get(System.getProperty("user.dir"),
               "src", "test", "resources", "chromedriver").toString();

        System.setProperty("webdriver.chrome.driver", driverPath + (osName.contains("Windows") ? ".exe": ""));

       capabilities = DesiredCapabilities.chrome();

    }

    public void init(String viewURL) throws RuntimeException {
        if(driver == null) {


            ChromeOptions options = new ChromeOptions();

            options.addArguments("--no-sandbox");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1280,1024");

            String binaryPath;

            if(osName.contains("Windows")) {
                binaryPath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
            }
            else if(osName.contains("Mac")) {
                binaryPath = "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome";
            }
            else if (osName.contains("Linux")) {
                binaryPath = "/usr/bin/google-chrome";
            }
            else {
                throw new RuntimeException("Unsupported OS: " + osName);
            }

            options.setBinary(binaryPath);


            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            capabilities.setCapability(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, System.getProperty("webdriver.chrome.driver"));
            capabilities.setCapability("chrome.version", "98");


            this.baseUrl = viewURL;

            if(this.baseUrl == null || this.baseUrl.isEmpty())
                throw new RuntimeException("Thundra Workshop WEB CONTENT RETRIEVER URL is not set");

        }
    }


    public String getBaseUrl() {
        return this.baseUrl;
    }
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public  void setupDriver(){
        this.driver = new ChromeDriver(ChromeDriverService.createDefaultService(), capabilities);
    }

    public void tearDown() {
        if(driver != null) {
            driver.close();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
