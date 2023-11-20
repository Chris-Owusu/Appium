package AppiumBasic;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class LongPress extends BaseTest {
	
	@Test
	public void Views() throws MalformedURLException {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		
		//LongPress
		WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text=\"People Names\"]"));
		LongPress(element);
		WebElement sampleMenu = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Sample menu\"]"));
		System.out.println(sampleMenu.isDisplayed() == true);
		
	}

}
