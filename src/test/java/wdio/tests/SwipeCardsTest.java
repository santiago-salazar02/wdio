package wdio.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import wdio.screens.MenuScreen;
import wdio.screens.SwipeScreen;
import wdio.utils.BaseTest;

public class SwipeCardsTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(SwipeCardsTest.class);

    @BeforeMethod(groups = "swipeGroup")
    public void setUpSwipe(){
        MenuScreen menuScreen = loadMenu();
        menuScreen.tapSwipeHref();
        log.info("Inside Swipe screen");
    }

    @Test(groups = "swipeGroup")
    public void swipeCards(){
        SoftAssert softAssert = new SoftAssert();

        SwipeScreen swipeScreen = loadSwipe();
        swipeScreen.waitSomeSeconds(3);

        // Check image from the actual card -> Swipe -> Check if the image from the new card is the same
        boolean stillFollowingCard = true;
        log.info("Swipe cards");
        while(stillFollowingCard){
            swipeScreen.waitSomeSeconds(1);
            log.info("Actual image: {}", swipeScreen.getImageCardText());
            softAssert.assertFalse(swipeScreen.isImageCardVisibleAfterSwipe());
            stillFollowingCard = swipeScreen.isFollowingCardVisible();
        }

        log.info("Swipe into hidden message");
        swipeScreen.scrollDown2HiddenCard();
        swipeScreen.waitSomeSeconds(3);
        softAssert.assertEquals(swipeScreen.getHiddenText(),"You found me!!!");
        softAssert.assertAll();
    }

}
