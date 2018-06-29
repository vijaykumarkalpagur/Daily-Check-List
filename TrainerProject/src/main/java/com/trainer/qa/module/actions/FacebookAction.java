package com.trainer.qa.module.actions;

import org.openqa.selenium.WebDriver;
import com.trainer.qa.module.helpers.WindowsHandlehelper;
import com.trainer.qa.module.pages.SocialLoginPage;
import com.trainer.qa.utility.Log;

public class FacebookAction {

	static WebDriver driver;
	
public static void socialFacebookLogin(WebDriver driver ,String Facebookid,String FacebookPswd) throws Exception{		
	SocialLoginPage Facebook = new SocialLoginPage(driver);
	
	Facebook.ContinueWithFacebook.isDisplayed();
	Facebook.ContinueWithFacebook.isEnabled();
	Facebook.ContinueWithFacebook.click();
	Thread.sleep(2000);
	Log.info("Click action performed on Continue with Facebook.");
	
	WindowsHandlehelper.PopupWindows(driver);
	
	Facebook.FacebookUserName.isDisplayed();
	Facebook.FacebookUserName.clear();
	Facebook.FacebookUserName.sendKeys(Facebookid);
	Log.info("Facebook valid id is enetered in ID edit field.");
		
	Facebook.FacebookUserPassword.isDisplayed();
	Facebook.FacebookUserPassword.clear();
	Facebook.FacebookUserPassword.sendKeys(FacebookPswd);
	Thread.sleep(5000);
	Log.info("FacebooK valid password is enetered in password edit field.");
		
	Facebook.ClickonFBloginbutton.isDisplayed();
	Facebook.ClickonFBloginbutton.isEnabled();
	Facebook.ClickonFBloginbutton.click();	
	Thread.sleep(15000);
	Log.info("Click action performed to login button.");
	
 }
}
