package management_on_school.stepDefinitions.ui_step_defs.ViceDean.US_12;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import management_on_school.pages.ViceDeanPage;
import management_on_school.utilities.ConfigReader;
import management_on_school.utilities.Driver;
import management_on_school.utilities.ReusableMethods;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import java.security.Key;

public class lesson_steps {

    ViceDeanPage viceDeanPage = new ViceDeanPage();

    @Given("User enters the home page")
    public void kullaniciWebSitesineGirer() {
        Driver.getDriver().get(ConfigReader.getProperty("manage_Url"));
    }

    @When("User clicks Login")
    public void kullanici_login_e_tiklar() {
        ReusableMethods.waitForVisibleElement(viceDeanPage.loginBtnHomeKubraC, 5);
        viceDeanPage.loginBtnHomeKubraC.click();
    }

    @When("User enters User Name {string}")
    public void user_enters_user_name(String userName) {
        viceDeanPage.userNameKubraC.sendKeys(userName);
    }

    @When("User enters Password {string}")
    public void user_enters_password(String password) {
        viceDeanPage.passwordKubraC.sendKeys(password);
    }

    @When("User clicks the Login button")
    public void user_clicks_the_login_button() {
        ReusableMethods.waitForVisibleElement(viceDeanPage.loginButtonKubraC, 5);
        viceDeanPage.loginButtonKubraC.click();
    }

    @When("Lesson program is selected")
    public void Lesson_program_is_selected(){
        viceDeanPage.lessonProgramKubraC.click();
}

    @When("From the Add Course section select Select Course Education Period Select Day Start Time End Time")
    public void From_the_Add_Course_section_select_Select_Course_Education_Period_Select_Day_Start_Time_End_Time(){
        viceDeanPage.chooseLessonClickKubraC.click();
        viceDeanPage.chooseLessonClickKubraC.sendKeys("Cypress" + Keys.ENTER);
        ReusableMethods.ddmIndex(viceDeanPage.eduTimeKubraC,2);
        ReusableMethods.ddmIndex(viceDeanPage.chooseDayKubraC,3);
        viceDeanPage.startTimeKubraC.sendKeys("0909AM");
        viceDeanPage.stopTimeKubraC.sendKeys("1010AM" + Keys.TAB + Keys.ENTER);
}

    @Then("User can see that the created lesson")
    public void User_can_see_that_the_created_lesson(){
        ReusableMethods.waitForVisibleElement(viceDeanPage.verifyCreatedLessonKubraC, 1);
        Assert.assertTrue("ders ekleme başarısız", viceDeanPage.verifyCreatedLessonKubraC.isDisplayed());
    }

    @When("select the new lesson")
    public void select_the_new_lesson() throws InterruptedException {
        Thread.sleep(3000);
        viceDeanPage.selectLessonKubraC.sendKeys(Keys.SPACE);
    }
    @When("select the teacher")
    public void select_the_teacher() throws InterruptedException {
        ReusableMethods.ddmIndex(viceDeanPage.selectTeacherKubraC, 3);
        Thread.sleep(3000);
    }
    @When("clicks on submit button")
    public void clicks_on_submit_button() {
        viceDeanPage.submitTeacherKubraC.click();
    }
    @Then("verify assign the lesson")
    public void verify_assign_the_lesson() {
        ReusableMethods.waitForVisibleElement(viceDeanPage.verifyAddedTeacKubraC, 1);
        Assert.assertTrue("ders ekleme başarısız", viceDeanPage.verifyAddedTeacKubraC.isDisplayed());
    }

}
