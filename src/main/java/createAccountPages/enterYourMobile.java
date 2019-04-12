package createAccountPages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class enterYourMobile {
	  AppiumDriver<MobileElement>driver;
		
			@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.imfootball:id/btnNext']")
			MobileElement next;
			@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.imfootball:id/editTextPhoneNo']")
			MobileElement editbox1;
			@AndroidFindBy(xpath="//android.widget.Button[@resource-id='android:id/button1']")
			MobileElement popup;
			
			
			
			public enterYourMobile(AppiumDriver<MobileElement>driver)
			{
				PageFactory.initElements(new AppiumFieldDecorator(driver), this);
			}
			
			public void clickOnNext() 
			{
				next.click();
               // utility.clickOn(driver, editbox1, 5, null);
		
			}
			
		
			public void enterValidMobileNumber()
			{
				popup.click();
				editbox1.sendKeys("8352888633");
				//utility.clickOn(driver, popup, 5, null);
			}
}
