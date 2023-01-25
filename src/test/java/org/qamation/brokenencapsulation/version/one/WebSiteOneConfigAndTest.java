package org.qamation.brokenencapsulation.version.one;

import org.openqa.selenium.By;
import org.qamation.brokenencapsulation.website.WebSiteConfiguration;
import org.testng.annotations.Test;

@Test
public class WebSiteOneConfigAndTest extends AllTestsTogetheer{

    {
        configuration = WebSiteConfiguration.builder()
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
