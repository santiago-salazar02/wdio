package wdio.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import wdio.screens.LoginMenuScreen;
import wdio.screens.LoginScreen;
import wdio.screens.MenuScreen;
import wdio.screens.RegisterScreen;
import wdio.utils.BaseTest;

import java.util.UUID;

public class UserCredentialsTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(UserCredentialsTest.class);

    @BeforeMethod(groups = "loginGroup")
    public void setUpLogin(){
        MenuScreen menuScreen = loadMenu();
        menuScreen.tapLoginRegisterHref();
        log.info("Inside login screen");
    }

    @DataProvider(name="randomCredentials")
    public Object[][] getRandomEmail(){
        String randomUserEmail = String.format("%s_%s", UUID.randomUUID().toString().substring(0, 5), System.currentTimeMillis() / 1000);
        String randomEmail = String.format("%s@%s", randomUserEmail, "gmail.com");

        String password = "123456Aa#";
        return new Object[][] {{randomEmail,password}};
    }

    @Test(dataProvider = "randomCredentials", groups = "loginGroup")
    public void testLogin(String randomEmail, String password){
        // Pre-register
        log.info("Pre-register");
        LoginMenuScreen loginMenuScreen = loadLoginMenuScreen();
        loginMenuScreen.waitSomeSeconds(2);
        RegisterScreen registerScreen = loginMenuScreen.tapRegisterButtonSectionChanger();
        registerScreen.waitSomeSeconds(2);

        registerScreen.register(randomEmail,password);
        registerScreen.waitSomeSeconds(5);
        registerScreen.tapOkButtonPopUp();

        // Go to login
        log.info("Returning to login");
        LoginScreen loginScreen = loginMenuScreen.tapLoginButtonSectionChanger();
        loginScreen.waitSomeSeconds(2);
        log.info("Sending login keys (username and password)");
        loginScreen.login(randomEmail,password);
        log.info("Waiting for login popup");
        loginScreen.waitSomeSeconds(5);
        Assert.assertTrue(loginScreen.isTitleLoginPopUpVisible());
    }

    @Test(dataProvider = "randomCredentials")
    public void testRegister(String randomEmail, String password){
        LoginMenuScreen loginMenuScreen = loadLoginMenuScreen();
        loginMenuScreen.waitSomeSeconds(2);
        log.info("Going to register screen");
        RegisterScreen registerScreen = loginMenuScreen.tapRegisterButtonSectionChanger();
        registerScreen.waitSomeSeconds(2);

        log.info("Sending register keys (username, password and repeated password)");
        registerScreen.register(randomEmail,password);
        log.info("Waiting for register popup");
        registerScreen.waitSomeSeconds(5);

        Assert.assertTrue(registerScreen.isTitleRegisterPopUpVisible());
    }

}
