package management_on_school.stepDefinitions.api_step_defs.Admin.US_23;

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

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static management_on_school.base_url.BaseUrl.setUp;
import static management_on_school.base_url.BaseUrl.spec;

public class US23_AdminShouldBeAbleToAddViceDeanAPI {
    ViceDeanPostPojo payload;
    Response response;
    ViceDeanResponsePojo actualData;
    static int userId;
    ViceDeanObjectPojo expectedData;
    @Given("Login as Admin and set the URL for Vice Dean SAVE.")
    public void loginAsAdminAndSetTheURLForViceDeanSAVE() {
        setUp("Team05Admin","Project14");
        spec.pathParams("first","vicedean",
                "second","save");
    }

    @When("Create the Payload for Vice Dean Save as Admin.")
    public void createThePayloadForViceDeanSaveAsAdmin() {
        payload = new ViceDeanPostPojo(
                "1990-12-16",
                "konya",
                "FEMALE",
                "fatıma",
                "Fato123456",
                "154-987-9655",
                "124-58-3215",
                "yanik",
                "Fato6548");
    }

    @And("Admin sends a POST request for adding a Vice Dean and receives a response.")
    public void adminSendsAPOSTRequestForAddingAViceDeanAndReceivesAResponse() {
        response =  given(spec).body(payload).when().post("{first}/{second}");
        actualData = response.as(ViceDeanResponsePojo.class);
    }

    @Then("Verify that the Status Code Is {int}")
    public void verifyThatTheStatusCodeIs(int statusCode) {
        assertEquals(statusCode,response.statusCode());
    }

    @Then("Verify that the response body for Vice Dean Save")
    public void verifyThatTheResponseBodyForViceDeanSave() {
        assertEquals(payload.getBirthDay(),actualData.getObject().getBirthDay());
        assertEquals(payload.getBirthPlace(),actualData.getObject().getBirthPlace());
        assertEquals(payload.getGender(),actualData.getObject().getGender());
        assertEquals(payload.getName(),actualData.getObject().getName());
        assertEquals(payload.getPhoneNumber(),actualData.getObject().getPhoneNumber());
        assertEquals(payload.getSsn(),actualData.getObject().getSsn());
        assertEquals(payload.getSurname(),actualData.getObject().getSurname());
        assertEquals(payload.getUsername(),actualData.getObject().getUsername());
    }
    //---------------------------SCENARIO 2 ----------------------------------------------------------------------
    @Given("Login as Admin and set the URL for Vice Dean Views.")
    public void loginAsAdminAndSetTheURLForViceDeanViews() {
        setUp("Team05Admin", "Project14");
        spec.pathParams("first", "vicedean",
                "second", "getAll");
        response = given(spec).when().get("{first}/{second}");

        JsonPath json = response.jsonPath();
        userId = json.getInt("find{it.username=='Fato6548'}.userId");

        setUp("Team05Admin", "Project14");
        spec.pathParams("first", "vicedean",
                "second", "getViceDeanById", "third", userId);
    }


    @And("Admin sends a GET request for Views a Vice Dean and receives a response.")
    public void adminSendsAPOSTRequestForViewsAViceDeanAndReceivesAResponse() {
        expectedData = new ViceDeanObjectPojo(
                userId,
                "Fato6548",
                "fatıma",
                "yanik",
                "1990-12-16",
                "124-58-3215",
                "konya",
                "154-987-9655",
                "FEMALE"
        );
    }

    @And("Verify that the response body And Create expected Data for Vice Dean Views")
    public void verifyThatTheResponseBodyAndCreateExpectedDataForViceDeanViews() {
        response = given(spec).when().get("{first}/{second}/{third}");
        actualData = response.as(ViceDeanResponsePojo.class);
        response.prettyPrint();

        assertEquals(expectedData.getUserId(), actualData.getObject().getUserId());
        assertEquals(expectedData.getUsername(), actualData.getObject().getUsername());
        assertEquals(expectedData.getName(), actualData.getObject().getName());
        assertEquals(expectedData.getSurname(), actualData.getObject().getSurname());
        assertEquals(expectedData.getBirthDay(), actualData.getObject().getBirthDay());
        assertEquals(expectedData.getSsn(), actualData.getObject().getSsn());
        assertEquals(expectedData.getBirthPlace(), actualData.getObject().getBirthPlace());
        assertEquals(expectedData.getPhoneNumber(), actualData.getObject().getPhoneNumber());
        assertEquals(expectedData.getGender(), actualData.getObject().getGender());
    }

    //-------------------------------------- SCENARIO 3 -----------------------------------------------------------
    @Given("Login as Admin and set the URL for Vice Dean Delete.")
    public void loginAsAdminAndSetTheURLForViceDeanDelete() {

        setUp("Team05Admin", "Project14");
        spec.pathParams("first", "vicedean",
                "second", "delete", "third", userId);
    }

    @And("Admin sends a DELETE request for Delete a Vice Dean and receives a response.")
    public void adminSendsAPOSTRequestForDeleteAViceDeanAndReceivesAResponse() {
        response =  given(spec).when().delete("{first}/{second}/{third}");
    }

    @And("Verify that the response body for Vice Dean Delete")
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
