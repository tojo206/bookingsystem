package Tests;

import PageObjects.LandingPage;
import PageObjects.RoomsPage;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import java.util.Random;

public class CreateRoomsTest extends BaseTest {


    LandingPage landingPage;
    RoomsPage roomsPage;


    String username = System.getenv("USERNAME");
    String password = System.getenv("UIPASSWORD");

    @Test(priority = 0, description = "testing create rooms functionality")
    @Story("create rooms tests")
    public void testCreateRoomsFunctionality() throws InterruptedException {

        roomsPage  = new RoomsPage(driver);
        landingPage = new LandingPage(driver);

        Random random = new Random();
        int randomNum = random.nextInt(1 , 200);

        landingPage.verifyAdminNavFunctionality(username, password);
        roomsPage.navigateToRooms();
        roomsPage.verifyRoomsPageElements();
        roomsPage.verifyCreateRoomFunctionality(String.valueOf(randomNum),"Twin","120");

        landingPage.verifyLogoutFunctionality();

    }

    @Test(priority = 1, description = "testing create rooms functionality with different data")
    @Story("create rooms tests")
    public void testCreateRoomsFunctionalityWithInvalidData() throws InterruptedException {

        roomsPage  = new RoomsPage(driver);
        landingPage = new LandingPage(driver);

        Random random = new Random();
        int randomNum = random.nextInt(1 , 200);

        landingPage.verifyAdminNavFunctionality(username, password);
        roomsPage.navigateToRooms();
        roomsPage.verifyRoomsPageElements();
        roomsPage.verifyCreateRoomFunctionality(String.valueOf(randomNum),"Twin","-");
        roomsPage.verifyFormValidation();

        landingPage.verifyLogoutFunctionality();

    }
}
