package management_on_school.pages;

import management_on_school.utilities.ConfigReader;
import management_on_school.utilities.Driver;
import management_on_school.utilities.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

















public class AdminPage {
    public AdminPage() {PageFactory.initElements(Driver.getDriver(),this); }







































































    // Duygu Jones (100)
    @FindBy(css="h3[bg='primary']") public WebElement adminPageTitleDj;
    @FindBy(css="button[aria-controls='offcanvasNavbar-expand-false']") public WebElement adminMenuButtonDj;
    @FindBy(xpath = "//a[text()='Dean Management']")  public WebElement deanManagementButtonDj;
































































































    //Salih Kaygusuz (200)
    public void performLoginAdmin() {
        Actions actions = new Actions(Driver.getDriver());
        Driver.getDriver().get(ConfigReader.getProperty("manage_Url"));
        ReusableMethods.waitForSecond(3);
        homePageLoginLinkST.click();
        userNameButtonST.sendKeys("AdminGakky");
        PasswordButtonST.sendKeys("Cavabunga82");
        homePageLoginButtonAdST.click();
    }

    @FindBy(xpath = "//a[@class='header_link ms-2']")         public WebElement homePageLoginLinkST;
    @FindBy(xpath = "//input[@id='username']")         public WebElement userNameButtonST;
    @FindBy(xpath = "//input[@id='password']")         public WebElement PasswordButtonST;
    @FindBy(xpath = "//button[normalize-space()='Login']")         public WebElement loginPageLoginButtonST;
    @FindBy(xpath = "//button[normalize-space()='Menu']")
    public WebElement PageMenuButtonAdST;
    @FindBy(xpath = "//a[normalize-space()='Student Management']")
    public WebElement mainMenuStudentManagementButtonAdST;
    @FindBy(xpath = "//select[@id='advisorTeacherId']")         public WebElement advisorTeacherDropDownButtonAdST;
    @FindBy(id = "name")         public WebElement studentMngNamenBoxAdST;
    @FindBy(id = "surname")         public WebElement studentMngSurnamenBoxAdST;
    @FindBy(id = "birthPlace")         public WebElement studentMngBPlaceBoxAdST;
    @FindBy(id = "email")         public WebElement studentMngemailBoxAdST;
    @FindBy(id = "phoneNumber")         public WebElement studentMngPhoneBoxAdST;
    @FindBy(id = "ssn")         public WebElement studentMngSsnBoxAdST;
    @FindBy(id = "username")         public WebElement studentMngUserNameBoxAdST;
    @FindBy(id = "fatherName")         public WebElement studentMngFatherNameBoxAdST;
    @FindBy(id = "motherName")         public WebElement studentMngMotherNameBoxAdST;
    @FindBy(id = "password")         public WebElement studentMngPasswordBoxAdST;
    @FindBy(xpath = "//input[@value='MALE']")         public WebElement studentMngGenderMaleButtonAdST;
    @FindBy(xpath = "//input[@value='FEMALE']")         public WebElement studentMngGenderFeMaleButtonAdST;

    @FindBy(xpath = "//div[contains(text(),'Student saved Successfully')]")         public WebElement studentMngSuccessfullyAdST;
    @FindBy(xpath = "//button[normalize-space()='Submit']")         public WebElement studentMngSubmitButtonAdST;
    @FindBy(xpath = "//div[normalize-space()='Required']")         public WebElement studentMngNameRequiredTesxtAdST;
    @FindBy(css = "div[role='alert'] div:nth-child(2)")         public WebElement studentMngPleaseEnterValidEmailTesxtAdST;
    @FindBy(xpath = "//div[contains(text(),'You have entered an invalid value. Valid values ar')]")         public WebElement studentMngGenderIvalidValueTesxtAdST;
    @FindBy(id = "birthDay")         public WebElement studentMngBirthdayBoxAdST;

