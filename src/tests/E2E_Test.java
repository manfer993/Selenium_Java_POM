package tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pages.CartPage;
import pages.CheckoutCompletePage;
import pages.CheckoutStepOnePage;
import pages.CheckoutStepTwoPage;
import pages.HomePage;
import pages.LogInPage;
import utils.BasePage;
import utils.Messages;

public class E2E_Test {
	private WebDriver driver;
	private BasePage base;
	private LogInPage logIn;
	private HomePage home;
	private CartPage cart;
	private CheckoutStepOnePage checkoutStepOne;
	private CheckoutStepTwoPage checkoutStepTwo;
	private CheckoutCompletePage checkoutComplete;
	private String url = null;
	private String user_name = null;
	private String password = null;
	private String first_product = null;
	private String second_product = null;
	private String fist_name = null;
	private String last_name = null;
	private String postal_code = null;
	
	
	@BeforeTest
	@Parameters({"url","user_name","password","first_product","second_product","fist_name","last_name","postal_code"})
	public void setUp(
			String url, 
			String user_name,
			String password,
			String first_product,
			String second_product,
			String fist_name,
			String last_name,
			String postal_code) {
		
		this.url = url;
		this.user_name = user_name;
		this.password = password;
		this.first_product = first_product;
		this.second_product = second_product;
		this.fist_name = fist_name;
		this.last_name = last_name;
		this.postal_code = postal_code;
		
		base = new BasePage(driver);
		driver = base.chromeDriverConnection();
		base.setDriver(driver);
		
		logIn = new LogInPage(base.getDriver());
		home = new HomePage(base.getDriver());
		cart = new CartPage(base.getDriver());
		checkoutStepOne = new CheckoutStepOnePage(base.getDriver());
		checkoutStepTwo = new CheckoutStepTwoPage(base.getDriver());
		checkoutComplete = new CheckoutCompletePage(base.getDriver());
		
		base.getUrl(this.url);
	}
	@AfterTest
	public void tearDown() {
		logIn.closeWindow();
	}
	
	@Test(priority = 1, description = "2nd. E2E test to buy two products", enabled = true)
	public void shopping_E2E_test() {
		Assert.assertTrue(logIn.isLogInPageEnabled());
		logIn.loginUser(user_name, password);
		
		Assert.assertTrue(home.isHomePageEnabled());
		home.addProductToCart(first_product);
		home.addProductToCart(second_product);
		home.clickShopping();
		
		Assert.assertEquals(cart.getPageName(), Messages.subHeader_cart);
		cart.clickCheckOut();
		
		Assert.assertEquals(checkoutStepOne.getPageName(), Messages.subHeader_checkout_step_one);
		checkoutStepOne.setPersonalInfo(fist_name, last_name, postal_code);
		
		Assert.assertEquals(checkoutStepTwo.getPageName(), Messages.subHeader_checkout_step_two);
		checkoutStepTwo.clickFinish();
		
		Assert.assertEquals(checkoutComplete.getPageName(), Messages.subHeader_checkout_complete);
		Assert.assertEquals(checkoutComplete.getShoppingResponse(), Messages.shopping_response);
		
		home.logoutUser();
		Assert.assertTrue(logIn.isLogInPageEnabled());
	}
	
	@Test(priority = 2, description = "3rd. Verify the labels in the “Your Cart” page", enabled = true)
	public void verify_test() {	
		Assert.assertTrue(logIn.isLogInPageEnabled());
		logIn.loginUser(user_name, password);
		
		Assert.assertTrue(home.isHomePageEnabled());
		home.addProductToCart(first_product);
		home.addProductToCart(second_product);
		home.clickShopping();
		
		Assert.assertEquals(cart.getPageName(), Messages.subHeader_cart);
		
		List<String> products = new ArrayList<String>();
		products.add(first_product);
		products.add(second_product);
		Assert.assertTrue(cart.checkProductLabels(products));
		
		cart.removeProduct(first_product);
		cart.removeProduct(second_product);
				
		home.logoutUser();
		Assert.assertTrue(logIn.isLogInPageEnabled());
	}
	
	@Test(priority = 3, description = "4th. remove an item from the cart", enabled = true)
	public void remove_product_test() {
		Assert.assertTrue(logIn.isLogInPageEnabled());
		logIn.loginUser(user_name, password);
		
		Assert.assertTrue(home.isHomePageEnabled());
		home.addProductToCart(first_product);
		home.addProductToCart(second_product);
		home.clickShopping();
		
		Assert.assertEquals(cart.getPageName(), Messages.subHeader_cart);
		cart.removeProduct(first_product);
		cart.removeProduct(second_product);
				
		home.logoutUser();
		Assert.assertTrue(logIn.isLogInPageEnabled());
	}
	
	@Test(priority = 4, description = "5th. Validations for the Checkout your information fields", enabled = true)
	public void validation_empty_file_test() {
		Assert.assertTrue(logIn.isLogInPageEnabled());
		logIn.loginUser(user_name, password);
		
		Assert.assertTrue(home.isHomePageEnabled());
		home.addProductToCart(first_product);
		home.addProductToCart(second_product);
		home.clickShopping();
		
		Assert.assertEquals(cart.getPageName(), Messages.subHeader_cart);
		cart.clickCheckOut();
		
		Assert.assertEquals(checkoutStepOne.getPageName(), Messages.subHeader_checkout_step_one);
		
		checkoutStepOne.setMissingFirstName(last_name, postal_code);
		Assert.assertEquals(checkoutStepOne.errorMessage(), Messages.errormessage_first_name_missing);
		
		checkoutStepOne.setMissingLastName(fist_name, postal_code);
		Assert.assertEquals(checkoutStepOne.errorMessage(), Messages.errormessage_last_name_missing);
		
		checkoutStepOne.setMissingPostalCode(fist_name, last_name);
		Assert.assertEquals(checkoutStepOne.errorMessage(), Messages.errormessage_postal_code_missing);		
		
		home.logoutUser();
		Assert.assertTrue(logIn.isLogInPageEnabled());
	}
}
