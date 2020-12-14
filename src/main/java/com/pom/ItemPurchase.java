package com.pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.BaseClass;

public class ItemPurchase extends BaseClass {
	private WebDriver driver;
	private WebDriverWait wait;

	public ItemPurchase(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 15, 50);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'Login')]/../../../../../button")
	private WebElement closeLoginPrompt;

	@FindBy(xpath = "//span[contains(text(),'Electronics')]")
	private WebElement electronicsItem;

	@FindBy(xpath = "//div/a[contains(text(),'OPPO')]")
	private WebElement selectDevice;

	@FindBy(xpath = "//h2[contains(text(),'Oppo Mobiles under ₹10K')]/../following-sibling::div/a")
	private WebElement viewAll;

	@FindBy(xpath = "//div[contains(text(),'OPPO A1K (Red, 32 GB)')]/..")
	private WebElement navigateToDevice;

	@FindBy(xpath = "//li/button/..")
	private WebElement addToCart;

	@FindBy(xpath = "//a[contains(text(),'Explore')]/../a[1]/img")
	private WebElement homebutton;

	@FindBy(xpath = "//span[contains(text(),'Cart')]")
	private WebElement homecart;

	@FindBy(xpath = "//a[contains(text(),'OPPO A1K (Red, 32 GB)')]")
	private WebElement cartItem;

	@FindBy(xpath = "//span[contains(text(),'Place Order')]")
	private WebElement placeOrder;

	@FindBy(xpath = "//input[@type='text']")
	private WebElement phoneNO;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement butnContinue;

	@FindBy(xpath = "//input[@type='password']")
	private WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginBtn;

	@FindBy(xpath = "//button[contains(text(),'CONTINUE')]")
	private WebElement confirm;

	@FindBy(xpath = "//input[@id='NET_OPTIONS']/..")
	private WebElement netBakingPayment;

	@FindBy(xpath = "//div/select")
	private WebElement banks;

	@FindBy(xpath = "//button[contains(text(),'PAY')]")
	private WebElement makepayment;

	@FindBy(xpath = "//div[contains(text(),'Mobile')]")
	private WebElement landingpage2;


	public void closeLoginPrompet() {
		closeLoginPrompt.click();
	}

	public void clickLoginBtn() {
		this.loginBtn.click();
	}

	public void selectMobile() throws InterruptedException {
		if (electronicsItem.isDisplayed()) {
			mouseHover(electronicsItem, driver);
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(selectDevice)).click();
		} else {
			landingpage2.click();
			Thread.sleep(1000);
			mouseHover(electronicsItem, driver);
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(selectDevice)).click();

		}

	}

	public void clickOnViewAll() {
		viewAll.click();
	}

	public void AddItemToCart() throws InterruptedException {
		String MainWindow;
		scrollToAnElement(navigateToDevice, driver);
		wait.until(ExpectedConditions.visibilityOf(navigateToDevice)).click();
		MainWindow = driver.getWindowHandle();
		switchToNewWindow(MainWindow, driver);
		addToCart.click();

	}

	public void clickOnHomeIcon() {
		wait.until(ExpectedConditions.visibilityOf(homebutton)).click();

	}

	public void clickOncart() {
		driver.navigate().refresh();
		homecart.click();

	}

	public String getCartItemName() {

		return cartItem.getText();
	}

	public void clickPlaceOrder() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(placeOrder)).click();
	}

	public void enterUserPhoneNo() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(phoneNO)).sendKeys((readProperties().get("userName")).toString());

	}

	public void enterUserPassWord() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(password)).sendKeys((readProperties().get("password")).toString());

	}

	public void clickOnContinueButn() {
		wait.until(ExpectedConditions.visibilityOf(butnContinue)).click();

	}

	public void clickOnContinueAtCart() {
		wait.until(ExpectedConditions.visibilityOf(confirm)).click();
	}

	public void clickNetBanking() {
		scrollToAnElement(netBakingPayment, driver);
		wait.until(ExpectedConditions.visibilityOf(netBakingPayment)).click();

	}

	public void selectBank(String bankName) {
		Select se = new Select(banks);
		se.selectByValue(bankName);
	}

	public void clickOnPayment() {
		wait.until(ExpectedConditions.visibilityOf(makepayment)).click();
	}
	
	public void acceptBankingAlert()
	{
		driver.switchTo().alert().dismiss();
	}

}
