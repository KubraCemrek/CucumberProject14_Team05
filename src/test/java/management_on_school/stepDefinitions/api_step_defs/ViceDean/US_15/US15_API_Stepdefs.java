package management_on_school.stepDefinitions.api_step_defs.ViceDean.US_15;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import management_on_school.pojos.student_management.vicedean_student_management.ObjectVDPojo;
import management_on_school.pojos.student_management.vicedean_student_management.StudentDeleteResponseVDPojo;
import management_on_school.pojos.student_management.vicedean_student_management.StudentPostResponseVDPojo;
import management_on_school.pojos.student_management.vicedean_student_management.StudentPostVDPojo;


import java.util.List;

import static io.restassured.RestAssured.given;
import static management_on_school.base_url.BaseUrl.setUp;
import static management_on_school.base_url.BaseUrl.spec;
import static org.junit.Assert.assertEquals;



public class US15_API_Stepdefs {
    static int studentId;
    static int stIde;

    public static int advisorTeacherId = 4004;
    public static String stBirthDay = "2017-05-05";
    public static String stBirthPlace = "impedit";
    public static String stEmail = "branda.beier@yahoo.com";
    public static String stFatherName = "Laree";
    public static String stGender = "MALE";
    public static String stMotherName = "Anne";
    public static String stName = "Courtney";
    public static String stPassword = "Baba12345";
    public static String stPhoneNumber = "059-166-0285";
    public static String stSsn = "086-95-1091";
    public static String stSurname = "Hilpert";
    public static String stUsername = "2443gakky";
    StudentPostVDPojo payload;
    Response response;
    StudentPostResponseVDPojo actualData;
    JsonPath json;
    public static List<Integer> idList;
    List<Integer> studentNumberList;

    public static int stId;
    StudentDeleteResponseVDPojo deleteResponse;
    StudentDeleteResponseVDPojo expectedDataDeleteRes;

    int stNumber;
    ObjectVDPojo object;
    StudentPostResponseVDPojo expectedData;
    ObjectVDPojo actualDataObj;
    StudentPostVDPojo expectedData1;


    @Given("Login as Vice Dean and set the URL for student SAVE")
    public void loginAsViceDeanAndSetTheURLForStudentSAVE() {
        setUp("gakky87VD", "Cavabunga82");
        spec.pathParams("first", "students", "second", "save");
    }

    @And("Create the Payload for Student Save")
    public void createThePayloadForStudentSave() {
        payload = new StudentPostVDPojo(4004, "2017-05-05", "impedit", "branda.beier@yahoo.com", "Laree", "MALE", "Anne", "Courtney", "Baba12345", "059-166-0285", "086-95-1091", "Hilpert", "2443gakky");
    }

    @When("Vice Dean sends a POST request for adding a student and receives a response")
    public void viceDeanSendsAPOSTRequestForAddingAStudentAndReceivesAResponse() {
        response = given(spec).body(payload).when().post("{first}/{second}");
        actualData = response.as(StudentPostResponseVDPojo.class);
    }

    @Then("Verify that the status code is {int}")
    public void verifyThatTheStatusCodeIs(int statusCode) {
        assertEquals(statusCode, response.statusCode());
    }

    @And("Verify that the response body for Student Save")
    public void verifyThatTheResponseBodyForStudentSave() {
        assertEquals(payload.getAdvisorTeacherId(), actualData.getObject().getAdvisorTeacherId());
        assertEquals(payload.getBirthDay(), actualData.getObject().getBirthDay());
        assertEquals(payload.getBirthPlace(), actualData.getObject().getBirthPlace());
        assertEquals(payload.getEmail(), actualData.getObject().getEmail());
        assertEquals(payload.getFatherName(), actualData.getObject().getFatherName());
        assertEquals(payload.getGender(), actualData.getObject().getGender());
        assertEquals(payload.getMotherName(), actualData.getObject().getMotherName());
        assertEquals(payload.getName(), actualData.getObject().getName());
        assertEquals(payload.getPhoneNumber(), actualData.getObject().getPhoneNumber());
        assertEquals(payload.getSsn(), actualData.getObject().getSsn());
        assertEquals(payload.getSurname(), actualData.getObject().getSurname());
        assertEquals(payload.getUsername(), actualData.getObject().getUsername());
    }

    @Given("Login as Vice Dean and  Get the ID number of the registered Student account information")
    public void loginAsViceDeanAndGetTheIDNumberOfTheRegisteredStudentAccountInformation() {
        setUp("gakky87VD", "Cavabunga82");
        spec.pathParams("first", "students", "second", "getAll");
        response = given(spec).when().get("{first}/{second}");

        json = response.jsonPath();

        //----------olusturulan ogrenciye ait id yi getirir------------------------------------
        idList = json.getList("findAll{it.username=='" + stUsername + "'}.id");
        stId = idList.get(0);
        System.out.println("Student id = " + stId);

        //----------olusturulan ogrenciye ait student number i getirir-------------------------
        studentNumberList = json.getList("findAll{it.username=='" + stUsername + "'}.studentNumber");
        stNumber = studentNumberList.get(0);
        //System.out.println("Student number = " + stNumber);

    }

