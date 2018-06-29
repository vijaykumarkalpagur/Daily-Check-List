package com.trainer.qa.testcases;

import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import com.trainer.qa.module.actions.CloseBrowserAction;
import com.trainer.qa.module.actions.LoginAction;
import com.trainer.qa.module.actions.LogoutAction;
import com.trainer.qa.module.helpers.Browserhelper;
import com.trainer.qa.module.testdata.LoginDataProvider;
import com.trainer.qa.utility.Log;

public class LoginTest {
	
@Test
public void OpenBrowser() throws Exception {	
	PropertyConfigurator.configure("log4j.properties");
	Browserhelper.openBrowser();}

@Test (dataProvider = "UserLogin" , dataProviderClass = LoginDataProvider.class)
public void TrainerLogin(String Username ,String Password) throws Exception{
	LoginAction.TrainerLogin(Browserhelper.driver,Username,Password);
	LogoutAction.UserLogOut(Browserhelper.driver);
	Log.info("Successfully validated Login functionality with valid inputs");}

@AfterClass
   public void teardown() throws Exception{	
	CloseBrowserAction.Application(Browserhelper.driver);
	}
}

