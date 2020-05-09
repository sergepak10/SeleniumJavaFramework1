package com.herokuapp.theinternet.dropdowntest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.BaseTest;
import com.herokuapp.theinternet.pages.DropdownPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class DropdownTest extends BaseTest{
	
	@Test
	public void OptionTwoTest() {
		
		//Open main page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();
		
		//Click on Dropdown link
		DropdownPage dropdownPage = welcomePage.clickDropdownLink();
		
		//Select option 2
		dropdownPage.selectOption(2);
		
		//Verify option 2 is selected
		String selectedOption = dropdownPage.getSelectedOption();
		Assert.assertTrue(selectedOption.equals("Option 2"), "Option 2 is not selected. Instead selected " + selectedOption);
	}

}
