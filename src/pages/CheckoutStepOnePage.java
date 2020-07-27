package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.Base;
import utility.Locators;

public class CheckoutStepOnePage extends Base{
	
	By titlePageLocator = By.className(Locators.pagetitle_div_class);
	By firstNameLocator = By.id(Locators.firstname_textbox_id);
	By lastNameLocator = By.id(Locators.lastname_textbox_id);
	By postalCodeLocator = By.id(Locators.postalcode_textbox_id);
	By continueButtonLocator = By.xpath(Locators.continue_Button_xpath);
	By errorMessageLocator = By.xpath(Locators.errormessage_h3_xpath);

	public CheckoutStepOnePage(WebDriver driver) {
		super(driver);
	}
	
	public void setPersonalInfo(String fistName, String lastName, String postalCode) {
		sendText(fistName, firstNameLocator);
		sendText(lastName, lastNameLocator);
		sendText(postalCode, postalCodeLocator);
		click(continueButtonLocator);
	}
	
	public void setMissingFirstName(String lastName, String postalCode) {
		refreshPage();
		sendText(lastName, lastNameLocator);
		sendText(postalCode, postalCodeLocator);
		click(continueButtonLocator);
	}
	
	public void setMissingLastName(String fistName, String postalCode) {
		refreshPage();
		sendText(fistName, firstNameLocator);
		sendText(postalCode, postalCodeLocator);
		click(continueButtonLocator);
	}
	
	public void setMissingPostalCode(String fistName,String lastName) {
		refreshPage();
		sendText(fistName, firstNameLocator);
		sendText(lastName, lastNameLocator);
		click(continueButtonLocator);
	}
	
	public String getPageName() {
		return getText(titlePageLocator);
	}
	
	public String errorMessage() {
		return getText(errorMessageLocator);
	}
}
