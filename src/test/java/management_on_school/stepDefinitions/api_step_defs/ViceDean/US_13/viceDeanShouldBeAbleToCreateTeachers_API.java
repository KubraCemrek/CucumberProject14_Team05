package management_on_school.stepDefinitions.api_step_defs.ViceDean.US_13;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import management_on_school.pojos.teacher_management.TeacherObjectPojo_hu;
import management_on_school.pojos.teacher_management.TeacherResponsePojo_hu;
import management_on_school.pojos.teacher_management.TeacherSavePostPojo_hu;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static management_on_school.base_url.BaseUrl.setUp;
import static management_on_school.base_url.BaseUrl.spec;
import static org.junit.Assert.assertEquals;

public class viceDeanShouldBeAbleToCreateTeachers_API {
    TeacherSavePostPojo_hu payload;
    Response response;
    TeacherResponsePojo_hu actualData;
    static int userId;

    public static TeacherObjectPojo_hu teacherObject;
    public static TeacherResponsePojo_hu expectedData;

    //---------------------POST-----------------------------------------

    @Given("Login as {string}_hu")
    public void Login_as(String user) {
        switch (user) {
            case "Admin":
                setUp("Team05Admin", "Project14");
                System.out.println("Logged in as Admin");
                break;
            case "Vice Dean":
                setUp("Team05ViceDean", "Project14");
                System.out.println("Logged in as Vice Dean");
                break;
        }
    }


    @Given("Save URL for Teacher edit_hu")
    public void Save_URL_for_teacher_edit_hu() {
        spec.pathParams("first", "teachers", "second", "save");
    }

    @Given("Save  Payload Teacher edit_hu")
    public void Save_payload_teacher_edit_hu() {
        List<Integer> lessonIdList = new ArrayList<>();
        lessonIdList.add(3524);
        payload = new TeacherSavePostPojo_hu(
                "1983-01-01",
                "Mersin",
                "uslu@halil",
                "MALE",
                true,
                lessonIdList,
                "Halil",
                "Karaman1",
                "537-235-9246",
                "564-38-8164",
                "Uslu",
                "TeacherUslu"
        );
    }

    @When("A POST Request is sent to Register a Teacher and a Response is received_hu")
    public void A_POST_Request_is_sent_to_Register_a_Teacher_and_a_Response_is_received_hu() {
        response = given(spec)
                .when().body(payload)
                .post("{first}/{second}");
        actualData = response.as(TeacherResponsePojo_hu.class);
    }

    @Then("Verified status code is {int}_hu")
    public void Verified_status_code_is_hu(int statusCode) {
        assertEquals(statusCode, response.statusCode());
    }

    @Then("Response Body for Teacher Save is verified_hu")
    public void TResponse_Body_for_Teacher_Save_is_verified_hu() {
        assertEquals(payload.getUsername(), actualData.getObject().getUsername());
        assertEquals(payload.getName(), actualData.getObject().getName());
        assertEquals(payload.getSurname(), actualData.getObject().getSurname());
        assertEquals(payload.getBirthDay(), actualData.getObject().getBirthDay());
        assertEquals(payload.getSsn(), actualData.getObject().getSsn());
        assertEquals(payload.getBirthPlace(), actualData.getObject().getBirthPlace());
        assertEquals(payload.getPhoneNumber(), actualData.getObject().getPhoneNumber());
        assertEquals(payload.getGender(), actualData.getObject().getGender());
        assertEquals(payload.getEmail(), actualData.getObject().getEmail());

    }

    //---------------------GET-----------------------------------------

    @Then("Vice Dean seved the userID after created teacher_hu")
    public void vice_dean_seved_the_userID_after_created_teacher_hu() {
        spec.pathParams("first", "teachers", "second", "getAll");
        response = given(spec).when().get("{first}/{second}");

        JsonPath json = response.jsonPath();
        List<Integer> userIdList = json.getList("findAll{it.username=='TeacherUslu'}.userId");
        userId = userIdList.get(0);
    }

