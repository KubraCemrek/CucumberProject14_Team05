package management_on_school.stepDefinitions.api_step_defs.Dean.US_06;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import management_on_school.pojos.vicedean_management.ViceDeanObjectPojo;
import management_on_school.pojos.vicedean_management.ViceDeanPostPojo;
import management_on_school.pojos.vicedean_management.ViceDeanResponsePojo;
import org.json.JSONObject;

import java.util.List;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static management_on_school.base_url.BaseUrl.setUp;
import static management_on_school.base_url.BaseUrl.spec;

public class US06_DeanShouldBeAbleToCreateViceDeanAPI {

    ViceDeanPostPojo payload;
    Response response;
    ViceDeanResponsePojo actualData;
    static int userId;
    ViceDeanObjectPojo expectedData;


    @Given("Login as Dean and set the URL for Vice Dean SAVE.")
    public void loginAsDeanAndSetTheURLForViceDeanSAVE() {
        setUp("Team05Dean", "Project14");
        spec.pathParams("first", "vicedean",
                "second", "save");
    }

    @When("Create the Payload for Vice Dean Save as Dean.")
    public void createThePayloadForViceDeanSaveAsDean() {
        payload = new ViceDeanPostPojo(
                "1990-11-15",
                "mardin",
                "MALE",
                "furkan",
                "Fu123456",
                "154-987-9666",
                "124-58-3222",
                "yanik",
                "Fur6548");
    }

    @Then("Dean sends a POST request for adding a Vice Dean and receives a response.")
    public void deanSendsAPOSTRequestForAddingAViceDeanAndReceivesAResponse() {
        response =  given(spec).body(payload).when().post("{first}/{second}");
        actualData = response.as(ViceDeanResponsePojo.class);

    }

    @And("Verify that the Status Code Is {int}.")
    public void verifyThatTheStatusCodeIs(int statusCode) {
        assertEquals(statusCode,response.statusCode());

    }

    @And("Verify that the response body for Vice Dean Save.")
    public void verifyThatTheResponseBodyForViceDeanSave() {
        assertEquals(payload.getBirthDay(), actualData.getObject().getBirthDay());
        assertEquals(payload.getBirthPlace(), actualData.getObject().getBirthPlace());
        assertEquals(payload.getGender(), actualData.getObject().getGender());
        assertEquals(payload.getName(), actualData.getObject().getName());
        assertEquals(payload.getPhoneNumber(), actualData.getObject().getPhoneNumber());
        assertEquals(payload.getSsn(), actualData.getObject().getSsn());
        assertEquals(payload.getSurname(), actualData.getObject().getSurname());
        assertEquals(payload.getUsername(), actualData.getObject().getUsername());
    }

//---------------------------SCENARIO 2 ----------------------------------------------------------------------
    @Given("Login as Dean and set the URL for Vice Dean Views.")
    public void loginAsDeanAndSetTheURLForViceDeanUPDATE() {
        setUp("Team05Dean", "Project14");
        spec.pathParams("first", "vicedean",
                "second", "getAll");
        response = given(spec).when().get("{first}/{second}");

        JsonPath json = response.jsonPath();
        userId = json.getInt("find{it.username=='Fur6548'}.userId");

        setUp("Team05Dean", "Project14");
        spec.pathParams("first", "vicedean",
               "second", "getViceDeanById", "third", userId);

    }

    @And("Create expected Data for Views Vice Dean")
    public void creatExpectedDataForViewsViceDean() {
        expectedData = new ViceDeanObjectPojo(
                userId,
                "Fur6548",
                "furkan",
                "yanik",
                "1990-11-15",
                "124-58-3222",
                "mardin",
                "154-987-9666",
                "MALE"
        );

    }

    @When("Dean sends a POST request for Views a Vice Dean and receives a response.")
    public void deanSendsAPOSTRequestForViewsAViceDeanAndReceivesAResponse() {
        response = given(spec).when().get("{first}/{second}/{third}");
        actualData = response.as(ViceDeanResponsePojo.class);
    }

    @And("Verify that the response body for Vice Dean Views.")
    public void verifyThatTheResponseBodyForViceDeanUpdate() {
        assertEquals(expectedData.getUserId(), actualData.getObject().getUserId());
        assertEquals(expectedData.getBirthDay(), actualData.getObject().getBirthDay());
        assertEquals(expectedData.getBirthPlace(), actualData.getObject().getBirthPlace());
        assertEquals(expectedData.getGender(), actualData.getObject().getGender());
        assertEquals(expectedData.getName(), actualData.getObject().getName());
        assertEquals(expectedData.getPhoneNumber(), actualData.getObject().getPhoneNumber());
        assertEquals(expectedData.getSsn(), actualData.getObject().getSsn());
        assertEquals(expectedData.getSurname(), actualData.getObject().getSurname());
        assertEquals(expectedData.getUsername(), actualData.getObject().getUsername());
    }

//-------------------------------------- SCENARIO 3 -----------------------------------------------------------
    @Given("Login as Dean and set the URL for Vice Dean Delete.")
    public void loginAsDeanAndSetTheURLForViceDeanDelete() {

        setUp("Team05Dean", "Project14");
        spec.pathParams("first", "vicedean",
                "second", "delete", "third", userId);
    }

    @And("Dean sends a POST request for Delete a Vice Dean and receives a response.")
    public void deanSendsAPOSTRequestForDeleteAViceDeanAndReceivesAResponse() {
        response = given(spec).when().delete("{first}/{second}/{third}");

    }


    @And("Verify that the response body for Vice Dean Delete.")
    public void VerifythattheresponsebodyforViceDeanDelete() {
        JSONObject expectedDeleteResponseBody = new JSONObject();
        expectedDeleteResponseBody.put("message", "Vice dean Deleted");
        expectedDeleteResponseBody.put("httpStatus", "OK");

        //Assertions
        JsonPath actualDeleteResponseBody = response.jsonPath();
        assertEquals(expectedDeleteResponseBody.get("message"), actualDeleteResponseBody.get("message"));
        assertEquals(expectedDeleteResponseBody.get("httpStatus"), actualDeleteResponseBody.get("httpStatus"));
    }
}
