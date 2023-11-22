package GStore;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import AppiumBasic.BaseTest;
import io.appium.java_client.AppiumBy;

public class Gstore extends BaseTest {
	@Test
	public void LoginErrorMsg() throws InterruptedException {
		driver.findElement(By.className("android.widget.Button")).click();
		String errorMsg = driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
		Assert.assertEquals(errorMsg, "Please enter your name");
	}
	
	@Test
	public void Login() {
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Wolf");
		driver.findElement(By.className("android.widget.Button")).click();
//		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_back")).click();
	}
	
	@Test
	public void addToCart() throws MalformedURLException {
		WebElement country = driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry"));
		country.click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Ghana\"));")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Wolf");
//		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.hideKeyboard();
		driver.findElement(By.className("android.widget.Button")).click();
		
		WebElement airJordanRetro = driver.findElement(By.xpath("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[1]"));
		Assert.assertEquals(airJordanRetro.getText(), "ADD TO CART");
		airJordanRetro.click();
		Assert.assertEquals(airJordanRetro.getText(), "ADDED TO CART");
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan Lift Off\"));"));
		
		// another way of doing it
		int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		for (int i = 0; i < productCount; i++) {
			String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if(productName.equalsIgnoreCase("Jordan Lift Off")) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			}
		}
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Card"));
		
		String product = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals(product, "Jordan Lift Off");
		
		// another way of doing it 
//		WebElement jordanLiftOff = driver.findElement(By.xpath("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[2]"));
//		Assert.assertEquals(jordanLiftOff.getText(), "ADD TO CART");
//		jordanLiftOff.click();
//		Assert.assertEquals(jordanLiftOff.getText(), "ADDED TO CART");
//		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
//		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productName\" and @text=\"Air Jordan 4 Retro\"]")).isDisplayed();
//		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productName\" and @text=\"Jordan Lift Off\"]")).isDisplayed();
		}
}
