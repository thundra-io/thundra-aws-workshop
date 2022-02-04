package io.thundra.workshop.selenium;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.nio.file.Paths;

public class SeleniumTestBase {


    private final DesiredCapabilities capabilities;
    private final String osName;

    protected WebDriver driver;
    protected String baseUrl;

    public SeleniumTestBase() {
        this.osName = System.getProperty("os.name");

        String driverPath = Paths.get(System.getProperty("user.dir"), "chromedriver").toString();

        System.setProperty("webdriver.chrome.driver", driverPath + (osName.contains("Windows") ? ".exe": ""));

       capabilities = DesiredCapabilities.chrome();

    }

    public void init(String viewURL) throws RuntimeException {
        if(driver == null) {


            ChromeOptions options = new ChromeOptions();
            
            options.addArguments("--window-size=1280,1024");
            options.addArguments("--headless");

            String binaryPath;

            if(osName.contains("Windows")) {
                binaryPath = Paths.get(System.getenv("ProgramFiles"),
                        "Google", "Chrome", "Application", "chrome.exe").toString();
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
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void getScreenShot(){
        ChromeDriver driver = (ChromeDriver) this.driver;
        driver.getScreenshotAs(OutputType.FILE);
    }
}
