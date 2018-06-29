package com.trainer.qa.module.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CustomSessionPage {
	
public CustomSessionPage(WebDriver driver){
	PageFactory.initElements(driver, this);
}
	
	@FindBy(how=How.XPATH,using = "//a[@ng-href = '/trainer/#/schedule/']")
	public WebElement CreateScheduleButton;

	@FindBy(how=How.XPATH,using = "//*[@id='name']")
	public WebElement NameoftheWorkoutSession;

	@FindBy(how=How.XPATH,using= "/html/body/div/section/div/div/div[1]/div/div/div/div/div/div/form/div[1]/div[2]/div/select")
	public WebElement TypeofWorkout;

	@FindBy(how=How.XPATH,using = "/html/body/div/section/div/div/div[1]/div/div/div/div/div/div/form/div[1]/div[2]/div/select/option[2]")
	public WebElement ClickonGroupSize;

	@FindBy(how=How.XPATH,using = "/html/body/div/section/div/div/div[1]/div/div/div/div/div/div/form/div[1]/div[3]/div/select")
	public WebElement GroupSize;

	@FindBy(how=How.XPATH,using = "//multiselect[@ng-model = 'vm.schedule.activity']/div/button")
	public WebElement WorkoutActivity;

	@FindBy(how=How.XPATH,using = "/html/body/div/section/div/div/div[1]/div/div/div/div/div/div/form/div[2]/div[1]/div/multiselect/div/ul/li[5]/div/input")
	public WebElement WorkoutAcvtivitySelection;

	@FindBy(how=How.XPATH,using = "/html/body/div/section/div/div/div[1]/div/div/div/div/div/div/form/div[2]/div[1]/div/multiselect/div/ul/li[7]/a")
	public WebElement ClickonWorkoutAcvtivity;

	@FindBy(how=How.XPATH,using = "/html/body/div/section/div/div/div[1]/div/div/div/div/div/div/form/div[2]/div[2]/div/select")
	public WebElement TrainingLevel;

	@FindBy(how=How.XPATH,using = "/html/body/div/section/div/div/div[1]/div/div/div/div/div/div/form/div[3]/div/div[1]/div[2]/label/span[1]")
	public WebElement RecurringSessionRadio;
	
	@FindBy(how=How.XPATH,using = "	/html/body/div/section/div/div/div[1]/div/div/div/div/div/div/form/div[3]/div/div[2]/div[2]/div/div[2]/div[1]/div[5]/label")
	public WebElement CustomSessionRadioButton;
	
	@FindBy(how=How.XPATH,using = "//input[@name = 'customScheduleStartDate0']")
	public WebElement FirstSessionStartDate;
	
	@FindBy(how=How.XPATH,using = "//input[@name = 'customScheduleStartTime0']")
	public WebElement FirstSessionTime;

	@FindBy(how=How.XPATH,using = "/html/body/div/section/div/div/div[1]/div/div/div/div/div/div/form/div[3]/div/div[2]/div[2]/div/div[2]/div[5]/div/div[1]/fieldset[1]/div[3]/div/div/select")
	public WebElement FirstSessionDuration;
	
	@FindBy(how=How.XPATH,using = "//button[@class = 'btn btn-primary btn-sm add-sess']")
	public WebElement AddMoreButton;
		
	@FindBy(how=How.XPATH,using = "//input[@name = 'customScheduleStartTime1']")
	public WebElement SecondSessionTime;

	@FindBy(how=How.XPATH,using = "/html/body/div/section/div/div/div[1]/div/div/div/div/div/div/form/div[3]/div/div[2]/div[2]/div/div[2]/div[5]/div/div[1]/fieldset[2]/div[3]/div/div/select")
	public WebElement SecondSessionDuration;
	
	@FindBy(how=How.XPATH,using = "//button[contains(text(),'Publish')]")
	public WebElement PublishButton;
	
	@FindBy(how=How.XPATH,using = "/html/body/div/section/div/div/div[1]/div/div/div[2]/div[2]/div[1]/ul/li[2]/a")
	public WebElement DeleteWorkoutSession;

	@FindBy(how=How.XPATH,using = "/html/body/div[1]/div/div/div/div/div/div/a[2]")
	public WebElement ConfirmDeleteWorkoutSession;
}


