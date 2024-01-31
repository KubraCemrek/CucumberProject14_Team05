package management_on_school.stepDefinitions.api_step_defs.ViceDean.US_12;

import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import management_on_school.pojos.teacher_management.*;

import java.util.*;

import static io.restassured.RestAssured.given;
import static management_on_school.base_url.BaseUrl.spec;
import static org.junit.Assert.*;

public class US12_API_StepDefs {
    Response response;
    List<Integer> lessonProgramIdKC;
    TeacherContObjectPojo expectedTeacherData;
    ChooseLessonPojo expectedLessonData;
    TeacherContResponsePojo actualDataTeacher;
    public static int userId;

    @Then("teacher ID is obtained")
    public void teacherIDIsObtained() {
        spec.pathParams("first", "lessonPrograms", "second", "getAll");
        response = given(spec).when().get("{first}/{second}");
        JsonPath jsonPath = response.jsonPath();

        lessonProgramIdKC = jsonPath.getList("lessonProgramId", Integer.class);
        System.out.println(lessonProgramIdKC);
    }

    @Then("URL is edited for Choose Lesson\\(teacher)_k")
    public void urlIsEditedForChooseLessonTeacher_k() {
        //https://managementonschools.com/app/teachers/chooseLesson
        spec.pathParams("first", "teachers", "second", "chooseLesson");
    }

    @And("payload is arranged for Choose Lesson\\(teacher)_k")
    public void payloadIsArrangedForChooseLessonTeacher_k() {
        List<Integer> lessonProgramId = new ArrayList<>();
        Random random = new Random();
        int randomLessonPrg = lessonProgramIdKC.get(random.nextInt(lessonProgramIdKC.size()));
        lessonProgramId.add(randomLessonPrg);

        expectedTeacherData = new TeacherContObjectPojo(4223, "teacherjohn03", "Zeynep", "Yaman", "2000-01-05", "555-13-5599", "Türkiye", "555-911-5599", "FEMALE", "derry.theus@falkcia.com", false);
        expectedLessonData = new ChooseLessonPojo(lessonProgramId, 4223);
    }

    @When("a POST Request is sent for Choose Lesson\\(teacher) and a response is received_k")
    public void aPOSTRequestIsSentForChooseLessonTeacherAndAResponseIsReceived_k() {
        response = given(spec).body(expectedLessonData).post("{first}/{second}");
        response.prettyPrint();
    }

    @And("response body for Choose Lesson\\(teacher) is verified_k")
    public void responseBodyForChooseLessonTeacherIsVerified_k() {
        actualDataTeacher = response.as(TeacherContResponsePojo.class);
        System.out.println("actualDataTeacher = " + actualDataTeacher);

        userId = actualDataTeacher.getObject().getUserId();
        System.out.println("userId = " + userId);

        assertEquals(200, response.statusCode());
        assertEquals("Lesson added to Teacher", actualDataTeacher.getMessage());
        assertEquals("CREATED", actualDataTeacher.getHttpStatus());
        assertEquals(userId, actualDataTeacher.getObject().getUserId());
        assertEquals(expectedTeacherData.getUsername(), actualDataTeacher.getObject().getUsername());
        assertEquals(expectedTeacherData.getName(), actualDataTeacher.getObject().getName());
        assertEquals(expectedTeacherData.getSurname(), actualDataTeacher.getObject().getSurname());
        assertEquals(expectedTeacherData.getBirthDay(), actualDataTeacher.getObject().getBirthDay());
        assertEquals(expectedTeacherData.getSsn(), actualDataTeacher.getObject().getSsn());
        assertEquals(expectedTeacherData.getBirthPlace(), actualDataTeacher.getObject().getBirthPlace());
        assertEquals(expectedTeacherData.getPhoneNumber(), actualDataTeacher.getObject().getPhoneNumber());
        assertEquals(expectedTeacherData.getGender(), actualDataTeacher.getObject().getGender());
        assertEquals(expectedTeacherData.getEmail(), actualDataTeacher.getObject().getEmail());
        assertFalse(actualDataTeacher.getObject().isAdvisorTeacher());
    }

}
