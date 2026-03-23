package Tests;

import PageObjects.LandingPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;


@Epic("Booking system tests")
@Feature("end to end testing")
public class LandingPageTest extends BaseTest{

    LandingPage landingPage;


    @Test(priority = 0,description = "testing elements on the Header page")
    @Story("Header elements tests")
    public void testHeaderElements(){

        landingPage = new LandingPage(driver);
        landingPage.verifyCompanyName();
        landingPage.verifyBookingNavVisible();
        landingPage.verifyContactNavVisible();
        landingPage.verifyAmenitiesNavVisible();
        landingPage.verifyRoomsNavVisible();
        landingPage.verifyLocationNavVisible();
        landingPage.VerifyAdminNavVisible();
    }


    @Test(priority = 1, description = "testing elements on hero section")
    @Story("Hero section elements tests")
    public void testHeroSectionElements(){
        landingPage = new LandingPage(driver);
        landingPage.verifyHeroSectionElements();
    }

    @Test(priority = 2, description = "testing rooms functionality")
    @Story("our rooms tests")
    public void testOurRoomsFunctionality(){

        landingPage = new LandingPage(driver);
        landingPage.verifyOurRoomsFunctionality();

    }

    @Test(priority = 3, description = "testing amenities functionality")
    @Story("amenities section tests")
    public void testAmenitiesFunctionality() {

        landingPage = new LandingPage(driver);
        landingPage.verifyAmenitiesFunctionality();

    }


    @Test(priority = 4, description = "testing location functionality")
    @Story("location section tests")
    public void testLocationFunctionality() {

        landingPage = new LandingPage(driver);
        landingPage.verifyLocationElements();

    }

    @Test(priority = 5, description = "testing contact functionality")
    @Story("contact section tests")
    public void testContactFunctionality() throws InterruptedException {

        landingPage = new LandingPage(driver);

        //positive test case
        landingPage.verifyContactFunctionality(
                "Steve",
                "stevetester@gmail.com",
                "+27 123 4567",
                "This is a test Subject from automation",
                "This is a test message from automation");

        landingPage.verifySuccessfulFormSubmission();
    }

    @Test(priority = 6, description = "testing contact form validation")
    @Story("contact form validation tests")
    public void testContactFormValidation() throws InterruptedException {

        landingPage = new LandingPage(driver);

        //negative test case
        landingPage.verifyContactFunctionality(
                "Steve",
                "not an email",
                "+27 123 4567",
                "This is a test Subject from automation",
                "This is a test message from automation");

        landingPage.verifyFormValidation();
    }

    @Test(priority = 7, description = "testing admin nav functionality")
    @Story("admin nav tests")
    public void testAdminFunctionality() throws InterruptedException {


        landingPage = new LandingPage(driver);
        landingPage.verifyAdminNavFunctionality("invalidUsername", "invalidPassword");
        landingPage.loginFormValidation();
    }

}
