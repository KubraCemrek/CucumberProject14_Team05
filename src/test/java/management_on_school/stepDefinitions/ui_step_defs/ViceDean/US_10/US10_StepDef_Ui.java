package management_on_school.stepDefinitions.ui_step_defs.ViceDean.US_10;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import management_on_school.pages.LessonPage;
import management_on_school.utilities.Driver;
import management_on_school.utilities.ReusableMethods;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class US10_StepDef_Ui {
    LessonPage lessonPage=new LessonPage();
    Actions actions=new Actions(Driver.getDriver());
    @When("Click on the Lesson Program tab")
    public void click_on_the_lesson_program_tab() {
        lessonPage.lessonProgramButton_me.click();

    }
    @When("Choose a lesson from the Choose Lessons menu")
    public void choose_a_lesson_from_the_choose_lessons_menu() {
        lessonPage.chooseLesson_me.click();
        actions.sendKeys(Keys.ARROW_DOWN, "Cypress", Keys.ENTER, Keys.TAB).perform();
    }
    @When("Select an education term from the Choose Education Term menu")
    public void select_an_education_term_from_the_choose_education_term_menu() {
        lessonPage.educationTerm_me.click();
        actions.sendKeys(Keys.ARROW_DOWN, "FALL_SEMESTER", Keys.ENTER, Keys.TAB).perform();
    }
    @When("Select a day from the Choose Day menu")
    public void select_a_day_from_the_choose_day_menu() {
        lessonPage.chooseDay_me.click();
        actions.sendKeys(Keys.ARROW_DOWN, "MONDAY", Keys.ENTER, Keys.TAB).perform();
    }

    @When("Enter a start time in the Start Time box")
    public void enter_a_start_time_in_the_start_time_box() {
        lessonPage.startTime_me.sendKeys("6000");
    }
    @When("Enter a stop time in the Stop Time box")
    public void enter_a_stop_time_in_the_stop_time_box() {
        lessonPage.stopTime_me.sendKeys("7000");

    }

    @Then("Verify that the \"Created Lesson Program\" message is displayed.")
    public void confirm_that_the_lesson_program_has_been_created() {
        ReusableMethods.waitForVisibleElement(lessonPage.createdLProgram_me ,3);
        Assert.assertTrue(lessonPage.createdLProgram_me.isDisplayed());
    }


    @When("Leave the Choose Day menu EMPTY")
    public void leave_the_choose_day_menu_empty() {
        lessonPage.educationTerm_me.click();
        actions.sendKeys(Keys.ARROW_DOWN, "FALL_SEMESTER", Keys.ENTER, Keys.TAB,Keys.TAB).perform();
    }

    @Then("Verify that the Lesson Program is not created")
    public void verify_that_the_lesson_program_is_not_created() {
        ReusableMethods.waitForVisibleElement(lessonPage.errorMessage_me,3);
        Assert.assertTrue(lessonPage.errorMessage_me.isDisplayed());

    }

    @And("Click on the Lesson Submit button")
    public void clickOnTheLessonSubmitButton() {
        ReusableMethods.jsClick(lessonPage.lessonSubmitButton2_me);
    }
}
