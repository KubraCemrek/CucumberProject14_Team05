package management_on_school.stepDefinitions.api_step_defs.ViceDean.US_11;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import management_on_school.pojos.lesson_management.LessonProgramResponseMehmet_10Pojo;
import management_on_school.pojos.lesson_management.LessonSaveMeResponsePojo;
import management_on_school.pojos.lesson_program_management.CurriculumDeletionResponsePojo;
import management_on_school.pojos.lesson_program_management.LessonProgramPojo;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static management_on_school.base_url.BaseUrl.spec;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class US11_API_StepDef {

    CurriculumDeletionResponsePojo actualDeleteData;
    public static Response response;
    public static JsonPath json;
    public static String lessonProgramId;
    LessonProgramResponseMehmet_10Pojo actualData;
    Faker faker = new Faker();
    List<String> lessonIdList=new ArrayList<>();
    LessonProgramPojo payload;

    @And("create a POST Request with the URL and use lessonPrograms-getAllUnassigned path parameters for lesson")
    public void createAPOSTRequestWithTheURLAndUseLessonProgramsGetAllUnassignedPathParametersForLesson() {
        spec.pathParams("first", "lessonPrograms", "second", "getAllUnassigned");
    }

    @And("VdURL is prepared for Lesson Program Save")
    public void vdurlIsPreparedForLessonProgramSave() {
        spec.pathParams("first","lessonPrograms","second","save");
    }

    @And("Payload is arranged for the Lesson Program")
    public void payloadIsArrangedForTheLessonProgram() {
        String startTime = faker.regexify("[0]{1}[0-9]{1}"+":"+"[0-5]{2}");
        String stopTime = faker.regexify("[1-2]{2}"+":"+"[0-5]{2}");

        lessonIdList.add("3546");
        payload=new LessonProgramPojo("THURSDAY","34",lessonIdList,startTime,stopTime);
    }

    @When("POST Request is sent and Response is received for the Lesson Program")
    public void postRequestIsSentAndResponseIsReceivedForTheLessonProgram() {
        response = given(spec).when().body(payload).post("{first}/{second}");
        response.prettyPrint();
        json=response.jsonPath();
        lessonProgramId=json.getString("object.lessonProgramId");
        System.out.println();
        System.out.println("Olusan LessonProgramId: "+lessonProgramId);

        actualData=response.as(LessonProgramResponseMehmet_10Pojo.class);
    }

    @Then("Verify that the status code for lesson programs is {int}")
    public void verifyThatTheStatusCodeForLessonProgramsIs(int statusKod) {
        assertEquals(statusKod,response.statusCode());
    }

    @And("The response body for lessons programs is verified")
    public void theResponseBodyForLessonsProgramsIsVerified() {
        assertEquals(payload.getDay(),actualData.getObject().getDay());
        assertTrue(actualData.getObject().getStartTime().contains(payload.getStartTime()));
        assertTrue(actualData.getObject().getStopTime().contains(payload.getStopTime()));
        assertEquals(3546,actualData.getObject().getLessonName().get(0).getLessonId());
        assertEquals("Created Lesson Program",actualData.getMessage());
        assertEquals("CREATED",actualData.getHttpStatus());

        System.out.println();
    }

    @And("URL is edited for Vice Dean GetById")
    public void urlIsEditedForViceDeanGetById() {
        System.out.println("-----------------------------");
        System.out.println();
        spec.pathParams("first", "lessonPrograms", "second", "getById", "third",lessonProgramId);
        response = given(spec).when().get("{first}/{second}/{third}");
        System.out.println("Olusturulan LessonPrograms GetById ile goruntulendi");
    }

    @Then("Verify that the status code for lesson programs getbyId is {int}")
    public void verifyThatTheStatusCodeForLessonProgramsGetbyIdIs(int successfulStatusCode) {
        assertEquals(successfulStatusCode,response.statusCode());

        System.out.println();
    }

    @And("VdUrl is edited to delete lesson programs")
    public void vdurlIsEditedToDeleteLessonPrograms() {
        System.out.println("----------------------------------");
        System.out.println();
        System.out.println("Olusturulan LessonProgram Delete ile Silindi");
        spec.pathParams("first","lessonPrograms","second","delete","third",lessonProgramId);
    }

    @When("For Lesson programs, a DELETE Request is issued and a Response is received")
    public void forLessonProgramsADELETERequestIsIssuedAndAResponseIsReceived() {
        response=given(spec).when().delete("{first}/{second}/{third}");
        response.prettyPrint();
        actualDeleteData=response.as(CurriculumDeletionResponsePojo.class);
    }

    @Then("In order to delete lessons programs, it is verified that the Status code is {int}")
    public void inOrderToDeleteLessonsProgramsItIsVerifiedThatTheStatusCodeIs(int statusCode) {
        assertEquals(statusCode,response.statusCode());
        assertEquals("Lesson Program Deleted",actualDeleteData.getMessage());
        assertEquals("OK",actualDeleteData.getHttpStatus());
    }

    @And("VdUrl is edited for getting all lesson programs")
    public void vdurlIsEditedForGettingAllLessonPrograms() {
        spec.pathParams("first","lessonPrograms","second","getAll");
    }

    @When("For Lesson programs, a GETALL Request is issued and a Response is received")
    public void forLessonProgramsAGETALLRequestIsIssuedAndAResponseIsReceived() {
        response=given(spec).when().get("{first}/{second}");
    }

    @Then("In order to see the lessons programs, it is verified that the Status code is {int}")
    public void inOrderToSeeTheLessonsProgramsItIsVerifiedThatTheStatusCodeIs(int statusCode) {
        response
                .then()
                .assertThat()
                .statusCode(statusCode)
                .contentType(ContentType.JSON)
                .header("Server","nginx/1.22.0 (Ubuntu)")
                .header("Connection","keep-alive");
    }
}
