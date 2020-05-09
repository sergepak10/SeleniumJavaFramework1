package com.herokuapp.theinternet.checkboxes;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.BaseTest;
import com.herokuapp.theinternet.pages.CheckboxesPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class CheckboxesTest extends BaseTest{

	@Test
	public void selectTwoChecboxesTest() {
		log.info("Starting selectTwoCheckboxesTest");
		
		//Open main page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();
		
		//Click on Checkboxes link
		CheckboxesPage checkboxesPage = welcomePage.clickCheckboxesLink();
	
		//Select all checkboxes
		checkboxesPage.selectAllCheckboxes();
		
		//Verify all checkboxes are selected
		Assert.assertTrue(checkboxesPage.areAllcheckboxesChecked(),"Not all checkboxes checked");
		
		
		
	}

}
