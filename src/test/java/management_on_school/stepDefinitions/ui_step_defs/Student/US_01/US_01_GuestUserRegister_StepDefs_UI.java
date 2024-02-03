package management_on_school.stepDefinitions.ui_step_defs.Student.US_01;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import management_on_school.pages.StudentPage;
import management_on_school.utilities.ConfigReader;
import management_on_school.utilities.Driver;
import management_on_school.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import static org.junit.Assert.assertTrue;

public class US_01_GuestUserRegister_StepDefs_UI {

    StudentPage studentPage = new StudentPage();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    static Faker faker = new Faker();
    static String fakeUserName;

    @Given("Kisi {string} adresine gider")
    public void kisi_adresine_gider(String string) {
        Driver.getDriver().get(ConfigReader.getProperty("manage_Url"));
    }


    @Then("Aday ogrenci Register ikonuna tiklar")
    public void aday_ogrenci_register_ikonuna_tiklar() {
        studentPage.registerAnaSayfa.click();
        ReusableMethods.waitForSecond(1);
    }
    @Given("Kullanici {string} alaninda tab tusuna basar")
    public void kullaniciNameAlanindaTabTusunaBasar(String arg0) {
        studentPage.name.sendKeys(Keys.TAB);
    }
    @Then("Kullanici Name kutusuna {string} girer")
    public void kullanici_name_kutusuna_girer(String name) {
        studentPage.name.sendKeys(name);
        ReusableMethods.waitForSecond(1);
    }
    @Then("Kullanici at least iki character uyarisini goruntulemez")
    public void kullanici_at_least_iki_character_uyarisini_goruntulemez() {
        assertTrue(Driver.getDriver().findElements(By.xpath("//div[@class='Toastify__toast Toastify__toast-theme--colored Toastify__toast--error Toastify__toast--close-on-click']")).size()<1);
        ReusableMethods.waitForSecond(1);
    }
    @Given("Kullanici name disindaki tum alanlara valid deger girer")
    public void kullaniciNameDisindakiTumAlanlaraValidDegerGirer() {
        studentPage.surname.sendKeys(faker.name().lastName());
        ReusableMethods.waitForSecond(1);
        studentPage.birthPlace.sendKeys(faker.address().city());
        ReusableMethods.waitForSecond(1);
        studentPage.phoneNumber.sendKeys(faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(1000,9999));
        ReusableMethods.pageDown();
        ReusableMethods.jsClick(studentPage.male);
        ReusableMethods.waitForSecond(1);
        studentPage.dateOfBirth.sendKeys("10/10/2000");
        ReusableMethods.waitForSecond(1);
        studentPage.ssn.sendKeys(faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(10,99)+"-"+faker.number().numberBetween(1000,9999));
        ReusableMethods.waitForSecond(1);
        fakeUserName = faker.name().firstName();
        studentPage.usernamep.sendKeys(fakeUserName);
        ReusableMethods.waitForSecond(1);
        ReusableMethods.pageDown();
        studentPage.passwordp.sendKeys("Mg123456",Keys.TAB);
        ReusableMethods.waitForSecond(1);
    }
    @Then("Kullanici at least iki character uyarisini goruntuler")
    public void kullanici_at_least_iki_character_uyarisini_goruntuler() {
        ReusableMethods.waitForVisibleElement(studentPage.atleast2char,5);
        assertTrue(studentPage.atleast2char.isDisplayed());
        ReusableMethods.waitForSecond(1);
    }
    @Given("Kullanici Surname kutusuna {string} girer")
    public void kullaniciSurnameKutusunaGirer(String surname) {
        studentPage.surname.sendKeys(surname);
        ReusableMethods.waitForSecond(1);
    }
    @Given("Kullanici surname disindaki tum alanlara valid deger girer")
    public void kullaniciSurnameDisindakiTumAlanlaraValidDegerGirer() {
        studentPage.name.sendKeys(faker.name().firstName());
        ReusableMethods.waitForSecond(1);
        studentPage.birthPlace.sendKeys(faker.address().city());
        ReusableMethods.waitForSecond(1);

        studentPage.phoneNumber.sendKeys(faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(1000,9999));
        //ReusableMethods.arrowDown();
        ReusableMethods.pageDown();

        ReusableMethods.jsClick(studentPage.female);
        ReusableMethods.waitForSecond(1);
        studentPage.dateOfBirth.sendKeys("10/10/2000");
        ReusableMethods.waitForSecond(1);
        studentPage.ssn.sendKeys(faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(10,99)+"-"+faker.number().numberBetween(1000,9999));
        ReusableMethods.waitForSecond(1);
        fakeUserName = faker.name().firstName();
        studentPage.usernamep.sendKeys(fakeUserName);
        //ReusableMethods.bekle(1);
        ReusableMethods.pageDown();
        studentPage.passwordp.sendKeys("Mg123456");
        ReusableMethods.waitForSecond(2);
    }
    @Given("Kullanici Birth place kutusuna {string} girer")
    public void kullaniciBirthPlaceKutusunaGirer(String birthplace) {
        studentPage.birthPlace.sendKeys(birthplace);
        ReusableMethods.waitForSecond(1);
    }
    @Given("Kullanici birth place disindaki tum alanlara valid deger girer")
    public void kullaniciBirthPlaceDisindakiTumAlanlaraValidDegerGirer() {
        studentPage.name.sendKeys(faker.name().firstName());
        ReusableMethods.waitForSecond(1);
        studentPage.surname.sendKeys(faker.name().lastName());
        ReusableMethods.waitForSecond(1);
        studentPage.phoneNumber.sendKeys(faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(1000,9999));
        ReusableMethods.waitForSecond(1);
        ReusableMethods.pageDown();
        ReusableMethods.jsClick(studentPage.female);
        ReusableMethods.waitForSecond(1);
        studentPage.dateOfBirth.sendKeys("10/10/2000");
        ReusableMethods.waitForSecond(1);
        studentPage.ssn.sendKeys(faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(10,99)+"-"+faker.number().numberBetween(1000,9999));
        ReusableMethods.waitForSecond(1);
        fakeUserName = faker.name().firstName();
        studentPage.usernamep.sendKeys(fakeUserName);
        ReusableMethods.waitForSecond(1);
        studentPage.passwordp.sendKeys("Mg123456",Keys.TAB);
        ReusableMethods.waitForSecond(1);
    }
    @Given("Kullanici Phone Number kutusuna {string} girer")
    public void kullaniciPhoneNumberKutusunaGirer(String phone) {
        studentPage.phoneNumber.sendKeys(phone);
        ReusableMethods.waitForSecond(1);
    }
    @Then("Kullanici enter valid phone number uyarisini goruntulemez")
    public void kullaniciEnterValidPhoneNumberUyarisiniGoruntulemez() {
        assertTrue(Driver.getDriver().findElements(By.xpath("//*[contains(text(),'Please enter valid phone number')]")).size()<1);
        ReusableMethods.waitForSecond(1);
    }
    @Then("Kullanici minumum 12 character uyarisini goruntuler")
    public void kullaniciMinumum12CharacterUyarisiniGoruntuler() {
        assertTrue(studentPage.min12char.isDisplayed());
        ReusableMethods.waitForSecond(1);
    }
    @Then("Kullanici phone number disindaki tum alanlara valid deger girer")
    public void kullaniciPhoneNumberDisindakiTumAlanlaraValidDegerGirer() {
        studentPage.name.sendKeys(faker.name().firstName());
        ReusableMethods.waitForSecond(1);
        studentPage.surname.sendKeys(faker.name().lastName());
        ReusableMethods.waitForSecond(1);
        studentPage.birthPlace.sendKeys(faker.address().city());
        ReusableMethods.pageDown();
        ReusableMethods.jsClick(studentPage.male);
        ReusableMethods.waitForSecond(1);
        studentPage.dateOfBirth.sendKeys("10/10/2000");
        ReusableMethods.waitForSecond(1);
        studentPage.ssn.sendKeys(faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(10,99)+"-"+faker.number().numberBetween(1000,9999));
        ReusableMethods.waitForSecond(1);
        fakeUserName = faker.name().firstName();
        studentPage.usernamep.sendKeys(fakeUserName);
        ReusableMethods.waitForSecond(1);
        studentPage.passwordp.sendKeys("Mg123456",Keys.TAB);
        ReusableMethods.waitForSecond(1);

    }
    @Then("Kullanici exact oniki character uyarisini goruntuler")
    public void kullaniciExactOnikiCharacterUyarisiniGoruntuler() {
        ReusableMethods.waitForVisibleElement(studentPage.exact12char,5);
        assertTrue(studentPage.exact12char.isDisplayed());
        ReusableMethods.waitForSecond(1);
    }
    @Then("Kullanici Gender radio butonlarindan gender secer")
    public void kullaniciGenderRadioButonlarindanGenderSecer() {
        ReusableMethods.waitForSecond(1);
        ReusableMethods.pageDown();
        ReusableMethods.jsClick(studentPage.male);
        ReusableMethods.waitForSecond(3);
    }
    @Given("Kullanici Date Of Birth kutusuna {string} girer")
    public void kullaniciDateOfBirthKutusunaGirer(String dateOfBirth) {
        studentPage.dateOfBirth.sendKeys(dateOfBirth);
        ReusableMethods.waitForSecond(1);
    }
    @Then("kullanici gecmis tarih olmali uyarisini goruntulemez")
    public void kullaniciGecmisTarihOlmaliUyarisiniGoruntulemez() {
        assertTrue(Driver.getDriver().findElements(By.xpath("//*[contains(text(),'geçmiş bir tarih olmalı')]")).size()<1);
        ReusableMethods.waitForSecond(1);
    }
    @Given("Kullanici date of birth disindaki tum alanlara valid deger girer")
    public void kullaniciDateOfBirthDisindakiTumAlanlaraValidDegerGirer() {
        ReusableMethods.waitForSecond(1);
        ReusableMethods.pageUp();
        studentPage.name.sendKeys(faker.name().firstName());
        ReusableMethods.waitForSecond(1);
        studentPage.surname.sendKeys(faker.name().lastName());
        ReusableMethods.waitForSecond(1);
        //ReusableMethods.pageDown();
        studentPage.birthPlace.sendKeys(faker.address().city());
        ReusableMethods.waitForSecond(1);
        studentPage.phoneNumber.sendKeys(faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(1000,9999));
        ReusableMethods.waitForSecond(1);
        ReusableMethods.pageDown();
        ReusableMethods.jsClick(studentPage.male);
        ReusableMethods.waitForSecond(1);
        studentPage.ssn.sendKeys(faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(10,99)+"-"+faker.number().numberBetween(1000,9999));
        ReusableMethods.waitForSecond(1);
        fakeUserName = faker.name().firstName();
        studentPage.usernamep.sendKeys(fakeUserName);
        ReusableMethods.waitForSecond(1);
        studentPage.passwordp.sendKeys("Mg123456");
        ReusableMethods.pageDown();
        ReusableMethods.waitForSecond(2);
    }
    @Then("kullanici gecmis tarih olmali uyarisini goruntuler")
    public void kullaniciGecmisTarihOlmaliUyarisiniGoruntuler() {
        ReusableMethods.waitForSecond(1);
        assertTrue(studentPage.gecmisBirTarihOlmali.isDisplayed());
        ReusableMethods.waitForSecond(1);
    }
    @Given("Kullanici SSN kutusuna {string} girer")
    public void kullaniciSSNKutusunaGirer(String ssn) {
        studentPage.ssn.sendKeys(ssn);
        ReusableMethods.waitForSecond(1);
    }

