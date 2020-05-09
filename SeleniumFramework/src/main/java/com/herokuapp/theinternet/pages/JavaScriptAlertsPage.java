package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlertsPage extends BasePageObject{
	
	private By clickForJSAlertLocator = By.xpath("//button[contains(text(),'Click for JS Alert')]");
	private By clickForJSConfirmLocator = By.xpath("//button[contains(text(),'Click for JS Confirm')]");
	private By clickForJSPromptLocator = By.xpath("//button[contains(text(),'Click for JS Prompt')]");
	private By resultTextLocator = By.id("result");
	

	public JavaScriptAlertsPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	/**click on Click for JS Alert button */
	public void clickForJSAlert() {
		log.info("clicking on Click for JS Alert button");
		click(clickForJSAlertLocator);
	}
	
	/**click on Click for JS Confirm button */
	public void clickForJSConfirm() {
		log.info("clicking on Click for JS Confirm button");
		click(clickForJSConfirmLocator);
	}
	
	/**click on Click for JS Prompt button */
	public void clickForJSPrompt() {
		log.info("clicking on Click for JS Prompt button");
		click(clickForJSPromptLocator);
	}
	
	/**switch to Alert and get its' message */
	public String getAlertText() {
		Alert alert = switchToAlert();
		String alertText = alert.getText();
		log.info("Alert text displays: " + alertText);
		return alertText;
	}
	
	/**switch to Alert and press OK */
	public void acceptAlert() {
		log.info("switching to Alert and pressing OK");
		Alert alert = switchToAlert();
		alert.accept();
	}
	
	/**switch to Alert and press Cancel */
	public void dismissAlert() {
		log.info("switching to Alert and pressing Cancel");
		Alert alert = switchToAlert();
		alert.dismiss();
	}
	
	/**Get Result message */
	public String getResultMessage() {
		String result = find(resultTextLocator).getText();
		log.info("Result message displays: " + result);
		return result;
		
	}
	
	
	
	
	
	
	

	
}
