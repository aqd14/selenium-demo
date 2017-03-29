package org.msu.testng.navigation;

import org.main.java.util.AssertionUtil;
import org.msu.testng.main.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageNavigationTest extends BaseTest {

	@Test
	public void navigateToStudentPage() throws InterruptedException {
		String expectedHrefFreshman = "http://www.admissions.msstate.edu/freshmen/about-msu/";
		String expectedFreshmanImgSrc = "www.msstate.edu/sites/www.msstate.edu/files/future-freshmen.jpg";
		
		WebElement e = driver.findElement(By.id("item_future-students"));
		e.click();
		// Wait some time for the element to be clickable
		Thread.sleep(1000);
		e.click();
		
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
	
	@Test (priority = 2, dependsOnMethods = {"navigateToStudentPage"})
	public void navigateToInternationalStudentPage() {
		driver.findElement(By.id("//*[@id=\"block-views-editable-blocks-future-index\"]/div/div[2]/div[1]/a")).click();
		AssertionUtil.assertInternationalStudentPage(driver);
	}
	
	@Test(priority = 3, dependsOnMethods = {"navigateToInternationalStudentPage"})
	public void navigateBackToHomePage() {
		driver.findElement(By.xpath("//*[@id=\"intlheader\"]/div[1]/a/div[1]/img")).click();
		boolean isHomePageDisplayed = AssertionUtil.waitUntilElementPresent(driver, 5, By.id("feature"));
		Assert.assertTrue(isHomePageDisplayed);
	}
}
