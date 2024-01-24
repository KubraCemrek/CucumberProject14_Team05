package management_on_school.stepDefinitions.ui_step_defs.Dean.US_06;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import management_on_school.pages.ViceDeanPage;
import management_on_school.utilities.ConfigReader;
import management_on_school.utilities.Driver;
import management_on_school.utilities.ReusableMethods;
import org.junit.Assert;
import java.sql.ResultSet;

public class US06_DeanShoulBeAbleToAddViceDean {
    ResultSet resultSet;
    ViceDeanPage viceDeanPage = new ViceDeanPage();
    Faker faker = new Faker();
    Response response;

    String name;
    static int userId;

    @Given("The website is visited.")
    public void Thewebsiteisvisited() {
        Driver.getDriver().get(ConfigReader.getProperty("manage_Url"));
    }

    @When("click Login.")
    public void clickLogin() {
        viceDeanPage.loginLinkYakup.click();
    }

    @And("enter username.")
    public void enterusername() {
        viceDeanPage.usernameBoxYakup.sendKeys(ConfigReader.getProperty("Dean_username"));

    }

    @And("enter password.")
    public void enterpassword() {
        viceDeanPage.passwordBoxYakup.sendKeys(ConfigReader.getProperty("Dean_password"));
    }

    @And("click Login Button.")
    public void clickLoginButton() {
        viceDeanPage.loginButtonYakup.click();
    }



    @And("Enters {string} into the name field.")
    public void Entersintothenamefield(String str) {
        name = faker.name().firstName();
        if (str.equals("bir isim")) {
            viceDeanPage.nameYakup.sendKeys(name);
        } else {
            viceDeanPage.nameYakup.sendKeys(str);
        }
    }

    @And("Enters {string} into the surname field.")
    public void Entersintothesurnamefield(String str) {
        String surname = faker.name().lastName();
        if (str.equals("bir soyisim")) {
            viceDeanPage.surnameYakup.sendKeys(surname);
        } else {
            viceDeanPage.surnameYakup.sendKeys(str);
        }
    }

    @And("Enters {string} into the birthplace field.")
    public void Entersintothebithplacefield(String str) {
        String birthPlace = faker.lorem().word();
        if (str.equals("bir yer isim")) {
            viceDeanPage.birthPlaceYakup.sendKeys(birthPlace);
        } else  {
            viceDeanPage.birthPlaceYakup.sendKeys(str);
            ReusableMethods.waitForSecond(2);
        }
    }

    @And("Select {string} options.")
    public void selectgender(String str) {
        String gender = "";
        if (str.equalsIgnoreCase("FEMALE")) {
            viceDeanPage.genderFemaleYakup.click();
            gender = "FEMALE";
        } else if (str.equalsIgnoreCase("MALE")) {
            viceDeanPage.genderMaleYakup.click();
            gender = "MALE";
        } else {
            System.out.println("Hatalı veri girdiniz.");
        }
        ReusableMethods.waitForSecond(2);
    }

    @And("Enters {string} into the dateOfBirth field.")
    public void entersDateOfBirth(String tarih) {
        viceDeanPage.birthDayYakup.sendKeys(tarih);
        ReusableMethods.waitForSecond(2);
    }

    @And("Enters {string} into the phone field.")
    public void entersPhoneField(String str) {
        if (str.equals("bir telefon numarasi")) {
            String ListPhoneNo = faker.regexify("[0-9]{3}-[0-9]{3}-[0-9]{4}");
            viceDeanPage.phoneNumberYakup.sendKeys(ListPhoneNo);
        } else {
            viceDeanPage.phoneNumberYakup.sendKeys(str);
        }
    }

    public static String ListSSNNo;
    @And("Enters {string} into the SSN field.")
    public void enterSSN(String ssn) {
        if (ssn.equals("bir ssn numarasi")) {
            ListSSNNo = faker.regexify("[0-8]{3}-[0-9]{2}-[0-9]{4}");
            viceDeanPage.ssnYakup.sendKeys(ListSSNNo);
        } else {
            viceDeanPage.ssnYakup.sendKeys(ssn);
        }
        ReusableMethods.waitForSecond(2);
    }

    @And("Enters {string} into the username field.")
    public void enterUsername(String str) {
        String username = faker.random().nextInt(1000,9999)+ "ali";
        if (str.equals("bir kullanici adi")) {
            viceDeanPage.usernameYakup.sendKeys(username);
        } else {
            viceDeanPage.usernameYakup.sendKeys(str);
        }
    }

    @And("Enter passwords into the password field.")
    public void enterPassword() {
        viceDeanPage.viceDeanPasswordYakup.sendKeys("12345678Aa");
    }

    @And("click the Submit Button.")
    public void clickSubmitButton() {
        viceDeanPage.viceDeanSubmitYakup.click();
        ReusableMethods.waitForSecond(2);
    }

    @Then("Vice Dean confirmed.")
    public void ViceDeanConfirmed() {
        Assert.assertTrue(viceDeanPage.viceDeanSavedPopUpYakup.isDisplayed());
    }


    @And("Name field is empty.")
    public void nameFieldIsEmpty() {
        viceDeanPage.nameYakup.sendKeys("");
    }

    @And("Surname field is empty.")
    public void surnameFieldIsEmpty() {
        viceDeanPage.surnameYakup.sendKeys("");
    }

    @And("BirthPlace field is empty.")
    public void birthPlaceFieldIsEmpty() {
        viceDeanPage.birthPlaceYakup.sendKeys("");
    }

    @And("Gender box is not selected.")
    public void genderBoxIsNotSelected() {
        if (viceDeanPage.genderMaleYakup.isSelected()) {
            viceDeanPage.genderMaleYakup.click(); // Eğer seçili ise, tıklama ile seçimini kaldır
        }
    }

    @And("DateOfBirth field is empty.")
    public void dateOfBirthFieldIsEmpty() {
        viceDeanPage.birthDayYakup.sendKeys("");
    }

    @And("Phone field is empty.")
    public void phoneFieldIsEmpty() {
        viceDeanPage.phoneNumberYakup.sendKeys("");
    }

    @And("SSN field is empty.")
    public void ssnFieldIsEmpty() {
        viceDeanPage.ssnYakup.sendKeys("");
    }

    @And("Username field is empty.")
    public void usernameFieldIsEmpty() {
        viceDeanPage.usernameYakup.sendKeys("");
    }

    @And("Password field is empty.")
    public void passwordFieldIsEmpty() {
        viceDeanPage.viceDeanPasswordYakup.sendKeys("");
    }


    @Then("Vice Dean record has not been created.")
    public void ViceDeanRecordHasNotBeenCreated() {
        if (!viceDeanPage.viceDeanSubmitYakup.isEnabled()) {
            System.out.println("Vice Dean Kaydi Yapilamiyor");
    }
}
}
