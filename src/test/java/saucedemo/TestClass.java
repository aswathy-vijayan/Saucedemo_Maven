package saucedemo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.constants.AutomationConstants;
import com.saucedemo.pages.LoginPage;


public class TestClass extends TestBase {
	LoginPage obj = null;
	
	@Test
	public void testCase1() {
		obj = new LoginPage(driver);
		obj.setUsername("WrongUsername");
		obj.setPassword("WrongPassword");
		obj.clickLogin();
		String actualError = obj.checkLoginStatus();
		Assert.assertEquals(actualError, AutomationConstants.expError);
	}

	@Test
	public void testCase2() {
		obj = new LoginPage(driver);
		obj.setUsername("standard_user");
		obj.setPassword("WrongPassword");
		obj.clickLogin();
		String actualError = obj.checkLoginStatus();
		Assert.assertEquals(actualError, AutomationConstants.expError);
	}

	@Test
	public void testCase3() {
		obj = new LoginPage(driver);
		obj.setUsername("WrongUsername");
		obj.setPassword("secret_sauce");
		obj.clickLogin();
		String actualError = obj.checkLoginStatus();
		Assert.assertEquals(actualError, AutomationConstants.expError);
	}

	@Test
	public void testCase4() {
		obj = new LoginPage(driver);
		obj.setUsername("standard_user");
		obj.setPassword("secret_sauce");
		obj.clickLogin();
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, AutomationConstants.expHomeUrl);
	}
}
