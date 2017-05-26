package stepDefinition;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencsv.CSVReader;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import resources.Constants;
import resources.Locators;

public class AbstractPage {
	protected static WebDriver driver;
	Constants cst;
	Locators loc;

	public void openPage(String url, String browser) {
		try {
			if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", cst.FF_PATH);
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", cst.CH_PATH);
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver", cst.IE_PATH);
				driver = new InternetExplorerDriver();
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.getMessage();
		}
		driver.get(url);
		driver.manage().window().maximize();
	}

	public WebElement getElement(String name) {
		waitForElement(1000);
		try {
			WebElement element = driver.findElement(getObject(name));
			waitForElement(500);
			return element;
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	public By getObject(String locator) {
		By by = null;
		try {
			if (locator.startsWith("id=")) {
				locator = locator.substring(3);
				by = By.id(locator);
			} else if (locator.startsWith("link=")) {

				locator = locator.substring(5);
				by = By.linkText(locator);

			} else if (locator.startsWith("xpath=")) {
				locator = locator.substring(6);
				by = By.xpath(locator);
			} else if (locator.startsWith("css=")) {
				locator = locator.substring(4);
				by = By.cssSelector(locator);
			}
			return by;
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	public void waitForElement(long timeInMillis) {
		try {
			Thread.sleep(timeInMillis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void waitForPageLoad() {
		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				return String.valueOf(
						((JavascriptExecutor) driver)
								.executeScript("return document.readyState"))
						.equals("complete");
			}
		});
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean stringToBool(String value) {
		value = value.toLowerCase();
		Set<String> trueSet = new HashSet<String>(Arrays.asList("1", "true",
				"yes"));
		Set<String> falseSet = new HashSet<String>(Arrays.asList("0", "false",
				"no"));

		if (trueSet.contains(value))
			return true;
		if (falseSet.contains(value))
			return false;

		throw new IllegalArgumentException(value + " is not a boolean.");
	}

}
