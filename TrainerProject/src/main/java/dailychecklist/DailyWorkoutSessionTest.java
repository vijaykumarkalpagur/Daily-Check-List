package dailychecklist;

import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.trainer.qa.DailyChecklistActions.FacebookLoginDailySessionAction;
import com.trainer.qa.DailyChecklistActions.GmailLoginDailySessionAction;
import com.trainer.qa.module.actions.CloseBrowserAction;
import com.trainer.qa.module.actions.LoginAction;
import com.trainer.qa.module.actions.SingleSessionAction;
import com.trainer.qa.module.helpers.Browserhelper;
import com.trainer.qa.module.testdata.LoginDataProvider;
import com.trainer.qa.utility.Log;

public class DailyWorkoutSessionTest {
	
@BeforeClass
public void OpenBrowser() throws Exception {	
	PropertyConfigurator.configure("log4j.properties");}

@Test (priority = 1 ,dataProvider = "UserLogin" , dataProviderClass = LoginDataProvider.class)
public void DailyWorkoutSessionNormalLogin(String Username ,String Password) throws Exception{
	Browserhelper.openBrowser();
	LoginAction.TrainerLogin(Browserhelper.driver,Username,Password);
	SingleSessionAction.WorkoutSession(Browserhelper.driver);
	Log.info("Successfully validated Daily Session functionlity with using normal Login with valid inputs");
	CloseBrowserAction.Application(Browserhelper.driver);}

@Test (priority = 2)
public void DailyWorkoutSessionGmailLogin() throws Exception{
	GmailLoginDailySessionAction.DailySessionwithGmailLogin();
	Log.info("Successfully validated Daily Session functionlity with using Gmail Login with valid inputs");}
		
@Test (priority = 3)
public void DailyWorkoutSessionFacebookLogin() throws Exception{
	FacebookLoginDailySessionAction.DailySessionwithFacebookLogin();
	Log.info("Successfully validated Daily Session functionlity with using Facebook Login with valid inputs");}

@AfterClass
public void DailySessionCreatedsuccesfully() throws Exception{
	Thread.sleep(3000);
	Log.Succesful("Succesfully validated Daily session with all valid inputs for both normal Login and Social Logins");}	
}

