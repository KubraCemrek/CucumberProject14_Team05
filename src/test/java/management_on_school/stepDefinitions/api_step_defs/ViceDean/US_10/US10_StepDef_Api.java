package management_on_school.stepDefinitions.api_step_defs.ViceDean.US_10;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import management_on_school.pojos.lesson_management.LessonProgramResponseMehmet_10Pojo;
import management_on_school.pojos.lesson_management.LessonProgramSaveMe_10Pojo;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static management_on_school.base_url.BaseUrl.spec;

public class US10_StepDef_Api {
    LessonProgramSaveMe_10Pojo payLoad;
    Response response;
    LessonProgramResponseMehmet_10Pojo actualData;
    List<String> lessonIdList=new ArrayList<>();


    @And("the URL is configured for creating a lesson program")
    public void theURLIsConfiguredForCreatingALessonProgram() {
        spec.pathParams("first","lessonPrograms","second","save");
    }

    @And("the payload is prepared for the lesson program")
    public void thePayloadIsPreparedForTheLessonProgram() {
        lessonIdList.add("3547");
        payLoad=new LessonProgramSaveMe_10Pojo("SATURDAY","35",lessonIdList,"10:00","11:00");
    }

    @When("a POST request is sent for the lesson program, and a response is received")
    public void aPOSTRequestIsSentForTheLessonProgramAndAResponseIsReceived() {
        response=given(spec).when().body(payLoad).post("{first}/{second}");
        response.prettyPrint();
        actualData=response.as(LessonProgramResponseMehmet_10Pojo.class);
    }

    @Then("it is verified that the status code for the lesson program is {int}")
    public void itIsVerifiedThatTheStatusCodeForTheLessonProgramIs(int statusCode) {
        Assert.assertEquals(statusCode,response.statusCode());
    }

    @And("the response body for the lesson program is verified")
    public void theResponseBodyForTheLessonProgramIsVerified() {
        Assert.assertEquals(payLoad.getDay(),actualData.getObject().getDay());
        Assert.assertEquals("10:00:00",actualData.getObject().getStartTime());
        Assert.assertEquals("11:00:00",actualData.getObject().getStopTime());
        Assert.assertEquals(13,actualData.getObject().getLessonName().get(0).getCreditScore());
        Assert.assertEquals("Java_1",actualData.getObject().getLessonName().get(0).getLessonName());
        Assert.assertEquals("Created Lesson Program",actualData.getMessage());
        Assert.assertEquals("CREATED",actualData.getHttpStatus());

    }
}
