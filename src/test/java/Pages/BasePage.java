package Pages;

import Utilities.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public static WebDriver driver;

    protected ChromeOptions chromeOptions;

    public LoginPage loginPage;
    public MainPage mainPage;
    protected Utilities utilities;

    public void initElements(WebDriver remoteDriver, Object aPage) {
        PageFactory.initElements(remoteDriver, aPage);

    }
    public void getToAnUrl(String anUrl) {
        driver.get(anUrl);

    }
    public LoginPage startTest() {
        loginPage = new LoginPage(driver);
        return loginPage;

    }
    public boolean isWebElementEnabled(WebElement aWebElement){
        return aWebElement.isEnabled();

    }
    public String getCssValueFromWebElement(WebElement aWebElement, String propertyName){
        return aWebElement.getCssValue(propertyName);
    }
}
