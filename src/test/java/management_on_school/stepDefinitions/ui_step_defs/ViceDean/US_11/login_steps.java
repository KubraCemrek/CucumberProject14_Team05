package management_on_school.stepDefinitions.ui_step_defs.ViceDean.US_11;

import io.cucumber.java.en.*;
import management_on_school.pages.ViceDeanPage;
import management_on_school.utilities.*;

public class login_steps {
    ViceDeanPage viceDeanPage = new ViceDeanPage();


    @Given("User enters the home page")
    public void kullaniciWebSitesineGirer() {
        Driver.getDriver().get(ConfigReader.getProperty("manage_Url"));
    }

    @When("User clicks Login")
    public void kullanici_login_e_tiklar() {
        System.out.println("meraba");
        ReusableMethods.waitForVisibleElement(viceDeanPage.loginBtnHomeKubraC, 5);
        viceDeanPage.loginBtnHomeKubraC.click();
    }

    @When("User enters User Name {string}")
    public void user_enters_user_name(String userName) {

    }

    @When("User enters Password {string}")
    public void user_enters_password(String password) {

    }

    @When("User clicks the Login button")
    public void user_clicks_the_login_button() {

    }

    @Then("From Lesson Program List; Must be able to see Lesson, Day, Start Time, Stop Time.")
    public void from_lesson_program_list_must_be_able_to_see_lesson_day_start_time_stop_time() {

    }
}
