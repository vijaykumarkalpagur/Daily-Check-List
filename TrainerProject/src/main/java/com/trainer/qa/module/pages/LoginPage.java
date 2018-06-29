package com.trainer.qa.module.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	static WebDriver driver;
	
public LoginPage(WebDriver driver){
	
	PageFactory.initElements(driver, this);
}
	@FindBy(xpath = "//*[@id='username']")
	public WebElement TrainerUsername;

	@FindBy(how=How.XPATH,using= "//*[@id='loginpassword']")
	public WebElement TrainerPassword;

	@FindBy(how=How.XPATH,using = "//button[@id='login-form' and @type='submit']")
	public WebElement TrainerLoginBtn;

}

