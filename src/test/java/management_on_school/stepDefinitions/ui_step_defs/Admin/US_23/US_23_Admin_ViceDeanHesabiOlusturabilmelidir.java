package management_on_school.stepDefinitions.ui_step_defs.Admin.US_23;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import management_on_school.pages.AdminPage;
import management_on_school.pages.ViceDeanPage;
import management_on_school.utilities.ConfigReader;
import management_on_school.utilities.Driver;
import management_on_school.utilities.ReusableMethods;
import org.junit.Assert;

import java.sql.ResultSet;

public class US_23_Admin_ViceDeanHesabiOlusturabilmelidir {
    AdminPage adminPage = new AdminPage();
    ResultSet resultSet;
    ViceDeanPage viceDeanPage = new ViceDeanPage();
    Faker faker = new Faker();
    Response response;

    String name;
    static int userId;

    @Given("The website is visited")
    public void Thewebsiteisvisited() {
        Driver.getDriver().get(ConfigReader.getProperty("manage_Url"));
    }

    @When("click Login")
    public void clickLogin() {
        adminPage.adminloginLinkYakup.click();
    }

    @And("enter username")
    public void enterusername() {
        adminPage.adminusernameBoxYakup.sendKeys(ConfigReader.getProperty("admin_username"));

    }

    @And("enter password")
    public void enterpassword() {
        adminPage.adminpasswordBoxYakup.sendKeys(ConfigReader.getProperty("admin_password"));
    }

    @And("click Login Button")
    public void clickLoginButton() {
        adminPage.adminloginButtonYakup.click();
    }


    @And("Enters {string} into the name field")
    public void Entersintothenamefield(String str) {
        name = faker.name().firstName();
        if (str.equals("bir isim")) {
            adminPage.adminNameYakup.sendKeys(name);
        } else {
            adminPage.adminNameYakup.sendKeys(str);
        }
    }

    @And("Enters {string} into the surname field")
    public void Entersintothesurnamefield(String str) {
        String surname = faker.name().lastName();
        if (str.equals("bir soyisim")) {
            adminPage.adminsurnameYakup.sendKeys(surname);
        } else {
            adminPage.adminsurnameYakup.sendKeys(str);
        }
    }

    @And("Enters {string} into the birthplace field")
    public void Entersintothebithplacefield(String str) {
        String birthPlace = faker.lorem().word();
        if (str.equals("bir yer isim")) {
            adminPage.adminbirthPlaceYakup.sendKeys(birthPlace);
        } else  {
            adminPage.adminbirthPlaceYakup.sendKeys(str);
            ReusableMethods.waitForSecond(2);
        }
    }

    @And("Select {string} options")
    public void selectgender(String str) {
        String gender = "";
        if (str.equalsIgnoreCase("FEMALE")) {
            adminPage.admingenderFemaleYakup.click();
            gender = "FEMALE";
        } else if (str.equalsIgnoreCase("MALE")) {
            adminPage.admingenderFemaleYakup.click();
            gender = "MALE";
        } else {
            System.out.println("Hatalı veri girdiniz.");
        }
        ReusableMethods.waitForSecond(2);
    }

    @And("Enters {string} into the dateOfBirth field")
    public void entersDateOfBirth(String tarih) {
        adminPage.adminbirthDayYakup.sendKeys(tarih);
        ReusableMethods.waitForSecond(2);
    }

    @And("Enters {string} into the phone field")
    public void entersPhoneField(String str) {
        if (str.equals("bir telefon numarasi")) {
            String ListPhoneNo = faker.regexify("[0-9]{3}-[0-9]{3}-[0-9]{4}");
            adminPage.adminphoneNumberYakup.sendKeys(ListPhoneNo);
        } else {
            adminPage.adminphoneNumberYakup.sendKeys(str);
        }
    }

    public static String ListSSNNo;
    @And("Enters {string} into the SSN field")
    public void enterSSN(String ssn) {
        if (ssn.equals("bir ssn numarasi")) {
            ListSSNNo = faker.regexify("[0-8]{3}-[0-9]{2}-[0-9]{4}");
            adminPage.adminssnYakup.sendKeys(ListSSNNo);
        } else {
            adminPage.adminssnYakup.sendKeys(ssn);
        }
        ReusableMethods.waitForSecond(2);
    }

    @And("Enters {string} into the username field")
    public void enterUsername(String str) {
        String username = faker.random().nextInt(1000,9999)+ "ali";
        if (str.equals("bir kullanici adi")) {
            adminPage.adminusernameYakup.sendKeys(username);
        } else {
            adminPage.adminusernameYakup.sendKeys(str);
        }
    }

    @And("Enter passwords into the password field")
    public void enterPassword() {
        adminPage.adminPasswordYakup.sendKeys("12345678Aa");
    }

    @And("click the Submit Button")
    public void clickSubmitButton()  {
        adminPage.adminSubmitYakup.click();
        ReusableMethods.waitForSecond(2);
    }

    @Then("Vice Dean confirmed")
    public void ViceDeanConfirmed() {
        Assert.assertTrue(adminPage.adminSavedPopUpYakup.isDisplayed());
    }


    @And("Name field is empty")
    public void nameFieldIsEmpty() {
        adminPage.adminNameYakup.sendKeys("");
    }

    @And("Surname field is empty")
    public void surnameFieldIsEmpty() {
        adminPage.adminsurnameYakup.sendKeys("");
    }

    @And("BirthPlace field is empty")
    public void birthPlaceFieldIsEmpty() {
        adminPage.adminbirthPlaceYakup.sendKeys("");
    }

    @And("Gender box is not selected")
    public void genderBoxIsNotSelected() {
        if (adminPage.admingenderMaleYakup.isSelected()) {
            adminPage.admingenderMaleYakup.click(); // Eğer seçili ise, tıklama ile seçimini kaldır
        }
    }

    @And("DateOfBirth field is empty")
    public void dateOfBirthFieldIsEmpty() {
        adminPage.adminbirthDayYakup.sendKeys("");
    }

    @And("Phone field is empty")
    public void phoneFieldIsEmpty() {
        adminPage.adminphoneNumberYakup.sendKeys("");
    }

    @And("SSN field is empty")
    public void ssnFieldIsEmpty() {
        adminPage.adminssnYakup.sendKeys("");
    }

    @And("Username field is empty")
    public void usernameFieldIsEmpty() {
        adminPage.adminusernameYakup.sendKeys("");
    }

    @And("Password field is empty")
    public void passwordFieldIsEmpty() {
        adminPage.adminPasswordYakup.sendKeys("");
    }


    @Then("Vice Dean record has not been created")
    public void ViceDeanRecordHasNotBeenCreated() {
        if (!adminPage.adminSubmitYakup.isEnabled()) {
            System.out.println("Vice Dean Cannot Created");
        }
    }

}
