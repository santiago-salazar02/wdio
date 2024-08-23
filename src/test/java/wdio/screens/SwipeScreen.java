package wdio.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import wdio.utils.BaseScreen;

import java.util.List;
import java.util.Objects;

public class SwipeScreen extends BaseScreen {

    public SwipeScreen(AndroidDriver driver) {
        super(driver);
        WebElement[] basicElements = {
                this.title,
                this.helperTitleText,
                this.actualCardImage,
                this.actualCardSubTitle,
                this.actualCardDescription
        };
        setBasicElements(basicElements);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Swipe horizontal\")")
    private WebElement title;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Or swipe vertical to find what I'm hiding.\")")
    private WebElement helperTitleText;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"card\"])/android.widget.TextView")
    private WebElement actualCardImage;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"FULLY OPEN SOURCE\")")
    private WebElement actualCardSubTitle;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"WebdriverIO is fully open source and can be found on GitHub\")")
    private WebElement actualCardDescription;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"card\"]")
    private List<WebElement> actualCards;


    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"You found me!!!\")")
    private WebElement hiddenText;

    public void scrollDown2HiddenCard(){
        Dimension windowSize = this.getDriver().manage().window().getSize();

        int startX = (int) (windowSize.getWidth() *0.9);
        int startY = (int) (windowSize.getHeight() * 0.3);
        int endX = startX;
        int endY = (int) (windowSize.getHeight() * 0.1);;

        this.swipeStart2End(startX,startY,endX,endY);
        for(int i = 0; i<5; i++){
            this.swipeStart2End(startX,startY*2,endX,endY*2);
        }
    }

    public void swipe2RightCard(){
        Dimension windowSize = this.getDriver().manage().window().getSize();

        int startX = (int) (windowSize.getWidth() * 0.9);
        int startY = windowSize.getHeight() / 2;
        int endX = (int) (windowSize.getWidth() * 0.2);
        int endY = startY;

        this.swipeStart2End(startX,startY,endX,endY);
    }

    public boolean isImageCardVisibleAfterSwipe(){
        String actualCardImageText = this.actualCardImage.getText();
        swipe2RightCard();
        return Objects.equals(actualCardImageText, this.actualCardImage.getText());
    }

    public String getImageCardText(){
        return this.actualCardImage.getText();
    }

    public boolean isFollowingCardVisible(){
        return this.actualCards.size() == 2;
    }

    public String getHiddenText(){
        return this.hiddenText.getText();
    }

}