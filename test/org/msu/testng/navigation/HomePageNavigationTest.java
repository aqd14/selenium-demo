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
		WebElement e = driver.findElement(By.id("item_future-students"));
		e.click();
		// Wait some time for the element to be clickable
		Thread.sleep(1000);
		e.click();
		AssertionUtil.assertFutureStudentPage(driver);
	}
	
	@Test (priority = 2, dependsOnMethods = {"navigateToStudentPage"})
	public void navigateToInternationalStudentPage() {
		driver.findElement(By.xpath("//*[@id=\"block-views-editable-blocks-future-index\"]/div/div[2]/div[1]/a")).click();
		AssertionUtil.assertInternationalStudentPage(driver);
	}
	
	@Test(priority = 3, dependsOnMethods = {"navigateToInternationalStudentPage"})
	public void navigateBackToHomePage() {
		driver.findElement(By.xpath("//*[@id=\"intlheader\"]/div[1]/a/div[1]/img")).click();
		boolean isHomePageDisplayed = AssertionUtil.waitUntilElementPresent(driver, 5, By.id("feature"));
		Assert.assertTrue(isHomePageDisplayed);
	}
}
