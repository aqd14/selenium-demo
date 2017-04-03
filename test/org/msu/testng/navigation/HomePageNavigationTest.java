package org.msu.testng.navigation;

import org.main.java.util.AssertionUtil;
import org.msu.testng.main.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HomePageNavigationTest extends BaseTest {

	@Test
	public void navigateToStudentPage() throws InterruptedException {
		WebElement e = driver.findElement(By.id("item_future-students"));
		e.click();
		// Wait some time for the element to be clickable
		Thread.sleep(1000);
		e.click();
		Thread.sleep(2000);
		AssertionUtil.assertFutureStudentPage(driver);
	}
	
	@Test (priority = 2, dependsOnMethods = {"navigateToStudentPage"})
	public void navigateToInternationalStudentPage() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"block-views-editable-blocks-future-index\"]/div/div[2]/div[1]/a")).click();
		Thread.sleep(2000);
		AssertionUtil.assertInternationalStudentPage(driver);
	}
	
	@Test(priority = 3, dependsOnMethods = {"navigateToInternationalStudentPage"})
	public void navigateBackToHomePage() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"intlheader\"]/div[1]/a/div[1]/img")).click();
		Thread.sleep(2000);
		AssertionUtil.assertHomePage(driver);
	}
}
