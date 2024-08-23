package wdio.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import wdio.utils.BaseScreen;

public class MenuScreen extends BaseScreen {

    public MenuScreen(AndroidDriver driver) {
        super(driver);
        WebElement[] basicElements = {
                this.homeButton,
                this.webViewButton,
                this.loginButton,
                this.formsButton,
                this.swipeButton,
                this.dragButton
        };
        setBasicElements(basicElements);
    }

    @AndroidFindBy(accessibility="Home")
    private WebElement homeButton;

    @AndroidFindBy(accessibility="Webview")
    private WebElement webViewButton;

    @AndroidFindBy(accessibility="Login")
    private WebElement loginButton;

    @AndroidFindBy(accessibility="Forms")
    private WebElement formsButton;

    @AndroidFindBy(accessibility="Swipe")
    private WebElement swipeButton;

    @AndroidFindBy(accessibility="Drag")
    private WebElement dragButton;

    public HomeScreen tapHomeHref(){
        this.homeButton.click();
        return new HomeScreen(this.getDriver());
    }

    public WebViewScreen tapWebViewHref(){
        this.webViewButton.click();
        return new WebViewScreen(this.getDriver());
    }

    public LoginScreen tapLoginRegisterHref(){
        this.loginButton.click();
        return new LoginScreen(this.getDriver());
    }

    public FormsScreen tapFormsHref(){
        this.formsButton.click();
        return new FormsScreen(this.getDriver());
    }

    public SwipeScreen tapSwipeHref(){
        this.swipeButton.click();
        return new SwipeScreen(this.getDriver());
    }

    public DragScreen tapDragHref(){
        this.dragButton.click();
        return new DragScreen(this.getDriver());
    }
}
