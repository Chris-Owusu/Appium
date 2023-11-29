package org.javaTut;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.javaTut.AppiumFramework.pageObjects.android.FormPage;
import org.javaTut.AppiumFramework.pageObjects.android.ProjectCatalog;

public class HybridApp extends BaseTests {

	@Test
	public void checkBox() throws InterruptedException {
		
		FormPage formPage = new FormPage(driver);
		formPage.setNameField("Marc");
		formPage.gender("male");
		formPage.chooseCountry("Aruba");
		ProjectCatalog projectCatalog = (ProjectCatalog) formPage.shopButton();
		Thread.sleep(5000);
		projectCatalog.chooseKicks();
		projectCatalog.addToCartPage();
		
		Thread.sleep(3000);
		WebElement title = driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title"));
		System.out.println("The title text is: " + title.getAttribute("text"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.attributeContains(title, "text", "Cart"));
		
		projectCatalog.makeCalculations();
		projectCatalog.clickTermsBtn();
		projectCatalog.clickTermsCancelBtn();
		 
		projectCatalog.discountEmailBtn();
		projectCatalog.website();
		Thread.sleep(10000);
		
		// this line of code gets all the different views in the application: Web and Mobile -> driver.getContextHandles();
		Set<String> context =  driver.getContextHandles();
		for (String contextName: context) {
			System.out.println(contextName);
		}
		Thread.sleep(3000);
		projectCatalog.webview();
	}
}
