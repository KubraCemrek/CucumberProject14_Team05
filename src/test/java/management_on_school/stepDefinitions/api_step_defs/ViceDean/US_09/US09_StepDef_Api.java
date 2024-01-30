package management_on_school.stepDefinitions.api_step_defs.ViceDean.US_09;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import management_on_school.pojos.lesson_management.Object8_9Pojo;

import static io.restassured.RestAssured.given;
import static management_on_school.base_url.BaseUrl.spec;
import static management_on_school.stepDefinitions.api_step_defs.ViceDean.US_08.US08_StepDef_Api.lessonId;
import static org.junit.Assert.assertEquals;

public class US09_StepDef_Api {
    Object8_9Pojo expectedData;
    Response response;

    @And("the URL is formatted to see a lesson")
    public void theURLIsFormattedToSeeALesson() {
        spec.pathParams("first","lessons","second","getAllLessonByLessonId")
                .queryParam("lessonId","3547");
    }

    @And("the payload is prepared for the current lesson")
    public void thePayloadIsPreparedForTheCurrentLesson() {
        expectedData = new Object8_9Pojo("Java_1",13,true);
    }

    @When("a GET request is sent for the current lesson and a response is received")
    public void aGETRequestIsSentForTheCurrentLessonAndAResponseIsReceived() {
        response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();
    }

    @Then("it is verified that the status code for the current lesson is {int}")
    public void itIsVerifiedThatTheStatusCodeForTheCurrentLessonIs(int statusCode) {
        assertEquals(statusCode,response.statusCode());
    }

    @And("the response body for the current lesson is validated")
    public void theResponseBodyForTheCurrentLessonIsValidated() {
        JsonPath actualData = response.jsonPath();
        assertEquals(expectedData.getCreditScore(),actualData.getInt("[0].creditScore"));
        assertEquals(expectedData.getLessonName(),actualData.getString("[0].lessonName"));
        assertEquals(expectedData.isCompulsory(),actualData.getBoolean("[0].compulsory"));
    }

    @And("the URL is formatted to delete a lesson")
    public void theURLIsFormattedToDeleteALesson() {
        spec.pathParams("first","lessons","second","delete","third",lessonId);
        System.out.println(lessonId);

    }

    @When("a DELETE request is sent for the lesson and a response is received")
    public void aDELETERequestIsSentForTheLessonAndAResponseIsReceived() {
        response = given(spec).when().delete("{first}/{second}/{third}");
        response.prettyPrint();
    }

    @Then("it is verified that the status code for the deleted lesson is {int}")
    public void itIsVerifiedThatTheStatusCodeForTheDeletedLessonIs(int statusCode) {
        assertEquals(statusCode,response.statusCode());
    }

    @And("the response body for the deleted lesson is validated")
    public void theResponseBodyForTheDeletedLessonIsValidated() {
        JsonPath actualData1 = response.jsonPath();
        assertEquals("Lesson Deleted",actualData1.getString("message"));

    }
}