    @Then("Kullanici enter valid SSN number alertini goruntulemez")
    public void kullaniciEnterValidSSNNumberAlertiniGoruntulemez() {
        assertTrue(Driver.getDriver().findElements(By.xpath("//*[contains(text(),'enter valid ssn number')]")).size()<1);
        ReusableMethods.waitForSecond(1);
    }

    @Then("Kullanici please enter valid SSN number alertini goruntuler")
    public void kullaniciPleaseEnterValidSSNNumberAlertiniGoruntuler() {
        ReusableMethods.waitForSecond(1);
        assertTrue(studentPage.pleaseEnterValidSsnNumber.isDisplayed());
        ReusableMethods.waitForSecond(1);
    }

    @Then("Kullanici minimum onbir character alertini goruntuler")
    public void kullaniciMinimumOnbirCharacterAlertiniGoruntuler() {
        ReusableMethods.waitForSecond(1);
        assertTrue(studentPage.min11char.isDisplayed());
        ReusableMethods.waitForSecond(1);
    }

    @Given("Kullanici SSN disindaki tum alanlara valid deger girer")
    public void kullaniciSSNDisindakiTumAlanlaraValidDegerGirer() {
        ReusableMethods.waitForSecond(1);
        ReusableMethods.pageUp();
        studentPage.name.sendKeys(faker.name().firstName());
        ReusableMethods.waitForSecond(1);
        studentPage.surname.sendKeys(faker.name().lastName());
        ReusableMethods.waitForSecond(1);
        studentPage.birthPlace.sendKeys(faker.address().city());
        ReusableMethods.waitForSecond(1);
        studentPage.phoneNumber.sendKeys(faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(1000,9999));
        ReusableMethods.waitForSecond(1);
        ReusableMethods.pageDown();
        ReusableMethods.jsClick(studentPage.male);
        studentPage.dateOfBirth.sendKeys("10/10/2000");
        ReusableMethods.waitForSecond(1);
        fakeUserName = faker.name().firstName();
        studentPage.usernamep.sendKeys(fakeUserName);
        ReusableMethods.waitForSecond(1);
        studentPage.passwordp.sendKeys("Mg123456",Keys.TAB);
        ReusableMethods.waitForSecond(1);

    }

