package com.trainer.qa.module.actions;

import org.openqa.selenium.WebDriver;
import com.trainer.qa.module.helpers.WindowsHandlehelper;
import com.trainer.qa.module.pages.SocialLoginPage;
import com.trainer.qa.utility.Log;

public class GmailAction {

	static WebDriver driver;
	
public static void socialGmailLogin(WebDriver driver ,String Gmailid,String GmailPswd) throws Exception{		
		
		SocialLoginPage Gmail = new SocialLoginPage(driver);
		
		Gmail.ClickonGmailbutton.isDisplayed();
		Gmail.ClickonGmailbutton.isEnabled();
		Gmail.ClickonGmailbutton.click();
		Thread.sleep(2000);
		Log.info("Click action performed on clickongmailbutton.");
		
		WindowsHandlehelper.WindowsHandle(driver, 2);
		
		Gmail.GmailUserID.isDisplayed();
		Gmail.GmailUserID.clear();
		Gmail.GmailUserID.sendKeys(Gmailid);
		Thread.sleep(2000);
		Log.info("Entered valid Gmail ID" );
		
		Gmail.GmailNextButton.isEnabled();
		Gmail.GmailNextButton.click();	
		Thread.sleep(3000);
		Log.info("Click action performed on GmailNextButton.");
				
		Gmail.GmailUserPassword.clear();
		Gmail.GmailUserPassword.sendKeys(GmailPswd);
		Thread.sleep(2000);
		Log.info("Entered valid Gmail Password" );
			
		Gmail.GmailNextButtontoLogin.isDisplayed();
		Gmail.GmailNextButtontoLogin.isEnabled();
		Gmail.GmailNextButtontoLogin.click();	
		Log.info("Click action performed on GmailNextButton.");	
		
		
	}		
}
