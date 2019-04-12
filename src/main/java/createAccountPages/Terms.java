package createAccountPages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Terms {
AppiumDriver<MobileElement>driver;
	
	@AndroidFindBy(xpath="//android.widget.Button[@bounds='[354,1585][726,1741]']")
	MobileElement continue1;
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.imfootball:id/btnAgreeContinue']")
	MobileElement continue2;

	public Terms(AppiumDriver<MobileElement>driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void clickContinue1() throws InterruptedException
	{  
		Thread.sleep(3000);
        continue1.click();
		//Thread.sleep(3000);
		
		//utility.clickOn(driver, continue1, 5, null);
	}
	
	public void clickContinue2() throws InterruptedException
	{
	    continue2.click();
		Thread.sleep(3000);	
		
		//utility.clickOn(driver, continue2, 5, null);
		
	}
}
