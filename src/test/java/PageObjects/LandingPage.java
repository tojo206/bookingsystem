package PageObjects;

import CommonBase.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;


public class LandingPage {

    public Actions actions;

    @FindBy(xpath = "(//span[normalize-space()='Shady Meadows B&B'])[1]")
    private WebElement CompanyName;

    @FindBy(xpath = "(//a[@class='nav-link'][normalize-space()='Rooms'])[1]")
    private WebElement roomsLink;

    @FindBy(xpath = "(//a[@class='nav-link'][normalize-space()='Booking'])[1]")
    private WebElement bookingLink;

    @FindBy(xpath="(//a[normalize-space()='Amenities'])[1]") private WebElement amenitiesLink;

    @FindBy(xpath = "(//a[normalize-space()='Location'])[1]")
    private WebElement LocationLink;

    @FindBy(xpath = "(//a[normalize-space()='Contact'])[1]")
    private WebElement ContactLink;

    @FindBy(xpath="(//a[normalize-space()='Admin'])[1]") private WebElement adminLink;

    @FindBy(xpath="(//h1[normalize-space()='Welcome to Shady Meadows B&B'])[1]") private WebElement welcomeHeader;

    @FindBy(xpath="(//p[@class='lead mb-4'])[1]") private WebElement welcomeSubHeadingText;

    @FindBy(xpath="(//a[normalize-space()='Book Now'])[1]") private WebElement bookNowButton;


    //our rooms

    @FindBy(xpath="(//h2[normalize-space()='Our Rooms'])[1]") private WebElement ourRoomsHeader;
    @FindBy(xpath="(//p[contains(text(),'Comfortable beds and delightful breakfast from loc')])[1]") private WebElement subheadingtext;

    @FindBy(xpath="(//h5[@class='card-title'])") private List<WebElement> cardTitle;
    @FindBy(xpath = "(//p[@class='card-text'])") private  List<WebElement> cardDescriptionText;
    @FindBy(xpath="(//img[@alt='Single Room'])") private List<WebElement> roomImg;
    @FindBy(xpath = "(//span[@class='badge bg-light text-dark'])") private List<WebElement> amenitiesBadges;
    @FindBy(xpath="(//div[@class='fw-bold fs-5'])") private List<WebElement> prices;
    @FindBy(xpath="(//a[@class='btn btn-primary'])") private List<WebElement> BookNowButton;


    //booking

    @FindBy(xpath="(//h3[normalize-space()='Check Availability & Book Your Stay'])[1]") private WebElement checkAvailability;


    //location

    @FindBy(xpath="(//h2[normalize-space()='Our Location'])[1]") private WebElement ourLocationHeaderText;
    @FindBy(xpath="(//p[@class='lead text-muted'])[2]") private WebElement SubHeadingText;

    @FindBy(xpath="(//h3[normalize-space()='Contact Information'])[1]") private WebElement contactInformationText;

    @FindBy(xpath="(//div[@class='d-flex mb-4'])[1]") private WebElement address;

    @FindBy(xpath="(//div[@class='d-flex mb-4'])[2]") private WebElement phone;

    @FindBy(xpath="(//div[@class='d-flex mb-4'])[3]") private WebElement email;

    @FindBy(xpath="(//h4[normalize-space()='Getting Here'])[1]") private WebElement gettingHereText;
    @FindBy(xpath="(//p[contains(text(),'Welcome to Shady Meadows, a delightful Bed & Break')])[2]") private WebElement welcomeToShadyMeadowsText;

    @FindBy(xpath="(//section[@id='location'])[1]") private WebElement map;




    //contact

    @FindBy(xpath="(//h3[normalize-space()='Send Us a Message'])[1]") private WebElement sendUsAMessageText;

    @FindBy(xpath="(//input[@id='name'])[1]") private WebElement nameInput;

    @FindBy(xpath="(//input[@id='email'])[1]") private WebElement emailInput;
    @FindBy(xpath="(//input[@id='phone'])[1]") private WebElement phoneInput;
    @FindBy(xpath="(//input[@id='subject'])[1]") private WebElement subjectInput;
    @FindBy(xpath="(//textarea[@id='description'])[1]") private WebElement descriptionInput;
    @FindBy(xpath="(//button[normalize-space()='Submit'])[1]") private WebElement submitButton;

    @FindBy(xpath="(//div[@class='card-body p-4'])[2]") private WebElement thanksForGettingInTouchAs;

    @FindBy(xpath= "//div[@class='alert alert-danger']") private WebElement errorMessage;



    //admin


    @FindBy(xpath="(//a[normalize-space()='Restful Booker Platform Demo'])[1]") private WebElement restfulBookerPlatformDemoLink;
    @FindBy(xpath="(//button[normalize-space()='Logout'])[1]") private WebElement logout;
    @FindBy(xpath="(//h2[normalize-space()='Login'])[1]") private WebElement loginHeader;

    @FindBy(xpath="(//input[@id='username'])[1]") private WebElement usernameInput;
    @FindBy(xpath="(//input[@id='password'])[1]") private WebElement passwordInput;
    @FindBy(xpath="(//button[normalize-space()='Login'])[1]") private WebElement loginButton;

