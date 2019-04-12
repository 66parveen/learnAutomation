package createAccountPages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class landingScreen {
	AppiumDriver<MobileElement>driver;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.imfootball:id/btnCreateAccount']")
	MobileElement CreateAccount;
	
	public landingScreen(AppiumDriver<MobileElement>driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void clickCreateAccount() throws InterruptedException
	{Thread.sleep(10000);
		CreateAccount.click();
		//utility.clickOn(driver, CreateAccount, 10,null);
	}
}