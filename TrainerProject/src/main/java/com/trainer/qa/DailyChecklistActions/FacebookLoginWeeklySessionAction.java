package com.trainer.qa.DailyChecklistActions;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.trainer.qa.module.helpers.CreateScheduleshelper;
import com.trainer.qa.module.pages.WeeklySessionPage;
import com.trainer.qa.utility.Constant;
import com.trainer.qa.utility.Log;

public class FacebookLoginWeeklySessionAction {
	static WebDriver driver;

	public static void WeeklySessionwithFacebookLogin() throws Exception{
		System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");	
		driver = new ChromeDriver();
		driver.get("http://ec2-54-191-190-7.us-west-2.compute.amazonaws.com/");
		driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(4000, TimeUnit.SECONDS);	
		
		driver.findElement(By.xpath(".//*[@id='hidemenu1']/li[7]/a")).click();	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000); 
				
		ArrayList<String> trainerTab = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(trainerTab.get(1));
	    
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//li[@class='login']/a")).click();
				
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='sign-in-fb']/span[2]")).click();
	
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window((String) tabs.get(2));

		Log.info("Switched to next opened window.");
		Thread.sleep(3000);
				
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("testingsunilkumar@gmail.com");
				
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@type ='password']")).sendKeys("Testing@12345");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='u_0_0']")).click();
				
		driver.switchTo().window((String) tabs.get(1));
		Log.info("Switching back to previous window.");
		
		Thread.sleep(3000);
			    
		    WebElement element = driver.findElement(By.xpath("//div[@class='web-menu ng-scope']//div[@id='navbar']//ul//li[3]/a"));
	        JavascriptExecutor js = (JavascriptExecutor)driver;
	        js.executeScript("arguments[0].click();", element);
	        Log.info("Click action performed on CreateScheduleButton.");
	        Thread.sleep(2000);
	        
	        WeeklySessionPage WeeklySession = new WeeklySessionPage(driver);
			    			
	    	WeeklySession.NameoftheWorkoutSession.isDisplayed();
	    	WeeklySession.NameoftheWorkoutSession.clear();
	    	WeeklySession.NameoftheWorkoutSession.sendKeys(CreateScheduleshelper.singleworkoutsession());
	        Thread.sleep(1000);
	    	Log.info("Entered name of the workoutsession");
	    			
	    	WeeklySession.TypeofWorkout.isDisplayed();
	    	WeeklySession.TypeofWorkout.click();
	    	WeeklySession.TypeofWorkout.sendKeys(CreateScheduleshelper.TypeofWorkout());
	    	Log.info("Session TypeofWorkout is selected");
	    			
	    	WeeklySession.ClickonGroupSize.click();
	    	WeeklySession.GroupSize.sendKeys(CreateScheduleshelper.GroupSession());
	    	Log.info("Group Session size is selected");
	    			
	    	WeeklySession.WorkoutActivity.isDisplayed();
	    	WeeklySession.WorkoutActivity.click();
	    	WeeklySession.WorkoutAcvtivitySelection.clear();
	    	WeeklySession.WorkoutAcvtivitySelection.sendKeys(CreateScheduleshelper.WorkoutActivity());
	    	Thread.sleep(3000);	
	    	WeeklySession.ClickonWorkoutAcvtivity.click();
	    	Thread.sleep(1000);
	    	Log.info("Session WorkoutActivity is selected");
	    			
	    	WeeklySession.TrainingLevel.isDisplayed();
	    	WeeklySession.TrainingLevel.click();
	    	WeeklySession.TrainingLevel.sendKeys(CreateScheduleshelper.TrainingLevel());
	    	Thread.sleep(1000);
	    	Log.info("Session TrainingLevel is selected");
	    	
	    	WeeklySession.RecurringSessionRadio.isDisplayed();
	    	WeeklySession.RecurringSessionRadio.click();
	    	Thread.sleep(3000);
	    	
	    	WeeklySession.WeeklySessionRadioButton.isDisplayed();
	    	WeeklySession.WeeklySessionRadioButton.click();
	    	
	    	WeeklySession.ClickonSelectDay.isDisplayed();
	    	WeeklySession.ClickonSelectDay.click();
	    	WeeklySession.SelectWeekDay.sendKeys(CreateScheduleshelper.SelectDay(driver));
	    	WeeklySession.ClickonWebElement.click();
	    	Log.info("Weekly Session days is selected");
	    	
	    	WeeklySession.SessionStartDate.isDisplayed();
	    	WeeklySession.SessionStartDate.click();
	    	WeeklySession.SessionStartDate.sendKeys(CreateScheduleshelper.AddDatestocurrentSystemDate("mm/dd/yyyy",Constant.StartDate));
	    	Thread.sleep(2000);
	    	Log.info("Session Start Date is selected");
	    	
	    	WeeklySession.DailySessionEndDate.isDisplayed();
	    	WeeklySession.DailySessionEndDate.click();
	    	WeeklySession.DailySessionEndDate.sendKeys(CreateScheduleshelper.AddDatestocurrentSystemDate("mm/dd/yyyy",Constant.EndDate));
	    	Thread.sleep(2000);
	    	Log.info("Session End Date is selected");
	    	
	    	WeeklySession.SessionTime.isDisplayed();
	    	WeeklySession.SessionTime.clear();
	    	WeeklySession.SessionTime.sendKeys(CreateScheduleshelper.randomTimeGenerate("hh:mm a"));
	    	Log.info("Session time is selected");
	    	
	    	WeeklySession.SessionDuration.isDisplayed();
	    	WeeklySession.SessionDuration.click();
	    	WeeklySession.SessionDuration.sendKeys(CreateScheduleshelper.Duration("Minutes"));
	    	Log.info("Session Duration is selected");
	    	Thread.sleep(3000);
	    	
	    	Actions action = new Actions(driver);
	    	action.sendKeys(Keys.PAGE_DOWN).build().perform();
	    	
	    	WeeklySession.PublishButton.isDisplayed();
	    	WeeklySession.PublishButton.isEnabled();
	    	WeeklySession.PublishButton.click();
	        Thread.sleep(9000);
	    	Log.info("Click action performed on Publish Button.");	
	    	
	    	WeeklySession.DeleteWorkoutSession.click();
	    	Thread.sleep(1000);
	    	
	    	WeeklySession.ConfirmDeleteWorkoutSession.click();
	    	Thread.sleep(3000);
			
			driver.close();
			Thread.sleep(1000);
			driver.quit();				
	}
}
