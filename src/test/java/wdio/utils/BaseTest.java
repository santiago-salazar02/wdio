package wdio.utils;

import io.github.cdimascio.dotenv.Dotenv;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.log4testng.Logger;
import wdio.screens.*;


public class BaseTest {

    MyDriver driver;

    private Logger log = Logger.getLogger(BaseTest.class);

    private Dotenv dotenv = Dotenv.load();

    @BeforeMethod
    public void beforeMethod(){
        this.driver = new MyDriver(dotenv.get("URL"));
    }

    @AfterMethod
    public void afterMethod(){
        this.driver.getDriver().quit();
    }

    public Logger getLog(){
        return this.log;
    }

    public void setLog(Logger log){
        this.log = log;
    }

    public HomeScreen loadHome(){
        return new HomeScreen(this.driver.getDriver());
    }

    public MenuScreen loadMenu(){
        return new MenuScreen(this.driver.getDriver());
    }

    public SwipeScreen loadSwipe(){
        return new SwipeScreen(this.driver.getDriver());
    }

    public LoginMenuScreen loadLoginMenuScreen(){
        return new LoginMenuScreen(this.driver.getDriver());
    }

    public LoginScreen loadLogin(){
        return new LoginScreen(this.driver.getDriver());
    }
}
