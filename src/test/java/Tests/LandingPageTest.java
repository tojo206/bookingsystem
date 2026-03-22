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

















}
