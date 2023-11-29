package org.javaTut.AppiumFramework.pageObjects.android;

import java.time.Duration;
import java.util.List;

import org.javaTut.AppiumFramework.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProjectCatalog extends AndroidActions {

AndroidDriver driver;
	
	// Define a constructor
	public ProjectCatalog(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	// Choose Kicks
	@AndroidFindBy(xpath="(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[1]")
	private WebElement airJordanRetro;
	@AndroidFindBy(xpath="(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[2]")
	private WebElement jordanLiftOff;
	@AndroidFindBy(xpath="(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[3]")
	private WebElement nikeSFBJungle;
	
	public void chooseKicks() {
		airJordanRetro.click();
		scrollToElement("Jordan Lift Off");
		jordanLiftOff.click();
		scrollToElement("Nike SFB Jungle");
		nikeSFBJungle.click();
	}
	
	// Add to cart button
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement addToCart;
	
	public void addToCartPage() {
		addToCart.click();
	}
	
	
	// Check if the price tallies out
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	private List<WebElement> price;
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement displaySum;
	
	public void makeCalculations() {
		int count = price.size();
		double totalSum = 0;
		for (int i = 0; i < count; i++) {
			String amountString = price.get(i).getText();
			Double fPrice = Double.parseDouble(amountString.substring(1));
			totalSum = totalSum + fPrice;
			System.out.println("total sum: " + totalSum);
		}
		String displaySumm = displaySum.getText();
		Double displayFormattedSum =  getFormattedAmount(displaySumm);
		System.out.println("system's total sum: " + displayFormattedSum);
	}
	
	// Click terms and condition button
	@AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
	private WebElement termsBtn;
	
	
	public void clickTermsBtn() {
		LongPress(termsBtn);
	}
	
	// Click cancel on terms and condition modal
	@AndroidFindBy(id="android:id/button1")
	private WebElement termsCancelBtn;
	
	
	public void clickTermsCancelBtn() {
		termsCancelBtn.click();
	}
	
	// Click discount email checkbox
	@AndroidFindBy(className="android.widget.CheckBox")
	private WebElement discountEmailBtn;
	
	
	public void discountEmailBtn() {
		discountEmailBtn.click();
	}
	
	// Click website link
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	private WebElement Website;
	
	
	public void website() {
		Website.click();
	}
	
	// Change to webview
	
	public void webview() throws InterruptedException {
		driver.context("WEBVIEW_com.androidsample.generalstore");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		driver.findElement(By.name("q")).sendKeys("Mangoes");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
		Thread.sleep(2000);
	}
	
}
