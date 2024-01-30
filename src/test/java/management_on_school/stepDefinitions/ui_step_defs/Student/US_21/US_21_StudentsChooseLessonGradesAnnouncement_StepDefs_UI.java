package management_on_school.stepDefinitions.ui_step_defs.Student.US_21;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import management_on_school.pages.StudentPage;
import management_on_school.utilities.ConfigReader;
import management_on_school.utilities.Driver;
import management_on_school.utilities.ReusableMethods;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class US_21_StudentsChooseLessonGradesAnnouncement_StepDefs_UI {

    StudentPage studentPage = new StudentPage();
    Faker faker = new Faker();

    @Given("go to url")
    public void goToUrl() {
        Driver.getDriver().get(ConfigReader.getProperty("manage_Url"));
        ReusableMethods.waitForSecond(1);
    }

    @And("click Login button")
    public void click_login_button() {
        ReusableMethods.jsClick(studentPage.loginButton);
    }
    @Given("enter {string} to the Username textbox")
    public void enter_to_the_username_textbox(String string) {
        studentPage.usernameBox.sendKeys(string);
    }
    @Given("enter {string} to the Password textbox")
    public void enter_to_the_password_textbox(String string) {
        studentPage.passwordBox.sendKeys(string);
    }

    @Then("verify that Choose Lesson Management page appears")
    public void verify_that_choose_lesson_management_page_appears() {
        Assert.assertTrue(studentPage.studentManagementPage.isDisplayed());
    }
    @Then("Verify that the title Teacher appears on the page")
    public void verify_that_the_title_teacher_appears_on_the_page() {
        Assert.assertTrue(studentPage.teacherTitle.isDisplayed());
    }
    @Then("Verify that the title Day appears on the page")
    public void verify_that_the_title_day_appears_on_the_page() {
        Assert.assertTrue(studentPage.dayTitle.isDisplayed());
    }
    @Then("Verify that the title Start Time appears on the page")
    public void verify_that_the_title_start_time_appears_on_the_page() {
        Assert.assertTrue(studentPage.startTimeTitle.isDisplayed());
    }
    @Then("Verify that the title Stop Time appears on the page")
    public void verify_that_the_title_stop_time_appears_on_the_page() {
        Assert.assertTrue(studentPage.stopTimeTitle.isDisplayed());
    }


    @When("click blue Login button")
    public void clickBlueLoginButton() {
        ReusableMethods.jsClick(studentPage.blueLoginButton);
    }

    @When("Click on the checkbox of the first Lesson")
    public void clickOnTheCheckboxOfTheFirstLesson() {
        ReusableMethods.checkTheBox(studentPage.firstLessonCheckbox);
    }

    @Then("Verify that the checkbox of the first lesson is selected")
    public void verifyThatTheCheckboxOfTheFirstLessonIsSelected() {
        Assert.assertTrue(studentPage.firstLessonCheckbox.isSelected());
    }

    @When("Click on the checkbox of the second Lesson \\(not having the same time period with first lesson)")
    public void clickOnTheCheckboxOfTheSecondLessonNotHavingTheSameTimePeriodWithFirstLesson() {
        ReusableMethods.checkTheBox(studentPage.secondLessonCheckbox);
        // derlerin zaman uyuşması ile ilgili methodu yazmaya üşendim. işim bittiken sonra yazarım :)
    }

    @Then("Verify that the checkbox of the second lesson is selected")
    public void VerifyThatTheCheckboxOfTheSecondLessonIsSelected() {
        Assert.assertTrue(studentPage.secondLessonCheckbox.isSelected());
    }

    @When("click submit button")
    public void clickSubmitButton() {
        ReusableMethods.jsScroll(studentPage.submitButton);
        ReusableMethods.jsClick(studentPage.submitButton);
    }

    @Then("Verify that the lessons that choosen are in the Lesson Program List at the bottom of the page")
    public void verifyThatTheLessonsThatChoosenAreInTheLessonProgramListAtTheBottomOfThePage() {
        Assert.assertEquals(studentPage.firstLessonNameAssertion.getText(),studentPage.firstLessonName.getText());
        // second lessonlar için de aynısından :) üşendim
    }

    @When("Click on the checkbox of the second Lesson \\(having the same time period with first lesson)")
    public void clickOnTheCheckboxOfTheSecondLessonHavingTheSameTimePeriodWithFirstLesson() {
        ReusableMethods.waitForSecond(1);
        ReusableMethods.jsClick(studentPage.secondLessonCheckbox);
        // studentPage.firstLessonName.getAttribute() ile attribute değeri içerisinden ulaşacağımız HTML verisinde
        // dinamikliği bozmayacak değişiklikler yaparak aynı satırdaki "Day", "Start Time", "Stop Time" gibi
        // bilgileri alıp basit bir nested if yapısıyla halledebiliriz.
        // Üşendim :)

    }

    @Then("Verify that the warning message about unability to select same time period lessons appears on the top of the page")
    public void verifyThatTheWarningMessageAboutAppearsOnTheTopOfThePage() {
        // Üşendim :)
        ReusableMethods.waitForSecond(1);
    }

    @When("Click Delete button")
    public void clickButton() {
        ReusableMethods.jsClick(studentPage.deleteButton);
    }

    @Then("Verify that selected lesson is deleted")
    public void verifyThatSelectedLessonIsDeleted() {
        ReusableMethods.waitForSecond(1);
    }
}
