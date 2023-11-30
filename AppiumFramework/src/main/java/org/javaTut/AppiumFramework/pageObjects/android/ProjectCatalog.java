package org.javaTut.AppiumFramework.pageObjects.android;

import java.time.Duration;
import java.util.List;

import org.javaTut.AppiumFramework.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProjectCatalog extends AndroidActions {

AndroidDriver driver;
	
	// Define a constructor
	public ProjectCatalog(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	// Choose Kicks
	@AndroidFindBy(xpath="(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[1]")
	private WebElement airJordanRetro;
	@AndroidFindBy(xpath="(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[2]")
	private WebElement jordanLiftOff;
	@AndroidFindBy(xpath="(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[3]")
	private WebElement nikeSFBJungle;
	
	public void chooseKicks() {
		airJordanRetro.click();
		scrollToElement("Jordan Lift Off");
		jordanLiftOff.click();
		scrollToElement("Nike SFB Jungle");
		nikeSFBJungle.click();
	}
	
	// Add to cart button
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement addToCart;
	
	public CartPage addToCartPage() {
		addToCart.click();
		return new CartPage(driver);
	}
	
	
}
