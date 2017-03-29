/**
 * 
 */
package org.main.java.util;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author doquocanh-macbook
 *
 */
public class AssertionUtil {

	/**
	 * 
	 */
	public AssertionUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public static String getAttributeByXpath(WebDriver driver, By by, String attribute) {
		WebElement element = driver.findElement(by);
		return element.getAttribute(attribute);
	}
	
	/**
	 * Set the timeout for WebDriver. If after timeout, the element doesn't display, return False. Otherwise, return True
	 * @param driver 	Current WebDriver instance
	 * @param timeout	Timeout for element display
	 * @param elementId	Id of expected element
	 * @return
	 */
	public static boolean waitUntilElementPresent(WebDriver driver, int timeout, By by) {
		return false;
	}
	
	public static boolean isElementPresent(WebDriver driver, By by) {
		WebDriverWait wait = new WebDriverWait(driver, 2); // Wait 2 seconds for presence of element
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}
}
