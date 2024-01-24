package management_on_school.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import management_on_school.utilities.Driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;

public class Hook {

    @Before("@UI")
    public void setup(){
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After("@UI")
    public void tearDown(){
        Driver.closeDriver();
    }

//    @After
//    public void tearDown(Scenario scenario) throws Exception {
//
//        if (scenario.isFailed()) {
//            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
//            scenario.attach(ts.getScreenshotAs(OutputType.BYTES), "image/png", "scenario" + scenario.getName());
//            Driver.closeDriver();
//        }
//        Driver.closeDriver();
//
//    }



}
