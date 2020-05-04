package com.herokuapp.theinternet.base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private String browserName;
	private Logger log;
	private String projectPath = System.getProperty("user.dir");
	

	public BrowserFactory(String browserName, Logger log) {
		this.browserName = browserName.toLowerCase();
		this.log = log;
		
	}

	public WebDriver createDriver() {
		log.info("Browser name is: " + browserName);
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver\\chromedriver.exe");
			driver.set(new ChromeDriver());
			
		} else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\drivers\\geckodriver\\geckodriver.exe");
			driver.set(new FirefoxDriver());
			
		} else if(browserName.contentEquals("ie")) {
			System.setProperty("webdriver.ie.driver", projectPath + "\\drivers\\iedriver\\IEDriverServer.exe");
			driver.set(new InternetExplorerDriver());
			
		}else {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\driver\\chromedriver\\chromedriver.exe");
			driver.set(new ChromeDriver());
		}
		
		return driver.get();
		
	}
}
