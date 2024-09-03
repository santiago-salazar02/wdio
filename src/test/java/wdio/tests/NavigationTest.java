package wdio.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import wdio.screens.*;
import wdio.utils.BaseTest;

public class NavigationTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(NavigationTest.class);

    @Test
    public void testNavigationHrefs(){
        MenuScreen menuScreen = loadMenu();
        menuScreen.waitSomeSeconds(3);
        WebViewScreen webViewScreen = menuScreen.tapWebViewHref();
        webViewScreen.waitSomeSeconds(10);
        log.info("Verifying WebView screen");
        Assert.assertTrue(webViewScreen.verifyElementsVisibility());

        LoginScreen loginScreen = menuScreen.tapLoginRegisterHref();
        log.info("Verifying Login screen");
        loginScreen.waitSomeSeconds(3);
        Assert.assertTrue(loginScreen.verifyElementsVisibility());

        LoginMenuScreen loginMenuScreen = loadLoginMenuScreen();
        loginMenuScreen.waitSomeSeconds(3);
        Assert.assertTrue(loginMenuScreen.verifyElementsVisibility());

        FormsScreen formsScreen = menuScreen.tapFormsHref();
        log.info("Verifying Forms screen");
        formsScreen.waitSomeSeconds(3);
        Assert.assertTrue(formsScreen.verifyElementsVisibility());

        SwipeScreen swipeScreen = menuScreen.tapSwipeHref();
        log.info("Verifying Swipe screen");
        swipeScreen.waitSomeSeconds(3);
        Assert.assertTrue(swipeScreen.verifyElementsVisibility());

        DragScreen dragScreen = menuScreen.tapDragHref();
        log.info("Verifying Drag screen");
        dragScreen.waitSomeSeconds(3);
        Assert.assertTrue(dragScreen.verifyElementsVisibility());

        HomeScreen homeScreen = menuScreen.tapHomeHref();
        log.info("Verifying home screen");
        homeScreen.waitSomeSeconds(3);
        Assert.assertTrue(homeScreen.verifyElementsVisibility());

    }
}
