package GStore;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import AppiumBasic.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class HybridApps extends BaseTest {

	@Test
	public void checkBox() throws InterruptedException {
//		WebElement errMsg = driver.findElement(By.id("android:id/aerr_close"));
//		if (errMsg.isDisplayed() == true) {
//			errMsg.click();
//		}
		WebElement country = driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry"));
		country.click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Aruba\"));")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Wolf");
		driver.hideKeyboard();
		driver.findElement(By.className("android.widget.Button")).click();
		
		WebElement airJordanRetro = driver.findElement(By.xpath("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[1]"));
//		Assert.assertEquals(airJordanRetro.getText(), "ADD TO CART");
		airJordanRetro.click();
//		Assert.assertEquals(airJordanRetro.getText(), "ADDED TO CART");
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan Lift Off\"));"));
		WebElement jordanLiftOff = driver.findElement(By.xpath("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[2]"));
//		Assert.assertEquals(jordanLiftOff.getText(), "ADsD TO CART");
		jordanLiftOff.click();
//		Assert.assertEquals(jordanLiftOff.getText(), "ADDED TO CART");
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Nike SFB Jungle\"));"));
		WebElement nikeSFBJungle = driver.findElement(By.xpath("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[3]"));
//		Assert.assertEquals(nikeSFBJungle.getText(), "ADD TO CART");
		nikeSFBJungle.click();
//		Assert.assertEquals(nikeSFBJungle.getText(), "ADDED TO CART");
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		Thread.sleep(3000);
		WebElement title = driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title"));
		System.out.println("The title text is: " + title.getAttribute("text"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.attributeContains(title, "text", "Cart"));

		List<WebElement> price = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int count = price.size();
		double totalSum = 0;
		for (int i = 0; i < count; i++) {
			String amountString = price.get(i).getText();
			Double fPrice = Double.parseDouble(amountString.substring(1));
			totalSum = totalSum + fPrice;
			System.out.println("total sum: " + totalSum);
		}
		String displaySum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		Double displayFormattedSum =  getFormattedAmount(displaySum);
		System.out.println("system's total sum: " + displayFormattedSum);
		Assert.assertEquals(String.format("%.2f", totalSum), String.format("%.2f", displayFormattedSum));
		 
		WebElement termsBtn = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		LongPress(termsBtn);
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(10000);
		
		// this line of code gets all the different views in the application: Web and Mobile -> driver.getContextHandles();
		Set<String> context =  driver.getContextHandles();
		for (String contextName: context) {
			System.out.println(contextName);
		}
		
		driver.context("WEBVIEW_com.androidsample.generalstore");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		driver.findElement(By.name("q")).sendKeys("Mangoes");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
		Thread.sleep(2000);

		// Hybrid
		
	}
}
