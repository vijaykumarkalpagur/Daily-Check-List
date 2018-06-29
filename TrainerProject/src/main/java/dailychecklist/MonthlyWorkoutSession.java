package dailychecklist;

import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.trainer.qa.DailyChecklistActions.FacebookLoginMontlySessionAction;

import com.trainer.qa.DailyChecklistActions.GmailLoginMonthlySessionAction;

import com.trainer.qa.module.actions.CloseBrowserAction;
import com.trainer.qa.module.actions.LoginAction;

import com.trainer.qa.module.actions.SingleSessionAction;
import com.trainer.qa.module.helpers.Browserhelper;
import com.trainer.qa.module.testdata.LoginDataProvider;
import com.trainer.qa.utility.Log;

public class MonthlyWorkoutSession {
	
@BeforeClass
public void OpenBrowser() throws Exception {	
	PropertyConfigurator.configure("log4j.properties");}

@Test (priority = 1 ,dataProvider = "UserLogin" , dataProviderClass = LoginDataProvider.class)
public void MonthlyWorkoutSessionNormalLogin(String Username ,String Password) throws Exception{
	Browserhelper.openBrowser();
	LoginAction.TrainerLogin(Browserhelper.driver,Username,Password);
	SingleSessionAction.WorkoutSession(Browserhelper.driver);
	Log.info("Successfully validated Monthly Session functionlity with using normal Login with valid inputs");
	CloseBrowserAction.Application(Browserhelper.driver);}

@Test (priority = 2)
public void MonthlyWorkoutSessionGmailLogin() throws Exception{
	GmailLoginMonthlySessionAction.MontlySessionwithGmailLogin();
	Log.info("Successfully validated Monthly Session functionlity with using Gmail Login with valid inputs");}
		
@Test (priority = 3)
public void MonthlyWorkoutSessionFacebookLogin() throws Exception{
	FacebookLoginMontlySessionAction.MonthlySessionwithFacebookLogin();
	Log.info("Successfully validated Monthly Session functionlity with using Facebook Login with valid inputs");}

@AfterClass
public void MonthlySessionCreatedsuccesfully() throws Exception{
	Thread.sleep(3000);
	Log.Succesful("Succesfully validated Monthly session with all valid inputs for both normal Login and Social Logins");}	
	}
