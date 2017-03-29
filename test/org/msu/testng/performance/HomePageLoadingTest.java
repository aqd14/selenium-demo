package org.msu.testng.performance;

import org.main.java.util.AssertionUtil;
import org.msu.testng.main.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageLoadingTest extends BaseTest {
	
	/**
	 * Check the GUI display of MSSTATE home page for 5 times with 3 threads running
	 * @throws InterruptedException
	 */
	@Test(invocationCount = 5, threadPoolSize = 3)
	public void loadTestHomePage() throws InterruptedException {
		String expectedTitle = "Mississippi State University";
		
		System.out.printf("%n[START] Thread Id : %s is started!",
                Thread.currentThread().getId());
		driver.get(MSU_URL);
		Thread.sleep(2000);
		boolean isHomePagePresent = AssertionUtil.waitUntilElementPresent(driver, 2, By.id("feature"));
		Assert.assertTrue(isHomePagePresent);
		Assert.assertEquals(driver.getTitle(), expectedTitle);
		System.out.printf("%n[END] Thread Id : %s is ended!",
                Thread.currentThread().getId());
	}
}