    @FindBy(xpath = "//div[normalize-space()='Minimum 11 character (XXX-XX-XXXX)']")         public WebElement studentMngSsnInvalidValueTextAdST;
    @FindBy(xpath = "//div[3]//div[2]//div[1]//div[1]")         public WebElement studentMngUserNameInvalidValueTextAdST;
    @FindBy(xpath = "//div[normalize-space()='At least 8 characters']")         public WebElement studentMngPas8CaharcterInvalidValueTextAdST;
    @FindBy(xpath = "//div[normalize-space()='One uppercase character']")         public WebElement studentMngPasUpperCaseInvalidValueTextAdST;
    @FindBy(xpath = "//div[normalize-space()='One lowercase character']")         public WebElement studentMngPasLowerCaseInvalidValueTextAdST;
    @FindBy(xpath = "//div[normalize-space()='One number']")         public WebElement studentMngPasOneNumberInvalidValueTextAdST;
    @FindBy(xpath = "//button[normalize-space()='Login']")         public WebElement homePageLoginButtonAdST;





















































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
    @FindBy(xpath = "//*[@href='/login']") public WebElement loginLink_hu;
    @FindBy(xpath = "//button[text()='Menu']") public WebElement menuButton_hu;
    @FindBy(xpath = "//a[text()='Teacher Management']") public WebElement teacherManagementButton_hu;
    @FindBy(xpath = "//div[@class=' css-1xc3v61-indicatorContainer']") public WebElement selectLesson_ok_hu;
    @FindBy(xpath = "//div[contains(@class,'css-19bb58m')]") public WebElement selectLesson_hu;
    @FindBy(xpath = "//div[@class=' css-9jq23d']") public WebElement javaScript_hu;
    @FindBy(xpath = "//input[@id='name']") public WebElement name_hu;
    @FindBy(xpath = "//input[@id='surname']") public WebElement surName_hu;
    @FindBy(xpath = "//input[@id='birthPlace']") public WebElement birthPlace_hu;
    @FindBy(xpath = "//input[@id='email']") public WebElement email_hu;
    @FindBy(xpath = "//input[@id='phoneNumber']") public WebElement phoneNumber_hu;
    @FindBy(xpath = "//input[@id = 'isAdvisorTeacher']") public WebElement isAdvisorTeacher_hu;
    @FindBy(xpath = "//input[@value='FEMALE']") public WebElement femaleButton_hu;
    @FindBy(xpath = "//input[@value='MALE']") public WebElement maleButton_hu;
    @FindBy(xpath = "//input[@id = 'birthDay']") public WebElement birthDay_hu;
    @FindBy(xpath = "//input[@id = 'ssn']") public WebElement ssnBox_hu;
    @FindBy(xpath = "//input[@id = 'username']") public WebElement usernameBox_hu;
    @FindBy(xpath = "//input[@id = 'password']") public WebElement passwordBox_hu;
    @FindBy(xpath = "//button[@class='fw-semibold btn btn-primary btn-lg']") public WebElement SubmitButton_hu;
    @FindBy(xpath = "//button[@class='fw-semibold btn btn-primary']") public WebElement loginButton_hu;
    @FindBy(xpath = "//a[text()='Dean Management']") public WebElement deanManagementButton_hu;
    @FindBy(xpath ="//div[contains(text(),'Teacher saved successfully')]") public WebElement SavedPopUp_hu;
    @FindBy(xpath = "//input[@role='combobox']") public WebElement chooseLesson_hu;
    @FindBy(xpath = "//div[normalize-space()='At least 8 characters']") public WebElement AtLeast8Characters_hu;
    @FindBy(xpath = "//div[normalize-space()='One uppercase character']") public WebElement OneUppercaseCharacter_hu;
    @FindBy(xpath = "//div[normalize-space()='One lowercase character']") public WebElement OneLowercaseCharacter_hu;
    @FindBy(xpath = "//div[normalize-space()='One number']") public WebElement OneNumber_hu;








































































    // Mustafa Aydin (700)



































































































    // Kubra Unver (800)



































































































    // Isra Muncester (900)



































































































}