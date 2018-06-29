package com.trainer.qa.module.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.trainer.qa.module.helpers.CreateScheduleshelper;
import com.trainer.qa.module.pages.MonthlySessionPage;
import com.trainer.qa.utility.Constant;
import com.trainer.qa.utility.Log;

public class MonthlySessionAction {
	
	static WebDriver driver;
	
public static void montlySession(WebDriver driver) throws Exception{

	MonthlySessionPage montlySession = new MonthlySessionPage(driver);
	
	montlySession.CreateScheduleButton.isDisplayed();
	montlySession.CreateScheduleButton.isEnabled();
	montlySession.CreateScheduleButton.click();
	Thread.sleep(1000);
	Log.info("Click action performed on CreateScheduleButton.");
			
	montlySession.NameoftheWorkoutSession.isDisplayed();
	montlySession.NameoftheWorkoutSession.clear();
	montlySession.NameoftheWorkoutSession.sendKeys(CreateScheduleshelper.singleworkoutsession());
    Thread.sleep(1000);
	Log.info("Entered name of the workoutsession");
			
	montlySession.TypeofWorkout.isDisplayed();
	montlySession.TypeofWorkout.click();
	montlySession.TypeofWorkout.sendKeys(CreateScheduleshelper.TypeofWorkout());
	Log.info("Session TypeofWorkout is selected");
			
	montlySession.ClickonGroupSize.click();
	montlySession.GroupSize.sendKeys(CreateScheduleshelper.GroupSession());
	Log.info("Group Session size is selected");
			
	montlySession.WorkoutActivity.isDisplayed();
	montlySession.WorkoutActivity.click();
	montlySession.WorkoutAcvtivitySelection.clear();
	montlySession.WorkoutAcvtivitySelection.sendKeys(CreateScheduleshelper.WorkoutActivity());
	Thread.sleep(3000);	
	montlySession.ClickonWorkoutAcvtivity.click();
	Thread.sleep(1000);
	Log.info("Session WorkoutActivity is selected");
			
	montlySession.TrainingLevel.isDisplayed();
	montlySession.TrainingLevel.click();
	montlySession.TrainingLevel.sendKeys(CreateScheduleshelper.TrainingLevel());
	Thread.sleep(1000);
	Log.info("Session TrainingLevel is selected");
	
	montlySession.RecurringSessionRadio.isDisplayed();
	montlySession.RecurringSessionRadio.click();
	Thread.sleep(3000);
	
	montlySession.MonthlySessionRadioButton.isDisplayed();
	montlySession.MonthlySessionRadioButton.click();
	
	montlySession.ClickonSelectDay.isDisplayed();
	montlySession.ClickonSelectDay.click();
	montlySession.SelectDay.click();
	Log.info("Daily Session day is selected");
	
	montlySession.SessionStartDate.isDisplayed();
	montlySession.SessionStartDate.click();
	montlySession.SessionStartDate.sendKeys(CreateScheduleshelper.AddDatestocurrentSystemDate("mm/dd/yyyy",Constant.StartDate));
	Thread.sleep(2000);
	Log.info("Session Start Date is selected");
	
	montlySession.DailySessionEndDate.isDisplayed();
	montlySession.DailySessionEndDate.click();
	montlySession.DailySessionEndDate.sendKeys(CreateScheduleshelper.AddDatestocurrentSystemDate("mm/dd/yyyy",Constant.EndDate));
	Thread.sleep(2000);
	Log.info("Session End Date is selected");
	
	montlySession.SessionTime.isDisplayed();
	montlySession.SessionTime.clear();
	montlySession.SessionTime.sendKeys(CreateScheduleshelper.randomTimeGenerate("hh:mm a"));
	Log.info("Session time is selected");
	
	montlySession.SessionDuration.isDisplayed();
	montlySession.SessionDuration.click();
	montlySession.SessionDuration.sendKeys(CreateScheduleshelper.Duration("Minutes"));
	Log.info("Session Duration is selected");
	Thread.sleep(3000);
	
	Actions action = new Actions(driver);
	action.sendKeys(Keys.PAGE_DOWN).build().perform();
	
	montlySession.PublishButton.isDisplayed();
	montlySession.PublishButton.isEnabled();
	montlySession.PublishButton.click();
    Thread.sleep(9000);
	Log.info("Click action performed on Publish Button.");	
	
	montlySession.DeleteWorkoutSession.click();
	Thread.sleep(1000);
	
	montlySession.ConfirmDeleteWorkoutSession.click();
	Thread.sleep(3000);
}
}
