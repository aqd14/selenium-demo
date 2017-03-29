/**
 * 
 */
package org.msu.testng.main;

import java.util.concurrent.TimeUnit;

import org.main.java.common.CommonDefine;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * @author doquocanh-macbook
 *
 */
public class BaseTest {
	protected WebDriver driver;
	protected String webDriverPath;
	protected final String MSU_URL = "http://www.msstate.edu/";
	/**
	 * 
	 */
	public BaseTest() {
		webDriverPath = CommonDefine.MACOS_WEB_DRIVER_PATH;
	}
	
	@BeforeClass
	public void setupBefore() {
		initializeWebDriver();
	}
	
	@AfterClass
	public void setupAfter() {
		if (driver != null) {
			driver.close();
		}
	}
	
	protected void initializeWebDriver() {
		webDriverPath = getWebDriverPath();
		System.setProperty("webdriver.chrome.driver", webDriverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(MSU_URL);
	}
	
	/**
	 * Initialize webdriver path based on current OS
	 */
	public String getWebDriverPath() {
		// Based on machine OS, select corresponding webdriver
		String os = System.getProperty("os.name").toLowerCase();
		String path;
		System.out.println(os);
		if (os.contains("win")) {
			path = CommonDefine.WINDOWS_WEB_DRIVER_PATH;
		} else if (os.contains("mac")) {
			path = CommonDefine.MACOS_WEB_DRIVER_PATH;
		} else if (os.contains("nux")) {
			path = CommonDefine.LINUX_WEB_DRIVER_PATH;
		} else {
			throw new InvalidArgumentException("Not supported OS: " + os);
		}
		return path;
	}
}
