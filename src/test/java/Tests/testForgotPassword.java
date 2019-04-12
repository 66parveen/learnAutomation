package Tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import forgotPasswordPages.forgotPassword;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class testForgotPassword {
	AppiumDriver<MobileElement>driver;

		@BeforeTest
		public void setUp() throws MalformedURLException
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
		
		@Test(dependsOnMethods="setUp")
		public void testForgotPasswordLinkWorking() throws InterruptedException
		{
			forgotPassword forgot=new forgotPassword(driver);
			//Thread.sleep(3000);
			forgot.clickOnLoginLink();
			forgot.clickOnForgotPassword();
			
			boolean actual=driver.findElementByXPath("//android.widget.TextView[@resource-id='com.imfootball:id/tvToolBarTitleCenter']").isDisplayed();
			Assert.assertTrue(actual);
	   }

		@Test(dependsOnMethods="testForgotPasswordLinkWorking")
		public void testResetPasswordWithoutEmailAndMobile() throws InterruptedException
		{
			forgotPassword forgot=new forgotPassword(driver);
			//Thread.sleep(3000);
			forgot.clickOnResetPasswordButton();
			
			boolean actual=driver.findElementByXPath("//android.widget.TextView[@resource-id='com.imfootball:id/textinput_error']").isDisplayed();
			Assert.assertTrue(actual);}
			
			
		@Test(dependsOnMethods="testResetPasswordWithoutEmailAndMobile")
		public void testResetPasswordWithInvaidEmail() throws InterruptedException
		{
			forgotPassword forgot=new forgotPassword(driver);
			//Thread.sleep(3000);
			forgot.enterInvaidEmail();
			forgot.entervalidMobile();
			forgot.clickOnResetPasswordButton();
			
			boolean actual=driver.findElementByXPath("//android.widget.TextView[@resource-id='com.imfootball:id/textinput_error']").isDisplayed();
			Assert.assertTrue(actual);
			}
		
		@Test(dependsOnMethods="testResetPasswordWithInvaidEmail")
		public void testResetPasswordWithoutPassword() throws InterruptedException
		{
			forgotPassword forgot=new forgotPassword(driver);
			//Thread.sleep(3000);
			forgot.clearmobile();
			forgot.emailClear();
			forgot.enterValidEmail();
			forgot.clickOnResetPasswordButton();
			
			boolean actual=driver.findElementByXPath("//android.widget.TextView[@resource-id='com.imfootball:id/textinput_error']").isDisplayed();
			Assert.assertTrue(actual);
			}
		
		@Test(dependsOnMethods="testResetPasswordWithoutPassword")
		public void testResetPasswordWithValidEmailAndMobile() throws InterruptedException
		{
			forgotPassword forgot=new forgotPassword(driver);
			Thread.sleep(10000);
			//forgot.enterValidEmail();
	        forgot.entervalidMobile();
			forgot.clickOnResetPasswordButton();
			
			boolean actual=driver.findElementByXPath("//android.widget.TextView[@bounds='[216,117][1080,194]']").isDisplayed();
			Assert.assertTrue(actual);
	   }
		
		@Test(dependsOnMethods="testResetPasswordWithValidEmailAndMobile")
		public void testResetPasswordWithInvalidPin() throws InterruptedException
		{
			forgotPassword forgot=new forgotPassword(driver);
			//Thread.sleep(3000);
	        forgot.enterInvalidPin();
	        
	        boolean actual=driver.findElementByXPath("//android.widget.Button[@resource-id='android:id/button1']").isDisplayed();
	        Assert.assertTrue(actual);
			
		}
		@Test(dependsOnMethods="testResetPasswordWithInvalidPin")
		public void testResetPasswordWithValidPin() throws InterruptedException
		{
			forgotPassword forgot=new forgotPassword(driver);
			forgot.closePopup();
			forgot.clearInvalidPin();
	        forgot.enterValidPin();
	    	//Thread.sleep(3000);
	        
	        boolean actual=driver.findElementByXPath("//android.widget.Button[@resource-id='com.imfootball:id/btnchangelogin']").isDisplayed();
	        Assert.assertTrue(actual);
}


@Test(dependsOnMethods="testResetPasswordWithValidPin")
public void testInformationIconWorking() throws InterruptedException
{
	forgotPassword forgot=new forgotPassword(driver);
   forgot.clickOnInformationIcon();
   
   boolean actual=driver.findElementByXPath("//android.widget.ImageView[@resource-id='com.imfootball:id/ivCross']").isDisplayed();
   Assert.assertTrue(actual);
}


@Test(dependsOnMethods="testInformationIconWorking")
public void testResetPasswordWithoutNewPassword() throws InterruptedException
{
	forgotPassword forgot=new forgotPassword(driver);
	forgot.clickOnCrossIcon();
   forgot.enterConfirmPassword();
   forgot.clickOnChangeAndLogin();
   
   boolean actual=driver.findElementByXPath("//android.widget.TextView[@resource-id='com.imfootball:id/textinput_error']").isDisplayed();
   Assert.assertTrue(actual);
}

@Test(dependsOnMethods="testResetPasswordWithoutNewPassword")
public void testResetPasswordWithoutConfirmPassword() throws InterruptedException
{
	forgotPassword forgot=new forgotPassword(driver);
	forgot.clearConfirmPassword();
   forgot.enterNewPassword();
   forgot.clickOnChangeAndLogin();
   
   boolean actual=driver.findElementByXPath("//android.widget.TextView[@resource-id='com.imfootball:id/textinput_error']").isDisplayed();
   Assert.assertTrue(actual);
}

@Test(dependsOnMethods="testResetPasswordWithoutConfirmPassword")
public void testResetPasswordNewAndConfirmNotMatch() throws InterruptedException
{
	forgotPassword forgot=new forgotPassword(driver);
   forgot.enterInvalidPass();
   forgot.clickOnChangeAndLogin();
   
   boolean actual=driver.findElementByXPath("//android.widget.TextView[@resource-id='com.imfootball:id/textinput_error']").isDisplayed();
   Assert.assertTrue(actual);
}

@Test(dependsOnMethods="testResetPasswordNewAndConfirmNotMatch")
public void testResetPasswordNewAndConfirmMatch() throws InterruptedException
{
	forgotPassword forgot=new forgotPassword(driver);
   forgot.enterValidNewPass();
   forgot.enterVaidConfirm();
   forgot.clickOnChangeAndLogin();
   //Thread.sleep(3000);
   
   boolean actual=driver.findElementByXPath("//android.widget.ImageView[@resource-id='com.imfootball:id/ivAddFriend']").isDisplayed();
   Assert.assertTrue(actual);}


}



