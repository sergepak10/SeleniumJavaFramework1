package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePageObject {

	private By dropdown = By.id("dropdown");	
	
	public DropdownPage(WebDriver driver, Logger log) {
		super(driver, log);
		
	}
	
	/**Select an option in Dropdown List */
	public void selectOption(int i) {
		log.info("selecting an option " + i + " from the dropdown");
		WebElement dropdownElement = find(dropdown);
		Select dropdown = new Select(dropdownElement);
		
		dropdown.selectByValue("" + i);
		
	}
	
	/**This method returns an option selected in the dropdown. An option returned as a string*/
	public String getSelectedOption() {
		WebElement dropdownElement = find(dropdown);
		Select dropdown = new Select(dropdownElement);
		String selectedOption = dropdown.getFirstSelectedOption().getText();
		log.info(selectedOption + " is selected in the dropdown");
		return selectedOption;	
	}
}
