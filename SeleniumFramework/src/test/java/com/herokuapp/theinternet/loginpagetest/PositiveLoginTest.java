package com.herokuapp.theinternet.loginpagetest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.BaseTest;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.SecureAreaPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class PositiveLoginTest extends BaseTest {
	

	@Test
	public void logInTest() {
		log.info("Starting LogIn test");
		
		//Open a main page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();
		
		//Click on form Authentication link
		LoginPage loginPage = welcomePage.clickFormAuthenticationLink();
		
		//Execute Login
		SecureAreaPage secureAreaPage = loginPage.Login("tomsmith", "SuperSecretPassword!");
		
		//New page displays correct url
		Assert.assertEquals(secureAreaPage.getCurrentUrl(), secureAreaPage.getPageUrl());
		 
		//Logout button is visible
		Assert.assertTrue(secureAreaPage.isLogOutButtonVisible(), "Logout button is not visible");
		
		//Successful login message
		String expectedSuccessMessage = "You logged into a secure area!";
		String actualSuccessMessage = secureAreaPage.getSuccessMessageText();
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage), "actualSuccessMessage does not contain expectedSuccessMessage" + 
		"\nactualSuccessMessage: " + actualSuccessMessage + "\nexpectedSuccessMessage: " + expectedSuccessMessage );
			
	}

}
