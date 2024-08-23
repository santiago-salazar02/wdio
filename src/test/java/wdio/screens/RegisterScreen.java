package wdio.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import wdio.utils.BaseScreen;

public class RegisterScreen extends BaseScreen {

    public RegisterScreen(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(accessibility = "input-email")
    private WebElement emailInput;

    @AndroidFindBy(accessibility = "input-password")
    private WebElement passwordInput;

    @AndroidFindBy(accessibility = "input-repeat-password")
    private WebElement repeatPasswordInput;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"SIGN UP\")")
    private WebElement registerButton;

    @AndroidFindBy(id="android:id/alertTitle")
    private WebElement titleRegisterPopUp;

    @AndroidFindBy(id="android:id/button1")
    private WebElement okButtonPopUp;

    public void register(String email, String password){
        this.emailInput.sendKeys(email);
        this.passwordInput.sendKeys(password);
        this.repeatPasswordInput.sendKeys(password);
        this.registerButton.click();
    }

    public boolean isTitleRegisterPopUpVisible(){
        return this.titleRegisterPopUp.isDisplayed();
    }

    public void tapOkButtonPopUp(){
        this.okButtonPopUp.click();
    }
}
