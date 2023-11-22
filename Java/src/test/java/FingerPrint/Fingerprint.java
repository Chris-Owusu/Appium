package FingerPrint;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import AppiumBasic.BaseTest;

public class Fingerprint extends BaseTest {

	@Test
	public void fPrint() {
		
		WebElement deny = driver.findElement(By.id("com.android.permissioncontroller:id/permission_deny_button"));
		if (deny.isDisplayed() == true) {
			deny.click();
		}
		driver.findElement(By.id("com.android.permissioncontroller:id/grant_singleton")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"ENTER HERE\"]")).click();
	}

}
