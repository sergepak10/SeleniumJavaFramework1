package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class WelcomePageObject extends BasePageObject{
	
	private String pageUrl = "https://the-internet.herokuapp.com/";
	
	private By formAuthenticationLinkLocator = By.linkText("Form Authentication");
	private By checkboxesLinkLocator = By.linkText("Checkboxes");
	private By dropdownLinkLocator = By.linkText("Dropdown");
	private By javaScriptAlertsLinkLocator = By.linkText("JavaScript Alerts");

	public WelcomePageObject(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	/**Open WelcomePage with it's url */
	public void openPage(){
		log.info("Opening page: " + pageUrl);
		openUrl(pageUrl);
		log.info("Page is opened!");
	}
	
	/**Click on Form Authentication link */
	public LoginPage clickFormAuthenticationLink() {
		log.info("clicking Form Authentication link on Welcome Page");
		click(formAuthenticationLinkLocator);
		return new LoginPage(driver, log);
	}
	
	/**Click on Checkboxes link */
	public CheckboxesPage clickCheckboxesLink() {
		log.info("clicking Checkboxes link on Welcome Page");
		click(checkboxesLinkLocator);
		return new CheckboxesPage(driver, log);
	}
	
	/**Click on Dropdown link */
	public DropdownPage clickDropdownLink() {
		log.info("clicking Dropdown link on Welcome Page");
		click(dropdownLinkLocator);
		return new DropdownPage(driver, log);
	}
	
	/** Click on javaScript Alerts locator*/
	public JavaScriptAlertsPage clickJavaScriptAlertsLink() {
		log.info("clicking javaScript Alerts link on Welcome Page");
		click(javaScriptAlertsLinkLocator);
		return new JavaScriptAlertsPage(driver,log);
		
	}
	

	
	
	
	
	
}
