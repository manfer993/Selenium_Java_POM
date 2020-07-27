package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.Base;
import utility.Locators;

public class CheckoutStepTwoPage extends Base{
	
	By titlePageLocator = By.className(Locators.pagetitle_div_class);
	By finishButtonLocator = By.xpath(Locators.finish_button_xpath);

	public CheckoutStepTwoPage(WebDriver driver) {
		super(driver);
	}
	
	public String getPageName() {
		return getText(titlePageLocator);
	}
	
	public void clickFinish() {
		click(finishButtonLocator);
	}

}
