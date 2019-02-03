package com.selenium.pages;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.selenium.utilities.GenericUtilites;



public class FlightFinderPage {
		//applications make logging calls
		Logger logger = Logger.getLogger(FlightFinderPage.class);
		//declaring webdriver
		WebDriver driver;
		//element locator for radio button
	
		@FindBy(name ="tripType")
		private List<WebElement> list_tripType;
		
		//Select the location from dropdown
		@FindBy(name = "fromPort")
		private WebElement fromPortDrop;
		
		//Select the day from dropdown
		@FindBy(name = "fromDay")
		private WebElement fromDayDrop;
		
		//Click Business radio button
		@FindBy(name = "servClass")
		private List<WebElement> list_serviceRadio;
		
		
		//Click find flights button
		@FindBy(name = "findFlights")
		private WebElement findFlightsButton;
		
		public FlightFinderPage(WebDriver driver){
			this.driver = driver;			
		}
		
		public void fightFinder() throws IOException{
			logger.info("Search the Flight details with desired destination and Date of Flight");
			
			//click on radio button
			String triptype =GenericUtilites.readpropertyFiledata("tripType");
			int size_tripType = list_tripType.size();
			for(int i=0; i<size_tripType; i++)
			{
				String name_tripType = list_tripType.get(i).getAttribute("value");
						if(name_tripType.contentEquals(triptype))
						{
							list_tripType.get(i).click();
							break;
					}
				}
			 // Select Departing From dropdown
			String departFrom = GenericUtilites.readpropertyFiledata("departFrom");
			Select dropDown =new Select(fromPortDrop);

			// Select Departing Day dropdown
			String departDate = GenericUtilites.readpropertyFiledata("departDate");
			Select dropDay = new Select(fromDayDrop);
			dropDay.selectByValue(departDate);

			// Click business class
			String servicetype =GenericUtilites.readpropertyFiledata("serviceType");
			int size_Service =list_serviceRadio.size();
			for(int i=0; i<size_Service; i++)
			{
				String name_service = list_serviceRadio.get(i).getAttribute("value");
						if(name_service.contentEquals(servicetype))
						{
							list_serviceRadio.get(i).click();
							break;
					}
			}
			// Click Find Flights button
			findFlightsButton.click();
			String methodName=new Exception().getStackTrace()[0].getMethodName();
			GenericUtilites.takeScreenshort(driver, methodName);

		}
}
