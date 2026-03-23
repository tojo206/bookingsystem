package Tests;

import PageObjects.BrandingPage;
import PageObjects.LandingPage;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

@Epic("Booking system tests")

public class BrandingTests extends BaseTest {

    LandingPage landingPage;
    BrandingPage brandingPage;

    String username = System.getenv("USERNAME");
    String password = System.getenv("UIPASSWORD");


    @Test(description = "Verify that the branding page is displayed correctly")
    public void testBrandingPage() throws InterruptedException {
        // Navigate to the branding page

        landingPage = new LandingPage(driver);
        brandingPage = new BrandingPage(driver);

        landingPage.verifyAdminNavFunctionality(username, password);
        brandingPage.navigateToBranding();

        // Verify that the branding page is displayed correctly
        brandingPage.verifyBrandingPageElements();
        brandingPage.verifyBrandingFunctionality(
            "Winterflood Luxury B&B",
            "https://example.com/logo.png",
            "A charming bed and breakfast with stunning views and exceptional service.",
            "51.5074",
            "-0.1278",
            "Located 5 minutes from the train station. Turn left at the main road.",
            "John Smith",
            "+44 20 1234 5678",
            "info@winterfloodbb.co.uk",
            "123 Riverside Lane",
            "Greenwich",
            "London",
            "Greater London",
            "SE10 9RT"
        );

    }

}