    @Given("Kullanici User Name kutusuna {string} girer")
    public void kullaniciUserNameKutusunaGirer(String userName) {
        studentPage.username.sendKeys(userName);
        ReusableMethods.waitForSecond(1);
    }
    @Then("Kullanici at least dort character uyarisini goruntulemez")
    public void kullaniciAtLeastDortCharacterUyarisiniGoruntulemez() {
        assertTrue(Driver.getDriver().findElements(By.xpath("//*[contains(text(),'Your username should be at least 4 characters')]")).size()<1);
        ReusableMethods.waitForSecond(1);
    }
    @Given("Kullanici user name disindaki alanlar icin valid deger girer")
    public void kullaniciUserNameDisindakiAlanlarIcinValidDegerGirer() {
        ReusableMethods.waitForSecond(1);
        ReusableMethods.pageUp();
        studentPage.name.sendKeys(faker.name().firstName());
        ReusableMethods.waitForSecond(1);
        studentPage.surname.sendKeys(faker.name().lastName());
        ReusableMethods.waitForSecond(1);
        studentPage.birthPlace.sendKeys(faker.address().city());
        ReusableMethods.waitForSecond(1);
        studentPage.phoneNumber.sendKeys(faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(1000,9999));
        ReusableMethods.waitForSecond(1);
        ReusableMethods.pageDown();
        ReusableMethods.jsClick(studentPage.male);
        studentPage.dateOfBirth.sendKeys("10/10/2000");
        ReusableMethods.waitForSecond(1);
        studentPage.ssn.sendKeys(faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(10,99)+"-"+faker.number().numberBetween(1000,9999));
        ReusableMethods.waitForSecond(1);
        studentPage.passwordp.sendKeys("Mg123456",Keys.TAB);
        ReusableMethods.waitForSecond(1);

    }
    @Then("Kullanici at least dort character uyarisini goruntuler")
    public void kullaniciAtLeastDortCharacterUyarisiniGoruntuler() {
        ReusableMethods.waitForSecond(1);
        assertTrue(studentPage.atleast4char.isDisplayed());
        ReusableMethods.waitForSecond(1);
    }
    @And("Kullanici Password kutusuna {string} girer")
    public void kullaniciPasswordKutusunaGirer(String password) {
        studentPage.password.sendKeys(password);
        ReusableMethods.waitForSecond(1);
    }
    @Given("Kullanici password disindaki alanlar icin valid deger girer")
    public void kullaniciPasswordDisindakiAlanlarIcinValidDegerGirer() {
        ReusableMethods.waitForSecond(1);
        ReusableMethods.pageUp();
        studentPage.name.sendKeys(faker.name().firstName());
        ReusableMethods.waitForSecond(1);
        studentPage.surname.sendKeys(faker.name().lastName());
        ReusableMethods.waitForSecond(1);
        studentPage.birthPlace.sendKeys(faker.address().city());
        ReusableMethods.waitForSecond(1);
        studentPage.phoneNumber.sendKeys(faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(1000,9999));
        ReusableMethods.waitForSecond(1);
        ReusableMethods.pageDown();
        ReusableMethods.jsClick(studentPage.male);
        ReusableMethods.waitForSecond(1);
        studentPage.dateOfBirth.sendKeys("10/10/2000");
        ReusableMethods.waitForSecond(1);
        studentPage.ssn.sendKeys(faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(10,99)+"-"+faker.number().numberBetween(1000,9999));
        ReusableMethods.waitForSecond(1);
        fakeUserName = faker.name().firstName();
        studentPage.usernamep.sendKeys(fakeUserName,Keys.TAB,Keys.TAB);
        ReusableMethods.waitForSecond(1);
    }

