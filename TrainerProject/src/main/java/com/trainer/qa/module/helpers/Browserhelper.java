package com.trainer.qa.module.helpers;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import com.trainer.qa.utility.Log;

public class Browserhelper {

	public static WebDriver driver;

	public static WebDriver openBrowser() throws Exception{

	Properties prop = new Properties() ;
	FileInputStream input  = new FileInputStream("C:\\Users\\Vijay\\workspace\\TrainerProject\\src\\main\\java\\com\\trainer\\qa\\module\\config\\config.properties");
	prop.load(input);
	String browserName = prop.getProperty("browser");
	
	try {
		if(browserName.equalsIgnoreCase("Chrome")){
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vijay\\workspace\\TrainerProject\\chromedriver.exe");	
				driver = new ChromeDriver();
				Log.info("Chrome Driver initiated ");}
		
		else if(browserName.equalsIgnoreCase("FireFox")){
			    System.setProperty("webdriver.gecko.driver", ".\\geckodriver.exe");
			    driver = new FirefoxDriver();
			    Log.info("FireFox Driver initiated ");}
		
		else if(browserName.equalsIgnoreCase("ie")){
				System.setProperty("webdriver.ie.driver",".\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				Log.info("InternetExplorer1 Driver initiated ");}
	}		
				catch (Exception e) {
					e.getMessage();}
	driver.get(prop.getProperty("url"));
	Log.info("Fitbase home page opened");
	driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.SECONDS);
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(4000, TimeUnit.SECONDS);	
	
	driver.findElement(By.xpath("//li[@class='trainer']/a")).click();
	Log.info("Clicked action performed on SIGNUP AS TRAINER button");
	driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.SECONDS);
	
	WindowsHandlehelper.WindowsHandle(driver, 1);
	Thread.sleep(10000);
	
	driver.findElement(By.xpath("//*[@id='signuplogin']/a")).click();
	Log.info("Clicked action performed on SIGNUP/LOGINbutton");
	Thread.sleep(5000);  
	
	return driver;
}
}
