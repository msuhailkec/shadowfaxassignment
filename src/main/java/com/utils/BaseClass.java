package com.utils;

import java.io.FileReader;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class BaseClass 
{
	private static FileReader fs;
	
	public static Properties readProperties() throws Exception
	{
		fs = new FileReader(System.getProperty("user.dir")+"/src/main/resources/global.properties");
		Properties p = new Properties();  ;
		p.load(fs);
		return p;
	}
	
	public static void mouseHover(WebElement element, WebDriver driver)
	{
		Actions builder = new Actions(driver);
        builder.moveToElement(element).build().perform();
	}

	
	public static void scrollToAnElement(WebElement scrollToelement, WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", scrollToelement);
	}
	
	public static WebDriver switchToNewWindow(String MainWindow, WebDriver driver)
	{
            Set<String> s1=driver.getWindowHandles();		
		    Iterator<String> i1=s1.iterator();		
		    		
		    while(i1.hasNext())			
		    {		
		        String ChildWindow=i1.next();		
		        		
		        if(!MainWindow.equalsIgnoreCase(ChildWindow))			
		        {    		
		             
		                driver.switchTo().window(ChildWindow);	                                                                                                           
		                	
		        }		
		    }
		    return driver;
		}

}
