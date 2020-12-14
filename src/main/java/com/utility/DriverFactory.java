package com.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.utils.BaseClass;

public class DriverFactory extends BaseClass {
	
	private static WebDriver driver; 
	static String   path = System.getProperty("user.dir");
	
	public static WebDriver getDriver(String driverName) throws Exception{

		if(driverName.equalsIgnoreCase(DriverNames.CHROME)){
			
			System.setProperty(Driver.CHROME,(path + readProperties().getProperty("chromeDriverPath")));
			driver = new ChromeDriver();
		
			
		}else if(driverName.equals(DriverNames.FIREFOX)){
			System.setProperty(Driver.FIREFOX, (path + readProperties().getProperty("firefoxDriverPath")));
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	
	
}