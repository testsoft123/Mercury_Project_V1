package com.selenium.testCase;
import org.testng.annotations.Test;

import com.selenium.pages.FlightFinderPage;
import com.selenium.pages.LoginPage;
import com.selenium.pages.RegisterPage;
import com.selenium.utilities.GenericUtilites;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BookFlight  extends GenericUtilites{
	// Global variable
	Logger logger = Logger.getLogger(BookFlight.class);
	WebDriver driver;
	LoginPage loginPage;
	FlightFinderPage flightFinderPage;
	RegisterPage registerPage;
	
	
	@BeforeTest
	public void beforeTest() throws IOException{
		logger.info("Executing the before Test Method-Setting the webdriver pathe");
		//copy the backup of screenShot Folder
		copyBackScreenShot();
		//Clearing the Screenshot Folder Content
		clearSSFolder();
		String browserName =GenericUtilites.readpropertyFiledata("browserName");
		driver = GenericUtilites.openBrowser(browserName);
		
	}
	
	@BeforeMethod
	public void beforeMethod() throws IOException {
		logger.info("Before Method Execution - Initiliaze the WebDriver & Page Factory");
		// Maximize window
		driver.manage().window().maximize();
		// Set the Implicit Wait Time
		driver.manage().timeouts().implicitlyWait(20,  TimeUnit.SECONDS);
		// Page Factory Initialization for all page objects
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		flightFinderPage=PageFactory.initElements(driver, FlightFinderPage.class);
		registerPage =PageFactory.initElements(driver, RegisterPage.class);
		driver.get(GenericUtilites.readpropertyFiledata("appURL"));
		
				
	}
	//Test case
	@Test(enabled=false)
	public void bookFlight() throws IOException {
		
		logger.info("Starting the Book Flight Reservation Application Automation");
		
		loginPage.loginUser();
		flightFinderPage.fightFinder();
	}
	@Test
	public void register() throws IOException {
		
		logger.info("Starting the Register");
		registerPage.Register();
		
		
		
	}
	// Test closer
	@AfterMethod
	public void aftermethod(){
		logger.info("Executing the AfterMethod -killing driver sesssion");
		//close and quite the browser to close the browser
		driver.close();
		driver.quit();
	}
	

}
