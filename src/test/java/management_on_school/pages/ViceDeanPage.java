package management_on_school.pages;

import management_on_school.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;














public class ViceDeanPage {
    public ViceDeanPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }











































































    // Duygu Jones (100)



































































































    //Salih Kaygusuz (200)



































































































    //Yakup Aydin (300)



































































































    //Kubra Cemrek (400)
    @FindBy(css = ".header_link.ms-2")
    public WebElement loginBtnHomeKubraC;
    @FindBy(id= "username")
    public WebElement userNameKubraC;
    @FindBy(id= "password")
    public WebElement passwordKubraC;
    @FindBy(css= ".fw-semibold.btn.btn-primary")
    public WebElement loginButtonKubraC;
    @FindBy(id= "#controlled-tab-example-tab-lessonProgram")
    public WebElement lessonProgramKubraC;


































































































    //Mehmet Ergan (500)



































































































   // Halil Uslu (600)



































































































   // Mustafa Aydin (700)



































































































   // Kubra Unver (800)



































































































   // Isra Muncester (900)



































































































}