    @Then("Kullanici username icin valid deger girer")
    public void usernameIcinValidDegerGirer() {
        do {
            fakeUserName = faker.name().firstName();
        } while (fakeUserName.length() < 4 || fakeUserName.length() > 8);
        studentPage.usernamep.sendKeys(fakeUserName);
        ReusableMethods.waitForSecond(1);
    }


    @And("Kullanici guest user registered mesajini gorerek basarili kayit yapabildigini dogrular")
    public void kullaniciGuestUserRegisteredMesajiniGorerekBasariliKayitYapabildiginiDogrular() {
        ReusableMethods.waitForVisibleElement(studentPage.guestUserRegistered,5);
        assertTrue(studentPage.guestUserRegistered.isDisplayed());
        ReusableMethods.waitForSecond(2);
    }
    @And("Kullanici guest user registered mesajini gormeyerek basarili kayit yapamadigini dogrular")
    public void kullaniciGuestUserRegisteredMesajiniGormeyerekBasariliKayitYapamadiginiDogrular() {
        assertTrue(Driver.getDriver().findElements(By.xpath("//*[contains(text(),'Guest User registered.')]")).size()<1);
        ReusableMethods.waitForSecond(1);
    }
    @Then("Kullanici register butonuna tiklar")
    public void kullaniciRegisterButonunaTiklar() {
        ReusableMethods.waitForSecond(1);
        ReusableMethods.jsClick(studentPage.register);
        ReusableMethods.waitForSecond(1);
    }



