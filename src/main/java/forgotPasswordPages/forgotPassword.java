package forgotPasswordPages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class forgotPassword {
	AppiumDriver<MobileElement>driver;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.imfootball:id/btnLogin']")
	MobileElement loginLink;
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.imfootball:id/tvForgotPassword']")
	MobileElement forgotPasswordLink;
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.imfootball:id/edusername']")
	MobileElement emailAddress;
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.imfootball:id/edmobile']")
	MobileElement mobileNumber;
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.imfootball:id/btnLogin']")
	MobileElement resetButton;
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.imfootball:id/ednewpassword']")
	MobileElement newPassword;
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.imfootball:id/edconfirmpassword']")
	MobileElement confirmPassword;
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.imfootball:id/btnchangelogin']")
	MobileElement changeButton;
	@AndroidFindBy(xpath="//android.widget.ImageView[@resource-id='com.imfootball:id/iv_InfoDialog']")
	MobileElement informationIcon;
	@AndroidFindBy(xpath="//android.widget.ImageView[@resource-id='com.imfootball:id/ivCross']")
	MobileElement crossIcon;
	
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.imfootball:id/otp_one_edit_text']")
	MobileElement edtbox1;
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.imfootball:id/otp_two_edit_text']")
	MobileElement edtbox2;
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.imfootball:id/otp_three_edit_text']")
	MobileElement edtbox3;
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.imfootball:id/otp_four_edit_text']")
	MobileElement edtbox4;
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='android:id/button1']")
	MobileElement popup;
	
	
	public forgotPassword(AppiumDriver<MobileElement>driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void clickOnForgotPassword()
	{
		forgotPasswordLink.click();
	}
	
	public void clickOnLoginLink()
	{
		loginLink.click();
	}

	public void clickOnResetPasswordButton()
	{
		resetButton.click();
		
	}
	public void enterInvaidEmail()
	{
		emailAddress.sendKeys("bb.co");
		
	}
	
	public void entervalidMobile()
	{
		mobileNumber.sendKeys("9999999988");
		
	}
	
	public void clearmobile()
	{
		mobileNumber.clear();
		
	}
	public void emailClear()
	{
		emailAddress.clear();
		
	}

	
	public void enterValidEmail()
	{
		emailAddress.sendKeys("reset1@test.com");
	}
	
	public void enterInvalidPin()
	{
		edtbox1.sendKeys("1");
		edtbox2.sendKeys("1");
		edtbox3.sendKeys("1");
	    edtbox4.sendKeys("1");
	}
	public void enterValidPin()
	{
		edtbox1.sendKeys("1");
		edtbox2.sendKeys("4");
		edtbox3.sendKeys("7");
	    edtbox4.sendKeys("1");
	}
	public void clearInvalidPin()
	{
		edtbox1.clear();
		edtbox2.clear();
		edtbox3.clear();
	    edtbox4.clear();
	}
	public void closePopup()
	{
		popup.click();
		
	}
	public void clickOnInformationIcon()
	{
		informationIcon.click();
		
	}
	public void enterConfirmPassword()
	{
		confirmPassword.sendKeys("Kabir123");
		
	}
	public void clickOnChangeAndLogin()
	{
		changeButton.click();	
	}
	public void enterNewPassword()
	{
	newPassword.sendKeys("Kabir123");
		
	}
	public void clickOnCrossIcon()
	{
		crossIcon.click();
		
	}
	public void clearConfirmPassword()
	{
		crossIcon.click();
		
	}
	
	public void enterInvalidPass()
	{
		
		confirmPassword.sendKeys("Kabir12");
		
	}
	public void enterValidNewPass()
	{
		
	newPassword.sendKeys("Kabir123");
		
	}	
	public void enterVaidConfirm()
	{
		confirmPassword.sendKeys("Kabir123");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
