package GStore;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BrowserBaseTest {
	
	@Test
	public void browserTest() throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".navbar-toggler-icon")).click();
		driver.findElement(By.cssSelector(".nav-link[routerlink='/products']")).click();
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1000)", "");
		String devops = driver.findElement(By.xpath("//a[normalize-space()='Devops']")).getText();
		Assert.assertEquals(devops, "Devops");
		
		
	}

}
