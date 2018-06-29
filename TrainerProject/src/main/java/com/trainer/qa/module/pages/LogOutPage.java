package com.trainer.qa.module.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {
	
	public LogOutPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}	
	@FindBy(xpath = "//li[contains(@class,'dropdown')]//a//span[@class='prof-img-frame img-circle user-img-upld']")
	public static WebElement ClickonProfilebutton;

	@FindBy(how=How.XPATH,using= "/html/body/div/nav/div[2]/div/div/div/div[1]/ul/li/ul/li[8]/a")
	public static WebElement TrainerLogout;
	
}
