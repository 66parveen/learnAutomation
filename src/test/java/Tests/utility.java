package Tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class utility {
	AppiumDriver<MobileElement>driver;
	public void launch() throws MalformedURLException
	{
	   DesiredCapabilities caps=new DesiredCapabilities();
	   caps.setCapability("deviceName","ZY223D4K34");
	   caps.setCapability("platformName","Android");
	   caps.setCapability("platformVersion","7.0");
	   caps.setCapability("appPackage","com.imfootball");
	   caps.setCapability("appActivity","com.imfootball.ui.activities.SplashActivity");
	   caps.setCapability("unicodeKeyboard", true);
	   caps.setCapability("resetKeyboard", true);
		
	   driver =new AppiumDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),caps);
	}
}