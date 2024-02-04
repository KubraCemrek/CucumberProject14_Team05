package management_on_school.stepDefinitions.api_step_defs.Teacher.US_17_18;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import management_on_school.pojos.student_info_management.*;


import static io.restassured.RestAssured.given;
import static management_on_school.base_url.BaseUrl.setUp;
import static management_on_school.base_url.BaseUrl.spec;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class Student_Info_Management {

 SaveStudentInfoSavePojo payload;

    public static Response response;
    SaveResponsePojo actualData;
    static int userId;
    GetStudentResponsePojo g1;
  GetResponsePojo g2;
   GetResponsePojo actualData2;
   PutBodyResponsePojo payload2;
   DeleteResponsePojo delete;
   DeleteResponsePojo actualData3;




        //-------------------NOT VERME SAVE---------------------//

    @Given("Not verme icin URL duzenlenir")
    public void notVermeIcinURLDuzenlenir() {

        setUp("almuallim","Cavabunga82");
        //https://managementonschools.com/app/studentInfo/save
        spec.pathParams("first","studentInfo","second","save");
    }
    @And("Not verme icin payload duzenlenir")
    public void notVermeIcinPayloadDuzenlenir() {

        payload = new SaveStudentInfoSavePojo(2,36,85.0,"good job big man!!",3530,90.0,2769);
    }
    @When("Not verme icin POST Request gonderilir ve Reponse alinir")
    public void notVermeIcinPOSTRequestGonderilirVeReponseAlinir() {

        response = given(spec).body(payload).when().post("{first}/{second}");
        response.prettyPrint();
        actualData = response.as(SaveResponsePojo.class);

        userId = actualData.getObject().getId();
        System.out.println(userId);

        System.out.println(response.statusCode());

    }
    @And("Not verme icin gelen Response body dogrulanir")
    public void notVermeIcinGelenResponseBodyDogrulanir() {

        assertEquals(payload.getAbsentee(),actualData.getObject().getAbsentee());
        assertEquals(payload.getEducationTermId(),actualData.getObject().getEducationTermId());
        assertEquals(payload.getFinalExam(),actualData.getObject().getFinalExam());
        assertEquals(payload.getInfoNote(),actualData.getObject().getInfoNote());
        assertEquals(payload.getLessonId(),actualData.getObject().getLessonId());
        assertEquals(payload.getMidtermExam(),actualData.getObject().getMidtermExam());
        assertEquals(payload.getStudentId(),actualData.getObject().getStudentResponse().getUserId());

    }

    //------------------NOT GET--------------------//

    @Given("StudentInfoGetID icin URL duzenlenir")
    public void verilenNotlariGetirmekIcinURLDuzenlenir() {

       // setUp("almuallim","Cavabunga82");
        //https://managementonschools.com/app/studentInfo/get/1
        spec.pathParams("first","studentInfo","second","get","third",userId);
    }
    @And("StudentInfoGetID icin beklenen veriler olusturulur")
    public void studentınfogetıdIcinBeklenenVerilerOlusturulur() {

        g1 = new GetStudentResponsePojo(2769, "agamu2","Aga1",
                "Mugun1", "2014-06-23", "Nugur1", "098-129-0253",
                "MALE", 1025,"Ruguna", "Magam", "wesh1@gmail.com", true);

        g2 = new GetResponsePojo(userId,90.0, 85.0, 2, "good job big man!!",
                "JavaScript", 3530, 10, 36, 87.0,
                g1, true, "AA");
    }
    @When("StudentInfoGetID icin POST Request gonderilir ve Reponse alinir")
    public void studentınfogetıdIcinPOSTRequestGonderilirVeReponseAlinir() {

        response = given(spec).when().get("{first}/{second}/{third}");
        response.prettyPrint();
        actualData2 = response.as(GetResponsePojo.class);
    }
    @And("Verilen notlarin goruldugu dogrulanir")
    public void verilenNotlarinGorulduguDogrulanir() {

        assertEquals(g2.getFinalExam(),actualData2.getFinalExam());
        assertEquals(g2.getMidtermExam(),actualData2.getMidtermExam());
    }


        //----------------NOT GUNCELLEME-------------------//

    @Given("Not guncelleme icin URL düzenlenir")
    public void notGuncellemeIcinURLDüzenlenir() {
       // setUp("almuallim","Cavabunga82");
        //https://managementonschools.com/app/studentInfo/update/1
        spec.pathParams("first","studentInfo","second","update","third",userId);
    }
    @And("Not guncelleme icin payload duzenlenir")
    public void notGuncellemeIcinPayloadDuzenlenir() {

        payload2 = new PutBodyResponsePojo("3","38","15","Guncellendi","3532","25");
    }
    @When("Not guncelleme icin POST Request gonderilir ve Reponse alinir")
    public void notGuncellemeIcinPOSTRequestGonderilirVeReponseAlinir() {
        response = given(spec).body(payload2).when().put("{first}/{second}/{third}");
        response.prettyPrint();
        actualData = response.as(SaveResponsePojo.class);
    }
    @And("Not guncelleme icin gelen Response body dogrulanir")
    public void notGuncellemeIcinGelenResponseBodyDogrulanir() {
        assertTrue(actualData.getMessage().contains("Student Info updated Successfully"));
    }


        //----------------------NOT SILME------------------------------//

    @Given("Not silme icin URL düzenlenir")
    public void notSilmeIcinURLDüzenlenir() {
       // setUp("almuallim","Cavabunga82");
        //https://managementonschools.com/app/studentInfo/delete/1
        spec.pathParams("first","studentInfo","second","delete","third",userId);
    }
    @And("Not silme icin beklenen veriler olusturulur")
    public void notSilmeIcinBeklenenVerilerOlusturulur() {
        delete = new DeleteResponsePojo("Student Info deleted Successfully","OK");
    }
    @When("Not silme icin POST Request gonderilir ve Reponse alinir")
    public void notSilmeIcinPOSTRequestGonderilirVeReponseAlinir() {
        response = given(spec).when().delete("{first}/{second}/{third}");
        response.prettyPrint();
        actualData3 = response.as(DeleteResponsePojo.class);

        System.out.println("---------------------");
        System.out.println(actualData3);
    }

    @And("Not silme icin gelen Response body dogrulanir")
    public void notSilmeIcinGelenResponseBodyDogrulanir() {

        assertEquals(delete.getMessage(),actualData3.getMessage());

    }


    //--------------------------STATUSCODE DOGRULAMA---------------------------//
    @Then("Gelen Status kodun {int} oldugu dogrulanir")
    public void gelenStatusKodunOlduguDogrulanir(int statuscode) {
        assertEquals(response.getStatusCode(),statuscode);
    }



}