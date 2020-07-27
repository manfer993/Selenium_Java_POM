package utility;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	private WebDriver driver;

	public Base(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebDriver chromeDriverConnection() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("incognito");
		options.addArguments("--disable-gpu");
		options.addArguments("--verbose");
		driver = new ChromeDriver(options);		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		return driver;
	}

	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}

	public List<WebElement> findElements(By locator) {
		return driver.findElements(locator);
	}

	public String getText(WebElement element) {
		return element.getText();
	}

	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}
	
	public List<String> getTexts(By locator) {
		List<WebElement> elements = findElements(locator);
		List<String> texts = new ArrayList<String>();
		for (int i = 0; i < elements.size(); i++) {
			texts.add(elements.get(i).getText());
		}
		return texts;
	}
	
	public String getText(WebElement webElement, By locator) {
		return webElement.findElement(locator).getText();
	}

	public void sendText(String inputText, By locator) {
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(inputText);
	}
	
	public void refreshPage() {
		driver.navigate().refresh();
	}

	public void click(By locator) {
		driver.findElement(locator).click();
	}
	
	public void click(WebElement webElement, By locator) {
		 webElement.findElement(locator).click();
	}
	
	public void getUrl(String url) {
		driver.get(url);
	}

	public void navigateTo(String url) {
		driver.navigate().to(url);
	}
	
	public void navigateBack() {
		driver.navigate().back();
	}
	
	public void closeWindow() {
		driver.quit();
	}
	
	public Boolean isEnabled(By locator) {
		try {
			return driver.findElement(locator).isEnabled();
		}catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
}
