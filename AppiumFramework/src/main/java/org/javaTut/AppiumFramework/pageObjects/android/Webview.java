package org.javaTut.AppiumFramework.pageObjects.android;

import java.time.Duration;

import org.javaTut.AppiumFramework.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Webview extends AndroidActions {
	
	AndroidDriver driver;

	public Webview(AndroidDriver driver) {
		this.driver = driver;
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
