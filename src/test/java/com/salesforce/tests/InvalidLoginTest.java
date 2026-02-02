package com.salesforce.tests;

import com.salesforce.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class InvalidLoginTest extends BaseTest {

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
    public void verifyLoginWithEmptyCredentials() throws Exception {
        try {
            navigateToLoginPage();
            loginPage = new LoginPage(driver);
            loginPage.login("", "");
            Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed for empty credentials");
        } catch (AssertionError e) {
            throw new AssertionError("Empty credentials test failed: " + e.getMessage());
        }
    }

    @Test(priority = 2)
    public void verifyLoginWithEmptyUsername() throws Exception {
        try {
            navigateToLoginPage();
            loginPage = new LoginPage(driver);
            loginPage.login("", "Password123");
            Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed for empty username");
        } catch (AssertionError e) {
            throw new AssertionError("Empty username test failed: " + e.getMessage());
        }
    }

    @Test(priority = 3)
    public void verifyLoginWithEmptyPassword() throws Exception {
        try {
            navigateToLoginPage();
            loginPage = new LoginPage(driver);
            loginPage.login("testuser@test.com", "");
            Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed for empty password");
        } catch (AssertionError e) {
            throw new AssertionError("Empty password test failed: " + e.getMessage());
        }
    }

    @Test(priority = 4)
    public void verifyLoginWithInvalidUsername() throws Exception {
        try {
            navigateToLoginPage();
            loginPage = new LoginPage(driver);
            loginPage.login("invaliduser@test.com", "ValidPassword123");
            Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed for invalid username");
        } catch (AssertionError e) {
            throw new AssertionError("Invalid username test failed: " + e.getMessage());
        }
    }

    @Test(priority = 5)
    public void verifyLoginWithInvalidPassword() throws Exception {
        try {
            navigateToLoginPage();
            loginPage = new LoginPage(driver);
            loginPage.login("validuser@test.com", "WrongPassword123");
            Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed for invalid password");
        } catch (AssertionError e) {
            throw new AssertionError("Invalid password test failed: " + e.getMessage());
        }
    }

    @Test(priority = 6)
    public void verifyLoginWithInvalidFormat() throws Exception {
        try {
            navigateToLoginPage();
            loginPage = new LoginPage(driver);
            loginPage.login("notanemail", "Password123");
            Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed for invalid email format");
        } catch (AssertionError e) {
            throw new AssertionError("Invalid format test failed: " + e.getMessage());
        }
    }

    @Test(priority = 7)
    public void verifyLoginWithSpecialCharacters() throws Exception {
        try {
            navigateToLoginPage();
            loginPage = new LoginPage(driver);
            loginPage.login("user@#$%^&*@test.com", "Pass@#$%123");
            Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed for special characters");
        } catch (AssertionError e) {
            throw new AssertionError("Special characters test failed: " + e.getMessage());
        }
    }

    @Test(priority = 8)
    public void verifyLoginWithSQLInjection() throws Exception {
        try {
            navigateToLoginPage();
            loginPage = new LoginPage(driver);
            loginPage.login("admin' OR '1'='1", "admin' OR '1'='1");
            Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed for SQL injection attempt");
        } catch (AssertionError e) {
            throw new AssertionError("SQL injection test failed: " + e.getMessage());
        }
    }
}
