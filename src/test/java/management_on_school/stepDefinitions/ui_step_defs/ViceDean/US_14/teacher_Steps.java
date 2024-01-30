package management_on_school.stepDefinitions.ui_step_defs.ViceDean.US_14;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import management_on_school.pages.TeacherPage;
import management_on_school.utilities.ReusableMethods;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class teacher_Steps {;

    TeacherPage teacherPage = new TeacherPage();
    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();

    @And("User clicks on menu button")
    public void User_clicks_on_menu_button(){
        teacherPage.menuButtonKubraC.click();
    }
    @And("User clicks on Teacher management button")
    public void User_clicks_on_Teacher_button(){
        teacherPage.teacherManagementButtonKubraC.click();
    }
    @Then("User should see teacher list")
    public void User_should_see_teacher_list(){
        ReusableMethods.waitForVisibleElement(teacherPage.teacherListKubraC, 2);
        Assert.assertTrue("öğretmen listesi bulunamadı", teacherPage.teacherListKubraC.isDisplayed());
    }
    @And("User clicks on edit button")
    public void User_clicks_on_edit_button(){
        ReusableMethods.waitForVisibleElement(teacherPage.teacherEditButtonKubraC, 2);
        ReusableMethods.jsClick(teacherPage.teacherEditButtonKubraC);
    }


    @And("User update the teacher's lesson")
    public void userUpdateTheTeacherSInformation() {
        ReusableMethods.waitForVisibleElement(teacherPage.updateTeachLessonKubraC, 2);
        teacherPage.updateTeachLessonKubraC.click();
        teacherPage.updateTeachLessonKubraC.sendKeys("OOP" + Keys.ENTER);
    }
    @And("User enters name in the box")
    public void userEntersNameInTheBox() {
        ReusableMethods.jsCleanBy(teacherPage.nameKubraC);
        teacherPage.nameKubraC.sendKeys(firstName);
    }
    @And("User enters null name in the box")
    public void userEntersNullNameInTheBox() {
        int size = teacherPage.nameKubraC.getAttribute("value").length();
        for (int i = 0; i < size; i++) {
            teacherPage.nameKubraC.sendKeys(Keys.BACK_SPACE);
        }
    }
    @And("User enters surName  in the box")
    public void userEntersSurNameInTheBox() {
        teacherPage.surNameKubraC.click();
        ReusableMethods.jsCleanBy(teacherPage.surNameKubraC);
        teacherPage.surNameKubraC.sendKeys(lastName);
    }
    @And("User enters birthPlace in the box")
    public void userEntersBirthPlaceInTheBox() {
        teacherPage.birthPlaceKubraC.click();
        ReusableMethods.jsCleanBy(teacherPage.birthPlaceKubraC);
        teacherPage.birthPlaceKubraC.sendKeys("ANKARA");
    }
    @And("User enters email in the box")
    public void userEntersEmailInTheBox() {
        teacherPage.emailKubraC.click();
        ReusableMethods.jsCleanBy(teacherPage.emailKubraC);
        teacherPage.emailKubraC.sendKeys(faker.internet().emailAddress());
    }
    @And("User enters null email in the box")
    public void userEntersNullEmailInTheBox() {
        int size = teacherPage.emailKubraC.getAttribute("value").length();
        for (int i = 0; i < size; i++) {
            teacherPage.emailKubraC.sendKeys(Keys.BACK_SPACE);
        }
    }
    @And("User enters phone in the box")
    public void userEntersPhoneInTheBox() {
        teacherPage.phoneNumberKubraC.click();
        ReusableMethods.jsCleanBy(teacherPage.phoneNumberKubraC);
        teacherPage.phoneNumberKubraC.sendKeys(faker.regexify("[0-9]{3}-[0-9]{3}-[0-9]{4}"));
    }
    @And("User enters SSN in the box")
    public void userEntersSSNInTheBox() {
        teacherPage.ssnBoxKubraC.click();
        ReusableMethods.jsCleanBy(teacherPage.ssnBoxKubraC);
        teacherPage.ssnBoxKubraC.sendKeys(faker.regexify("[0-9]{3}-[0-9]{2}-[0-9]{4}"));
    }
    @And("User enters is Advisor")
    public void userEntersIsAdvisor() {
        teacherPage.isAdvisorTeacherKubraC.click();
    }
    @And("User enters gender {string}")
    public void userEntersGender(String gender) {
        String gen = "";
        if (gender.equalsIgnoreCase("FEMALE")) {
            teacherPage.femaleButtonKubraC.click();
            gen = "FEMALE";
        } else if (gender.equalsIgnoreCase("MALE")) {
            teacherPage.maleButtonKubraC.click();
            gen = "MALE";
        } else {
            System.out.println("You entered incorrect data");
        }
        ReusableMethods.waitForSecond(1);
    }
    @And("User enters dateOfBirth in the box {string}")
    public void userEntersDateOfBirthInTheBox(String date) {
        teacherPage.birthDayKubraC.sendKeys(date);
        ReusableMethods.waitForSecond(1);
    }
    @And("User enters userName")
    public void userEntersUserName() {
        teacherPage.usernameBoxKubraC.click();
        ReusableMethods.jsCleanBy(teacherPage.usernameBoxKubraC);
        teacherPage.usernameBoxKubraC.sendKeys(firstName.toLowerCase() + "." + lastName.toLowerCase());
    }
    @And("User enters password in the password box")
    public void userEntersPasswordInThePasswordBox() {
        teacherPage.passwordBoxKubraC.sendKeys("Ab" + faker.internet().password());
    }
    @And("User enters clicks the submit button")
    public void userEntersClicksTheSubmitButton() {
        teacherPage.submitButtonKubraC.click();
    }
}
