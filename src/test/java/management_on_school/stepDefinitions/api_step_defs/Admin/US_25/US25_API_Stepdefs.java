package management_on_school.stepDefinitions.api_step_defs.Admin.US_25;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import management_on_school.pojos.student_management.admin_student_management.ObjectAdminPojo;
import management_on_school.pojos.student_management.admin_student_management.StudentDeleteResponseAdminPojo;
import management_on_school.pojos.student_management.admin_student_management.StudentPostAdminPojo;
import management_on_school.pojos.student_management.admin_student_management.StudentPostResponseAdminPojo;


import java.util.List;

import static io.restassured.RestAssured.given;
import static management_on_school.base_url.BaseUrl.*;
import static org.junit.Assert.assertEquals;



public class US25_API_Stepdefs {
    static int studentId;

    public static int advisorTeacherId=4004;
    public static String stBirthDay="2019-09-05";
    public static String stBirthPlace="Ahal";
    public static String stEmail="wesson.andru@falkcia.com";
    public static String stFatherName="Maksat";
    public static String stGender="FEMALE";
    public static String stMotherName="Jumagul";
    public static String stName="Maya";
    public static String stPassword="Baba12345";
    public static String stPhoneNumber="059-176-3275";
    public static String stSsn="298-59-2092";
    public static String stSurname="Turkmen";
    public static String stUsername="maya2022";
    public static String stAdvisorTeacherName="AllrightBigman";
    public static String stAdvisorTeacherSurName="Yoloten";
    public static String stAdvisorTeacherEmail="nassir.tomasi@free2ducks.com";
    StudentPostAdminPojo payload;
    Response response;
    StudentPostResponseAdminPojo actualData;
    JsonPath json;
    public static List<Integer> idList;
    List<Integer> studentNumberList;

    public static int stId;
    StudentDeleteResponseAdminPojo deleteResponse;
    StudentDeleteResponseAdminPojo expectedDataDeleteRes;

    int stNumber;
    ObjectAdminPojo object;
    StudentPostResponseAdminPojo expectedData;
    ObjectAdminPojo actualDataObj;



    @Given("Login as Admin and set the URL for student SAVE")
    public void loginAsAdminAndSetTheURLForStudentSAVE() {
        setUp("AdminGakky","Cavabunga82");
        spec.pathParams("first","students","second","save");
    }

    @And("Create the Payload for Student Saveas Admin")
    public void createThePayloadForStudentSaveasAdmin() {
        payload=new StudentPostAdminPojo(4004,stBirthDay,stBirthPlace,stEmail,stFatherName,stGender,stMotherName,stName,stPassword,stPhoneNumber,stSsn,stSurname,stUsername);
    }

    @When("Admin sends a POST request for adding a student and receives a response")
    public void adminSendsAPOSTRequestForAddingAStudentAndReceivesAResponse() {
        response = given(spec).body(payload).when().post("{first}/{second}");
        actualData=response.as(StudentPostResponseAdminPojo.class);

    }

    @Then("Verify that the Status Code is {int}")
    public void verifyThatTheStatusCodeIs(int statusCode) {
       assertEquals(statusCode,response.statusCode());
    }

    @And("Verify that the response body for Student Save.")
    public void verifyThatTheResponseBodyForStudentSave() {
        assertEquals(payload.getAdvisorTeacherId(),actualData.getObject().getAdvisorTeacherId());
        assertEquals(payload.getBirthDay(),actualData.getObject().getBirthDay());
        assertEquals(payload.getBirthPlace(),actualData.getObject().getBirthPlace());
        assertEquals(payload.getEmail(),actualData.getObject().getEmail());
        assertEquals(payload.getFatherName(),actualData.getObject().getFatherName());
        assertEquals(payload.getGender(),actualData.getObject().getGender());
        assertEquals(payload.getMotherName(),actualData.getObject().getMotherName());
        assertEquals(payload.getName(),actualData.getObject().getName());
        assertEquals(payload.getPhoneNumber(),actualData.getObject().getPhoneNumber());
        assertEquals(payload.getSsn(),actualData.getObject().getSsn());
        assertEquals(payload.getSurname(),actualData.getObject().getSurname());
        assertEquals(payload.getUsername(),actualData.getObject().getUsername());
    }

