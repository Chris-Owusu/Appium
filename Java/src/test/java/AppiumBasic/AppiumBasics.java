package AppiumBasic;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumBasics {
	
	@Test
	public void AppiumTest() throws MalformedURLException {
		
		// Automatically start service.
		AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//ChristopherOwusuAhen//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
					.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		
		
		// Setting up UIAutomator
		UiAutomator2Options option = new UiAutomator2Options();
		option.setDeviceName("Pixel 7 Pro");
		option.setApp("C://eclipseWorkflow//Java//Java//src//test//java//resources//ApiDemos-debug.apk");
		
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), option);
		
		//Actual Automation
		WebElement pref = driver.findElement(AppiumBy.accessibilityId("Preference"));
		pref.click();
		
		
		driver.quit();
		service.stop();
	}

}
