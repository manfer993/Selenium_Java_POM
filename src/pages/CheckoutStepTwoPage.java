package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.BasePage;
import utils.Locators;

public class CheckoutStepTwoPage extends BasePage{
	
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
