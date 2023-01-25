package org.qamation.brokenencapsulation.website;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebSite {
    private WebSiteConfiguration configuration;
    private WebDriver driver;
    private WebDriverWait wait;

    public WebSite (WebSiteConfiguration configuration) {
        this.configuration = configuration;
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void openLandingPage() {
        driver.get(configuration.getLandingPageUrl());
        driver.manage().window().fullscreen();
        wait.until(ExpectedConditions.presenceOfElementLocated(configuration.getSignInButtonLocator()));
    }

    public void close() {
        //driver.quit();
    }


    public void login() {
        openLoginPage();
        submitLoginForm();
    }

    private void openLoginPage() {
        wait.until(ExpectedConditions.elementToBeClickable(configuration.getSignInButtonLocator()));
        driver.findElement(configuration.getSignInButtonLocator()).click();
        wait.until(ExpectedConditions.elementToBeClickable(configuration.getSubmitCredentialsLocator()));
    }

    private void submitLoginForm() {
        driver.findElement(configuration.getUserNameFieldLocator()).sendKeys(configuration.getUserName());
        driver.findElement(configuration.getPasswordFieldLocator()).sendKeys(configuration.getUserPassword());
        driver.findElement(configuration.getSubmitCredentialsLocator()).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(configuration.getSignedInUniqueLocator()));
    }

    public boolean isOnLandingPage() {
        return driver.findElements(configuration.getSignInButtonLocator()).size() > 0;
    }

    public boolean isLoggedIn() {
        return driver.findElements(configuration.getSignedInUniqueLocator()).size() > 0;
    }
}
