package management_on_school.stepDefinitions.ui_step_defs.ViceDean.US_09;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import management_on_school.pages.LessonPage;
import management_on_school.utilities.Driver;
import management_on_school.utilities.ReusableMethods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class US09_StepDef_Ui {

    LessonPage lessonPage=new LessonPage();
    Actions actions=new Actions(Driver.getDriver());


    @Then("Verify that Lesson Name information is visible in the Lesson List section")
    public void verify_that_lesson_name_information_is_visible_in_the_lesson_list_section() {
       Assert.assertTrue(lessonPage.lessonNameVerify_me.isDisplayed());

    }
    @Then("Verify that Compulsory information is visible")
    public void verify_that_compulsory_information_is_visible() {
        Assert.assertTrue(lessonPage.compulsoryVerify_me.isDisplayed());
    }
    @Then("Verify that Credit Score information is visible")
    public void verify_that_credit_score_information_is_visible() {
        Assert.assertTrue(lessonPage.creditScoreVerify_me.isDisplayed());
    }

      @When("Click on the trash can icon for the course named {string} in the Lesson List")
    public void click_on_the_trash_can_icon_for_the_course_named_in_the_lesson_list(String string) {

        ReusableMethods.waitForSecond(1);
        ReusableMethods.jsClick(lessonPage.lastPageButton_me);
        actions.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.waitForSecond(1);
        lessonPage.lessonDeleteButton_me.click();


    }
    @Then("Verify that the Lesson Deleted message is displayed")
    public void verify_that_the_lesson_deleted_message_is_displayed() {
        ReusableMethods.waitForVisibleElement(lessonPage.lessonDeletedAlert_me,3);
        Assert.assertEquals("Lesson Deleted",
                lessonPage.lessonDeletedAlert_me.getText());
    }



}
