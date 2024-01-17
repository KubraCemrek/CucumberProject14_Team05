package management_on_school.stepDefinitions.ui_step_defs.ViceDean.US_15;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import management_on_school.pages.ViceDeanPage;
import management_on_school.utilities.ConfigReader;
import management_on_school.utilities.Driver;
import management_on_school.utilities.ReusableMethods;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertTrue;

public class AddStudentAsViceDean_StepDef_UI {
    ViceDeanPage salihPage=new ViceDeanPage();
    Faker faker = new Faker();
    Actions actions = new Actions(Driver.getDriver());
    String name;
    String password;


    @Given("Navigate to web site and Login as Vice Dean")
    public void navigatetowebsiteandLoginasViceDeanr() {
        Driver.getDriver().get(ConfigReader.getProperty("manage_Url"));

        salihPage.performLoginVD();
    }

    @And("Click on Menu button and select Student Management from Main Menu.")
    public void menuButonunaTilanirVeSolTarafdaAcilanMainMenudenStudentManagementSeceneğineTiklanir() {
        salihPage.PageMenuButtonVD_ST.click();
        salihPage.mainMenuStudentManagementButtonVD_ST.click();

    }

    @And("Advisor Teacher should be selected.")
    public void öğrecininDanışmanÖğretmeniSeçilmelidir() {
        Select select = new Select(salihPage.advisorTeacherDropDownButtonVD_ST);
        select.selectByVisibleText("AllrightBigman Yoloten");
    }

    @When("Enters {string} in the Name field")
    public void nameKutusunaGirer(String str) {
        name = faker.name().firstName();
        if (str.equals("Ali")) {
            salihPage.studentMngNamenBoxVD_ST.sendKeys(name);
        } else {
            salihPage.studentMngNamenBoxVD_ST.sendKeys(str);
        }
    }

    @And("Enters {string} in the SurName field")
    public void surnameKutusunaGirer(String str) {
        String surname = faker.name().lastName();
        if (str.equals("Yılmaz")) {
            salihPage.studentMngSurnamenBoxVD_ST.sendKeys(surname);
        } else {
            salihPage.studentMngSurnamenBoxVD_ST.sendKeys(str);
        }
    }

    @And("Enters {string} in BirthPlace field")
    public void birthplaceKutusunaGirer(String str) {
        String bPlace = faker.lorem().word();
        if (str.equals("İstanbul")) {
            salihPage.studentMngBPlaceBoxVD_ST.sendKeys(bPlace);
        } else {
            salihPage.studentMngBPlaceBoxVD_ST.sendKeys(str);
        }
    }

    @And("Enters {string} in email field.")
    public void eMailKutusunaGirer(String str) {
        String email = faker.internet().emailAddress();
        if (str.equals("murry@gmail.com")) {
            salihPage.studentMngemailBoxVD_ST.sendKeys(email);
        } else {
            salihPage.studentMngemailBoxVD_ST.sendKeys(str);
        }
    }

    @And("Enters {string} in phone field")
    public void phoneKutusunaGirer(String str) {
        String phone = faker.regexify("[0-9]{3}-[0-9]{3}-[0-9]{4}");
        if (str.equals("a phone number")) {
            salihPage.studentMngPhoneBoxVD_ST.sendKeys(phone);
        } else {
            salihPage.studentMngPhoneBoxVD_ST.sendKeys(str);
        }

    }

    @And("Select checkbox {string}")
    public void genderSeceneginiGirer(String str) {

        String gender = "";
        if (str.equalsIgnoreCase("FEMALE")) {
            salihPage.studentMngGenderFeMaleButtonVD_ST.click();
            gender = "FEMALE";
        } else if (str.equalsIgnoreCase("MALE")) {
            salihPage.studentMngGenderMaleButtonVD_ST.click();
            gender = "MALE";
        } else {
            System.out.println("Hatalı veri girdiniz.");
        }
        ReusableMethods.waitForSecond(2);
    }

    @And("Enters {string} in DateOfBirth field")
    public void dateofbirthKutusunaGirer(String date) {
        salihPage.studentMngBirthdayBoxVD_ST.sendKeys(date);
        ReusableMethods.waitForSecond(2);

    }

    public static String ListSSNNo;

    @And("Enters {string} in SSN field")
    public void ssnKutusunaGirer(String ssn) {
        if (ssn.equals("an ssn number")) {
            ListSSNNo = faker.regexify("[0-8]{3}-[0-9]{2}-[0-9]{4}");
            salihPage.studentMngSsnBoxVD_ST.sendKeys(ListSSNNo);
        } else {
            salihPage.studentMngSsnBoxVD_ST.sendKeys(ssn);
        }
        ReusableMethods.waitForSecond(2);
    }

    @And("Enters {string} in UserName field")
    public void usernameKutusunaGirer(String str) {
        String username = faker.random().nextInt(1000, 9999) + "momento";
        if (str.equals("a user name")) {
            salihPage.studentMngUserNameBoxVD_ST.sendKeys(username);
        } else {
            salihPage.studentMngUserNameBoxVD_ST.sendKeys(str);
        }
    }

