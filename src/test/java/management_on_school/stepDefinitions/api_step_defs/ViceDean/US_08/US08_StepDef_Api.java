package management_on_school.stepDefinitions.api_step_defs.ViceDean.US_08;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import management_on_school.pojos.lesson_management.LessonSaveMeResponsePojo;
import management_on_school.pojos.lesson_management.Object8_9Pojo;
import management_on_school.utilities.ConfigReader;

import static io.restassured.RestAssured.given;
import static management_on_school.base_url.BaseUrl.setUp;
import static management_on_school.base_url.BaseUrl.spec;
import static org.junit.Assert.assertEquals;

public class US08_StepDef_Api {

    Response response;
    public static Object8_9Pojo payLoad;
    public static LessonSaveMeResponsePojo actualData;
    Faker faker = new Faker();
    public JsonPath json;
    public static String lessonId;


    @Given("a login is performed with {string} account")
    public void a_login_is_performed_with_account(String string) {
        setUp(ConfigReader.getProperty("ViceDean_username"), ConfigReader.getProperty("ViceDean_password"));
    }
    @Given("the URL is formatted to create a lesson")
    public void the_url_is_formatted_to_create_a_lesson() {

        spec.pathParams("first","lessons","second","save");
    }
    @Given("the payload is prepared for the lesson")
    public void the_payload_is_prepared_for_the_lesson() {
        payLoad = new Object8_9Pojo(faker.name().firstName(),9,true);

    }
    @When("a POST request is sent for the lesson and a response is received")
    public void a_post_request_is_sent_for_the_lesson_and_a_response_is_received() {
        response = given(spec).body(payLoad).when().post("{first}/{second}");
        response.prettyPrint();


    }
    @Then("it is verified that the status code for the lesson is {int}")
    public void it_is_verified_that_the_status_code_for_the_lesson_is(int statusCode) {
        assertEquals(statusCode,response.statusCode());

    }
    @Then("the response body for the lesson is validated")
    public void the_response_body_for_the_lesson_is_validated() {
        actualData = response.as(LessonSaveMeResponsePojo.class);
        assertEquals(payLoad.getLessonName(),actualData.getObject().getLessonName());
        assertEquals(payLoad.getCreditScore(),actualData.getObject().getCreditScore());
        assertEquals(payLoad.isCompulsory(),actualData.getObject().isCompulsory());
        assertEquals("Lesson Created",actualData.getMessage());

        lessonId=response.jsonPath().getString("object.lessonId");

    }

    @And("the payload is prepared for the same lesson")
    public void thePayloadIsPreparedForTheSameLesson() {
        payLoad = new Object8_9Pojo("Java_5",9,true);

    }

    @And("the response body for the same lesson is validated")
    public void theResponseBodyForTheSameLessonIsValidated() {
        JsonPath actualData= response.jsonPath();

        assertEquals("Error: Lesson with lesson name Java_5 already register",actualData.getString("message"));

    }
}
