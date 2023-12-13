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
public class Cards extends BaseTest {
	

	
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
		
		driver.findElement(By.id("com.cardsapp.android:id/start_like_pro_close_button")).click();
	}
	
	@DataProvider(name = "getData")
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")
				+ "//src//main//java//TestData//Credentials.json");
		return new Object[][] {{data.get(0)}};
	}

}
