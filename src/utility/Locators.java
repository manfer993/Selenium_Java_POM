package utility;

public class Locators {
	// LogInPage
	public static String username_textbox_id = "user-name";
	public static String password_textbox_id = "password";
	public static String login_button_id = "login-button";
	public static String errormessage_h3_xpath = "//h3[@data-test='error']";
	
	// HomePage
	public static String menuclose_button_xpath = "//button[text()='Close Menu']";
	public static String menuopen_button_xpath = "//button[text()='Open Menu']";
	public static String logout_button_id = "logout_sidebar_link";
	public static String productitem_div_class = "inventory_item";
	public static String productname_div_class = "inventory_item_name";
	public static String addproduct_button_class = "btn_primary";
	public static String removeproduct_button_class = "btn_secondary";
	public static String shopping_button_id = "shopping_cart_container";
	
	// CartPage
	public static String pagetitle_div_class = "subheader";
	public static String checkout_button_xpath = "//a[@href='./checkout-step-one.html']";
	
	// CheckoutStepOnePage	
	public static String firstname_textbox_id = "first-name";
	public static String lastname_textbox_id = "last-name";
	public static String postalcode_textbox_id = "postal-code";
	public static String continue_Button_xpath = "//*[@value='CONTINUE']";
	
	// CheckoutStepTwoPage
	public static String finish_button_xpath = "//a[@href='./checkout-complete.html']";
	
	// CheckoutCompletePage
	public static String shoppingresponse_text_class = "complete-header";

}
