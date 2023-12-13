package FingerPrint;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
//import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import AppiumBasic.BaseTest;
public class Fingerprint extends BaseTest {
	

	
	public List<HashMap<String, String>> getJsonData(String jsonFIlePath) throws IOException {
		String jsonContent = FileUtils.readFileToString(new File(jsonFIlePath),
				StandardCharsets.UTF_8);
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, 
				new TypeReference<List<HashMap<String, String>>>(){
			
		});
		return data;
	}

	@Test(dataProvider = "getData")
	public void fPrint(HashMap<String, String> input) throws InterruptedException {
		
		WebElement deny = driver.findElement(By.id("com.android.permissioncontroller:id/permission_deny_button"));
		if (deny.isDisplayed() == true) {
			deny.click();
			
			// Enter here button
			driver.findElement(By.xpath("//android.widget.TextView[@text=\"ENTER HERE\"]")).click();

			// Email
			driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Input undefined\" and @text=\"Enter your login\"]")).sendKeys(input.get("username"));
			// Password
			driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Input undefined\" and @text=\"Enter your password\"]")).sendKeys(input.get("password"));
			
			// Remember Me button
			WebElement rememberMe = driver.findElement(By.className("android.widget.Switch"));
			String rememberMeText = rememberMe.getText();
			System.out.println("Remember me before: "+rememberMeText);
			Assert.assertEquals(rememberMeText, "OFF");
			rememberMe.click();
//			Thread.sleep(5000);
//			System.out.println("Remember me after: "+rememberMeText);
//			Assert.assertEquals(rememberMeText, "ON");
			
			//Choose Country
			driver.findElement(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[12]")).click();
			Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text=\"Choose Country\"]")).isDisplayed());
			driver.findElement(By.xpath("//android.widget.TextView[@text=\"GHANA\"]")).click();
			
			//sign in button
			driver.findElement(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]")).click();
			Thread.sleep(10000);
//			driver.findElement(By.id("com.android.permissioncontroller:id/grant_singleton")).click();
//			driver.findElement(By.xpath("//android.widget.TextView[@text=\"ENTER HERE\"]")).click();
		}
	}
	
	@DataProvider(name = "getData")
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")
				+ "//src//main//java//TestData//Credentials.json");
		return new Object[][] {{data.get(0)}};
	}

}
