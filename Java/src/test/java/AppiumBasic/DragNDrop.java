package AppiumBasic;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class DragNDrop extends BaseTest {
	
	@Test
	public void DragDemoTests() throws MalformedURLException {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		WebElement dragEle = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		WebElement dragResult = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		// Drag
		Drag(dragEle, 820, 800);
		Assert.assertEquals(dragResult.isDisplayed(), true);
	}

}
