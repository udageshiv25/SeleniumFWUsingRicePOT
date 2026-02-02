package com.salesforce.tests;

import com.salesforce.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ValidLoginTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeTest
    public void setUpLoginPage() throws Exception {
        try {
            super.setUp();
            loginPage = new LoginPage(driver);
        } catch (Exception e) {
            throw new Exception("Setup failed: " + e.getMessage());
        }
    }

    @Test(priority = 1)
    public void verifyLoginPageElements() throws Exception {
        try {
            Assert.assertTrue(loginPage.isUsernameFieldDisplayed(), "Username field is not displayed");
            Assert.assertTrue(loginPage.isPasswordFieldDisplayed(), "Password field is not displayed");
            Assert.assertTrue(loginPage.isLoginButtonDisplayed(), "Login button is not displayed");
            Assert.assertTrue(loginPage.isRememberMeCheckboxDisplayed(), "Remember me checkbox is not displayed");
        } catch (AssertionError e) {
            throw new AssertionError("Login page elements verification failed: " + e.getMessage());
        }
    }

    @Test(priority = 2)
    public void verifyUsernameFieldAcceptsInput() throws Exception {
        try {
            loginPage.enterUsername("testuser@salesforce.com");
        } catch (Exception e) {
            throw new Exception("Username field input test failed: " + e.getMessage());
        }
    }

    @Test(priority = 3)
    public void verifyPasswordFieldAcceptsInput() throws Exception {
        try {
            loginPage.enterPassword("ValidPassword123");
        } catch (Exception e) {
            throw new Exception("Password field input test failed: " + e.getMessage());
        }
    }

    @Test(priority = 4)
    public void verifyRememberMeFunctionality() throws Exception {
        try {
            navigateToLoginPage();
            loginPage = new LoginPage(driver);
            loginPage.selectRememberMe();
        } catch (Exception e) {
            throw new Exception("Remember me functionality test failed: " + e.getMessage());
        }
    }

    @Test(priority = 5)
    public void verifyLoginButtonClickable() throws Exception {
        try {
            navigateToLoginPage();
            loginPage = new LoginPage(driver);
            loginPage.enterUsername("validuser@test.com");
            loginPage.enterPassword("ValidPass123");
            loginPage.clickLoginButton();
        } catch (Exception e) {
            throw new Exception("Login button click test failed: " + e.getMessage());
        }
    }
}
