
package com.trainer.qa.testcases;

import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.trainer.qa.module.actions.CloseBrowserAction;
import com.trainer.qa.module.actions.GmailAction;
import com.trainer.qa.module.helpers.Browserhelper;
import com.trainer.qa.module.testdata.LoginDataProvider;
import com.trainer.qa.utility.Log;

public class GmailLoginTest {
		
@BeforeClass
public void TrainerSocialBrowser() throws Exception {	
	PropertyConfigurator.configure("log4j.properties");
	Browserhelper.openBrowser();}	

@Test (dataProvider = "GmailLogin" , dataProviderClass = LoginDataProvider.class)
public static void GmailLogin(String Gmailid,String GmailPswd) throws Exception{	
	GmailAction.socialGmailLogin(Browserhelper.driver, Gmailid, GmailPswd);
//	LogoutAction.UserLogOut(Browser.driver);
	Log.info("Successfully validated GmailLogin functionality with valid inputs");}

@AfterClass
public void teardown() throws Exception{
	CloseBrowserAction.Application(Browserhelper.driver);}
}

