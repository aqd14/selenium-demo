package org.msu.testng.navigation;

import org.junit.Assert;
import org.main.java.util.AssertionUtil;
import org.msu.testng.main.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class HomePageNavigationTest extends BaseTest {

	@Test
	public void navigateToStudentPage() {
		WebElement e = driver.findElement(By.id("item_future-students"));
		e.click();
		// Check href display
		boolean isHrefDisplayed = AssertionUtil.isElementPresent(driver,
		        By.xpath("//*[@id=\"block-views-editable-blocks-future-index\"]/div/div[1]/div[1]/a"));
		Assert.assertTrue(isHrefDisplayed);
		// Check freshman image source
		String freshmanImgSrc = AssertionUtil.getAttributeByXpath(driver, By.xpath("//*[@id=\"block-views-editable-blocks-future-index\"]/div/div[1]/div[1]/a/div[1]"), "style");
		String expectedFreshmanImgSrc = "www.msstate.edu/sites/www.msstate.edu/files/future-freshmen.jpg";
		Assert.assertTrue(freshmanImgSrc.contains(expectedFreshmanImgSrc));
	}
	
	public void navigateBackToHomePage() {
		AssertionUtil.waitUntilElementPresent(driver, 5, By.id("feature"));
	}
}
