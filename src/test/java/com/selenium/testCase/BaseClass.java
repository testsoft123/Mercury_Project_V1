package com.selenium.testCase;

import org.testng.annotations.Test;

import com.selenium.utilities.GenericUtilites;

import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;

public class BaseClass {
	static WebDriver driver;
	  @BeforeClass
	  public static void openBrowser() throws IOException{
		// Initialize driver
			String browserName =GenericUtilites.readpropertyFiledata("browserName");
			driver = GenericUtilites.openBrowser(browserName);
			// Navigate to UR
			
			
		}

  @AfterClass
  public void closeBrowser() {
		//close and quite the browser to close the browser
		driver.close();
		driver.quit();
  }

}
