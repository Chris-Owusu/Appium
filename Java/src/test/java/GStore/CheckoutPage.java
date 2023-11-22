package GStore;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import AppiumBasic.BaseTest;
import io.appium.java_client.AppiumBy;

public class CheckoutPage extends BaseTest {

	@Test
	public void checkout() throws InterruptedException {
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
//		Assert.assertEquals(jordanLiftOff.getText(), "ADD TO CART");
		jordanLiftOff.click();
//		Assert.assertEquals(jordanLiftOff.getText(), "ADDED TO CART");
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Nike SFB Jungle\"));"));
		WebElement nikeSFBJungle = driver.findElement(By.xpath("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[3]"));
//		Assert.assertEquals(nikeSFBJungle.getText(), "ADD TO CART");
		nikeSFBJungle.click();
//		Assert.assertEquals(nikeSFBJungle.getText(), "ADDED TO CART");
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement title = driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title"));
		wait.until(ExpectedConditions.attributeContains(title, "text", "Cart"));

		List<WebElement> price = driver.findElements(By.id("com.androidsample.generalstore:id/toolbar_title"));
		int count = price.size();
		double totalSum = 0;
		for (int i = 0; i < count; i++) {
			String amountString = price.get(i).getText();
			Double fPrice = Double.parseDouble(amountString.substring(1));
			totalSum = totalSum + fPrice;
		}
		String displaySum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		Double displayFormattedSum =  getFormattedAmount(displaySum);
		
		Assert.assertEquals(totalSum, displayFormattedSum);
		
//		List<WebElement> product = driver.findElements(By.className("android.widget.TextView"));
//		int count = product.size();
//		for (int i = 0; i < count; i++) {
//			String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
//			System.out.println(productName);
//			Thread.sleep(5000);
//		}
		
	}
}
