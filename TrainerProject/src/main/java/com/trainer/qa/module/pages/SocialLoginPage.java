package com.trainer.qa.module.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SocialLoginPage {
  
public SocialLoginPage(WebDriver driver){
	PageFactory.initElements(driver, this);}

	@FindBy(how=How.XPATH,using= "//*[@id='sign-in-fb']/span[2]")
	public WebElement ContinueWithFacebook;
	
	@FindBy(how=How.XPATH,using= "//*[@id='email']")
	public WebElement FacebookUserName;

	@FindBy(how=How.XPATH,using= "//input[@type ='password']")
	public WebElement FacebookUserPassword;
	
	@FindBy(how=How.XPATH,using="//*[@id='u_0_0']")
	public WebElement ClickonFBloginbutton;

	@FindBy(how=How.XPATH,using="//*[@id='sign-in-google']/span[2]")
	public WebElement ClickonGmailbutton;

	@FindBy(how=How.XPATH,using="//*[@id='identifierId']")
	public WebElement GmailUserID;
		
	@FindBy(how=How.XPATH,using= "//*[@id='password']/div[1]/div/div[1]/input")
	public WebElement GmailUserPassword;

	@FindBy(how=How.XPATH,using= "//*[@id='identifierNext']/content/span")
	public WebElement GmailNextButton;

	@FindBy(how=How.XPATH,using= "//*[@id='passwordNext']/content/span")
	public WebElement GmailNextButtontoLogin;	
		
	}

