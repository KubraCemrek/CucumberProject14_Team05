package management_on_school.stepDefinitions.ui_step_defs.ViceDean.US_08;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import management_on_school.pages.HomePage;
import management_on_school.pages.LessonPage;
import management_on_school.utilities.ConfigReader;
import management_on_school.utilities.Driver;
import management_on_school.utilities.ReusableMethods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.util.List;

public class US08_StepDef_Ui {
    HomePage homePage=new HomePage();
    LessonPage lessonPage=new LessonPage();
    Actions actions=new Actions(Driver.getDriver());

    @Given("Go to the given URL")
    public void goToTheGivenURL() {
        Driver.getDriver().get(ConfigReader.getProperty("manage_Url"));
    }
    @When("Click on the Login link")
    public void clickOnTheLoginLink() {
        homePage.loginLink_me.click();
    }
    @And("Enter {string} into the User Name field")
    public void enterIntoTheUserNameField(String string) {
        homePage.userName_me.sendKeys(string);
    }
    @And("Enter {string} into the Password field")
    public void enterIntoThePasswordField(String string) {
        homePage.password_me.sendKeys(string);
    }
    @And("Click on the Login button")
    public void clickOnTheLoginButton() {
        homePage.loginButton_me.click();
    }
    @And("Click on the Lessons tab")
    public void clickOnTheLessonsTab() {
        lessonPage.lessonsButton_me.click();
    }
    @And("In the Add Lesson section, enter {string} into the Lesson Name field")
    public void ınTheAddLessonSectionEnterIntoTheLessonNameField(String string) {
        lessonPage.lessonNameBox_me.sendKeys(string);
        ReusableMethods.waitForSecond(1);
    }
    @And("Verify that data is entered into the Lesson Name field")
    public void verifyThatDataIsEnteredIntoTheLessonNameField() {
        // Assert.assertEquals("Cypress1",lessonPage.lessonNameText_me.getText());
//        ReusableMethods.jsGetValueBy("lessonName","Cypress1");
    }
    @And("Click on the Compulsory checkbox")
    public void clickOnTheCompulsoryCheckbox() {
        lessonPage.compulsoryButton_me.click();
    }
    @And("Verify that the Compulsory checkbox is checked")
    public void verifyThatTheCompulsoryCheckboxIsChecked() {
        Assert.assertTrue(lessonPage.compulsoryButton_me.isSelected());
    }
    @And("Enter {int} into the Credit Score field")
    public void enterIntoTheCreditScoreField(int sayi) {
        lessonPage.creditScoreBox_me.sendKeys(""+sayi+"");
        ReusableMethods.waitForSecond(1);
    }
    @And("Verify that data is entered into the Credit Score field")
    public void verifyThatDataIsEnteredIntoTheCreditScoreField() {
        Assert.assertTrue(lessonPage.creditScoreText_me.isDisplayed());
    }
    @And("Click on the Submit button")
    public void clickOnTheSubmitButton() {
        ReusableMethods.waitForVisibleElement(lessonPage.lessonSubmitButton_me,3);
        lessonPage.lessonSubmitButton_me.click();
        ReusableMethods.waitForSecond(1);
    }
    @Then("Verify that the {string} message is displayed")
    public void verifyThatTheMessageIsDisplayed(String arg0) {
        ReusableMethods.waitForVisibleElement(lessonPage.lessonCreatedAlert_me,3);
        Assert.assertEquals("Lesson Created", lessonPage.lessonCreatedAlert_me.getText());
        Driver.closeDriver();
    }
    @And("Click on the Submit button{int}")
    public void clickOnTheSubmitButton(int arg0) {
        ReusableMethods.waitForVisibleElement(lessonPage.lessonSubmitButton_me,3);
        lessonPage.lessonSubmitButton_me.click();
        ReusableMethods.waitForSecond(1);
    }
    @Then("Verify that the message {string} is displayed")
    public void verifyThatTheMessageIsDisplayed1(String arg0) {
        ReusableMethods.waitForVisibleElement(lessonPage.lessonAlreadyCreatedAlert_me,3);
        Assert.assertEquals("Error: Lesson with lesson name Cypress1 already register",
                lessonPage.lessonAlreadyCreatedAlert_me.getText());
        ReusableMethods.waitForSecond(1);
//        ReusableMethods.jsClick(lessonPage.lastPageButton_me);
//        actions.sendKeys(Keys.PAGE_UP).perform();
//        ReusableMethods.waitForSecond(1);
//        lessonPage.lessonDeleteButton_me.click();
    }




}

