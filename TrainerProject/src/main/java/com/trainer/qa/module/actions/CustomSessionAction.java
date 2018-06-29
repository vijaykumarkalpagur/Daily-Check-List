package com.trainer.qa.module.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.trainer.qa.module.helpers.CreateScheduleshelper;
import com.trainer.qa.module.pages.CustomSessionPage;
import com.trainer.qa.utility.Constant;
import com.trainer.qa.utility.Log;

public class CustomSessionAction {

	static WebDriver driver;
	
public static void CustomSession(WebDriver driver) throws Exception{
	CustomSessionPage CustomSession = new CustomSessionPage(driver);
				
	CustomSession.CreateScheduleButton.isDisplayed();
	CustomSession.CreateScheduleButton.isEnabled();
	CustomSession.CreateScheduleButton.click();
	Thread.sleep(1000);
	Log.info("Click action performed on CreateScheduleButton.");
			
	CustomSession.NameoftheWorkoutSession.isDisplayed();
	CustomSession.NameoftheWorkoutSession.clear();
	CustomSession.NameoftheWorkoutSession.sendKeys(CreateScheduleshelper.singleworkoutsession());
    Thread.sleep(1000);
	Log.info("Entered name of the workoutsession");
			
	CustomSession.TypeofWorkout.isDisplayed();
	CustomSession.TypeofWorkout.click();
	CustomSession.TypeofWorkout.sendKeys(CreateScheduleshelper.TypeofWorkout());
	Log.info("Session TypeofWorkout is selected");
			
	CustomSession.ClickonGroupSize.click();
	CustomSession.GroupSize.sendKeys(CreateScheduleshelper.GroupSession());
	Log.info("Group Session size is selected");
			
	CustomSession.WorkoutActivity.isDisplayed();
	CustomSession.WorkoutActivity.click();
	CustomSession.WorkoutAcvtivitySelection.clear();
	CustomSession.WorkoutAcvtivitySelection.sendKeys(CreateScheduleshelper.WorkoutActivity());
	Thread.sleep(3000);	
	CustomSession.ClickonWorkoutAcvtivity.click();
	Thread.sleep(1000);
	Log.info("Session WorkoutActivity is selected");
			
	CustomSession.TrainingLevel.isDisplayed();
	CustomSession.TrainingLevel.click();
	CustomSession.TrainingLevel.sendKeys(CreateScheduleshelper.TrainingLevel());
	Thread.sleep(1000);
	Log.info("Session TrainingLevel is selected");
	
	CustomSession.RecurringSessionRadio.isDisplayed();
	CustomSession.RecurringSessionRadio.click();
	Thread.sleep(3000);
	
	CustomSession.CustomSessionRadioButton.isDisplayed();
	CustomSession.CustomSessionRadioButton.click();
		
	CustomSession.FirstSessionStartDate.isDisplayed();
	CustomSession.FirstSessionStartDate.click();
	CustomSession.FirstSessionStartDate.sendKeys(CreateScheduleshelper.AddDatestocurrentSystemDate("mm/dd/yyyy",Constant.StartDate));
	Thread.sleep(2000);
	Log.info("Session Start Date is selected");
		
	CustomSession.FirstSessionTime.isDisplayed();
	CustomSession.FirstSessionTime.clear();
	CustomSession.FirstSessionTime.sendKeys(CreateScheduleshelper.randomTimeGenerate("hh:mm a"));
	Log.info("Session time is selected");
	
	CustomSession.FirstSessionDuration.isDisplayed();
	CustomSession.FirstSessionDuration.click();
	CustomSession.FirstSessionDuration.sendKeys(CreateScheduleshelper.Duration("Minutes"));
	Log.info("Session Duration is selected");
	Thread.sleep(3000);
	
	CustomSession.AddMoreButton.isDisplayed();
	CustomSession.AddMoreButton.isEnabled();
	CustomSession.AddMoreButton.click();
	Log.info("Click action performed on AddMoreButton.");
		
	CustomSession.SecondSessionTime.isDisplayed();
	CustomSession.SecondSessionTime.clear();
	CustomSession.SecondSessionTime.sendKeys(CreateScheduleshelper.randomTimeGenerate("hh:mm a"));
	Log.info("Session Second Time is selected");
	
	CustomSession.SecondSessionDuration.isDisplayed();
	CustomSession.SecondSessionDuration.click();
	CustomSession.SecondSessionDuration.sendKeys(CreateScheduleshelper.Duration("Minutes"));
	Log.info("Session Second Duration is selected");
	Thread.sleep(3000);
		
	Actions action = new Actions(driver);
	action.sendKeys(Keys.PAGE_DOWN).build().perform();
	
	CustomSession.PublishButton.isDisplayed();
	CustomSession.PublishButton.isEnabled();
	CustomSession.PublishButton.click();
    Thread.sleep(9000);
	Log.info("Click action performed on Publish Button.");	
	
	CustomSession.DeleteWorkoutSession.click();
	Thread.sleep(1000);
	
	CustomSession.ConfirmDeleteWorkoutSession.click();
	Thread.sleep(3000);
}	
}
