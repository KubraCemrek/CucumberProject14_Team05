package management_on_school.stepDefinitions.ui_step_defs.Dean.US_07;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import management_on_school.pages.AddDeanPage;
import management_on_school.utilities.ConfigReader;
import management_on_school.utilities.Driver;
import org.junit.Assert;

public class US007Dean_ShouldBeAbleToSeeTheMessages {
    AddDeanPage addDeanPage = new AddDeanPage();

    @Given("The website is visitedyk")
    public void Thewebsiteisvisitedyk() {
        Driver.getDriver().get(ConfigReader.getProperty("manage_Url"));
    }

    @When("click Loginyk.")
    public void clickLoginyk() {
        addDeanPage.deanloginLinkYakup.click();
    }

    @And("enter usernameyk")
    public void enterusernameyk() {
        addDeanPage.deanusernameBoxYakup.sendKeys(ConfigReader.getProperty("Dean_username"));

    }

    @And("enter passwordyk.")
    public void enterpasswordyk() {
        addDeanPage.deanpasswordBoxYakup.sendKeys(ConfigReader.getProperty("Dean_password"));
    }

    @And("click Login Buttonyk")
    public void clickLoginButtonyk() {
        addDeanPage.deanloginButtonYakup.click();
    }

    @And("click the Menu button.")
    public void clickMenuButton() {
        addDeanPage.deanMenuButton.click();
    }

    @And("click the Contact Get All button.")
    public void clickContactGetAllButton() {
        addDeanPage.contactGetAllButton.click();


    }

    @Then("Dean confirms viewing information.")
    public void DeanConfirmsViewingInformation() {
      Assert.assertTrue(addDeanPage.contactMessageText.isDisplayed());

    }

    @Then("delete button and delete messages are confirmed.")
    public void deleteButtonAndDeleteMessagesAreConfirmed() {
       if (!addDeanPage.undeletableMessage.isEnabled()){
           System.out.println("UnDeleted Messages");
        }


    }
}