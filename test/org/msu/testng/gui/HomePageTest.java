package org.msu.testng.gui;

import org.main.java.util.AssertionUtil;
import org.msu.testng.main.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
public class HomePageTest extends BaseTest {
	
	/**
	 * Test if title of home page will be display correctly
	 */
	@Test
	public void testTitle() {
		String expectedTitle = "Mississippi State University | Home";
		String actualTitle = AssertionUtil.getAttributeByXpath(driver, By.xpath("//*[@id=\"wrapper\"]/header/div[1]/div/div/div/div[1]/a"), "title");
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	/**
	 * Test if logo icon of MSU is displayed correctly in [Home] page
	 */
	@Test
	public void testIcon() {
		String expectedMsuIcon = "http://cdn01.its.msstate.edu/i/logos/msstate/msstate_horizontal_maroon.svg";
		String actualMsuIcon = AssertionUtil.getAttributeByXpath(driver, By.xpath("//*[@id=\"wrapper\"]/header/div[1]/div/div/div/div[1]/a/img"), "src");
		Assert.assertEquals(actualMsuIcon, expectedMsuIcon);
	}
}
