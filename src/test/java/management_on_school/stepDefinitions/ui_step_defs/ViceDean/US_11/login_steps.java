package management_on_school.stepDefinitions.ui_step_defs.ViceDean.US_11;

import io.cucumber.java.en.*;
import management_on_school.pages.ViceDeanPage;
import management_on_school.utilities.*;
import org.junit.Assert;

public class login_steps {
    ViceDeanPage viceDeanPage = new ViceDeanPage();


    @Given("User enters the home page")
    public void kullaniciWebSitesineGirer() {
        Driver.getDriver().get(ConfigReader.getProperty("manage_Url"));
    }

    @When("User clicks Login_k")
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
    ReusableMethods.waitForVisibleElement(viceDeanPage.loginButtonKubraC,5);
    viceDeanPage.loginButtonKubraC.click();
}
    @Then("From Lesson Program List; Must be able to see Lesson, Day, Start Time, Stop Time.")
    public void from_lesson_program_list_must_be_able_to_see_lesson_day_start_time_stop_time() {
    viceDeanPage.lessonProgramKubraC.click();
    ReusableMethods.waitForVisibleElement(viceDeanPage.lessonProgramListKubraC,5);
    Assert.assertTrue(viceDeanPage.lessonProgramListKubraC.isDisplayed());

            }

}