    @Then("Kullanici {string} icin required uyarisini goruntuler")
    public void kullaniciIcinRequiredUyarisiniGoruntuler(String kutucuk) {
        switch (kutucuk){
            case "name":
                assertTrue(studentPage.requiredMessageName.isDisplayed());
                break;

            case "surname":
                assertTrue(studentPage.requiredMessageSurname.isDisplayed());
                break;

            case "birth place":
                assertTrue(studentPage.requiredMessageBirthPlace.isDisplayed());
                break;

            case "date of birth":
                assertTrue(studentPage.requiredMessageDateOfBirth.isDisplayed());
                break;

            case "phone":
                assertTrue(studentPage.requiredMessagePhone.isDisplayed());
                break;

            case "SSN":
                assertTrue(studentPage.requiredMessageSsn.isDisplayed());
                break;

            case "username":
                assertTrue(studentPage.requiredMessageUserName.isDisplayed());
                break;

            case "pasword":
                assertTrue(studentPage.EnterYourPasswordMessage.isDisplayed());
                break;
        }
        ReusableMethods.waitForSecond(1);
    }

    @Then("Kullanici minimum sekiz karakter uyarisini goruntuler")
    public void kullaniciMinimumSekizKarakterUyarisiniGoruntuler() {
        assertTrue(studentPage.minimum8.isDisplayed());
    }

    @Given("Kullanici {string}  alaninda tab tusuna basar")
    public void kullaniciSurnameAlanindaTabTusunaBasar(String arg0) {
        studentPage.surname.sendKeys(Keys.TAB);
    }

    @Given("Kullanici {string}   alaninda tab tusuna basar")
    public void kullanicibirthplaceAlanindaTabTusunaBasar(String arg0) {
        studentPage.birthPlace.sendKeys(Keys.TAB);
    }

    @Given("Kullanici  {string} alaninda tab tusuna basar")
    public void kullaniciSsnAlanindaTabTusunaBasar(String arg0) {
        studentPage.ssn.sendKeys(Keys.TAB);
    }

    @Given("Kullanici   {string} alaninda tab tusuna basar")
    public void kullaniciUsernameAlanindaTabTusunaBasar(String arg0) {
        studentPage.username.sendKeys(Keys.TAB);
    }

    @Given("Kullanici{string} alaninda tab tusuna basar")
    public void kullaniciPasswordAlanindaTabTusunaBasar(String arg0) {
        studentPage.password.sendKeys(Keys.TAB);
    }

}
