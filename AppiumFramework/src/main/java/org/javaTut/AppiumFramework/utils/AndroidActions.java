package org.javaTut.AppiumFramework.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public abstract class AndroidActions {
	
	public List<HashMap<String, String>> getJsonData(String jsonFIlePath) throws IOException {
		String jsonContent = FileUtils.readFileToString(new File(jsonFIlePath),
				StandardCharsets.UTF_8);
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, 
				new TypeReference<List<HashMap<String, String>>>(){
			
		});
		return data;
	}

	// Long press on web element
		public void LongPress(WebElement element, AppiumDriver driver) {
			((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
				    "elementId", ((RemoteWebElement) element).getId(), "duration", 2000
				));
		}
		
		// Scroll to a particular element
		public void scrollToElement(String ele, AppiumDriver driver) {
			driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+ele+"\"));")).click();
		}
		
		// Get formatted amount --> remove $ from the price
		public Double getFormattedAmount(String amount) {
			Double fPrice = Double.parseDouble(amount.substring(1));
			return fPrice;
		}
		
		public String getScreenshotPath(String testCaseName, AppiumDriver driver) throws IOException{
			File source = driver.getScreenshotAs(OutputType.FILE);
			String destinationFile = System.getProperty("user.dir") + "//reports" + testCaseName+".png";
			FileUtils.copyFile(source, new File(destinationFile));
			return destinationFile;
		}
}
