package IOS;

public class IOSBasis {
	
	public void IOSBasisTest() {

		// Various selectors -> classname, id, accessibility id, IOSClassChain, IOSpredicate
		
		// Scroll effect --> "mobile:scroll"
		// LongPress --> "mobile:touchAndHold"
		// For dropdowns --> we use sendkeys
		// Slider --> use sendKeys. and it's between 0% - 1%
		// loadApp/install app --> "mobile:launchApp", the bundle ID is "com.apple.mobileslideshow", "mobile:swipe"
		// Swipe --> "mobile:swipe"
		
		// Go back --> driver.navigate().back();
	}

}
