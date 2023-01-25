package org.qamation.brokenencapsulation.website;

import lombok.Builder;
import lombok.Data;
import org.openqa.selenium.By;

@Builder
@Data
public class WebSiteConfiguration {
    private String landingPageUrl;
    private By landingPageUniqueLocator;
    private By signInButtonLocator;
    private String userName;
    private String userPassword;
    private By userNameFieldLocator;
    private By passwordFieldLocator;
    private By submitCredentialsLocator;
    private By signedInUniqueLocator;
}
