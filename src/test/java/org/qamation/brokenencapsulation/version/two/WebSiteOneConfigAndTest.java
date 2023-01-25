package org.qamation.brokenencapsulation.version.two;

import org.openqa.selenium.By;
import org.qamation.brokenencapsulation.website.WebSiteConfiguration;
import org.testng.annotations.Test;

@Test
public class WebSiteOneConfigAndTest extends AllTestsTogetheer {

    WebSiteConfiguration getConfiguration() {
        return WebSiteConfiguration.builder()
                .landingPageUrl("https://websiteone.ca")
                .landingPageUniqueLocator(By.xpath("//div[contains(@class,'featureGridContainer')]"))
                .userNameFieldLocator(By.id("username"))
                .passwordFieldLocator(By.id("password"))
                .signInButtonLocator(By.xpath("//a/*[text()='Account']/.."))
                .signedInUniqueLocator(By.xpath("//*[contains(text(),'Welcome to your account')]"))
                .submitCredentialsLocator(By.xpath("//button[@type='submit']"))
                .userName("username@somedomain.com")
                .userPassword("verysecretpassword!")
                .build();
    }
}

