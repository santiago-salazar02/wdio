package wdio.utils;

import io.appium.java_client.android.AndroidDriver;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class MyDriver {

    private AndroidDriver driver;
    private Dotenv dotenv = Dotenv.load();

    private DesiredCapabilities getEnvironmentSetup(){
        String appPath =System.getProperty("user.dir") + dotenv.get("APP_PATH");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:deviceName",dotenv.get("DEVICE_NAME"));
        capabilities.setCapability("platformName",dotenv.get("PLATFORM_NAME"));
        capabilities.setCapability("appium:platformVersion",dotenv.get("PLATFORM_VERSION"));
        capabilities.setCapability("appium:app",appPath);
        capabilities.setCapability("appium:appPackage",dotenv.get("APP_PACKAGE"));
        capabilities.setCapability("appium:appActivity",dotenv.get("APP_ACTIVITY"));
        capabilities.setCapability("appium:automationName",dotenv.get("APP_AUTOMATION_NAME"));
        return capabilities;
    }

    public MyDriver(String url){
        DesiredCapabilities capabilities = this.getEnvironmentSetup();
        try{
            this.driver = new AndroidDriver(
                    (new URI(dotenv.get("URL"))).toURL(), capabilities
            );
        } catch (URISyntaxException | MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public AndroidDriver getDriver(){
        return this.driver;
    }
}
