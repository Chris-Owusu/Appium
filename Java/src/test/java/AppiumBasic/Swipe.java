package AppiumBasic;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Swipe extends BaseTest {
	
	@Test
	public void SwipeDemoTests() throws MalformedURLException {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
		WebElement firstImg = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
		Assert.assertEquals(firstImg.getAttribute("focusable"), "true");
		
		//Swipe
		Swipe(firstImg, "left");
		Assert.assertEquals(firstImg.getAttribute("focusable"), "false");
	}

}
