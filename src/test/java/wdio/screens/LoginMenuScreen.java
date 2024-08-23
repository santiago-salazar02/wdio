package wdio.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import wdio.utils.BaseScreen;

public class LoginMenuScreen extends BaseScreen {


    public LoginMenuScreen(AndroidDriver driver) {
        super(driver);
        WebElement[] basicElements = {
                this.loginButtonSectionChanger,
                this.registerButtonSectionChanger,
        };
        setBasicElements(basicElements);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Login\").instance(0)")
    private WebElement loginButtonSectionChanger;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Sign up\")")
    private WebElement registerButtonSectionChanger;

    public RegisterScreen tapRegisterButtonSectionChanger(){
        this.registerButtonSectionChanger.click();
        return new RegisterScreen(this.getDriver());
    }

    public LoginScreen tapLoginButtonSectionChanger(){
        this.loginButtonSectionChanger.click();
        return new LoginScreen(this.getDriver());
    }
}
