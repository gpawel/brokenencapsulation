package org.qamation.brokenencapsulation.version.two;

import org.qamation.brokenencapsulation.website.WebSite;
import org.qamation.brokenencapsulation.website.WebSiteConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public abstract class AllTestsTogetheer {

    private WebSite webSite;

    @BeforeClass
    public void allTestsSetup() {
        WebSiteConfiguration configuration = getConfiguration();
        webSite = new WebSite(configuration);
    }

    @Test
    public void testOpenLandingPage() {
        webSite.openLandingPage();
        Assert.assertTrue(webSite.isOnLandingPage());

    }

    @Test(dependsOnMethods={"testOpenLandingPage"})
    public void testLogin() {
        webSite.login();
        Assert.assertTrue(webSite.isLoggedIn());
    }

    @AfterClass
    public void allTestsTearDown() {
        webSite.close();
    }

    abstract WebSiteConfiguration getConfiguration();
}
