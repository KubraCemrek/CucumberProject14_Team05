package management_on_school.stepDefinitions.api_step_defs.Admin.US_23;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import management_on_school.pojos.vicedean_management.ObjectPojo;
import management_on_school.pojos.vicedean_management.ResponseViceDeanTPojo;
import management_on_school.pojos.vicedean_management.ViceDeanPostPojo;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static management_on_school.base_url.BaseUrl.setUp;
import static management_on_school.base_url.BaseUrl.spec;

public class US23_AdminShouldBeAbleToAddViceDeanAPI {
    ViceDeanPostPojo payload;
    Response response;
    ResponseViceDeanTPojo actualData;
    static int userId;
    ObjectPojo expectedData;
    ResponseViceDeanTPojo expectedDataDelete;
    @Given("Login as Admin and set the URL for Vice Dean SAVE.")
    public void loginAsAdminAndSetTheURLForViceDeanSAVE() {
        setUp("AdminProject14","Project14+");
        spec.pathParams("first","vicedean",
                "second","save");
    }

    @When("Create the Payload for Vice Dean Save as Admin.")
    public void createThePayloadForViceDeanSaveAsAdmin() {
        payload = new ViceDeanPostPojo("1990-12-15","Konya","Male","Furkan","F123456","154-987-9658","124-58-3214","Yanik","Fu6548");
    }

    @And("Admin sends a POST request for adding a Vice Dean and receives a response.")
    public void adminSendsAPOSTRequestForAddingAViceDeanAndReceivesAResponse() {
        response =  given().body(spec).when().post("{first}/{second}");
        actualData = response.as(ResponseViceDeanTPojo.class);
    }

    @Then("Verify that the Status Code is {int}")
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

    @Given("Login as Admin and set the URL for Vice Dean Views.")
    public void loginAsAdminAndSetTheURLForViceDeanViews() {
        JsonPath json = response.jsonPath();
        userId = json.getInt("find{it.username=='team5Ali'}.userId");

        setUp("AdminProject14", "Project14+");
        spec.pathParams("first", "admin",
                "second", "getAll", "page", 0, "size", 10, "sort", "name", "type", "desc", "third", userId);
    }

    @And("Adm sends a POST request for Views a Vice Dean and receives a response.")
    public void admSendsAPOSTRequestForViewsAViceDeanAndReceivesAResponse() {
        expectedData = new ObjectPojo(
                3496,
                "team5Ali",
                "ali",
                "kurt",
                "2000-11-14",
                "148-85-9784",
                "kenya",
                "147-548-4879",
                "Male"
        );
    }

    @And("Create expected Data for Views Vice Dean.")
    public void createExpectedDataForViewsViceDean() {
        response =  given().body(spec).when().post("{first}/{second}/{third}");
        actualData = response.as(ResponseViceDeanTPojo.class);
    }

    @And("Verify that the response body for Vice Dean Views")
    public void verifyThatTheResponseBodyForViceDeanViews() {
        assertEquals(expectedData.getUserId(),actualData.getObject().getUserId());
        assertEquals(expectedData.getBirthDay(),actualData.getObject().getBirthDay());
        assertEquals(expectedData.getBirthPlace(),actualData.getObject().getBirthPlace());
        assertEquals(expectedData.getGender(),actualData.getObject().getGender());
        assertEquals(expectedData.getName(),actualData.getObject().getName());
        assertEquals(expectedData.getPhoneNumber(),actualData.getObject().getPhoneNumber());
        assertEquals(expectedData.getSsn(),actualData.getObject().getSsn());
        assertEquals(expectedData.getSurname(),actualData.getObject().getSurname());
        assertEquals(expectedData.getUsername(),actualData.getObject().getUsername());
    }

    @Given("Login as Admin and set the URL for Vice Dean Delete.")
    public void loginAsAdminAndSetTheURLForViceDeanDelete() {
        JsonPath json = response.jsonPath();
        userId = json.getInt("find{it.username=='team5Ali'}.userId");

        setUp("AdminProject14","Project14+");
        spec.pathParams("first","admin",
                "second","delete","third",userId);
    }

    @And("Admin sends a POST request for Delete a Vice Dean and receives a response.")
    public void adminSendsAPOSTRequestForDeleteAViceDeanAndReceivesAResponse() {
        response =  given().body(spec).when().post("{first}/{second}/{third}");
        actualData = response.as(ResponseViceDeanTPojo.class);
    }

    @And("Verify that the response body for Vice Dean Delete")
    public void VerifythattheresponsebodyforViceDeanDelete() {
        JSONObject expectedDeleteResponseBody = new JSONObject();
        expectedDeleteResponseBody.put("message", "Vice Dean Deleted");
        expectedDeleteResponseBody.put("httpStatus", "OK");

        //Assertions
        JsonPath actualDeleteResponseBody = response.jsonPath();
        assertEquals(expectedDeleteResponseBody.get("message"), actualDeleteResponseBody.get("message"));
        assertEquals(expectedDeleteResponseBody.get("httpStatus"), actualDeleteResponseBody.get("httpStatus"));
    }
}
