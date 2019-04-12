package Tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import createAccountPages.Register;
import createAccountPages.Terms;
import createAccountPages.completeYourReg;
import createAccountPages.enterYourMobile;
import createAccountPages.landingScreen;
import createAccountPages.selectDomesticTeam;
import createAccountPages.selectInternationalTeam;
import createAccountPages.selectLeague;
import createAccountPages.verifyMobileNumber;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class testCreateAccount {
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
	
	
	@Test(priority=0)
	public void testCreateAccountButtonWorking() throws InterruptedException
	{
	   landingScreen screen=new landingScreen(driver);
	   screen.clickCreateAccount();
	   
	   boolean actual= driver.findElementByXPath("//android.widget.TextView[@resource-id='com.imfootball:id/tvToolBarTitle']").isDisplayed();
	   Assert.assertTrue(actual);
    }
	
	
	@Test(priority=1)
	public void testInternationalTeamSelected() throws InterruptedException
	{
	  selectInternationalTeam internationalteam =new selectInternationalTeam(driver);
	  internationalteam.clickSearchIcon();
	  internationalteam.searchInternationalTeam();
	  internationalteam.clickSearchResult();
	  
	  boolean actual= driver.findElementByXPath("//android.widget.TextView[@resource-id='com.imfootball:id/tvHeaderTitle']").isDisplayed();
	  Assert.assertTrue(actual);
	}
	
	
	@Test(priority=2)
	public void testLeagueSelected() throws InterruptedException
	{ 
	  selectLeague league=new selectLeague(driver);
	  league.clickOnLeagueName();
	  
	  boolean actual= driver.findElementByXPath("//android.widget.TextView[@resource-id='com.imfootball:id/tvleagueName']").isDisplayed();
	  Assert.assertTrue(actual);
	}
	
	
	@Test(priority=3)
	public void testDomesticTeamSelected() throws InterruptedException
	{ 
		 
	   selectDomesticTeam domestic=new selectDomesticTeam(driver);
	   domestic.clickOnSearchIcon();
	   domestic.typeDomesticTeamName();
	   domestic.clickOnSearchResult();
	  
	    boolean actual= driver.findElementByXPath("//android.widget.ImageView[@bounds='[9,279][1071,651]']").isDisplayed();
	    Assert.assertTrue(actual);
	}
	
	
	@Test(priority=4)
	public void testTermsCondAccpeted() throws InterruptedException
	{ 
	   Terms term=new Terms(driver);
	   term.clickContinue1();
	   term.clickContinue2();
		 
	   boolean actual= driver.findElementByXPath("//android.widget.TextView[@bounds='[60,735][1020,1035]']").isDisplayed();
	   Assert.assertTrue(actual);
	}
	
	
	@Test(priority=5)
	public void testCreateAccountWithoutMobileNumber() throws InterruptedException
	{  
	  enterYourMobile number=new enterYourMobile(driver);
	  number.clickOnNext();
		
	  boolean actual=driver.findElementByXPath("//android.widget.Button[@resource-id='android:id/button1']").isDisplayed();
	  Assert.assertTrue(actual);
	}
	
	
	@Test(priority=6)
	public void testCreateAccountWithValidMobileNumber() throws InterruptedException
	{  
	  enterYourMobile number=new enterYourMobile(driver);
	  number.enterValidMobileNumber();
	  number.clickOnNext();
	  Thread.sleep(3000);
		
	  boolean actual=driver.findElementByXPath("//android.widget.TextView[@bounds='[216,117][1080,194]']").isDisplayed();
	  Assert.assertTrue(actual);
	}

	
	@Test(priority=7)
	public void testCreateAccountWithInvalidPin() throws InterruptedException
	{  
	  verifyMobileNumber verifynum=new verifyMobileNumber(driver);
	  verifynum.enterInvalidPin();
	  
	  boolean actual=driver.findElementByXPath("//android.widget.TextView[@bounds='[75,790][1005,969]']").isDisplayed();
	  Assert.assertTrue(actual);
	}
	
	
	@Test(priority=8)
	public void testCreateAccountWithValidPin() throws InterruptedException
	{    
	  verifyMobileNumber verifynum=new verifyMobileNumber(driver);
	  verifynum.enterValidPin();
	  
	  boolean actual=driver.findElementByXPath("//android.widget.LinearLayout[@bounds='[82,540][997,690]']").isDisplayed();
	  Assert.assertTrue(actual);
	}
	
	
	@Test(priority=9)
	public void testManualRegiterLinkWorking() throws InterruptedException
	{    
	 completeYourReg reg=new completeYourReg(driver);
	 reg.clickManualRegisterLink();
	 Thread.sleep(3000);

	 boolean actual=driver.findElementByXPath("//android.widget.Button[@resource-id='com.imfootball:id/btnRegister']").isDisplayed();
	 Assert.assertTrue(actual);
	}
	
	
	@Test(priority=10)
	public void testCreateAccountWithoutDetails() throws InterruptedException
	{    
	 Register reg=new Register(driver);
	 reg.clickRegiterButton();
	 
	 boolean actual=driver.findElementByXPath("//android.widget.Button[@resource-id='android:id/button1']").isDisplayed();
	 Assert.assertTrue(actual);
	}
	
	
	@Test(priority=11)
	public void testCreateAccountWithFirstNameOnly() throws Exception
	{    
	 Register reg=new Register(driver);
	 reg.enterFirstName();
	 reg.clickRegiterButton();
	
	 boolean actual=driver.findElementByXPath("//android.widget.Button[@resource-id='android:id/button1']").isDisplayed();
	 Assert.assertTrue(actual);
	}
	
	
	@Test(priority=12)
	public void testCreateAccountWithFirstAndLastNameOnly() throws InterruptedException
	{    
     Register reg=new Register(driver);
	 reg.enterLastName();
	 reg.clickRegiterButton();
	  
	 boolean actual=driver.findElementByXPath("//android.widget.Button[@resource-id='android:id/button1']").isDisplayed();
	 Assert.assertTrue(actual);
	}
	
	
	@Test(priority=13)
	public void testCreateAccountWithoutEmail() throws InterruptedException
	{    
     Register reg=new Register(driver);
	 reg.clickRegiterButton();
	  
	 boolean actual=driver.findElementByXPath("//android.widget.Button[@resource-id='android:id/button1']").isDisplayed();
	 Assert.assertTrue(actual);
	}
	
	
	@Test(priority=14)
	public void testCreateAccountWithInvalidEmail() throws InterruptedException
	{    
     Register reg=new Register(driver);
	 reg.enterInvalidEmail();
	 reg.clickRegiterButton();
	  
	 boolean actual=driver.findElementByXPath("//android.widget.Button[@resource-id='android:id/button1']").isDisplayed();
	 Assert.assertTrue(actual);
	}
	

	@Test(priority=15)
	public void testCreateAccountWithoutDOB() throws InterruptedException
	{    
     Register reg=new Register(driver);
	 reg.enterValidEmail();
	 reg.clickRegiterButton();
	  
	 boolean actual=driver.findElementByXPath("//android.widget.Button[@resource-id='android:id/button1']").isDisplayed();
	 Assert.assertTrue(actual);
	}
	
	
	@Test(priority=16)
	public void testCreateAccountWithoutPassword() throws InterruptedException
	{    
     Register reg=new Register(driver);
	 reg.selectDOB();
	 reg.clickRegiterButton();
	 
	 boolean actual=driver.findElementByXPath("//android.widget.Button[@resource-id='android:id/button1']").isDisplayed();
	 Assert.assertTrue(actual);
	}
	
	
	@Test(priority=17)
	public void testCreateAccountWithInvaidPasswordCriteria() throws InterruptedException
	{    
     Register reg=new Register(driver);
	 reg.enterInvalidPassword1();
     reg.clickRegiterButton();
	 
	 boolean actual=driver.findElementByXPath("//android.widget.Button[@resource-id='android:id/button1']").isDisplayed();
	 Assert.assertTrue(actual);
	}
	
	
	@Test(priority=18)
	public void testCreateAccountWith2ndInvaidPasswordCriteria() throws InterruptedException
	{    
     Register reg=new Register(driver);
	 reg.enterInvalidPassword2();
     reg.clickRegiterButton();
	 
	 boolean actual=driver.findElementByXPath("//android.widget.Button[@resource-id='android:id/button1']").isDisplayed();
	 Assert.assertTrue(actual);
	}
	
	
	@Test(priority=19)
	public void testCreateAccountWith3rdInvaidPasswordCriteria() throws InterruptedException
	{    
     Register reg=new Register(driver);
	 reg.enterInvalidPassword3();
     reg.clickRegiterButton();
	 
	 boolean actual=driver.findElementByXPath("//android.widget.Button[@resource-id='android:id/button1']").isDisplayed();
	 Assert.assertTrue(actual);
	}
	
	
	@Test(priority=20)
	public void testInformationIconWorking()
	{    
     Register reg=new Register(driver);
     reg.clickOnInformationIcon();
     
	 boolean actual=driver.findElementByXPath("//android.widget.ImageView[@resource-id='com.imfootball:id/ivCross']").isDisplayed();
	 Assert.assertTrue(actual);
	}
	
	
}



