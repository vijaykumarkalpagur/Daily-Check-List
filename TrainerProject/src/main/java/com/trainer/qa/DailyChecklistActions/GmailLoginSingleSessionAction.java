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
import com.trainer.qa.module.pages.CreateSingleSessionPage;
import com.trainer.qa.utility.Constant;
import com.trainer.qa.utility.Log;

public class GmailLoginSingleSessionAction{

static WebDriver driver;

public static void SingleSessionwithGmailLogin() throws Exception{
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
		
		driver.findElement(By.xpath(".//*[@id='sign-in-google']")).click();
	
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window((String) tabs.get(2));
		Thread.sleep(3000);
				
		driver.findElement(By.name("identifier")).sendKeys("priyaindugula3@gmail.com");	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//Content[@class='CwaK9']//span[contains(text(),'Next')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='whsOnd zHQkBf']")).sendKeys("priyalaya");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();
				
		driver.switchTo().window((String) tabs.get(1));
		Thread.sleep(3000);
		    
	    WebElement element = driver.findElement(By.xpath("//div[@class='web-menu ng-scope']//div[@id='navbar']//ul//li[3]/a"));
     
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", element);
        Log.info("Click action performed on CreateScheduleButton.");
        Thread.sleep(2000);
        
        CreateSingleSessionPage singlesession = new CreateSingleSessionPage(driver);
		singlesession.NameoftheWorkoutSession.isDisplayed();
		singlesession.NameoftheWorkoutSession.clear();
		singlesession.NameoftheWorkoutSession.sendKeys(CreateScheduleshelper.singleworkoutsession());
	    Thread.sleep(1000);
		Log.info("Entered name of the workoutsession");
		
		singlesession.TypeofWorkout.isDisplayed();
		singlesession.TypeofWorkout.click();
		singlesession.TypeofWorkout.sendKeys(CreateScheduleshelper.TypeofWorkout());
		Log.info("Session TypeofWorkout is selected");
		
		singlesession.ClickonGroupSize.click();
		singlesession.GroupSize.sendKeys(CreateScheduleshelper.GroupSession());
		Log.info("Group Session size is selected");
		
		singlesession.WorkoutActivity.isDisplayed();
		singlesession.WorkoutActivity.click();
		
		singlesession.WorkoutAcvtivitySelection.clear();
		singlesession.WorkoutAcvtivitySelection.sendKeys(CreateScheduleshelper.WorkoutActivity());
		Thread.sleep(3000);
		
		singlesession.ClickonWorkoutAcvtivity.click();
	    Thread.sleep(1000);
		Log.info("Session WorkoutActivity is selected");
		
		singlesession.TrainingLevel.isDisplayed();
		singlesession.TrainingLevel.click();
		singlesession.TrainingLevel.sendKeys(CreateScheduleshelper.TrainingLevel());
	    Thread.sleep(1000);
		Log.info("Session TrainingLevel is selected");
		
		singlesession.SessionDate.isDisplayed();
		singlesession.SessionDate.click();
		singlesession.SessionDate.sendKeys(CreateScheduleshelper.AddDatestocurrentSystemDate("mm/dd/yyyy",Constant.StartDate));
		Thread.sleep(2000);
		Log.info("Session Date is selected");
		
		singlesession.SessionTime.isDisplayed();
		singlesession.SessionTime.clear();
		singlesession.SessionTime.sendKeys(CreateScheduleshelper.randomTimeGenerate("hh:mm a"));
		Log.info("Session time is selected");
		
		singlesession.SessionDuration.isDisplayed();
		singlesession.SessionDuration.click();
		singlesession.SessionDuration.sendKeys(CreateScheduleshelper.Duration("Minutes"));
		Log.info("Session Duration is selected");
		Thread.sleep(3000);
		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		
		singlesession.PublishButton.isDisplayed();
		singlesession.PublishButton.isEnabled();
		singlesession.PublishButton.click();
	    Thread.sleep(9000);
		Log.info("Click action performed on Publish Button.");
		
		singlesession.DeleteWorkoutSession.click();
		Thread.sleep(1000);
		
		singlesession.ConfirmDeleteWorkoutSession.click();
		Thread.sleep(4000);
		
		driver.close();
		Thread.sleep(1000);
		driver.quit();
				
}
}
