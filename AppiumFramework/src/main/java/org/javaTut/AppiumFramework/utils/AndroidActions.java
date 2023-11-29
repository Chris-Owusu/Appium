package org.javaTut.AppiumFramework.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions {
	
	AndroidDriver driver;
	
	public AndroidActions(AndroidDriver driver) {
		this.driver = driver;
	}

	// Long press on web element
		public void LongPress(WebElement element) {
			((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
				    "elementId", ((RemoteWebElement) element).getId(), "duration", 2000
				));
		}
		
		// Scroll to the end
		public void ScrollToEnd() {
			boolean canScrollMore;
			do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 3.0
			));
			}while(canScrollMore);
		}
		
		// Scroll to a particular element
		public void scrollToElement(String ele) {
			driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+ele+"\"));")).click();
		}
		
		// Swipe Action
		public void Swipe(WebElement element, String direction) {
			((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
					"elementId", ((RemoteWebElement) element).getId(),
				    "direction", direction,
				    "percent", 0.75
				));
		}
		
		// Drag
		public void Drag(WebElement element, int x, int y) {
			((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
				    "elementId", ((RemoteWebElement) element).getId(),
				    "endX", x,
				    "endY", y
				));
		}
		
		// Get formatted amount --> remove $ from the price
		public Double getFormattedAmount(String amount) {
			Double fPrice = Double.parseDouble(amount.substring(1));
			return fPrice;
		}
}
