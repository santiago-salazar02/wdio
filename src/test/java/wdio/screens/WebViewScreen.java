package wdio.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import wdio.utils.BaseScreen;

public class WebViewScreen extends BaseScreen {

    public WebViewScreen(AndroidDriver driver) {
        super(driver);
        WebElement[] basicElements = {
                this.burguerMenu,
                this.IOImage,
                this.search,
                this.robotImage,
                this.infoText,
                this.copilotImage
        };
        setBasicElements(basicElements);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Toggle navigation bar\")")
    private WebElement burguerMenu;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Main\").childSelector(new UiSelector().description(\"WebdriverIO\"))")
    private WebElement IOImage;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Search\")")
    private WebElement search;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"WebdriverIO\").instance(1)")
    private WebElement robotImage;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Next-gen browser and mobile automation test framework for Node.js\")")
    private WebElement infoText;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"WebdriverIO AI Copilot\")")
    private WebElement copilotImage;

}