package pages;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.BasePage;
import utils.Locators;

public class CartPage extends BasePage{
	
	By titlePageLocator = By.className(Locators.pagetitle_div_class);
	By checkOutButtonLocator = By.xpath(Locators.checkout_button_xpath);
	By productNameLocator = By.className(Locators.productname_div_class);
	By productRemoveButtonLocator = By.className(Locators.removeproduct_button_class);
	
	By productDivLocator = By.className("cart_item");

	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	public String getPageName() {
		return getText(titlePageLocator);
	}
	
	public void clickCheckOut() {
		click(checkOutButtonLocator);
	}
	
	public Boolean checkProductLabels(List<String> labels) {
		List<String> elements = getTexts(productNameLocator);
	    Collections.sort(elements);
	    Collections.sort(labels);
	    return elements.equals(labels);		
	}
	
	public void removeProduct(String product) {
		List<WebElement> elements = findElements(productDivLocator);
		for (int i = 0; i < elements.size(); i++) {
			if(getText(elements.get(i), productNameLocator).equals(product)){
				click(elements.get(i), productRemoveButtonLocator);
				break;
			}
		}
	}
	

}