    @And("Enters {string} in Father Name field")
    public void fatherNameKutusunaGirer(String str) {
        String fatherName = faker.name().firstName();
        if (str.equals("Father")) {
            salihPage.studentMngFatherNameBoxVD_ST.sendKeys(fatherName);
        } else {
            salihPage.studentMngFatherNameBoxVD_ST.sendKeys(str);
        }
    }

    @And("Enters {string} in Mother Name field")
    public void motherNameKutusunaGirer(String str) {
        String motherName = faker.name().firstName();
        if (str.equals("Mother")) {
            salihPage.studentMngMotherNameBoxVD_ST.sendKeys(motherName);
        } else {
            salihPage.studentMngMotherNameBoxVD_ST.sendKeys(str);
        }
    }

    @And("Enters password in Password field")
    public void passwordKutusunaSifreGirer() {
        salihPage.studentMngPasswordBoxVD_ST.sendKeys("Baba12345");

    }

    @And("Click Submit button")
    public void submitButonunaTiklar() {

        salihPage.studentMngSubmitButtonVD_ST.click();
    }

    @Then("Verify that student can be registered as Vice Dean")
    public void ogrenciOlşturuldugunuDogrular() {
        ReusableMethods.waitForVisibleElement(salihPage.studentMngSuccessfullyVD_ST, 5);
        Assert.assertTrue(salihPage.studentMngSuccessfullyVD_ST.isDisplayed());
    }

    @When("Leave blank in Name field")
    public void nameKutusunaBoşBirak() {
        salihPage.studentMngNamenBoxVD_ST.sendKeys("");
    }

    @And("Close Page")
    public void sayfayiKapatir() {
        Driver.closeDriver();
    }

    @Then("Verify that student registration is not completed")
    public void ogrenciOlşturulamadiginiDogrulaDogrular() {
        Assert.assertTrue(salihPage.studentMngNameRequiredTesxtVD_ST.isDisplayed());
    }


    @And("Enters invalid email adress in E-mail field")
    public void eMailKutusunaGecersizEmailGirer(String str) {
        String email = faker.lorem().word()+"@gmailcom";

            salihPage.studentMngemailBoxVD_ST.sendKeys(email);

    }

    @Then("Verify that student registration cannot be created with an invalid email")
    public void gecersizEmailIleOgrenciOlşturulamadiginiDogrular() {

        Assert.assertTrue(salihPage.studentMngPleaseEnterValidEmailTesxtVD_ST.isDisplayed());
    }

    @Then("Verify that student registiration cannot be formed without gender selection")
    public void genderSecilmedenOgrenciOlşturulamadiginiDogrular() {
        ReusableMethods.waitForVisibleElement(salihPage.studentMngGenderIvalidValueTesxtVD_ST, 5);
        Assert.assertTrue(salihPage.studentMngGenderIvalidValueTesxtVD_ST.isDisplayed());
    }

    @Then("Verify that student registiration cannot be formed without entering a valid SSN selection")
    public void gecerliSsnGirmedenOgrenciOlşturulamadiginiDogrular() {
        ReusableMethods.waitForVisibleElement(salihPage.studentMngSsnInvalidValueTextVD_ST, 3);
        Assert.assertTrue(salihPage.studentMngSsnInvalidValueTextVD_ST.isDisplayed());
    }

    @Then("Verify that student registration cannot be created by leaving user name field blank")
    public void usernameKutusuBosBirakilarakOgrenciOlşturulamadiginiDogrular() {
        ReusableMethods.waitForVisibleElement(salihPage.studentMngUserNameInvalidValueTextVD_ST, 3);
        Assert.assertTrue(salihPage.studentMngUserNameInvalidValueTextVD_ST.isDisplayed());
    }

    @And("{string} Fill the field enters a password of less than eight characters, no uppercase or lowercase letters, no numbers")
    public void alaninaSekizKarakterdenAzBuyukHarfVeyaKucukkHarfOlmadanRakamOlmadanPasswordGirer(String str) {

        salihPage.studentMngPasswordBoxVD_ST.sendKeys(str);
        password = str;
    }

    @Then("verify that a student registiration cannot be successfully created with invalid passwords entered")
    public void yanlişGirilenPasswordlarDolaysiylaUyarilarAlarakOgrenciOlşturulamadiginiDogrular() {
        ReusableMethods.waitForSecond(2);
        if (password.length() < 8) {
            assertTrue(salihPage.studentMngPas8CaharcterInvalidValueTextVD_ST.getText().contains("At least 8 characters"));
            ReusableMethods.waitForSecond(2);
        }
        if (password.replaceAll("[^A-Z]", "").length() == 0) {
            assertTrue(salihPage.studentMngPasUpperCaseInvalidValueTextVD_ST.getText().contains("One uppercase character"));
            ReusableMethods.waitForSecond(2);
        }
        if (password.replaceAll("[^a-z]", "").length() == 0) {
            assertTrue(salihPage.studentMngPasLowerCaseInvalidValueTextVD_ST.getText().contains("One lowercase character"));
            ReusableMethods.waitForSecond(2);
        }
        if (password.replaceAll("[^0-9]", "").length() == 0) {
            assertTrue(salihPage.studentMngPasOneNumberInvalidValueTextVD_ST.getText().contains("One number"));
            ReusableMethods.waitForSecond(2);

        }
    }
}
