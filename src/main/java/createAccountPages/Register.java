package createAccountPages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Register {
	AppiumDriver<MobileElement>driver;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.imfootball:id/btnRegister']")
	MobileElement registerButton;
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.imfootball:id/textInputFirstname']")
	MobileElement firstNameField;
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.imfootball:id/textInputLastname']")
	MobileElement lastNameField;
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='android:id/button1']")
	MobileElement popupR;
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.imfootball:id/textInputEmail']")
	MobileElement EmailField;
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.imfootball:id/textInputDob']")
	MobileElement DOBField;
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='android:id/button1']")
	MobileElement DOBpopup;
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.imfootball:id/textInputPassword']")
	MobileElement passwordField;
	@AndroidFindBy(xpath="//android.widget.ImageView[@resource-id='com.imfootball:id/iv_InfoDialog']")
	MobileElement InformationIcon;
	
	
	public Register(AppiumDriver<MobileElement>driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void clickRegiterButton() 
	{
		registerButton.click();
		//utility.clickOn(driver, registerButton, 5, null);
	}
	
	public void enterFirstName()
	{   popupR.click();
	    utility.sendKeys(driver, firstNameField, 5, "Test");
		
	}
	
	public void enterLastName()
	{  
		popupR.click();
		lastNameField.sendKeys("Dev");
		//utility.sendKeys(driver, lastNameField, 5, "Dev");
		popupR.click();
	}
	
	public void enterInvalidEmail()
	{   popupR.click();
		EmailField.sendKeys("meritestingtest.com");
		//utility.sendKeys(driver,EmailField, 3, "meritestingtest.com");
	}
	
    public void enterValidEmail()
    {
    popupR.click();
    EmailField.clear();
    //utility.sendKeys(driver,EmailField, 3, "meritestingtest.com");
	EmailField.sendKeys("meritesting@test.com");
	
	}
    
    public void selectDOB()
    {   popupR.click();
    	DOBField.click();
    	//utility.clickOn(driver, DOBpopup,5, null);
    	DOBpopup.click();
    	
     }
    
    public void enterInvalidPassword1()
    {  popupR.click();
    	passwordField.sendKeys("kabir123");
    	//utility.clickOn(driver, popupR, 5, null);
        //utility.sendKeys(driver, passwordField, 5, "kabir123");	
    }
    
    public void enterInvalidPassword2()
    {
    	  popupR.click();
    	  passwordField.sendKeys("kabir");
    	
    	//utility.clickOn(driver, popupR, 5, null);
       // utility.sendKeys(driver, passwordField, 5, "kabir");
    }
    
    public void enterInvalidPassword3()
    {  popupR.click();
       passwordField.sendKeys("Kabir12");
       
       //utility.clickOn(driver, popupR, 5, null);
       //utility.sendKeys(driver, passwordField, 5, "Kabir12");
    }
    
    public void clickOnInformationIcon()
    { 
    	popupR.click();
    	InformationIcon.click();
    	//utility.clickOn(driver, popupR, 5, null);
        //utility.clickOn(driver, passwordField, 5, null);
    	
    	
    	
    }
}
