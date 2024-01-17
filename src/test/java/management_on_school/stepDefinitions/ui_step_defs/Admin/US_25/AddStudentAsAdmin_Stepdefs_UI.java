package management_on_school.stepDefinitions.ui_step_defs.Admin.US_25;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import management_on_school.pages.AdminPage;
import management_on_school.utilities.Driver;
import management_on_school.utilities.ReusableMethods;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertTrue;

public class AddStudentAsAdmin_Stepdefs_UI {
    AdminPage adminPage=new AdminPage();
    Faker faker=new Faker();
    Actions actions=new Actions(Driver.getDriver());

    String name;
    String password;

    @Given("Navigate to web site and Login as Admin.")
    public void navigateToWebSiteAndLoginAsAdmin() {
        adminPage.performLoginAdmin();

    }

    @And("Click on Menu Button and select Student Management from Main Menu")
    public void clickOnMenuButtonAndSelectStudentManagementFromMainMenu() {
        ReusableMethods.waitForSecond(5);
        adminPage.PageMenuButtonAdST.click();
        ReusableMethods.waitForSecond(5);
        adminPage.mainMenuStudentManagementButtonAdST.click();
        ReusableMethods.waitForSecond(3);
    }

    @And("Advisor Teacher should be Selected.")
    public void advisorTeacherShouldBeSelected() {
        Select select = new Select(adminPage.advisorTeacherDropDownButtonAdST);
        select.selectByVisibleText("AllrightBigman Yoloten");
    }

    @When("Enters {string} in Name Field.")
    public void entersInNameField(String str) {
        name = faker.name().firstName();
        if (str.equals("Ali")) {
            adminPage.studentMngNamenBoxAdST.sendKeys(name);
        } else {
            adminPage.studentMngNamenBoxAdST.sendKeys(str);
        }
    }

    @And("Enters {string} in the SurName Field.")
    public void entersInTheSurNameField(String str) {
        String surname = faker.name().lastName();
        if (str.equals("Yılmaz")) {
            adminPage.studentMngSurnamenBoxAdST.sendKeys(surname);
        } else {
            adminPage.studentMngSurnamenBoxAdST.sendKeys(str);
        }
    }

    @And("Enters {string} in BirthPlace Field.")
    public void entersInBirthPlaceField(String str) {
        String bPlace = faker.lorem().word();
        if (str.equals("İstanbul")) {
            adminPage.studentMngBPlaceBoxAdST.sendKeys(bPlace);
        } else {
            adminPage.studentMngBPlaceBoxAdST.sendKeys(str);
        }
    }

    @And("Enters {string} in email Field")
    public void entersInEmailField(String str) {
        String email = faker.internet().emailAddress();
        if (str.equals("murry@gmail.com")) {
            adminPage.studentMngemailBoxAdST.sendKeys(email);
        } else {
            adminPage.studentMngemailBoxAdST.sendKeys(str);
        }
    }

    @And("Enters {string} in phone Field.")
    public void entersInPhoneField(String str) {
        String phone = faker.regexify("[0-9]{3}-[0-9]{3}-[0-9]{4}");
        if (str.equals("a phone number")) {
            adminPage.studentMngPhoneBoxAdST.sendKeys(phone);
        } else {
            adminPage.studentMngPhoneBoxAdST.sendKeys(str);
        }
    }

    @And("Select Checkbox {string}.")
    public void selectCheckbox(String str) {
        String gender = "";
        if (str.equalsIgnoreCase("FEMALE")) {
            adminPage.studentMngGenderFeMaleButtonAdST.click();
            gender = "FEMALE";
        } else if (str.equalsIgnoreCase("MALE")) {
            adminPage.studentMngGenderMaleButtonAdST.click();
            gender = "MALE";
        } else {
            System.out.println("Hatalı veri girdiniz.");
        }
        ReusableMethods.waitForSecond(2);
    }

    @And("Enters {string} in DateOfBirth Field.")
    public void entersInDateOfBirthField(String date) {
        adminPage.studentMngBirthdayBoxAdST.sendKeys(date);
        ReusableMethods.waitForSecond(2);
    }
    public static String ListSSNNo;
    @And("Enters {string} in SSN Field.")
    public void entersInSSNField(String ssn) {
        if (ssn.equals("an ssn number")) {
            ListSSNNo = faker.regexify("[0-8]{3}-[0-9]{2}-[0-9]{4}");
            adminPage.studentMngSsnBoxAdST.sendKeys(ListSSNNo);
        } else {
            adminPage.studentMngSsnBoxAdST.sendKeys(ssn);
        }
        ReusableMethods.waitForSecond(2);
    }

    @And("Enters {string} in UserName Field.")
    public void entersInUserNameField(String str) {
        String username = faker.random().nextInt(1000, 9999) + "momento";
        if (str.equals("a user name")) {
            adminPage.studentMngUserNameBoxAdST.sendKeys(username);
        } else {
            adminPage.studentMngUserNameBoxAdST.sendKeys(str);
        }
    }

