package com.trainer.qa.module.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DailySessionPage {

public DailySessionPage(WebDriver driver){
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
	
	@FindBy(how=How.XPATH,using = "/html/body/div/section/div/div/div[1]/div/div/div/div/div/div/form/div[3]/div/div[2]/div[2]/div/div[2]/div[2]/div[1]/div/div[1]/div/div/input")
	public WebElement SessionStartDate;

	@FindBy(how=How.XPATH,using = "/html/body/div/section/div/div/div[1]/div/div/div/div/div/div/form/div[3]/div/div[2]/div[2]/div/div[2]/div[2]/div[1]/div/div[2]/div/div/input")
	public WebElement DailySessionEndDate;
	
	@FindBy(how=How.XPATH,using = "/html/body/div/section/div/div/div[1]/div/div/div/div/div/div/form/div[3]/div/div[2]/div[2]/div/div[2]/div[2]/div[1]/div/div[3]/div/div/input")
	public WebElement SessionTime;

	@FindBy(how=How.XPATH,using = "/html/body/div/section/div/div/div[1]/div/div/div/div/div/div/form/div[3]/div/div[2]/div[2]/div/div[2]/div[2]/div[1]/div/div[4]/div/div/select")
	public WebElement SessionDuration;

	@FindBy(how=How.XPATH,using = "//button[contains(text(),'Publish')]")
	public WebElement PublishButton;
	
	@FindBy(how=How.XPATH,using = "/html/body/div/section/div/div/div[1]/div/div/div[2]/div[2]/div[1]/ul/li[2]/a")
	public WebElement DeleteWorkoutSession;

	@FindBy(how=How.XPATH,using = "/html/body/div[1]/div/div/div/div/div/div/a[2]")
	public WebElement ConfirmDeleteWorkoutSession;
}
