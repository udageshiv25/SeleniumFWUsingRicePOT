package com.salesforce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//div[@class='slds-icon-waffle']")
    private WebElement appLauncher;

    @FindBy(xpath = "//span[contains(@class,'uiImage')]")
    private WebElement userAvatar;

    @FindBy(xpath = "//a[@title='Home']")
    private WebElement homeTab;

    @FindBy(xpath = "//span[contains(text(),'Home')]")
    private WebElement homeLabel;

    @FindBy(xpath = "//div[@class='profileTrigger']")
    private WebElement profileMenu;

    @FindBy(xpath = "//a[contains(text(),'Log Out')]")
    private WebElement logoutLink;

    @FindBy(xpath = "//div[@class='slds-context-bar__label-action']")
    private WebElement navigationBar;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public boolean isHomePageDisplayed() {
        try {
            return wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(appLauncher),
                ExpectedConditions.visibilityOf(userAvatar),
                ExpectedConditions.visibilityOf(navigationBar)
            )) != null;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isAppLauncherDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(appLauncher)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isUserAvatarDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(userAvatar)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickProfileMenu() throws Exception {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(profileMenu));
            profileMenu.click();
        } catch (Exception e) {
            throw new Exception("Failed to click profile menu: " + e.getMessage());
        }
    }

    public void logout() throws Exception {
        try {
            clickProfileMenu();
            wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
            logoutLink.click();
        } catch (Exception e) {
            throw new Exception("Logout failed: " + e.getMessage());
        }
    }

    public String getPageTitle() {
        try {
            return driver.getTitle();
        } catch (Exception e) {
            return "";
        }
    }

    public String getCurrentUrl() {
        try {
            return driver.getCurrentUrl();
        } catch (Exception e) {
            return "";
        }
    }
}