    @And("Enters {string} in Father Name Field.")
    public void entersInFatherNameField(String str) {
        String fatherName = faker.name().firstName();
        if (str.equals("Father")) {
            adminPage.studentMngFatherNameBoxAdST.sendKeys(fatherName);
        } else {
            adminPage.studentMngFatherNameBoxAdST.sendKeys(str);
        }
    }

    @And("Enters {string} in Mother Name Field.")
    public void entersInMotherNameField(String str) {
        String motherName = faker.name().firstName();
        if (str.equals("Mother")) {
            adminPage.studentMngMotherNameBoxAdST.sendKeys(motherName);
        } else {
            adminPage.studentMngMotherNameBoxAdST.sendKeys(str);
        }
    }

    @And("Enters password in Password Field.")
    public void entersPasswordInPasswordField() {
        adminPage.studentMngPasswordBoxAdST.sendKeys("Baba12345");
    }

    @And("Click Submit Button.")
    public void clickSubmitButton() {
        adminPage.studentMngSubmitButtonAdST.click();
    }

    @Then("Verify that student can be Registered as Admin")
    public void verifyThatStudentCanBeRegisteredAsAdmin() {
        ReusableMethods.waitForVisibleElement(adminPage.studentMngSuccessfullyAdST, 5);
        assertTrue(adminPage.studentMngSuccessfullyAdST.isDisplayed());
    }

    @And("Close Page.")
    public void closePage() {
        Driver.closeDriver();
    }

    @When("Leave blank in Name field.")
    public void leaveBlankInNameField() {
        adminPage.studentMngNamenBoxAdST.sendKeys("");
    }

    @Then("Verify that student registration is not completed.")
    public void verifyThatStudentRegistrationIsNotCompleted() {
        Assert.assertTrue(adminPage.studentMngNameRequiredTesxtAdST.isDisplayed());
    }

    @And("Enters invalid email adress in E-mail Field")
    public void entersInvalidEmailAdressInEMailField() {
        String email = faker.lorem().word()+"@gmailcom";

        adminPage.studentMngemailBoxAdST.sendKeys(email);

    }

    @Then("Verify that student registration cannot be created with an invalid email.")
    public void verifyThatStudentRegistrationCannotBeCreatedWithAnInvalidEmail() {
        Assert.assertTrue(adminPage.studentMngPleaseEnterValidEmailTesxtAdST.isDisplayed());
    }

    @Then("Verify that student registiration cannot be formed without gender selection.")
    public void verifyThatStudentRegistirationCannotBeFormedWithoutGenderSelection() {
        ReusableMethods.waitForVisibleElement(adminPage.studentMngGenderIvalidValueTesxtAdST, 5);
        assertTrue(adminPage.studentMngGenderIvalidValueTesxtAdST.isDisplayed());
    }

    @Then("Verify that student registiration cannot be formed without entering a valid SSN selection.")
    public void verifyThatStudentRegistirationCannotBeFormedWithoutEnteringAValidSSNSelection() {
        ReusableMethods.waitForVisibleElement(adminPage.studentMngSsnInvalidValueTextAdST, 3);
        assertTrue(adminPage.studentMngSsnInvalidValueTextAdST.isDisplayed());
    }

    @Then("Verify that student registration cannot be created by leaving user name field blank.")
    public void verifyThatStudentRegistrationCannotBeCreatedByLeavingUserNameFieldBlank() {
        ReusableMethods.waitForSecond(3);
        assertTrue(adminPage.studentMngUserNameInvalidValueTextAdST.isDisplayed());
    }

    @And("{string} Fill the field enters a password of less than eight characters, no uppercase or lowercase letters, no numbers.")
    public void fillTheFieldEntersAPasswordOfLessThanEightCharactersNoUppercaseOrLowercaseLettersNoNumbers(String str) {
        adminPage.studentMngPasswordBoxAdST
                .sendKeys(str);
        password = str;
    }

    @Then("Verify that a student registiration cannot be successfully created with invalid passwords entered")
    public void verifyThatAStudentRegistirationCannotBeSuccessfullyCreatedWithInvalidPasswordsEntered() {
        ReusableMethods.waitForSecond(2);
        if (password.length() < 8) {
            assertTrue(adminPage.studentMngPas8CaharcterInvalidValueTextAdST.getText().contains("At least 8 characters"));
            ReusableMethods.waitForSecond(2);
        }
        if (password.replaceAll("[^A-Z]", "").length() == 0) {
            assertTrue(adminPage.studentMngPasUpperCaseInvalidValueTextAdST.getText().contains("One uppercase character"));
            ReusableMethods.waitForSecond(2);
        }
        if (password.replaceAll("[^a-z]", "").length() == 0) {
            assertTrue(adminPage.studentMngPasLowerCaseInvalidValueTextAdST.getText().contains("One lowercase character"));
            ReusableMethods.waitForSecond(2);
        }
        if (password.replaceAll("[^0-9]", "").length() == 0) {
            assertTrue(adminPage.studentMngPasOneNumberInvalidValueTextAdST.getText().contains("One number"));
            ReusableMethods.waitForSecond(2);

        }
    }
}
