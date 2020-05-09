package com.herokuapp.theinternet.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
	
	protected WebDriver driver;
	protected Logger log;
	
	
	@Parameters({"browserName"})
	@BeforeTest
	public void setUP(@Optional("chrome") String browserName, ITestContext ctx) {
		String testName = ctx.getCurrentXmlTest().getName();
		log = LogManager.getLogger(testName);
		
		BrowserFactory factory = new BrowserFactory(browserName, log);
			driver = factory.createDriver();
			
			driver.manage().window().maximize();
			
	}
	
	@AfterTest
	public void tearDown() {
		// close browser
		driver.close();

		System.out.println("Test is completed");

	}
}
