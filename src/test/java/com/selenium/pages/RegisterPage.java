package com.selenium.pages;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import com.selenium.utilities.GenericUtilites;


public class RegisterPage {
	Logger logger =Logger.getLogger(RegisterPage.class);
	WebDriver driver;
	//Element locator for Register Hyperlink
	@FindBy(linkText="REGISTER")
	private WebElement register;
	//Element locator for country select DropDown
	@FindBy(name="country")
	private WebElement country;
	//Element locator for userName texBox
	@FindBy(name="email")
	private WebElement username;
	//Element locator for password texBox
	@FindBy(name= "password")
	private WebElement password;
	@FindBy(name="register")
	private WebElement submitButton;
	//Counstructor. driver intialization 
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Register method.Notice no returntype
	public void Register() throws IOException{
		
		register.click();
		String countryName = GenericUtilites.readpropertyFiledata("country");
		String user_Name = GenericUtilites.readpropertyFiledata("username");
		String user_password=GenericUtilites.readpropertyFiledata("password");
		Select country_Name = new Select(country);
		country_Name.selectByVisibleText(countryName);
		username.sendKeys(user_Name);
		password.sendKeys(user_password);
		submitButton.click();
		
	}
	
	
	
	

}
