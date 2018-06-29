package dailychecklist;

import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.trainer.qa.DailyChecklistActions.FacebookLoginCustomSessionAction;
import com.trainer.qa.DailyChecklistActions.GmailLoginCustomSessionAction;
import com.trainer.qa.module.actions.CloseBrowserAction;
import com.trainer.qa.module.actions.LoginAction;
import com.trainer.qa.module.actions.SingleSessionAction;
import com.trainer.qa.module.helpers.Browserhelper;
import com.trainer.qa.module.testdata.LoginDataProvider;
import com.trainer.qa.utility.Log;

public class CustomWorkoutSessionsTest {
	
@BeforeClass
public void OpenBrowser() throws Exception {	
	PropertyConfigurator.configure("log4j.properties");}

@Test (priority = 1 ,dataProvider = "UserLogin" , dataProviderClass = LoginDataProvider.class)
public void CustomWorkoutSessionNormalLogin(String Username ,String Password) throws Exception{
	Browserhelper.openBrowser();
	LoginAction.TrainerLogin(Browserhelper.driver,Username,Password);
	SingleSessionAction.WorkoutSession(Browserhelper.driver);
	Log.info("Successfully validated Custom Session functionlity with using normal Login with valid inputs");
	CloseBrowserAction.Application(Browserhelper.driver);}

@Test (priority = 2)
public void CustomWorkoutSessionGmailLogin() throws Exception{
	GmailLoginCustomSessionAction.CustomSessionwithGmailLogin();
	Log.info("Successfully validated Custom Session functionlity with using Gmail Login with valid inputs");}
		
@Test (priority = 3)
public void CustomWorkoutSessionFacebookLogin() throws Exception{
	FacebookLoginCustomSessionAction.CustomSessionwithFacebookLogin();
	Log.info("Successfully validated Custom Session functionlity with using Facebook Login with valid inputs");}

@AfterClass
public void CustomSessionCreatedsuccesfully() throws Exception{
	Thread.sleep(3000);
	Log.Succesful("Succesfully validated Custom session with all valid inputs for both normal Login and Social Logins");}	
	}