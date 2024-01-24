package management_on_school.stepDefinitions.ui_step_defs.Admin.US_02;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import management_on_school.pages.AdminPage;
import management_on_school.pages.GuestUserListPage;
import management_on_school.pages.HomePage;
import management_on_school.utilities.ConfigReader;
import management_on_school.utilities.Driver;
import management_on_school.utilities.ReusableMethods;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class US_02_AdminGuestUserList_StepDef_UI {

    HomePage homePage=new HomePage();
    AdminPage adminPage=new AdminPage();
    GuestUserListPage guestUserPage =new GuestUserListPage();

    @Given("dj admin goes the page url")
    public void djUserGoesThePageUrl() {
        Driver.getDriver().get(ConfigReader.getProperty("manage_Url"));
    }

    @When("dj admin clicks to login button")
    public void djUserClicksToLoginButton() {
        ReusableMethods.waitForSecond(2);
        ReusableMethods.jsClick(homePage.loginMainDj);
    }

    @And("dj admin login with user credentials")
    public void djUserLoginWithUserCredentials() {
        homePage.usernameDj.sendKeys(ConfigReader.getProperty("admin_username"), Keys.TAB,
                ConfigReader.getProperty("admin_password"),Keys.TAB,Keys.ENTER);
    }

    @Then("tb user verifies if navigated to the admin management page")
    public void tbUserVerifiesIfNavigatedToTheAdminManagementPage() {
        ReusableMethods.waitForSecond(3);
        String expectedUrl = "https://managementonschools.com/admin-management";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
    }

    @And("dj user clicks on the menu button")
    public void djUserClicksOnTheMenuButton() {
        ReusableMethods.waitForSecond(2);
        adminPage.adminMenuButtonDj.click();
    }

    @And("dj user clicks the guest user button")
    public void djUserClicksTheGuestUserButton() {
        ReusableMethods.waitForSecond(2);
        guestUserPage.adminGuestUserDj.click();
    }

    @Then("dj user verifies,Guest User List title is visible")
    public void dj_user_verifies_guest_user_list_title_is_visible() {
        ReusableMethods.waitForSecond(2);
        Assert.assertTrue(guestUserPage.guestUserListTitleDj.isDisplayed());
    }

    @And("dj user verifies,name is visible")
    public void djUserVerifiesNameIsVisible() {
        ReusableMethods.waitForSecond(1);
//        List<WebElement> nameList = guestUserPage.guestNamesListDj;
//        List<String> names = new ArrayList<>();
//        for (WebElement w : nameList) {
//            names.add(w.getText());
//        }
//        Assert.assertTrue(names.contains("Team05Guest Perfect"));

        Assert.assertTrue(guestUserPage.guestNamesListDj.get(0).isDisplayed());

    }

    @And("dj user verifies, phone number is visible")
    public void djUserVerifiesPhoneNumberIsVisible() {
        ReusableMethods.waitForSecond(1);
        Assert.assertTrue(guestUserPage.guestPhoneNumsListDj.get(0).isDisplayed());

//        List<WebElement> guestPhoneList = guestUserPage.guestPhoneNumsListDj;
//        List<String> phoneNumbers = guestPhoneList.stream().map(WebElement::getText).collect(Collectors.toList());
//        Assert.assertTrue(phoneNumbers.contains("guest_phone"));
    }

    @And("dj user verifies, ssn is visible")
    public void djUserVerifiesSsnIsVisible() {
        ReusableMethods.waitForSecond(1);
        Assert.assertTrue(guestUserPage.guestSsnNumsListDj.get(0).isDisplayed());
    }

    @And("dj user verifies, Username is visible")
    public void djUserVerifiesUsernameIsVisible() {
        ReusableMethods.waitForSecond(1);
        Assert.assertTrue(guestUserPage.guestUserNamesListDj.get(0).isDisplayed());
    }

    @And("dj user clicks the delete")
    public void djUserClicksTheDelete() {
        ReusableMethods.waitForSecond(1);
        ReusableMethods.jsClick(guestUserPage.guestDeleteButtonListDj.get(0));
    }

    @And("dj close the browser")
    public void djCloseTheBrowser() {
        Driver.closeDriver();
    }
}
