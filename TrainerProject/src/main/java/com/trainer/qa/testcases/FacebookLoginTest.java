package com.trainer.qa.testcases;

import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.trainer.qa.module.actions.CloseBrowserAction;
import com.trainer.qa.module.actions.FacebookAction;
import com.trainer.qa.module.helpers.Browserhelper;
import com.trainer.qa.module.testdata.LoginDataProvider;
import com.trainer.qa.utility.Log;

public class FacebookLoginTest {

@BeforeClass
public void TrainerSocialBrowser() throws Exception {	
	PropertyConfigurator.configure("log4j.properties");
	Browserhelper.openBrowser();}	

@Test (dataProvider = "FacebookLogin" , dataProviderClass = LoginDataProvider.class)
public static void FacebookLogin(String Facebookid,String FacebookPswd) throws Exception{	
	FacebookAction.socialFacebookLogin(Browserhelper.driver, Facebookid, FacebookPswd);
//	LogoutAction.UserLogOut(driver);
	Log.info("Successfully validated FacebookLogin functionality with valid inputs");}

@AfterClass
public void teardown() throws Exception{
	CloseBrowserAction.Application(Browserhelper.driver);}
}

