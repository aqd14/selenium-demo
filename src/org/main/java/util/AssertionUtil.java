/**
 * 
 */
package org.main.java.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


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
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}
	
	/**
	 * Check if an element is present or not. Default timeout for checking is 2 seconds
	 * @param driver
	 * @param by
	 * @return
	 */
	public static boolean isElementPresent(WebDriver driver, By by) {
		WebDriverWait wait = new WebDriverWait(driver, 2); // Wait 2 seconds for presence of element
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}
	
	public static void assertFutureStudentPage(WebDriver driver) {
		String expectedHrefFreshman = "http://www.admissions.msstate.edu/freshmen/about-msu/";
		String expectedFreshmanImgSrc = "www.msstate.edu/sites/www.msstate.edu/files/future-freshmen.jpg";
		
		// Home page is no longer display
		boolean isHomePageDisplayed = AssertionUtil.isElementPresent(driver, By.id("feature"));
		Assert.assertFalse(isHomePageDisplayed);

		// Check correct href attribute to freshmen page
		String actualHrefFreshman = AssertionUtil.getAttributeByXpath(driver,
				By.xpath("//*[@id=\"block-views-editable-blocks-future-index\"]/div/div[1]/div[1]/a"), "href");
		Assert.assertTrue(actualHrefFreshman.contains(expectedHrefFreshman));

		// Check freshman image source
		String freshmanImgSrc = AssertionUtil.getAttributeByXpath(driver,
				By.xpath("//*[@id=\"block-views-editable-blocks-future-index\"]/div/div[1]/div[1]/a/div[1]"), "style");
		Assert.assertTrue(freshmanImgSrc.contains(expectedFreshmanImgSrc));
	}
	
	/**
	 * Assert GUIs and contents of [International Student] page
	 * @param driver
	 */
	public static void assertInternationalStudentPage(WebDriver driver) {
		List<String> expectedSections = Arrays.asList("Immigration Information", "English Language Institute",
		        "Shackouls Honors College", "MSU", "Starkville", "New Student Services");
		List<String> expectedLinks = Arrays.asList("http://international.msstate.edu/future/pre/index.php",
		        "http://international.msstate.edu/esl/index.php", "http://www.honors.msstate.edu/about/index.php",
		        "http://international.msstate.edu/future/msu/index.php",
		        "http://international.msstate.edu/future/starkville/index.php",
		        "http://international.msstate.edu/future/newstudentservices/index.php");
		
		// Check image source
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"therest\"]/div/div[1]/img")).getAttribute("src").contains("Students.jpg"));
		// Check text
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"thetitle\"]/h1")).getText(), "Prospective Students");
		// Check side sections
		List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"sideNav\"]/ul/li/a"));
		
		List<String> actualSections = new ArrayList<String>();
		List<String> actualLinks = new ArrayList<String>();
		for (WebElement e : elements) {
			actualSections.add(e.getText());
			actualLinks.add(e.getAttribute("href"));
		}
		Assert.assertEquals(actualSections, expectedSections);
		Assert.assertEquals(actualLinks, expectedLinks);
	}
}
