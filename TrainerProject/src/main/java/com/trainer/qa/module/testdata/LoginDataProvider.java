package com.trainer.qa.module.testdata;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {

@DataProvider(name = "UserLogin" )//New Registered User
	public static Object[][] getDataFromUserLoginDataprovider(){
	return new Object[][]{{"saikumaratmakur@gmail.com", "password"}};
}
@DataProvider(name = "GmailLogin" )//Social Login
	public static Object[][] gmailDataprovider(){
	return new Object[][]{{"testingsunilkumar@gmail.com", "Testing@12345"}};
}
@DataProvider(name = "FacebookLogin" )//Social Login
	public static Object[][] FacebookDataprovider(){
	return new Object[][]{{"testingsunilkumar@gmail.com", "Testing@12345"}};
}
}
