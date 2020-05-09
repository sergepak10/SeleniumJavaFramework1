package com.herokuapp.theinternet.alertstests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.BaseTest;
import com.herokuapp.theinternet.pages.JavaScriptAlertsPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class JavaScriptAlertsTest extends BaseTest {
	
	@Test
	public void jsAlertTest() {
		//Open main page
		System.out.println("********************************************");
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();
		
		//Click on JavaScriptAlerts link
		JavaScriptAlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();
		
		//Click on Click for JS Alert button
		alertsPage.clickForJSAlert();
		
		//Get JS Alert text
		String alertText = alertsPage.getAlertText();
		
		//Click OK
		alertsPage.acceptAlert();
		
		//Get Result message
		String resultMessage = alertsPage.getResultMessage();
		
		//Verifications
		//1 - Alert text as expected
		Assert.assertTrue(alertText.equals("I am a JS Alert"), "Alert text is not correct. \nExpected 'I am a JS Alert', but received: " 
				+ alertText);
		//2 - Result message as expected
		Assert.assertTrue(resultMessage.equals("You successfuly clicked an alert"), "Result message is not correct. \nExpected 'You successfuly clicked an alert',"
				+ " but received: " + resultMessage);
		
	}
	
	@Test
	public void jsConfirmTest() {
		//Open main page
		System.out.println("********************************************");
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();
		
		//Click on JavaScriptAlerts link
		JavaScriptAlertsPage alertPage = welcomePage.clickJavaScriptAlertsLink();
		
		//Click on Click for JS Confirm button
		alertPage.clickForJSConfirm();
		
		//Get JS confirm text
		String confirmText = alertPage.getAlertText();
		
		//Click OK
		alertPage.acceptAlert();
		
		//Get Result OK message
		String resultMessage = alertPage.getResultMessage();
		
		//Click on Click for JS Confirm button
		alertPage.clickForJSConfirm();
		
		//Click Cancel
		alertPage.dismissAlert();
		
		//Get Result Cancel message
		String resultCancelMessage = alertPage.getResultMessage();
		
		//Verifications
		//1 - Confirm text as expected
		Assert.assertTrue(confirmText.equals("I am a JS Confirm"), "Alert text is not correct. \nExpected 'I am a JS Confirm', but received: " 
				+ confirmText);
		
		//2 - Result OK message as expected
		Assert.assertTrue(resultMessage.equals("You clicked: Ok"), "Result message is not correct. \nExpected 'You clicked: Ok',"
				+ " but received: " + resultMessage);
		
		//3 - Result Cancel message as expected
		Assert.assertTrue(resultCancelMessage.equals("You clicked: Cancel"), "Result message is not correct. \nExpected 'You clicked: Cancel',"
				+ " but received: " + resultCancelMessage);
		
	}
	@Test
	public void jsPromptTest() {
		//Open main page
		System.out.println("********************************************");
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();
		
		//Click on JavaScriptAlerts link
		JavaScriptAlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();
		
		//Click on Click for JS Prompt button
		alertsPage.clickForJSPrompt();
		
		//Get JS prompt text
		String alertText = alertsPage.getAlertText();
		
		//Type text into alert
		alertsPage.typeTextIntoAlert("alert - js prompt text!");
		
		//Click OK
		alertsPage.acceptAlert();
		
		//Get Result message
		String resultPromptMessage = alertsPage.getResultMessage();
		
		//Verifications
		//1 - Alert text as expected
		Assert.assertTrue(alertText.equals("I am a JS prompt"), "Alert text is not correct. \nExpected 'I am a JS prompt', but received: " 
				+ alertText);
		
		//2 - Result message as expected
		Assert.assertTrue(resultPromptMessage.equals("You entered: alert - js prompt text!"), "Result message is not correct. \nExpected 'alert - js prompt text!',"
				+ "but received: " + resultPromptMessage);
		
	}
}
