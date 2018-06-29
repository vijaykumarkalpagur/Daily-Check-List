package dailychecklist;

import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.trainer.qa.DailyChecklistActions.FacebookLoginSingleSessionAction;
import com.trainer.qa.DailyChecklistActions.GmailLoginSingleSessionAction;
import com.trainer.qa.module.actions.CloseBrowserAction;
import com.trainer.qa.module.actions.LoginAction;
import com.trainer.qa.module.actions.SingleSessionAction;
import com.trainer.qa.module.helpers.Browserhelper;
import com.trainer.qa.module.testdata.LoginDataProvider;
import com.trainer.qa.utility.Log;

public class SingleWorkoutSession {
	
@BeforeClass
public void OpenBrowser() throws Exception {	
	PropertyConfigurator.configure("log4j.properties");}

@Test (priority = 1 ,dataProvider = "UserLogin" , dataProviderClass = LoginDataProvider.class)
public void singleWorkoutSessionNormalLogin(String Username ,String Password) throws Exception{
	Browserhelper.openBrowser();
	LoginAction.TrainerLogin(Browserhelper.driver,Username,Password);
	SingleSessionAction.WorkoutSession(Browserhelper.driver);
	Log.info("Successfully validated Daily Session functionlity with using normal Login with valid inputs");
	CloseBrowserAction.Application(Browserhelper.driver);}

@Test (priority = 2)
public void singleWorkoutSessionGmailLogin() throws Exception{
	GmailLoginSingleSessionAction.SingleSessionwithGmailLogin();
	Log.info("Successfully validated Single Session functionlity with using Gmail Login with valid inputs");}
		
@Test (priority = 3)
public void singleWorkoutSessionFacebookLogin() throws Exception{
	FacebookLoginSingleSessionAction.SingleSessionwithFacebookLogin();
	Log.info("Successfully validated Single Session functionlity with using Facebook Login with valid inputs");}

@AfterClass
public void SingleSessionCreatedsuccesfully() throws Exception{
	Thread.sleep(3000);
	Log.Succesful("Succesfully validated Single session with all valid inputs for both normal Login and Social Logins");}	
	}