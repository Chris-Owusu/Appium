package AppiumBasic;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ScrollEffect extends BaseTest {
	
	@Test
	public void ScrollDemoTests() throws MalformedURLException {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		// If you know where to scroll --> Using google engine
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		
		//Scroll to the end of the page
		ScrollToEnd();
	}

}
