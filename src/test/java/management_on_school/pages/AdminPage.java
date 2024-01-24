package management_on_school.pages;

import management_on_school.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

















public class AdminPage {
    public AdminPage() {PageFactory.initElements(Driver.getDriver(),this); }












































































    // Duygu Jones (100)



































































































    //Salih Kaygusuz (200)

































































































    //Yakup Aydin (300)
    @FindBy(xpath = "//*[@href='/login']") public WebElement adminloginLinkYakup;
    @FindBy(id = "username") public WebElement adminusernameBoxYakup;
    @FindBy(id = "password") public WebElement adminpasswordBoxYakup;
    @FindBy(xpath = "//button[@class='fw-semibold btn btn-primary']") public WebElement adminloginButtonYakup;
    @FindBy(id = "name") public WebElement adminNameYakup;
    @FindBy(id = "surname") public WebElement adminsurnameYakup;
    @FindBy(id = "birthPlace") public WebElement adminbirthPlaceYakup;
    @FindBy(xpath = "//input[@value='FEMALE']") public WebElement admingenderFemaleYakup;
    @FindBy(xpath = "//input[@value='MALE']") public WebElement admingenderMaleYakup;
    @FindBy(id = "birthDay") public WebElement adminbirthDayYakup;
    @FindBy(id = "phoneNumber") public WebElement adminphoneNumberYakup;
    @FindBy(id = "ssn") public WebElement adminssnYakup;
    @FindBy(id = "username") public WebElement adminusernameYakup;
    @FindBy(id = "password") public WebElement adminPasswordYakup;
    @FindBy(xpath ="(//div[@role='alert']//div)[2]") public WebElement adminSavedPopUpYakup;
    @FindBy (css = "button[class='fw-semibold btn btn-primary btn-lg']") public WebElement adminSubmitYakup;


































































































    //Kubra Cemrek (400)



































































































    //Mehmet Ergan (500)



































































































    // Halil Uslu (600)



































































































    // Mustafa Aydin (700)



































































































    // Kubra Unver (800)



































































































    // Isra Muncester (900)



































































































}