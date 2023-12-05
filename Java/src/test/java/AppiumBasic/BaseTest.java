package AppiumBasic;

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

public class BaseTest {
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
//		option.setDeviceName("Pixel 7 Pro"); // emulator
		option.setDeviceName("Android Device");   // When running it on a real device
		option.setChromedriverExecutable("C://Users//ChristopherOwusuAhen//Downloads//chromedriver.exe");
//		option.setApp("C://eclipseWorkflow//Java//Java//src//test//java//resources//ApiDemos-debug.apk");
//		option.setApp("C://eclipseWorkflow//Java//Java//src//test//java//resources//General-Store.apk");
		option.setApp("C://eclipseWorkflow//Java//Java//src//test//java//resources//AccessBank.apk");
//		option.setApp("C://eclipseWorkflow//Java//Java//src//test//java//resources//XLock.apk");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}

}
