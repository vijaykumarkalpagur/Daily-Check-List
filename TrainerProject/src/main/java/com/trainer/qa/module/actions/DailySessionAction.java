package com.trainer.qa.module.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.trainer.qa.module.helpers.CreateScheduleshelper;
import com.trainer.qa.module.pages.DailySessionPage;
import com.trainer.qa.utility.Constant;
import com.trainer.qa.utility.Log;

public class DailySessionAction {

	static WebDriver driver;
	
public static void DailySession(WebDriver driver) throws Exception{
	DailySessionPage dailysession = new DailySessionPage(driver);
				
	dailysession.CreateScheduleButton.isDisplayed();
	dailysession.CreateScheduleButton.isEnabled();
	dailysession.CreateScheduleButton.click();
	Thread.sleep(1000);
	Log.info("Click action performed on CreateScheduleButton.");
			
	dailysession.NameoftheWorkoutSession.isDisplayed();
	dailysession.NameoftheWorkoutSession.clear();
	dailysession.NameoftheWorkoutSession.sendKeys(CreateScheduleshelper.singleworkoutsession());
    Thread.sleep(1000);
	Log.info("Entered name of the workoutsession");
			
	dailysession.TypeofWorkout.isDisplayed();
	dailysession.TypeofWorkout.click();
	dailysession.TypeofWorkout.sendKeys(CreateScheduleshelper.TypeofWorkout());
	Log.info("Session TypeofWorkout is selected");
			
	dailysession.ClickonGroupSize.click();
	dailysession.GroupSize.sendKeys(CreateScheduleshelper.GroupSession());
	Log.info("Group Session size is selected");
			
	dailysession.WorkoutActivity.isDisplayed();
	dailysession.WorkoutActivity.click();
	dailysession.WorkoutAcvtivitySelection.clear();
	dailysession.WorkoutAcvtivitySelection.sendKeys(CreateScheduleshelper.WorkoutActivity());
	Thread.sleep(3000);		
	dailysession.ClickonWorkoutAcvtivity.click();
	Thread.sleep(1000);
	Log.info("Session WorkoutActivity is selected");
			
	dailysession.TrainingLevel.isDisplayed();
	dailysession.TrainingLevel.click();
	dailysession.TrainingLevel.sendKeys(CreateScheduleshelper.TrainingLevel());
	Thread.sleep(1000);
	Log.info("Session TrainingLevel is selected");
	
	dailysession.RecurringSessionRadio.isDisplayed();
	dailysession.RecurringSessionRadio.click();
	Thread.sleep(3000);
	
	dailysession.SessionStartDate.isDisplayed();
	dailysession.SessionStartDate.click();
	dailysession.SessionStartDate.sendKeys(CreateScheduleshelper.AddDatestocurrentSystemDate("mm/dd/yyyy",Constant.StartDate));
	Thread.sleep(2000);
	Log.info("Session Start Date is selected");
	
	dailysession.DailySessionEndDate.isDisplayed();
	dailysession.DailySessionEndDate.click();
	dailysession.DailySessionEndDate.sendKeys(CreateScheduleshelper.AddDatestocurrentSystemDate("mm/dd/yyyy",Constant.EndDate));
	Thread.sleep(2000);
	Log.info("Session End Date is selected");
	
	dailysession.SessionTime.isDisplayed();
	dailysession.SessionTime.clear();
	dailysession.SessionTime.sendKeys(CreateScheduleshelper.randomTimeGenerate("hh:mm a"));
	Log.info("Session time is selected");
	
	dailysession.SessionDuration.isDisplayed();
	dailysession.SessionDuration.click();
	dailysession.SessionDuration.sendKeys(CreateScheduleshelper.Duration("Minutes"));
	Log.info("Session Duration is selected");
	Thread.sleep(3000);
	
	Actions action = new Actions(driver);
	action.sendKeys(Keys.PAGE_DOWN).build().perform();
	
	dailysession.PublishButton.isDisplayed();
	dailysession.PublishButton.isEnabled();
	dailysession.PublishButton.click();
    Thread.sleep(9000);
	Log.info("Click action performed on Publish Button.");	
	
	dailysession.DeleteWorkoutSession.click();
	Thread.sleep(1000);
	
	dailysession.ConfirmDeleteWorkoutSession.click();
	Thread.sleep(3000);	
}			
}
