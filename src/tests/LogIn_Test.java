package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LogInPage;
import utils.BasePage;
import utils.Messages;


public class LogIn_Test {
	private WebDriver driver;
	private BasePage base;
	private LogInPage logIn;
	private HomePage home;
	private String url = null;
	private String standard_user = null;
	private String locked_out_user = null;
	private String problem_user = null;
	private String performance_glitch_user = null;
	private String password = null;
	
	
	@BeforeTest
	@Parameters({"url","standard_user","locked_out_user","problem_user","performance_glitch_user","password"})
	public void setUp(
			String url, 
			String standard_user, 
			String locked_out_user, 
			String problem_user, 
			String performance_glitch_user, 
			String password) {
		this.url = url;
		this.standard_user = standard_user;
		this.locked_out_user = locked_out_user;
		this.problem_user = problem_user;
		this.performance_glitch_user = performance_glitch_user;
		this.password = password;
		base = new BasePage(driver);
		driver = base.chromeDriverConnection();
		base.setDriver(driver);
		logIn = new LogInPage(base.getDriver());
		home = new HomePage(base.getDriver());
		base.getUrl(this.url);
	}
	@AfterTest
	public void tearDown() {
		logIn.closeWindow();
	}
	
	@Test(description = "Standar User", enabled = true)
	public void login_standard_user_test() {
		Assert.assertTrue(logIn.isLogInPageEnabled());
		logIn.loginUser(standard_user, password);
		
		Assert.assertTrue(home.isHomePageEnabled());
		home.logoutUser();
		Assert.assertTrue(logIn.isLogInPageEnabled());
	}
	
	@Test(description = "Locked out User", enabled = true)
	public void login_locked_out_user_test() {
		Assert.assertTrue(logIn.isLogInPageEnabled());
		logIn.loginUser(locked_out_user, password);
		Assert.assertEquals(logIn.errorMessage(), Messages.errorMessage_locked_out_user);
	}

	@Test(description = "Problem User", enabled = true)
	public void login_problem_user_test() {
		Assert.assertTrue(logIn.isLogInPageEnabled());
		logIn.loginUser(problem_user, password);
		
		Assert.assertTrue(home.isHomePageEnabled());
		home.logoutUser();
		Assert.assertTrue(logIn.isLogInPageEnabled());
	}
	
	@Test(description = "performance User", enabled = true)
	public void login_performance_glitch_user_test() {
		Assert.assertTrue(logIn.isLogInPageEnabled());
		logIn.loginUser(performance_glitch_user, password);
		
		Assert.assertTrue(home.isHomePageEnabled());
		home.logoutUser();
		Assert.assertTrue(logIn.isLogInPageEnabled());
	}
}
