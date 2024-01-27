package management_on_school.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",//==> console da scenariolar ile ilgili ayrintili bilgi verir
                "html:target/default-cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml",
                "rerun:TestOutput/failed_scenario.txt" },
        features = "src\\test\\resources",
        glue = {"management_on_school/stepDefinitions", "management_on_school/hooks"},
        dryRun = false,
        tags = "@E2Eus15",
        monochrome = true

)
public class Runner {

}
