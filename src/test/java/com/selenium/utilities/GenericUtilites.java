package com.selenium.utilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class GenericUtilites {
	static WebDriver driver;
	/***********Select driver***********************/
	public static WebDriver openBrowser(String browserName){
		switch (browserName) {
		case "Firefox":
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Driver/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Driver/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "IE":
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Driver/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		}
		return driver;
	}
	/********************select value for perticular key***************/
	public static String readpropertyFiledata(String keyName) throws IOException {
		String reValue = null;
		try {
			Properties properties = null;
			FileReader fileReader = new FileReader(
					System.getProperty("user.dir") + "\\src\\test\\java\\com\\selenium\\testData\\BookFlight.properties");
			properties = new Properties();
			properties.load(fileReader);
			reValue = properties.getProperty(keyName).toString();
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("Exception thrown");
		}
		return reValue;
	}
	/*********Current date and time*****************/
	public static String dateTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyy_MM_dd_HH.mm.ss");  
		LocalDateTime currentDate = LocalDateTime.now();  
		String dateTime=dtf.format(currentDate);
		return dateTime;
	}
	/*********Take ScreenShot*****************/
	public static void takeScreenshort(WebDriver driver,String sheet) throws IOException {
	  	File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path =System.getProperty("user.dir") + "/ScreenShot/";
		FileUtils.copyFile(scr, new File(path+sheet+"_"+dateTime()+ ".jpg"));
		
	}
	
	/********Copy the Screenshot Folder Content*********/
	public static void copyBackScreenShot() throws IOException {
		FileUtils.copyDirectory(new File("./ScreenShot"), new File("D://Backup//V1_"+dateTime()+""));
	}
	/********Clearing the Screenshot Folder Content*********/
	public static void clearSSFolder() throws IOException {
		FileUtils.cleanDirectory(new File("./ScreenShot"));
	}
	
}
