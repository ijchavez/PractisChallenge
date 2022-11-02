package Test;

import Pages.BasePage;
import Utilities.Constants;
import Utilities.Utilities;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.awt.*;
import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.Map;


public class BaseTest extends BasePage {
    @BeforeTest
    public void setUpBrowser() throws IOException {
        this.setProperty(Constants.WEBDRIVER_CHROME, Constants.CHROMEDRIVER_FILE);

    }

    @BeforeMethod
    public void setUpBrowser(ITestContext context) throws AWTException, InterruptedException {
        chromeOptions = new ChromeOptions();

        addOptionsArgumentsForBrowser(chromeOptions);

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        utilities = new Utilities(driver);

        timeoutManager(10);

        initElements(driver, this);
        setContextAttribute(context, Constants.WEBDRIVER_ATTRIBUTE_VALUE, driver);

        getToAnUrl(Constants.PRACTIS_URL);
    }
    @AfterMethod
    public void closeDriver() throws InterruptedException {
        if (driver != null) {
            driver.quit();

        }

    }
    public void setProperty(String aWebDriver, String aChromeDriverFile) {
        System.setProperty(aWebDriver, aChromeDriverFile);

    }
    public void addOptionsArgumentsForBrowser(ChromeOptions aChromeDriverOptions) {
        aChromeDriverOptions.addArguments(Constants.START_MAXIMIZED, Constants.DISABLE_INFOBARS,
                                          Constants.DISABLE_EXTENSIONS, Constants.DISABLE_NOTIFICATIONS);
        aChromeDriverOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);


    }

    public void setContextAttribute(ITestContext aContext, String aWebDriverAttribute, WebDriver remoteDriver) {
        aContext.setAttribute(aWebDriverAttribute, remoteDriver);

    }
    public void timeoutManager(int seconds) {
        Duration dur = Duration.ofSeconds(seconds);
        driver.manage().timeouts().implicitlyWait(dur);

    }
    public String getCurrentDir(String anUserDir) {
        String currentDir = System.getProperty(Constants.USER_DIR);
        return currentDir;

    }

}
