package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.BasePage;
import utils.Locators;

public class HomePage extends BasePage {
	By menuOpenLocator = By.xpath(Locators.menuopen_button_xpath);
	By logoutButtonLocator = By.id(Locators.logout_button_id);
	By loginButtonLocator = By.id(Locators.login_button_id);
	By productDivLocator = By.className(Locators.productitem_div_class);
	By productNameLocator = By.className(Locators.productname_div_class);
	By productAddButtonLocator = By.className(Locators.addproduct_button_class);
	By productRemoveButtonLocator = By.className(Locators.removeproduct_button_class);
	By shoppingButtonLocator = By.id(Locators.shopping_button_id);

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void logoutUser() {
		click(menuOpenLocator);
		click(logoutButtonLocator);
	}

	public boolean isHomePageEnabled() {
		return isEnabled(menuOpenLocator);
	}

	public void addProductToCart(String product) {
		List<WebElement> elements = findElements(productDivLocator);
		for (int i = 0; i < elements.size(); i++) {
			if(getText(elements.get(i), productNameLocator).equals(product)){
				click(elements.get(i), productAddButtonLocator);
				break;
			}
		}
	}
	
	public void removeProductToCart(String product) {
		List<WebElement> elements = findElements(productDivLocator);
		for (int i = 0; i < elements.size(); i++) {
			if(getText(elements.get(i), productNameLocator).equals(product)){
				click(elements.get(i), productRemoveButtonLocator);
				break;
			}
		}
	}
	
	public void clickShopping() {
		click(shoppingButtonLocator);
	}

}
