package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.BasePage;
import utils.Locators;

public class LogInPage extends BasePage {
	By userNameLocator = By.id(Locators.username_textbox_id);
	By passwordLocator = By.id(Locators.password_textbox_id);
	By loginButtonLocator = By.id(Locators.login_button_id);
	By errorMessageLocator = By.xpath(Locators.errormessage_h3_xpath);
	By menuOpenLocator = By.xpath(Locators.menuopen_button_xpath);

	public LogInPage(WebDriver driver) {
		super(driver);
	}

	public void loginUser(String userName, String password) {
		sendText(userName, userNameLocator);
		sendText(password, passwordLocator);
		click(loginButtonLocator);
	}
	
	public String errorMessage() {
		return getText(errorMessageLocator);
	}
	
	public boolean isLogInPageEnabled() {
		return isEnabled(loginButtonLocator);
	}
}
