package com.trainer.qa.module.helpers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WindowsHandlehelper {

	static WebDriver driver;
	private static int index;
	 
public static void PopupWindows(WebDriver driver) throws Exception {	
					
		Set<String> windowscount = driver.getWindowHandles();
		Iterator<String> iter = windowscount.iterator();
		
		@SuppressWarnings("unused")
		String parentwindow		 = iter.next();
		
		@SuppressWarnings("unused")
		String Childwindow 		 = iter.next();
		
		String SubChildwindow	 = iter.next();
		driver.switchTo().window(SubChildwindow);}	

public static void WindowsHandle(WebDriver driver,int index) throws Exception {	
	
	ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	driver.switchTo().window((String) tabs.get(index));	}	
}

