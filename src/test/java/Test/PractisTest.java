package Test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PractisTest extends BaseTest{
    @Test(description = "By clicking in Do1 button Do2 will be enabled and Do1 disabled and vice versa")
    public void doButtonsTest(){
        loginPage = startTest();

        WebElement username = loginPage.getUsernameInput();
        username.sendKeys("admin");

        WebElement password = loginPage.getpasswordInput();
        password.sendKeys("admin");

        mainPage = loginPage.clickOnLoginBtn();

        WebElement doOneBtn = mainPage.getDoOneBtn();
        WebElement doTwoBtn = mainPage.getDoTwoBtn();

        Assert.assertTrue(mainPage.isWebElementEnabled(doOneBtn), "Do1 Button is not enabled");
        Assert.assertFalse(mainPage.isWebElementEnabled(doTwoBtn), "Do2 Button is enabled");

        doOneBtn.click();

        doOneBtn = mainPage.getDoOneBtn();
        doTwoBtn = mainPage.getDoTwoBtn();

        Assert.assertFalse(mainPage.isWebElementEnabled(doOneBtn), "Do1 Button is enabled after Do1 click");
        Assert.assertTrue(mainPage.isWebElementEnabled(doTwoBtn), "Do2 Button is not enabled after Do1 click");

        doTwoBtn.click();

        doOneBtn = mainPage.getDoOneBtn();
        doTwoBtn = mainPage.getDoTwoBtn();

        Assert.assertTrue(mainPage.isWebElementEnabled(doOneBtn), "Do1 Button is not enabled");
        Assert.assertFalse(mainPage.isWebElementEnabled(doTwoBtn), "Do2 Button is enabled");

    }
    @Test(description = "By clicking in increase and decrease buttons, the font of 'Click the buttons here to change the font size' " +
            "will increase or decrease by 3px")
    public void fontChangingSizeTest(){
        loginPage = startTest();

        WebElement username = loginPage.getUsernameInput();
        username.sendKeys("admin");

        WebElement password = loginPage.getpasswordInput();
        password.sendKeys("admin");

        mainPage = loginPage.clickOnLoginBtn();

        WebElement fontSize = mainPage.getTextFontSize();
        String fontSizeText = mainPage.getCssValueFromWebElement(fontSize, "font-size");

        int pixel = utilities.pixelsToInt(fontSizeText);
        Assert.assertEquals(pixel, 20);

        mainPage.clickOnIncreaseBtn();

        WebElement fontSizeIncreased = mainPage.getTextFontSize();
        String fontSizeIncreasedText = mainPage.getCssValueFromWebElement(fontSizeIncreased, "font-size");

        int pixelIncrease = utilities.pixelsToInt(fontSizeIncreasedText);
        Assert.assertEquals(pixelIncrease, 23, "the font size was not increased");

        mainPage.clickOnDecreaseBtn();
        mainPage.clickOnDecreaseBtn();

        WebElement fontSizeDecreased = mainPage.getTextFontSize();
        String fontSizeDecreasedText = mainPage.getCssValueFromWebElement(fontSizeDecreased, "font-size");

        int pixelDecrease = utilities.pixelsToInt(fontSizeDecreasedText);
        Assert.assertEquals(pixelDecrease, 17, "the font size was not decreased");

    }
    @Test(description = "By entering a valid background color in the input and clicking in 'SET BACKGROUND COLOR' button the div " +
            "element that contains both input and button will change its background color")
    public void backgroundColorChangingTest(){
        loginPage = startTest();

        WebElement username = loginPage.getUsernameInput();
        username.sendKeys("admin");

        WebElement password = loginPage.getpasswordInput();
        password.sendKeys("admin");

        mainPage = loginPage.clickOnLoginBtn();

        WebElement backgroundColorInput = mainPage.getBgColorInput();
        backgroundColorInput.sendKeys("red");

        mainPage.clickOnSetColorBtn();

        WebElement formToColorize = mainPage.getFormToColorize();
        String formToColorizeColorText = mainPage.getCssValueFromWebElement(formToColorize, "background");

        Assert.assertTrue(formToColorizeColorText.contains("rgb(255, 0, 0)"));

        backgroundColorInput.clear();
        backgroundColorInput.sendKeys("blue");

        mainPage.clickOnSetColorBtn();

        WebElement newFormToColorize = mainPage.getFormToColorize();
        String newFormToColorizeColorText = mainPage.getCssValueFromWebElement(newFormToColorize, "background");

        Assert.assertTrue(newFormToColorizeColorText.contains("rgb(0, 0, 255)"));

    }

}
