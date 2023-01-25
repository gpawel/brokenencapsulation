package org.qamation.brokenencapsulation.version.two;

import org.openqa.selenium.By;
import org.qamation.brokenencapsulation.website.WebSiteConfiguration;
import org.testng.annotations.Test;

@Test
public class WebSiteTwoConfigAndTest extends AllTestsTogetheer {

    WebSiteConfiguration getConfiguration() {
        return WebSiteConfiguration.builder()
                .landingPageUrl("https://websitetwo.ca")
                .landingPageUniqueLocator(By.xpath("//div[@class='spinerGrid']"))
                .userNameFieldLocator(By.id("important-username"))
                .passwordFieldLocator(By.id("secrete-password"))
                .signInButtonLocator(By.xpath("//a/*[text()='Sign In']/.."))
                .signedInUniqueLocator(By.xpath("//span[text()='Welcome back']"))
                .submitCredentialsLocator(By.id("submit"))
                .userName("another.user@anotherdomain.com")
                .userPassword("anothersecretpassword#")
                .build();
    }
}
