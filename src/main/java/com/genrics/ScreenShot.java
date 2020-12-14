package com.genrics;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class ScreenShot {

	private WebDriver driver;

	public ScreenShot(WebDriver driver) {
		this.driver = driver;
	}

	public void captureScreenShot(String fileName) {
		String path = "/target/Screenshots/";

		try {
			TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
			File file = takeScreenShot.getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(file, new File(System.getProperty("user.dir") + path + fileName + ".png"));
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
