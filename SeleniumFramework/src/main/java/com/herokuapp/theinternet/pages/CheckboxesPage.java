package com.herokuapp.theinternet.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxesPage extends BasePageObject{
	
	private By checkbox = By.xpath("//input[@type='checkbox']");

	public CheckboxesPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	/**Get a list of all checkboxes and select each unchecked box */
	public void selectAllCheckboxes() {
		log.info("selecting all unchecked boxes");
		List<WebElement> checkboxes = findAll(checkbox);
		for (WebElement checkbox: checkboxes) {
			if(!checkbox.isSelected()) {
				checkbox.click();
			}
		}
		
	}
	
	/**Get a list of checkboxes and confirm that all checkboxes are checked */
	public boolean areAllcheckboxesChecked() {
		log.info("verifying all checkboxes are checked");
		List<WebElement> checkboxes = findAll(checkbox);
		for (WebElement checkbox: checkboxes) {
			if(!checkbox.isSelected()) {
				return false;
			}
		}
		return true;
		
	}

}
