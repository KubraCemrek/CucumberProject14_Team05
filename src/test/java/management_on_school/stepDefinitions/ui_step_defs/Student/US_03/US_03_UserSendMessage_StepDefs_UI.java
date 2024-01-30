package management_on_school.stepDefinitions.ui_step_defs.Student.US_03;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import management_on_school.pages.StudentPage;
import management_on_school.utilities.ConfigReader;
import management_on_school.utilities.Driver;
import management_on_school.utilities.ReusableMethods;

import static org.junit.Assert.assertTrue;
public class US_03_UserSendMessage_StepDefs_UI {

    StudentPage studentPage =new StudentPage();

    @Given("Kullanici anasayfaya girer")
    public void kullaniciUrlEGirer() {
        Driver.getDriver().get(ConfigReader.getProperty("manage_Url"));
        ReusableMethods.waitForSecond(1);
    }

    @When("Kullanici Contact butonuna tıklar")
    public void kullaniciContactButonunaTıklar() {
        ReusableMethods.jsClick(studentPage.contactButon);
    }

    @And("Kullanici Your name kutucuguna gecerli name {string} girer")
    public void kullaniciYourNameKutucugunaGecerliNameGirer(String arg0) {
        ReusableMethods.jsScroll(studentPage.yourNameBox);
        studentPage.yourNameBox.sendKeys(arg0);

    }

    @And("Kullanici Your email kutucuguna gecerli mail {string} girer")
    public void kullaniciYourEmailKutucugunaGecerliMailGirer(String arg0) {
        ReusableMethods.waitForSecond(1);
        studentPage.yourEmailBox.sendKeys(arg0);

    }

    @And("Kullanici Subject kutucuguna gecerli ders {string} girer")
    public void kullaniciSubjectKutucugunaGecerliDersGirer(String arg0) {
        studentPage.subjectBox.sendKeys(arg0);

    }
    @And("Kullanici Message kutucuguna gecerli mesaj {string} girer")
    public void kullaniciMessageKutucugunaGecerliMesajGirer(String arg0) {

        studentPage.messageBox.sendKeys(arg0);

    }

    @And("Kullanici Send Message butonuna tiklar")
    public void kullaniciSendMessageButonunaTiklar() {

        ReusableMethods.jsClick(studentPage.sendMessageButon);
    }

    @And("Kullanici Contact Message Created Successfully uyarisini gorunurlugunu test eder")
    public void kullaniciContactMessageCreatedSuccessfullyUyarisiniGorunurlugunuTestEder() {
        ReusableMethods.waitForVisibleElement(studentPage.alertMessage, 5);
        assertTrue(studentPage.alertMessage.getText().contains("Contact Message Created Successfully"));
    }


    @And("Kullanici Please enter valid email uyarisinin gorunurlugunu test eder")
    public void kullaniciPleaseEnterValidEmailUyarisininGorunurlugunuTestEder() {
        ReusableMethods.waitForVisibleElement(studentPage.alertMessage, 5);
        assertTrue(studentPage.alertMessage.getText().contains("valid"));

    }

    @And("Kullanici Your email kutucuguna gecersiz mail {string} girer")
    public void kullaniciYourEmailKutucugunaGecersizMailGirer(String arg0) {
        studentPage.yourEmailBox.sendKeys(arg0);
    }


}
