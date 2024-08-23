package wdio.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import wdio.utils.BaseScreen;

public class FormsScreen extends BaseScreen {

    public FormsScreen(AndroidDriver driver) {
        super(driver);
        WebElement[] basicElements = {
                this.title,
                this.inputFieldTitle,
                this.inputField,
                this.textFieldTitle,
                this.textField,
                this.switchTitle,
                this.switchElement,
                this.switchHelpText,
                this.dropdownTitle,
                this.dropDownInput

        };
        setBasicElements(basicElements);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Form components\")")
    private WebElement title;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Input field:\")")
    private WebElement inputFieldTitle;

    @AndroidFindBy(accessibility = "text-input")
    private WebElement inputField;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"You have typed:\")")
    private WebElement textFieldTitle;

    @AndroidFindBy(accessibility = "input-text-result")
    private WebElement textField;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Switch:\")")
    private WebElement switchTitle;

    @AndroidFindBy(accessibility = "switch")
    private WebElement switchElement;

    @AndroidFindBy(accessibility = "switch-text")
    private WebElement switchHelpText;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Dropdown:\")")
    private WebElement dropdownTitle;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"text_input\")")
    private WebElement dropDownInput;

}