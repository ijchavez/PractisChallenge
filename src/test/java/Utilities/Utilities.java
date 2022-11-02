package Utilities;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Utilities extends BasePage {
    public Utilities(WebDriver remoteDriver){
        driver = remoteDriver;
        initElements(driver, this);

    }
    public Utilities(){

    }
    public int pixelsToInt(String aPixelSize){
        Assert.assertTrue(aPixelSize.endsWith("px"));

        String newIntToBeParsed = aPixelSize.substring(0, aPixelSize.length() - 2);
        return Integer.parseInt(newIntToBeParsed);

    }

}