    @Given("Login as Admin and  Get the ID number of the registered Student account information")
    public void loginAsAdminAndGetTheIDNumberOfTheRegisteredStudentAccountInformation() {
        setUp("AdminGakky","Cavabunga82");
        spec.pathParams("first","students","second","getAll");
        response=given(spec).when().get("{first}/{second}");

        json = response.jsonPath();

        //----------olusturulan ogrenciye ait id yi getirir------------------------------------
        idList = json.getList("findAll{it.username=='"+stUsername+"'}.id");
        stId=idList.get(0);
        System.out.println("Student id = "+stId);

        //----------olusturulan ogrenciye ait student number i getirir-------------------------
        studentNumberList = json.getList("findAll{it.username=='"+stUsername+"'}.studentNumber");
        stNumber =studentNumberList.get(0);
        //System.out.println("Student number = " + stNumber);
    }

    @And("Set the URL for Student GetStudentById.")
    public void setTheURLForStudentGetStudentById() {
        spec.pathParams("first","students","second","getStudentById")
                .queryParam("id",stId);
    }

    @And("Set the expected data for Student GetStudentById.")
    public void setTheExpectedDataForStudentGetStudentById() {
        object=new ObjectAdminPojo(stId,stUsername,stSsn,stName,stSurname,stBirthDay
                ,stBirthPlace,stPhoneNumber,stGender,stMotherName,stFatherName,stNumber
                ,advisorTeacherId,stAdvisorTeacherName,stAdvisorTeacherSurName,stAdvisorTeacherEmail,stEmail,false);
        expectedData=new StudentPostResponseAdminPojo(object,"Student saved Successfully");

    }

    @When("Send GET Request for Student GetStudentById and get Response.")
    public void sendGETRequestForStudentGetStudentByIdAndGetResponse() {
        response=given(spec).when().get("{first}/{second}");
        response.prettyPrint();
        actualDataObj =response.as(ObjectAdminPojo.class);
    }

    @Then("Verify that Status Code is {int}")
    public void verifyThatStatusCodeIs(int statusCode) {
        assertEquals(statusCode,response.statusCode());
    }

    @And("Verify the Response Body for Student GetStudentById.")
    public void verifyTheResponseBodyForStudentGetStudentById() {
        assertEquals(expectedData.getObject().getId(), actualDataObj.getId());
        assertEquals(expectedData.getObject().getUsername(), actualDataObj.getUsername());
        assertEquals(expectedData.getObject().getSsn(), actualDataObj.getSsn());
        assertEquals(expectedData.getObject().getName(), actualDataObj.getName());
        assertEquals(expectedData.getObject().getSurname(), actualDataObj.getSurname());
        assertEquals(expectedData.getObject().getBirthDay(), actualDataObj.getBirthDay());
        assertEquals(expectedData.getObject().getBirthPlace(), actualDataObj.getBirthPlace());
        assertEquals(expectedData.getObject().getPhoneNumber(), actualDataObj.getPhoneNumber());
        assertEquals(expectedData.getObject().getGender(), actualDataObj.getGender());
        assertEquals(expectedData.getObject().getMotherName(), actualDataObj.getMotherName());
        assertEquals(expectedData.getObject().getFatherName(), actualDataObj.getFatherName());
        assertEquals(expectedData.getObject().getStudentNumber(), actualDataObj.getStudentNumber());
        assertEquals(expectedData.getObject().getAdvisorTeacherId(), actualDataObj.getAdvisorTeacherId());
        assertEquals(expectedData.getObject().getAdvisorTeacherName(), actualDataObj.getAdvisorTeacherName());
        assertEquals(expectedData.getObject().getAdvisorTeacherSurname(), actualDataObj.getAdvisorTeacherSurname());
        assertEquals(expectedData.getObject().getAdvisorTeacherEmail(), actualDataObj.getAdvisorTeacherEmail());
        assertEquals(expectedData.getObject().getEmail(), actualDataObj.getEmail());
        assertEquals(expectedData.getObject().isActive(), actualDataObj.isActive());
    }

    @Given("Edit teh URL for Student Delete.")
    public void editTehURLForStudentDelete() {
        spec.pathParams("first","students","second","delete","third",stId);
    }

    @When("Send the DELETE Request and Response is received.")
    public void sendTheDELETERequestAndResponseIsReceived() {
        response=given(spec).when().delete("{first}/{second}/{third}");
        deleteResponse=response.as(StudentDeleteResponseAdminPojo.class);
        expectedDataDeleteRes=new StudentDeleteResponseAdminPojo("Student Deleted","OK");
        response.prettyPrint();
    }

    @Then("Verify that the Response Body for Student Delete is validated.")
    public void verifyThatTheResponseBodyForStudentDeleteIsValidated() {
        assertEquals(expectedDataDeleteRes.getMessage(),deleteResponse.getMessage());
        assertEquals(expectedDataDeleteRes.getHttpStatus(),deleteResponse.getHttpStatus());

    }
}