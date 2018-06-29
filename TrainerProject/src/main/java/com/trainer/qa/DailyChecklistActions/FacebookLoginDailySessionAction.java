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
import com.trainer.qa.module.pages.DailySessionPage;
import com.trainer.qa.utility.Constant;
import com.trainer.qa.utility.Log;

public class FacebookLoginDailySessionAction {
	static WebDriver driver;
	
public static void DailySessionwithFacebookLogin() throws Exception{
		System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");	
		driver = new ChromeDriver();
		Log.info("Chrome Driver initiated ");

		driver.get("http://ec2-54-191-190-7.us-west-2.compute.amazonaws.com/");

		driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.SECONDS);
		Log.info("Fitbase home page opened");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(4000, TimeUnit.SECONDS);	
		
		driver.findElement(By.xpath(".//*[@id='hidemenu1']/li[7]/a")).click();	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000); 
		Log.info("Clicked action performed on SIGNUP AS TRAINER button");
				
		ArrayList<String> trainerTab = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(trainerTab.get(1));
	    
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//li[@class='login']/a")).click();		
		Thread.sleep(3000);
		Log.info("Clicked action performed on SIGNUP/LOGINbutton");
		
		driver.findElement(By.xpath("//*[@id='sign-in-fb']/span[2]")).click();
	
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window((String) tabs.get(2));
		Thread.sleep(3000);
				
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("testingsunilkumar@gmail.com");	
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@type ='password']")).sendKeys("Testing@12345");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='u_0_0']")).click();
				
		driver.switchTo().window((String) tabs.get(1));
		Thread.sleep(3000);
		    
	    WebElement element = driver.findElement(By.xpath("//div[@class='web-menu ng-scope']//div[@id='navbar']//ul//li[3]/a"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", element);
        Log.info("Click action performed on CreateScheduleButton.");
        Thread.sleep(2000);
        
        DailySessionPage dailysession = new DailySessionPage(driver);
	
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
		Thread.sleep(4000);
		
		driver.close();
		Thread.sleep(1000);
		driver.quit();
				
}
}