    @And("Set the URL for Student GetStudentById")
    public void setTheURLForStudentGetStudentById() {
        spec.pathParams("first", "students", "second", "getStudentById")
                .queryParam("id", stId);

    }

    @And("Set the expected data for Student GetStudentById")
    public void setTheExpectedDataForStudentGetStudentById() {
        object = new ObjectVDPojo(
                stId, stUsername, stSsn, stName, stSurname, stBirthDay, stBirthPlace, stPhoneNumber, stGender, stMotherName
                , stFatherName, stNumber, advisorTeacherId, "AllrightBigman", "Yoloten"
                , "nassir.tomasi@free2ducks.com", stEmail, false);
        expectedData = new StudentPostResponseVDPojo(object, "Student saved Successfully");
        // System.out.println("expectedData = " + expectedData);

    }

    @When("Send GET Request for Student GetStudentById and get Response")
    public void sendGETRequestForStudentGetStudentByIdAndGetResponse() {
        response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();
        actualDataObj = response.as(ObjectVDPojo.class);
    }

    @Then("Verify that Status code is {int}")
    public void verifyThatStatusCodeIs(int statusCode) {
        assertEquals(statusCode, response.statusCode());
    }

    @And("Verify the Response Body for Student GetStudentById")
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

    @Given("Edit teh URL for Student Delete")
    public void editTehURLForStudentDelete() {
        spec.pathParams("first", "students", "second", "delete", "third", stId);
    }

    @When("Send the DELETE Request and Response is received")
    public void sendTheDELETERequestAndResponseIsReceived() {
        response = given(spec).when().delete("{first}/{second}/{third}");
        deleteResponse = response.as(StudentDeleteResponseVDPojo.class);
        expectedDataDeleteRes = new StudentDeleteResponseVDPojo("Student Deleted", "OK");
        response.prettyPrint();

    }

    @Then("Verify that the Response Body for Student Delete is validated")
    public void verifyThatTheResponseBodyForStudentDeleteIsValidated() {
        assertEquals(expectedDataDeleteRes.getMessage(), deleteResponse.getMessage());
        assertEquals(expectedDataDeleteRes.getHttpStatus(), deleteResponse.getHttpStatus());

    }

   // @Given("{string} yetkisile giriş yapılır")
   // public void yetkisileGirişYapılır(String arg0) {
   //     setUp("gakky87VD", "Cavabunga82");
   // }
//
   // @And("Kayitli Student verisinin ID nnumarasini alma")
   // public void kayitliStudentVerisininIDNnumarasiniAlma() {
   //     spec.pathParams("first","students","second","getAll");
   //     Response response = given(spec).when().get("{first}/{second}");
   //     JsonPath json = response.jsonPath();
   //     stIde= json.getInt("find{it.username=='2443gakky'}.id");
   // }
//
   // @And("Student getStudentById icin URL duzenlenir")
   // public void studentGetStudentByIdIcinURLDuzenlenir() {
   //     spec.pathParams("first","students","second","getStudentById","third",stIde);
   // }
//
   // @And("Student getStudentById icin beklenen veriler duzenlenir")
   // public void studentGetStudentByIdIcinBeklenenVerilerDuzenlenir() {
   //      expectedData1=new StudentPostVDPojo(4004, "2017-05-05",
   //             "impedit",
   //             "branda.beier@yahoo.com",
   //             "Laree", "MALE",
   //             "Anne", "Courtney",
   //             "Baba12345", "059-166-0285",
   //             "086-95-1091", "Hilpert",
   //             "2443gakky");
//
   // }
//
   // @When("Student getStudentById icin GET Request gonderilir Response alinir")
   // public void studentGetStudentByIdIcinGETRequestGonderilirResponseAlinir() {
   //   response=  given(spec).when().get("{first}/{second}/{third}");
//
   //   StudentPostResponseVDPojo actualData1=response.as(StudentPostResponseVDPojo.class);
   // }
//
   // @Then("Status kodun {string} oldugu dogrulanir")
   // public void statusKodunOlduguDogrulanir(String statusCode) {
   //     assertEquals(statusCode, response.statusCode());
   // }
//
   // @And("Student getStudentById icin gelen Response body dogrulanir")
   // public void studentGetStudentByIdIcinGelenResponseBodyDogrulanir() {
   // }
}//