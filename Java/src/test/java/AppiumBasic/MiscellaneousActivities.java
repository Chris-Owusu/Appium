package AppiumBasic;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MiscellaneousActivities extends BaseTest {
	
	@Test
	public void MiscellaneousActivity() throws MalformedURLException {
		// Jump to a particular page
//	    Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.Preferences");
//	    driver.startActivity(activity);

	    // Actual Automation
	    driver.findElement(AppiumBy.accessibilityId("Preference")).click();
	    driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
	    driver.findElement(By.id("android:id/checkbox")).click();

	    // Rotate your phone to landscape mode
	    DeviceRotation landscape = new DeviceRotation(0, 0, 90);
	    driver.rotate(landscape);

	    driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();

	    // Store and retrieve text from clipboard
	    driver.setClipboardText("Mac");
	    driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());

	    String settingName = driver.findElement(By.id("android:id/alertTitle")).getText();

	    Assert.assertEquals(settingName, "WiFi settings");
	    driver.pressKey(new KeyEvent(AndroidKey.SHIFT_LEFT));
	    driver.findElement(By.id("android:id/button1")).click();
	    driver.pressKey(new KeyEvent(AndroidKey.BACK));
	    driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}


}
