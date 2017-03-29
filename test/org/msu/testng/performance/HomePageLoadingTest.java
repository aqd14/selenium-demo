package org.msu.testng.performance;

import org.main.java.util.AssertionUtil;
import org.msu.testng.main.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageLoadingTest extends BaseTest {

	@Test(invocationCount = 5, threadPoolSize = 3)
	public void loadTestHomePage() throws InterruptedException {
		boolean isHomePagePresent = AssertionUtil.waitUntilElementPresent(driver, 2, By.id("feature"));
		Assert.assertTrue(isHomePagePresent);
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
	}
}
