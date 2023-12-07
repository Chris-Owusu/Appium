package org.javaTut.AppiumFramework.pageObjects.android;

import java.util.List;

import org.javaTut.AppiumFramework.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends AndroidActions {
	
	AndroidDriver driver;

	// Define a constructor
	public CartPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
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
			LongPress(termsBtn, driver);
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
			
			
			public Webview website() {
				Website.click();
				return new Webview(driver);
			}

}
