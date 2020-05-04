package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class WelcomePageObject extends BasePageObject{
	
	private String pageUrl = "https://the-internet.herokuapp.com/";
	
	private By formAuthenticationLinkLocator = By.linkText("Form Authentication");

	public WelcomePageObject(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	/**Open WelcomePage with it's url */
	public void openPage(){
		log.info("Opening page: " + pageUrl);
		openUrl(pageUrl);
		log.info("Page opened!");
	}
	
	/**Click on Form Authentication link */
	public LoginPage clickFormAuthenticationLink() {
		log.info("clicking Form Authentication Form on Welcome Page");
		click(formAuthenticationLinkLocator);
		return new LoginPage(driver, log);
	}
}
