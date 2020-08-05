package utils;

public final class Locators {
	// LogInPage
	public static final String username_textbox_id = "user-name";
	public static final String password_textbox_id = "password";
	public static final String login_button_id = "login-button";
	public static final String errormessage_h3_xpath = "//h3[@data-test='error']";
	
	// HomePage
	public static final String menuclose_button_xpath = "//button[text()='Close Menu']";
	public static final String menuopen_button_xpath = "//button[text()='Open Menu']";
	public static final String logout_button_id = "logout_sidebar_link";
	public static final String productitem_div_class = "inventory_item";
	public static final String productname_div_class = "inventory_item_name";
	public static final String addproduct_button_class = "btn_primary";
	public static final String removeproduct_button_class = "btn_secondary";
	public static final String shopping_button_id = "shopping_cart_container";
	
	// CartPage
	public static final String pagetitle_div_class = "subheader";
	public static final String checkout_button_xpath = "//a[@href='./checkout-step-one.html']";
	
	// CheckoutStepOnePage	
	public static final String firstname_textbox_id = "first-name";
	public static final String lastname_textbox_id = "last-name";
	public static final String postalcode_textbox_id = "postal-code";
	public static final String continue_Button_xpath = "//*[@value='CONTINUE']";
	
	// CheckoutStepTwoPage
	public static final String finish_button_xpath = "//a[@href='./checkout-complete.html']";
	
	// CheckoutCompletePage
	public static final String shoppingresponse_text_class = "complete-header";

}
