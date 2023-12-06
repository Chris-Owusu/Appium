package org.javaTut;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.javaTut.AppiumFramework.pageObjects.android.FormPage;
import org.javaTut.AppiumFramework.utils.AndroidActions;
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

public class BaseTests extends AndroidActions {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	public FormPage formPage;
	
	@BeforeClass
	public void ConfigureAppium() throws IOException {
		
		// Automatically start service.
		service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//ChristopherOwusuAhen//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
					.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//org//javaTut//AppiumFramework//resources//data.properties");
		prop.load(fis);
		
		String phone = prop.getProperty("deviceName");
		
		
		// Setting up UIAutomator
		UiAutomator2Options option = new UiAutomator2Options();
		option.setDeviceName(phone); // emulator
//		option.setDeviceName("Android Device");   // When running it on a real device
		option.setChromedriverExecutable("C://Users//ChristopherOwusuAhen//Downloads//chromedriver.exe");
		option.setApp("C://eclipseWorkflow//Java//Java//src//test//java//resources//General-Store.apk");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		formPage =  new FormPage(driver);
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}

}
