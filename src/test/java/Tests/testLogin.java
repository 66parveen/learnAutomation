package Tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import loginPage.Login;

public class testLogin {

	 AppiumDriver<MobileElement>driver;
	 
		@BeforeTest
		public void setUp() throws MalformedURLException
		{
			DesiredCapabilities caps=new DesiredCapabilities();
			caps.setCapability("deviceName","LGK53521d14829");
			caps.setCapability("platformName","Android");
			caps.setCapability("platformVersion","6.0.1");
			caps.setCapability("appPackage","com.imfootball");
			caps.setCapability("appActivity","com.imfootball.ui.activities.SplashActivity");
			caps.setCapability("unicodeKeyboard", true);
			caps.setCapability("resetKeyboard", true);
			
		    driver =new AppiumDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),caps);
		}

@Test(priority=0,description="this test willl verify the login flow without username and password")
public void testloginWithoutEmailAndPassword()
{
	Login log=new Login(driver);
	log.clickOnLoginLink();
	log.clickOnLoginButton();
	
	boolean actual=driver.findElementByXPath("//android.widget.TextView[@resource-id='com.imfootball:id/textinput_error']").isDisplayed();
	Assert.assertTrue(actual);
}

@Test(priority=1,description="this test willl verify the login flow with email only.")
public void testloginWithEmailOnly()
{
	Login log=new Login(driver);
	log.enterEmail();
	log.clickOnLoginButton();
	
	boolean actual=driver.findElementByXPath("//android.widget.TextView[@resource-id='com.imfootball:id/textinput_error']").isDisplayed();
	Assert.assertTrue(actual);
}

@Test(priority=2,description="this test willl verify the login flow with password only.")
public void testloginWithPasswordOnly()
{
	Login log=new Login(driver);
 log.enterPassword();
 log.blankEmail();
	log.clickOnLoginButton();
	
	boolean actual=driver.findElementByXPath("//android.widget.TextView[@resource-id='com.imfootball:id/textinput_error']").isDisplayed();
	Assert.assertTrue(actual);
}

@Test(priority=3,description="this test willl verify the login flow with invalid email")
public void testloginWithInvalidEmail()
{
	Login log=new Login(driver);
	log.enterInvalidEmail();
 log.enterPassword();
	log.clickOnLoginButton();
	
	boolean actual=driver.findElementByXPath("//android.widget.TextView[@resource-id='com.imfootball:id/textinput_error']").isDisplayed();
	Assert.assertTrue(actual);
}

@Test(priority=4,description="this test willl verify the login flow with invalid password")
public void testloginWithInvalidPassword()
{
	Login log=new Login(driver);
	log.blankEmail();
	log.enterEmail();
 log.enterInvalidPassword();
	log.clickOnLoginButton();
	
	boolean actual=driver.findElementByXPath("//android.widget.TextView[@resource-id='com.imfootball:id/textinput_error']").isDisplayed();
	Assert.assertTrue(actual);
}

@Test(priority=5,description="this test willl verify the login flow with valid username and password.")
public void testloginWithValidUsernameAndPassword() throws InterruptedException
{
	Login log=new Login(driver);
	log.clearPassword();
	log.enterPassword();
	log.clickOnLoginButton();
	Thread.sleep(10000);
	
	boolean actual=driver.findElementByXPath("//android.widget.ImageView[@resource-id='com.imfootball:id/ivAddFriend']").isDisplayed();
	Assert.assertTrue(actual);
}

}