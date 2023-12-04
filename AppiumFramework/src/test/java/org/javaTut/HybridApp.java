package org.javaTut;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.javaTut.AppiumFramework.pageObjects.android.CartPage;
import org.javaTut.AppiumFramework.pageObjects.android.ProjectCatalog;
import org.javaTut.AppiumFramework.pageObjects.android.Webview;

public class HybridApp extends BaseTests {

	@Test(dataProvider = "getData")
	public void checkBox(String name, String gender, String country) throws InterruptedException {
		
		formPage.setNameField(name);
		formPage.gender(gender);
		formPage.chooseCountry(country);
		ProjectCatalog projectCatalog = (ProjectCatalog) formPage.shopButton();
		Thread.sleep(5000);
		projectCatalog.chooseKicks();
		CartPage cartPage = (CartPage) projectCatalog.addToCartPage();
		
		Thread.sleep(3000);
		WebElement title = driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title"));
		System.out.println("The title text is: " + title.getAttribute("text"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.attributeContains(title, "text", "Cart"));
		
		cartPage.makeCalculations();
		cartPage.clickTermsBtn();
		cartPage.clickTermsCancelBtn();
		 
		cartPage.discountEmailBtn();
		Webview webview = cartPage.website();
		Thread.sleep(10000);
		
		// this line of code gets all the different views in the application: Web and Mobile -> driver.getContextHandles();
		Set<String> context =  driver.getContextHandles();
		for (String contextName: context) {
			System.out.println(contextName);
		}
		Thread.sleep(3000);
		webview.webview();
	}
	
//	@BeforeMethod
//	public void preSetup() {
//		formPage.setActivity();
//	}
	
	@DataProvider(name = "getData")
	public Object[][] getData() {
		return new Object[][] {{"Marc", "male", "Aruba"}, {"Sarah", "female", "Brazil"}, {"Joel", "male", "Ghana"}};
	}
}
