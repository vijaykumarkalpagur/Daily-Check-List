package com.trainer.qa.module.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.trainer.qa.module.pages.LogOutPage;

public class LogoutAction {

public static void UserLogOut(WebDriver driver) throws Exception{	
	
	@SuppressWarnings("unused")
	LogOutPage logout = new LogOutPage(driver);
			
	Actions action = new Actions(driver);
	action.moveToElement(LogOutPage.ClickonProfilebutton).click().build().perform();
	Thread.sleep(2000);	
		
	LogOutPage.TrainerLogout.click();
	Thread.sleep(3000);
	
	}
}


