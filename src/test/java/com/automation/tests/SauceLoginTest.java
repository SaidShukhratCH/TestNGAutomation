package com.automation.tests;

import org.testng.annotations.Test;

import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.utils.ExcelUtils;
import com.automation.utils.PropertyReader;

public class SauceLoginTest extends BaseTest {

	@Test(groups = { "Regression", "Umed", "Login" })
	public void verifyUserCannotDoLoginWithInvalidCred() {
		// Login Page
		LoginPage loginPage = new LoginPage(driver);
		loginPage.doLogin("testtest", "test@123");

		// Login page error
		loginPage.verifyInvalidLoginError();
	}

	@Test(groups = { "Regression", "Login" })
	public void verifyUserCanAbleToLogin() {
		// Login Page
		LoginPage loginPage = new LoginPage(driver);
		// Reading user name / password from Property file
		// loginPage.doLogin(PropertyReader.getProperty("login.username"),
		// PropertyReader.getProperty("login.password"));

		// Reading user name / password from Excel Property file
		loginPage.doLogin(ExcelUtils.getData(1, 0), ExcelUtils.getData(1, 1));

		// Verify Home Page
		HomePage homePage = new HomePage(driver);
		homePage.verifyHomePage();
	}

}
