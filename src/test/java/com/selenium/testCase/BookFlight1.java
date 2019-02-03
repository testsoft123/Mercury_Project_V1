package com.selenium.testCase;
import org.testng.annotations.Test;

import com.selenium.pages.FlightFinderPage;
import com.selenium.pages.LoginPage;
import com.selenium.utilities.GenericUtilites;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BookFlight1  extends BaseClass{
	// Global variable
	Logger logger = Logger.getLogger(BookFlight1.class);

	LoginPage loginPage;
	FlightFinderPage flightFinderPage;
	
	@BeforeTest
	public void beforeTest() throws IOException{
		logger.info("Executing the before Test Method-Setting the webdriver pathe");
		//copy the backup of screenShot Folder
		GenericUtilites.copyBackScreenShot();
		//Clearing the Screenshot Folder Content
		GenericUtilites.clearSSFolder();
		
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
				
	}
	//Test case
	@Test
	public void bookFlight() throws IOException {
		logger.info("Starting the Book Flight Reservation Application Automation");
		driver.get(GenericUtilites.readpropertyFiledata("appURL"));
		loginPage.loginUser();
		flightFinderPage.fightFinder();
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
