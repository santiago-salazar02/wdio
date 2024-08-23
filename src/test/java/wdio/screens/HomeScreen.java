package wdio.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import wdio.utils.BaseScreen;

public class HomeScreen extends BaseScreen {

    public HomeScreen(AndroidDriver driver){
        super(driver);
        WebElement[] basicElements = {
                this.robotImage,
                this.titleWebDriver,
                this.ioImage,
                this.descriptionText,
                this.appleLogo,
                this.androidLogo,
                this.supportText
        };
        setBasicElements(basicElements);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Home-screen\").childSelector(new UiSelector().className(\"android.widget.ImageView\").instance(0))")
    private WebElement robotImage;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"WEBDRIVER\")")
    private WebElement titleWebDriver;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Home-screen\").childSelector(new UiSelector().className(\"android.widget.ImageView\").instance(1))")
    private WebElement ioImage;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Demo app for the appium-boilerplate\")")
    private WebElement descriptionText;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"\uDB80\uDC35\")")
    private WebElement appleLogo;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"\uDB80\uDC32\")")
    private WebElement androidLogo;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Support\")")
    private WebElement supportText;

}