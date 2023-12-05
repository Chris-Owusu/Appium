 package org.javaTut.AppiumFramework.pageObjects.android;

import org.javaTut.AppiumFramework.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends AndroidActions {
	AndroidDriver driver;
	
	// Define a constructor
	public FormPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
//	public void setActivity() {
//	    Activity activity = new Activity("com.androidsample.genralstore", "com.androidsample.generalstore.MainActivity");
//	    driver.startActivity(activity);
//	}

	
	
	// Type Name
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	public void setNameField(String name) {
		nameField.sendKeys(name);
		driver.hideKeyboard();
	}
	
	
	//  Choose Gender
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Male']")
	private WebElement maleOption;
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Male']")
	private WebElement femaleOption;
	
	public void gender(String gender) {
		if (gender.contains("female"))
			femaleOption.click();
		else
			maleOption.click();
	}
	
	// Choose country
	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	private WebElement country;
	
	public void chooseCountry(String countryName) {
		country.click();
		scrollToElement(countryName, driver);
//		driver.findElement(By.xpath("//android.widget.TextView[@text'"+countryName+"']")).click();
	}
	
	//Shop Button
	@AndroidFindBy(className="android.widget.Button")
	private WebElement shopBtn;
	
	public ProjectCatalog shopButton() {
		shopBtn.click();
		return new ProjectCatalog(driver);
	}

}
