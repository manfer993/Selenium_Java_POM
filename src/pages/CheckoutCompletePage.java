package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.Base;
import utility.Locators;

public class CheckoutCompletePage extends Base{
	
	By titlePageLocator = By.className(Locators.pagetitle_div_class);
	By responseTextLocator = By.className(Locators.shoppingresponse_text_class);

	public CheckoutCompletePage(WebDriver driver) {
		super(driver);
	}
	
	public String getPageName() {
		return getText(titlePageLocator);
	}
	
	public String getShoppingResponse() {
		return getText(responseTextLocator);
	}

}
