package com.test;


import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.genrics.ScreenShot;
import com.pom.ItemPurchase;
import com.utility.DriverFactory;
import com.utils.BaseClass;


public class PurchaseFlowTest extends BaseClass {
	private WebDriver driver;
	private String baseUrl;
	private ItemPurchase purchasePom;
	private ScreenShot screenShot;
	String tcName;

	@BeforeClass
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(readProperties().getProperty("browserName"));
		purchasePom = new ItemPurchase(driver); 
		baseUrl = readProperties().getProperty("baseUrl");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);
	}
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	@BeforeMethod
	public void setUp(Method method){
		tcName = method.getName();
		
	}
	@AfterMethod
	public void screenShot(ITestResult result)
	{
		if(ITestResult.FAILURE==result.getStatus()||ITestResult.SUCCESS==result.getStatus())
		{
			screenShot.captureScreenShot(tcName);
		}
	}
	

	@Test
	public void validLoginTest() throws Exception {
		purchasePom.closeLoginPrompet();
		purchasePom.selectMobile();
		purchasePom.clickOnViewAll();
		purchasePom.AddItemToCart();
		purchasePom.clickOnHomeIcon();
		purchasePom.clickOncart();
		Thread.sleep(1000);
		Assert.assertEquals(purchasePom.getCartItemName(), "OPPO A1K (Red, 32 GB)");
		Thread.sleep(1000);
		purchasePom.clickPlaceOrder();
	
		purchasePom.enterUserPhoneNo();
		purchasePom.clickOnContinueButn();
		Thread.sleep(1000);
		purchasePom.enterUserPassWord();
		purchasePom.clickLoginBtn();
		purchasePom.clickOnContinueAtCart();
		Thread.sleep(1000);
		purchasePom.clickNetBanking();
		purchasePom.selectBank((readProperties().get("bankName")).toString());
		purchasePom.clickOnPayment();
		Thread.sleep(5000);
		purchasePom.acceptBankingAlert();
		Thread.sleep(5000);
		
	}
}
