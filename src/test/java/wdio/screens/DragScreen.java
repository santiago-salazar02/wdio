package wdio.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import wdio.utils.BaseScreen;

public class DragScreen extends BaseScreen {

    public DragScreen(AndroidDriver driver) {
        super(driver);
        WebElement[] basicElements =  {this.title,
                this.robotImage,
                this.refreshButton,
                this.firstPuzzleImage,
                this.secondPuzzleImage,
                this.thirdPuzzleImage,
                this.fourthPuzzleImage,
                this.fifthPuzzleImage,
                this.sixthPuzzleImage,
                this.seventhPuzzleImage,
                this.eighthPuzzleImage,
                this.ninthPuzzleImage};
        setBasicElements(basicElements);
    }


    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Drag and Drop\")")
    private WebElement title;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(0)")
    private WebElement robotImage;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"\uDB80\uDC6A\")")
    private WebElement refreshButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(1)")
    private WebElement firstPuzzleImage;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(2)")
    private WebElement secondPuzzleImage;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(3)")
    private WebElement thirdPuzzleImage;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(4)")
    private WebElement fourthPuzzleImage;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(5)")
    private WebElement fifthPuzzleImage;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(6)")
    private WebElement sixthPuzzleImage;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(7)")
    private WebElement seventhPuzzleImage;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(8)")
    private WebElement eighthPuzzleImage;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(9)")
    private WebElement ninthPuzzleImage;
}
