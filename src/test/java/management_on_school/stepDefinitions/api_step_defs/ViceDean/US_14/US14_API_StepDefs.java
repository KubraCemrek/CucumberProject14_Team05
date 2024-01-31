package management_on_school.stepDefinitions.api_step_defs.ViceDean.US_14;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import management_on_school.pojos.teacher_management.TeacherContObjectPojo;
import management_on_school.pojos.teacher_management.TeacherContResponsePojo;
import management_on_school.pojos.teacher_management.TeacherUpdatePojo;
import org.junit.Assert;

import java.util.List;

import static io.restassured.RestAssured.given;
import static management_on_school.base_url.BaseUrl.spec;

public class US14_API_StepDefs {

    TeacherContObjectPojo expectedData;
    Response response;
    TeacherUpdatePojo payload;
    String expectedData1;
    Faker faker = new Faker();

    @When("URL is edited for Teachers getTeacherByName")
    public void urlIsEditedForTeachersGetTeacherByName() {
        // /teachers/getTeacherByName?name=Kubra
        spec.pathParams("first","teachers","second","getTeacherByName")
                .queryParam("name","Kubra ");
    }

    @And("expectedData is edited for Teachers getTeacherByName")
    public void expectedDataIsEditedForTeachersGetTeacherByName() {
        expectedData = new TeacherContObjectPojo(
                5222,
                "KubraAPI",
                "Kubra ",
                "API",
                "2007-12-30",
                "765-90-7824",
                "turkey",
                "222-331-1811",
                "FEMALE",
                "marpkk@hotmail.com",
                true);
    }

    @And("a post request is sent for Teachers getTeacherByName and a response is received.")
    public void aPostRequestIsSentForTeachersGetTeacherByNameAndAResponseIsReceived() {
        response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();
    }

    @Then("verifies that the status code is {int}")
    public void verifiesThatTheStatusCodeIs(int statusCode) {
        Assert.assertEquals(statusCode, response.statusCode());
    }

    @And("response body for Teachers getTeacherByName Lesson is verified")
    public void responseBodyForTeachersGetTeacherByNameLessonIsVerified() {
        JsonPath actualData = response.jsonPath();

        Assert.assertEquals(expectedData.getUsername(),         actualData.getString("[0].username"));
        Assert.assertEquals(expectedData.getName(),             actualData.getString("[0].name"));
        Assert.assertEquals(expectedData.getSurname(),          actualData.getString("[0].surname"));
        Assert.assertEquals(expectedData.getBirthDay(),         actualData.getString("[0].birthDay"));
        Assert.assertEquals(expectedData.getSsn(),              actualData.getString("[0].ssn"));
        Assert.assertEquals(expectedData.getBirthPlace(),       actualData.getString("[0].birthPlace"));
        Assert.assertEquals(expectedData.getPhoneNumber(),      actualData.getString("[0].phoneNumber"));
        Assert.assertEquals(expectedData.getGender(),           actualData.getString("[0].gender"));
        Assert.assertEquals(expectedData.getEmail(),            actualData.getString("[0].email"));
        Assert.assertEquals(expectedData.isAdvisorTeacher(),    actualData.getBoolean("[0].advisorTeacher"));
    }

    @When("URL is edited for Teachers update")
    public void urlIsEditedForTeachersUpdate() {
        spec.pathParams("first","teachers","second","update","third","5225");
    }

    @And("payload is edited for Teachers update")
    public void payloadIsEditedForTeachersUpdate() {
        payload = new TeacherUpdatePojo(
                "1998-01-01",
                "turkey",
                faker.internet().emailAddress(),
                "FEMALE",
                false,
                List.of(3420),
                faker.name().firstName(),
                "Project14",
                "222-391-1111",
                "456-91-3450",
                faker.name().lastName(),
                "KubraUpdate");


        expectedData1 ="Teacher updated Successful";
    }

    @And("a post request is sent for teachers update and a response is received")
    public void aPostRequestIsSentForTeachersUpdateAndAResponseIsReceived() {
        response = given(spec).body(payload).when().put("{first}/{second}/{third}");
        response.prettyPrint();
    }

    @And("response body for Teachers update Lesson is verified")
    public void responseBodyForTeachersUpdateLessonIsVerified() {

        TeacherContResponsePojo actualData1 =  response.as(TeacherContResponsePojo.class);

        Assert.assertEquals(payload.getUsername(),          actualData1.getObject().getUsername());
        Assert.assertEquals(payload.getName(),              actualData1.getObject().getName());
        Assert.assertEquals(payload.getSurname(),           actualData1.getObject().getSurname());
        Assert.assertEquals(payload.getBirthDay(),          actualData1.getObject().getBirthDay());
        Assert.assertEquals(payload.getSsn(),               actualData1.getObject().getSsn());
        Assert.assertEquals(payload.getBirthPlace(),        actualData1.getObject().getBirthPlace());
        Assert.assertEquals(payload.getPhoneNumber(),       actualData1.getObject().getPhoneNumber());
        Assert.assertEquals(payload.getGender(),            actualData1.getObject().getGender());
        Assert.assertEquals(payload.getEmail(),             actualData1.getObject().getEmail());
        Assert.assertEquals(expectedData1,                   actualData1.getMessage());
    }
}
