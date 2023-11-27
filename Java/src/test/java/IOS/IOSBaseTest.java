package IOS;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class IOSBaseTest {
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException {
		
		// Automatically start service.
		service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//ChristopherOwusuAhen//AppData//Roaming//npm//node_modules//appium//build//lib//main.js")) // use the right path
					.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		
		
		// Setting up XCUITest
		XCUITest2Options option = new XCUITest2Options();
		option.setDeviceName("iPhone 12 Pro");
		option.setApp("C://eclipseWorkflow//Java//Java//src//test//java//resources//General-Store.apk");
		option.setPlatformVersion("15.5");
		option.setWdaLaunchTimeout(Duration.ofSeconds(20));
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}

}
