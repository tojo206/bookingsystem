package PageObjects;

import CommonBase.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

            int totalCards = cardTitle.size();  // assuming all lists are same size

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


























}


