package PageObjects;

import CommonBase.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrandingPage {

    Actions actions;

    public BrandingPage (WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
    }

    @FindBy(xpath="(//a[normalize-space()='Branding'])[1]") private WebElement brandingLink;

    @FindBy(xpath="(//h2[normalize-space()='B&B details'])[1]") private WebElement BnBDetailsHeader;
    @FindBy(xpath="(//input[@id='name'])[1]") private WebElement enterBnBName;
    @FindBy(xpath="(//input[@id='logoUrl'])[1]") private WebElement enterImageUrl;
    @FindBy(xpath="(//textarea[@id='description'])[1]") private WebElement descriptionInput;

    @FindBy(xpath="(//h2[normalize-space()='Map details'])[1]") private WebElement mapDetails;
    @FindBy(xpath="(//input[@id='latitude'])[1]") private WebElement enterLatitude;
    @FindBy(xpath="(//input[@id='longitude'])[1]") private WebElement enterLongitude;
    @FindBy(xpath="(//textarea[@id='directions'])[1]") private WebElement enterDirections;


    @FindBy(xpath="(//h2[normalize-space()='Contact details'])[1]") private WebElement contactDetailsHeader;
    @FindBy(xpath="(//input[@id='contactName'])[1]") private WebElement enterContactName;
    @FindBy(xpath="(//input[@id='contactPhone'])[1]") private WebElement enterPhoneNumber;
    @FindBy(xpath="(//input[@id='contactEmail'])[1]") private WebElement enterEmailAddress;


    @FindBy(xpath="(//input[@id='line1'])[1]") private WebElement enterAddressLine1;
    @FindBy(xpath="(//input[@id='line2'])[1]") private WebElement enterAddressLine2;
    @FindBy(xpath="(//input[@id='postTown'])[1]") private WebElement enterPostTown;
    @FindBy(xpath="(//input[@id='county'])[1]") private WebElement enterCounty;
    @FindBy(xpath="(//input[@id='postCode'])[1]") private WebElement enterPostCode;
    @FindBy(xpath="(//button[normalize-space()='Submit'])[1]") private WebElement submit;


    public  void  navigateToBranding() {
        actions.click(brandingLink, "Branding Link");
    }

    public void verifyBrandingPageElements() {
        actions.verifyVisible(BnBDetailsHeader, "BnB Details Header");
        actions.verifyVisible(enterBnBName, "Enter BnB Name Input");
        actions.verifyVisible(enterImageUrl, "Enter Image URL Input");
        actions.verifyVisible(descriptionInput, "Description Input");

        actions.verifyVisible(mapDetails, "Map Details Header");
        actions.verifyVisible(enterLatitude, "Enter Latitude Input");
        actions.verifyVisible(enterLongitude, "Enter Longitude Input");
        actions.verifyVisible(enterDirections, "Enter Directions Input");

        actions.verifyVisible(contactDetailsHeader, "Contact Details Header");
        actions.verifyVisible(enterContactName, "Enter Contact Name Input");
        actions.verifyVisible(enterPhoneNumber, "Enter Phone Number Input");
        actions.verifyVisible(enterEmailAddress, "Enter Email Address Input");

        actions.verifyVisible(enterAddressLine1, "Enter Address Line 1 Input");
        actions.verifyVisible(enterAddressLine2, "Enter Address Line 2 Input");
        actions.verifyVisible(enterPostTown, "Enter Post Town Input");
        actions.verifyVisible(enterCounty, "Enter County Input");
        actions.verifyVisible(enterPostCode, "Enter Post Code Input");
        actions.verifyVisible(submit, "Submit Button");

    }

    public void verifyBrandingFunctionality(String bnbName, String imageUrl, String description, String latitude, String longitude, String directions, String contactName, String phoneNumber, String emailAddress, String addressLine1, String addressLine2, String postTown, String county, String postCode) {
        actions.sendKeys(enterBnBName, bnbName, "Enter BnB Name Input");
        actions.sendKeys(enterImageUrl, imageUrl, "Enter Image URL Input");
        actions.sendKeys(descriptionInput, description, "Description Input");

        actions.sendKeys(enterLatitude, latitude, "Enter Latitude Input");
        actions.sendKeys(enterLongitude, longitude, "Enter Longitude Input");
        actions.sendKeys(enterDirections, directions, "Enter Directions Input");

        actions.sendKeys(enterContactName, contactName, "Enter Contact Name Input");
        actions.sendKeys(enterPhoneNumber, phoneNumber, "Enter Phone Number Input");
        actions.sendKeys(enterEmailAddress, emailAddress, "Enter Email Address Input");

        actions.sendKeys(enterAddressLine1, addressLine1, "Enter Address Line 1 Input");
        actions.sendKeys(enterAddressLine2, addressLine2, "Enter Address Line 2 Input");
        actions.sendKeys(enterPostTown, postTown, "Enter Post Town Input");
        actions.sendKeys(enterCounty, county, "Enter County Input");
        actions.sendKeys(enterPostCode, postCode, "Enter Post Code Input");

        actions.click(submit,"Submit Button");

    }







}