    @Then("Vice Dean creates GET Request with the URL and teacher-search path parameters_hu")
    public void Vice_Dean_creates_GET_Request_with_the_URL_and_teachersearch_path_parameters_hu() {
        spec.pathParams("first", "teachers", "second", "getSavedTeacherById", "third", userId);

    }


    @Then("Vice Dean creates Expected Response Body for get_hu")
    public void Vice_Dean_creates_Expected_Response_Body_for_get_hu() {
        teacherObject = new TeacherObjectPojo_hu(
                userId,
                "TeacherUslu",
                "Halil",
                "Uslu",
                "1983-01-01",
                "564-38-8164",
                "Mersin",
                "537-235-9246",
                "MALE",
                "uslu@halil",
                true);

        expectedData = new TeacherResponsePojo_hu(teacherObject,
                "Teacher successfully found",
                "OK");
    }

    @When("Vice Dean sends GET Request gonderilir ve Response alinir_hu")
    public void vice_dean_sends_GET_request_gonderilir_ve_response_alinir_hu() {
        response = given(spec)
                .when()
                .get("{first}/{second}/{third}");
        response.prettyPrint();
        actualData = response.as(TeacherResponsePojo_hu.class);
    }

    @Then("Vice Dean sends GET  Response Body as expected_hu")
    public void Vice_Dean_sends_GET_Response_Body_as_expected_hu() {

        assertEquals(teacherObject.getUsername(), actualData.getObject().getUsername());
        assertEquals(teacherObject.getName(), actualData.getObject().getName());
        assertEquals(teacherObject.getSurname(), actualData.getObject().getSurname());
        assertEquals(teacherObject.getBirthDay(), actualData.getObject().getBirthDay());
        assertEquals(teacherObject.getSsn(), actualData.getObject().getSsn());
        assertEquals(teacherObject.getBirthPlace(), actualData.getObject().getBirthPlace());
        assertEquals(teacherObject.getPhoneNumber(), actualData.getObject().getPhoneNumber());
        assertEquals(teacherObject.getGender(), actualData.getObject().getGender());
        assertEquals(teacherObject.getEmail(), actualData.getObject().getEmail());
        assertEquals(expectedData.getMessage(), actualData.getMessage());
        assertEquals(expectedData.getHttpStatus(), actualData.getHttpStatus());

    }


    //---------------------DELETE-----------------------------------------

    @Then("Vice Dean creates DELETE Request with the URL and teacher-search path parameters_hu")
    public void Vice_Dean_creates_DELETE_Request_with_the_URL_and_teachersearch_path_parameters_hu() {
        spec.pathParams("first", "teachers", "second", "delete", "third", userId); }

    @When("Vice Dean sends DELETE Request with the URL and delete path parameters_hu")
    public void Vice_Dean_sends_DELETE_Request_with_the_URL_and_delete_path_parameters_hu() {
        response = given(spec)
                .when()
                .delete("{first}/{second}/{third}");
        response.prettyPrint();
    }


    @Then("Teacher deletion Status code is verified as {int}_hu")
    public void Teacher_deletion_Status_code_is_verified_as_hu(int deleteStatusCode) {
        assertEquals(deleteStatusCode, response.statusCode());

    }

    @Then("The Vice Dean confirmed the deletion of the Teacher's Text, as expected_hu")
    public void The_Vice_Dean_confirmed_the_deletion_of_theTeachers_Text_as_expected_hu() {

        JSONObject expectedResponseBody = new JSONObject();
        expectedResponseBody.put("message", "Teacher Deleted");
        expectedResponseBody.put("httpStatus", "OK");

        //Assertions
        JsonPath responseJsonBody = response.jsonPath();
        assertEquals(expectedResponseBody.get("message"), responseJsonBody.get("message"));
        assertEquals(expectedResponseBody.get("httpStatus"), responseJsonBody.get("httpStatus"));
    }

}