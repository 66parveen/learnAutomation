package loginPage;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Login {
AppiumDriver<MobileElement>driver;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.imfootball:id/btnLogin']")
	MobileElement loginLink;
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.imfootball:id/edusername']")
	MobileElement emailField;
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.imfootball:id/edpassword']")
	MobileElement passwordField;
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.imfootball:id/btnLogin']")
	MobileElement loginButton;
	
	public Login(AppiumDriver<MobileElement>driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

    public void clickOnLoginLink() 
    {
	  loginLink.click();
     }
    public void clickOnLoginButton() 
    {
	  loginButton.click();
	  
    }
   public void enterEmail()
   {
	  emailField.sendKeys("b@b.co");
	  
    }
   public void enterInvalidEmail()
   {
	  emailField.sendKeys("bbco");
	  
    }
   
   public void enterInvalidPassword()
   {
	  passwordField.sendKeys("IOS");
	  
    }
   
   public void enterPassword()
   {
	  passwordField.sendKeys("Ios@1234");
   }
   
   
   public void clearPassword()
   {
	 passwordField.clear();  
	   
	   
  }
  
   public void blankEmail()
   {
	 emailField.clear();
   }

   }
	

