package com.selenium.pages;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.selenium.utilities.GenericUtilites;


public class LoginPage {
	//applications make logging calls
	Logger logger = Logger.getLogger(LoginPage.class);
	//Declaring webdirver
	WebDriver driver;
	//Element locator for userName textBox
	@FindBy(name="userName")
	private WebElement userName;
	
	//Element locator for password textBox
	@FindBy(name="password")
	private WebElement password;
	
	//Element locator for login button
	@FindBy(name="login")
	private WebElement login;
	
	//Constructor . Driver initilization
	public LoginPage(WebDriver driver){
		this.driver=driver;
	}
	//Login method .Nothice there is no return type
	public void loginUser() throws IOException{
		logger.info("Logging int the Mercury Flight Reservation application" );
		//Enter userName
		String userName_data=GenericUtilites.readpropertyFiledata("loginName");
		userName.sendKeys(userName_data);
		//Enter password
		String password_data = GenericUtilites.readpropertyFiledata("loginPassword");
		password.sendKeys(password_data);
		//click on login button
		login.click();
		String methodName=new Exception().getStackTrace()[0].getMethodName();
		GenericUtilites.takeScreenshort(driver, methodName);
		
	}

}
