package PageObjects;

import CommonBase.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RoomsPage {

    public Actions actions;


    @FindBy(xpath="(//a[normalize-space()='Rooms'])[1]") private WebElement roomsLink;

    @FindBy(xpath="(//div[@class='col-sm-1 rowHeader'])[1]") private WebElement roomsHeader;
    @FindBy(xpath="(//div[@class='col-sm-2 rowHeader'])[1]") private WebElement typeHeader;
    @FindBy(xpath="(//div[@class='col-sm-2 rowHeader'])[2]") private WebElement accessibleHeader;
    @FindBy(xpath="(//div[@class='col-sm-1 rowHeader'])[2]") private WebElement priceHeader;


    @FindBy(xpath="(//input[@id='roomName'])[1]") private WebElement roomNameInput;

    @FindBy(xpath="(//select[@id='type'])[1]") private WebElement typeDropdown;
    @FindBy(xpath="(//input[@id='wifiCheckbox'])[1]") private WebElement wiFiCheckbox;
    @FindBy(xpath="(//input[@id='refreshCheckbox'])[1]") private WebElement refreshments;
    @FindBy(xpath="(//input[@id='tvCheckbox'])[1]") private WebElement tV;
    @FindBy(xpath="(//input[@id='safeCheckbox'])[1]") private WebElement safe;

    @FindBy(xpath="(//input[@id='radioCheckbox'])[1]") private WebElement radio;

    @FindBy(xpath="(//input[@id='viewsCheckbox'])[1]") private WebElement viewsCheckbox;
    @FindBy(xpath="(//button[normalize-space()='Create'])[1]") private WebElement createButton;

    @FindBy(xpath="(//input[@id='roomPrice'])[1]") private WebElement roomPriceInput;


    //validation

    @FindBy(xpath="(//div[@class='alert alert-danger'])[1]") private WebElement errorMessage;





    public RoomsPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
    }


    public void navigateToRooms() {
        actions.click(roomsLink, "Rooms Link");
    }

    public void verifyRoomsPageElements() {
        actions.verifyVisible(roomsHeader, "Rooms Header");
        actions.verifyVisible(typeHeader, "Type Header");
        actions.verifyVisible(accessibleHeader, "Accessible Header");
        actions.verifyVisible(priceHeader, "Price Header");

    }

    public void verifyCreateRoomFunctionality(String roomName, String type, String price) {
        actions.sendKeys(roomNameInput, roomName, "Room Name Input");
        actions.selectByVisibleText(typeDropdown, type, "Type Dropdown");
        actions.sendKeys(roomPriceInput , price, "Room Price Input");
        actions.click(wiFiCheckbox, "WiFi Checkbox");
        actions.click(refreshments, "Refreshments Checkbox");
        actions.click(tV, "TV Checkbox");
        actions.click(safe, "Safe Checkbox");
        actions.click(radio, "Radio Checkbox");
        actions.click(viewsCheckbox, "Views Checkbox");
        actions.click(createButton, "Create Button");

    }

    public void verifyFormValidation() {
        actions.verifyVisible(errorMessage, "Error Message");
    }








}