    @FindBy(xpath="(//div[@role='alert'])[1]") private WebElement invalidCredentials;







        public LandingPage(WebDriver driver) {

            PageFactory.initElements(driver, this);
            this.actions = new Actions(driver);
        }


        public void verifyCompanyName(){
            actions.verifyVisible(CompanyName , "company name");
        }

        public void  verifyRoomsNavVisible(){
            actions.verifyVisible(roomsLink ,"room link on nav");
        }

        public void verifyAmenitiesNavVisible(){
            actions.verifyVisible(amenitiesLink, "amenities link on nav");
        }

        public void verifyBookingNavVisible(){
            actions.verifyVisible(bookingLink, "booking link on nav");
        }

        public void verifyLocationNavVisible(){
            actions.verifyVisible(LocationLink, "location link on nav");
        }

        public void verifyContactNavVisible(){
            actions.verifyVisible(ContactLink, "contact link on nav");
        }

        public void VerifyAdminNavVisible(){
            actions.verifyVisible(adminLink, "admin link on nav");
        }


        public void verifyHeroSectionElements(){
            actions.verifyVisible(welcomeHeader, "welcome heading text");
            actions.verifyVisible(welcomeSubHeadingText , "welcome sub heading text");
            actions.verifyVisible(bookNowButton, "book now button");
        }




        public void verifyOurRoomsFunctionality(){

            actions.click(roomsLink,"rooms link on nav");

            int totalCards = cardTitle.size();

            actions.verifyVisible(ourRoomsHeader, "our rooms header text");
            actions.verifyVisible(subheadingtext, "our rooms sub text");

            for (int i = 0; i < totalCards; i++) {
                actions.verifyVisible(cardTitle.get(i), "Card " + (i+1) + " header");
                actions.verifyVisible(cardDescriptionText.get(i), "Card " + (i+1) + " text");
                actions.verifyVisible(roomImg.get(i), "Card " + (i+1) + " image");
                actions.verifyVisible(amenitiesBadges.get(i), "Card " + (i+1) + " amenities Badges");
                actions.verifyVisible(prices.get(i), "Card " + (i+1) + " prices");
                actions.verifyVisible(BookNowButton.get(i), "Card " + (i+1) + " Book Now Button");


            }
        }

        public void verifyAmenitiesFunctionality() {

            actions.click(amenitiesLink, "amenities link on nav");
            actions.verifyVisible(checkAvailability, "check availability header text");
            System.out.println("this button does not work but it is visible and clickable ");
        }

        public void verifyLocationElements() {

            actions.click(LocationLink, "location link on nav");
            actions.verifyVisible(ourLocationHeaderText, "our location header text");
            actions.verifyVisible(SubHeadingText, "our location sub heading text");
            actions.verifyVisible(contactInformationText, "contact information text");
            actions.verifyVisible(address, "address");
            actions.verifyVisible(phone, "phone");
            actions.verifyVisible(email, "email");
            actions.verifyVisible(gettingHereText, "getting here text");
            actions.verifyVisible(welcomeToShadyMeadowsText, "welcome to shady meadows text");
            actions.verifyVisible(map, "map");


        }


        public void verifyContactFunctionality(String name, String email, String phone, String subject, String description) throws InterruptedException {

            actions.click(LocationLink, "contact link on nav");
            actions.click(ContactLink, "contact link on nav");


            Thread.sleep(3000);
            actions.verifyVisible(sendUsAMessageText, "send us a message text");

            actions.sendKeys(nameInput, name, "name input");
            actions.sendKeys(emailInput, email, "email input");
            actions.sendKeys(phoneInput, phone, "phone input");
            actions.sendKeys(subjectInput, subject, "subject input");
            actions.sendKeys(descriptionInput, description, "description input");

            actions.click(submitButton, "submit button");

        }

        public void verifySuccessfulFormSubmission() throws InterruptedException {
            Thread.sleep(2000);
            actions.verifyVisible(thanksForGettingInTouchAs, "thanks for getting in touch message");

        }

        public void verifyFormValidation() {
            actions.verifyVisible(errorMessage, "error message");
        }


        public void verifyAdminNavFunctionality(String username, String password) throws InterruptedException {
            actions.click(adminLink, "admin link on nav");
            Thread.sleep(2000);
            actions.verifyVisible(restfulBookerPlatformDemoLink, "restful booker platform demo link");
            actions.verifyVisible(loginHeader, "login header text");
            actions.sendKeys(usernameInput,username, "username input");
            actions.sendKeys(passwordInput,password ,"password input");
            actions.click(loginButton, "login button");

        }

        public void loginFormValidation() throws InterruptedException {
            Thread.sleep(3000);
            actions.verifyVisible(invalidCredentials, "invalid credentials error message");
        }

        public void verifyLogoutFunctionality() throws InterruptedException {
            actions.click(logout, "logout button");
            Thread.sleep(2000);
        }

























}


