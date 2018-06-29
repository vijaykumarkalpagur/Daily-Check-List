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
import com.trainer.qa.module.pages.CustomSessionPage;
import com.trainer.qa.utility.Constant;
import com.trainer.qa.utility.Log;

public class FacebookLoginCustomSessionAction {
	static WebDriver driver;

	public static void CustomSessionwithFacebookLogin() throws Exception{
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
					
			driver.switchTo().window((String) tabs.get(1));
			Thread.sleep(3000);
			    
		    WebElement element = driver.findElement(By.xpath("//div[@class='web-menu ng-scope']//div[@id='navbar']//ul//li[3]/a"));
	     
	        JavascriptExecutor js = (JavascriptExecutor)driver;
	        js.executeScript("arguments[0].click();", element);
	        Log.info("Click action performed on CreateScheduleButton.");
	        Thread.sleep(2000);
	        
	        CustomSessionPage CustomSession = new CustomSessionPage(driver);
	    			
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
			
			driver.close();
			Thread.sleep(1000);
			driver.quit();
					
	}
}
