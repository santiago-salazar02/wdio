package wdio.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import wdio.utils.BaseScreen;

public class LoginScreen extends BaseScreen {

    public LoginScreen(AndroidDriver driver) {
        super(driver);
        WebElement[] basicElements = {
                this.title,
                this.emailInput,
                this.passwordInput,
                this.helpText,
                this.loginButton
        };
        setBasicElements(basicElements);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Login / Sign up Form\")")
    private WebElement title;


    @AndroidFindBy(accessibility = "input-email")
    private WebElement emailInput;

    @AndroidFindBy(accessibility = "input-password")
    private WebElement passwordInput;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"When the device has Touch/FaceID (iOS) or FingerPrint enabled a biometrics button will be shown to use and test the login.\")")
    private WebElement helpText;

    @AndroidFindBy(accessibility = "button-LOGIN")
    private WebElement loginButton;

    @AndroidFindBy(id="android:id/alertTitle")
    private WebElement titleLoginPopUp;



    public void login(String email,String password){
        this.emailInput.sendKeys(email);
        this.passwordInput.sendKeys(password);
        this.loginButton.click();
    }

    public boolean isTitleLoginPopUpVisible(){
        return this.titleLoginPopUp.isDisplayed();
    }

}
