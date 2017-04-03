package org.msu.testng.performance;

import org.msu.testng.main.BaseTest;
import org.testng.annotations.Test;

public class HomePageLoadingTest extends BaseTest {
	
	/**
	 * Check the GUI display of MSSTATE home page for 5 times with 3 threads running
	 * @throws InterruptedException
	 */
	@Test(invocationCount = 10, threadPoolSize = 3)
	public void loadTestHomePage() throws InterruptedException {
		System.out.printf("%n[START] Thread Id : %s is started!",
                Thread.currentThread().getId());
		driver.get(MSU_URL);
		Thread.sleep(2000);
		System.out.printf("%n[END] Thread Id : %s is ended!",
                Thread.currentThread().getId());
	}
}
