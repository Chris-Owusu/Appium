package GStore;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BrowserBaseTest {
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException {
		
		// Automatically start service.
		service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//ChristopherOwusuAhen//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
					.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		
		
		// Setting up UIAutomator
		UiAutomator2Options option = new UiAutomator2Options();
		option.setDeviceName("Pixel 7 Pro");
		option.setChromedriverExecutable("C://Users//ChristopherOwusuAhen//Downloads//chromedriver.exe"); 
		option.setCapability("browserName", "Chrome");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	// Get formatted amount --> remove $ from the price
	public Double getFormattedAmount(String amount) {
		Double fPrice = Double.parseDouble(amount.substring(1));
		return fPrice;
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}

}
