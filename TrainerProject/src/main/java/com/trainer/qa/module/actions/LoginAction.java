package com.trainer.qa.module.actions;

import org.openqa.selenium.WebDriver;
import com.trainer.qa.module.pages.LoginPage;
import com.trainer.qa.utility.Log;

public class LoginAction {

	static WebDriver driver;
	
	public static void TrainerLogin(WebDriver driver ,String Uname ,String Pswd) throws Exception{
		
		LoginPage login = new LoginPage(driver);
		
		login.TrainerUsername.isDisplayed();
		login.TrainerUsername.clear();
		login.TrainerUsername.sendKeys(Uname);	
		Log.info("Entered Trainer valid username");
		
		login.TrainerPassword.isDisplayed();
		login.TrainerPassword.clear();
		login.TrainerPassword.sendKeys(Pswd);	
		Log.info("Entered Trainer valid Password");
		
		login.TrainerLoginBtn.isDisplayed();
		login.TrainerLoginBtn.isEnabled();	
		login.TrainerLoginBtn.click();	
		Thread.sleep(15000);
		Log.info("Click action performed on Loginbutton.");
	}
}

