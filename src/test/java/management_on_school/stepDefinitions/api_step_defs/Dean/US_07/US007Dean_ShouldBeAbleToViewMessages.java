package management_on_school.stepDefinitions.api_step_defs.Dean.US_07;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.TestCase;
import management_on_school.pojos.contact_management.*;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static management_on_school.base_url.BaseUrl.setUp;
import static management_on_school.base_url.BaseUrl.spec;
import static org.junit.Assert.assertEquals;

public class US007Dean_ShouldBeAbleToViewMessages {
    ContactObjectPojo expectedData;
    Response response;
    ContactResponsePojo actualData;
    ContactMessagePojo payload;
    List<ContactResponsePojo> actualData2;

    ContentPojo getExpectedData;
    static String nowDate;
    ObjectPojo objectPojo;
    ResponseGetExpectedDataPojo expectedData1;
    ResponseGetExpectedDataPojo actualData22;
    GetContactMessagePojo getActualData;



    @Given("Login as Dean and set the URL for create message.")
    public void loginAsDeanAndSetTheURLForCreateMessage() {
        setUp("Team05Admin", "Project14");
        spec.pathParams("first", "contactMessages", "second", "save");

    }

    @When("Create the Payload for Save Message.")
    public void createThePayloadForSaveMessage() {
        LocalDate localDate = LocalDate.now();
        nowDate= String.valueOf(localDate);
        payload = new ContactMessagePojo(
                "jkp@gmail.com",
                "bunu yazan jacop",
                "jacop",
                "uyarii!");

        objectPojo=new ObjectPojo("jacop","jkp@gmail.com","uyarii!","bunu yazan jacop",nowDate);
        expectedData1=new ResponseGetExpectedDataPojo(objectPojo,"Contact Message Created Successfully","CREATED");

    }

    @When("Dean sends a POST request for create Messages and receives a response.")
    public void deanSendsAPOSTRequestForCreateMessagesAndReceivesAResponse() {
        response = given(spec).body(payload).when().post("{first}/{second}");
        actualData22 = response.as(ResponseGetExpectedDataPojo.class);
        response.prettyPrint();
    }

    @Then("Verify that the response body for create messages.")
    public void verifyThatTheResponseBodyForCreateMessages() {
        // assertEquals(payload.getName(),actualData.getObject().getName());
        // assertEquals(payload.getEmail(),actualData.getObject().getEmail());
        // assertEquals(payload.getMessage(),actualData.getObject().getMessage());
        // assertEquals(payload.getSubject(),actualData.getObject().getSubject());
        assertEquals(objectPojo.getMessage(),actualData22.getObject().getMessage());
        assertEquals(objectPojo.getSubject(),actualData22.getObject().getSubject());
        assertEquals(objectPojo.getDate(),actualData22.getObject().getDate());
        assertEquals(objectPojo.getEmail(),actualData22.getObject().getEmail());
        assertEquals(objectPojo.getName(),actualData22.getObject().getName());
        assertEquals(expectedData1.getMessage(),actualData22.getMessage());
        assertEquals(expectedData1.getHttpStatus(),actualData22.getHttpStatus());

    }
    //----------------------------SCENARIO 2-----------------------------------------------
    @Given("Login as Dean and set the URL for view message.")
    public void loginAsDeanAndSetTheURLForViewMessage() {
        setUp("Team05Admin", "Project14");
        spec.pathParams("first", "contactMessages", "second", "searchByEmail")
                .queryParams("email","jkp@gmail.com","page",0,
                        "size",500,
                        "sort","date",
                        "type","desc");
    }

    @When("Create expected Data for Views Messages")
    public void createExpectedDataForViewsMessages() {
        expectedData = new ContactObjectPojo(
                "jacop",
                "jkp@gmail.com",
                "uyarii!",
                "bunu yazan jacop",
                "2024-02-02");

    }

    @And("Dean sends a GET request for Views Messages.")
    public void deanSendsAPOSTRequestForViewsMessages() {

        response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();
        getActualData = response.as(GetContactMessagePojo.class);
        getExpectedData = new ContentPojo("jacop","jkp@gmail.com","uyarii!","bunu yazan jacop", nowDate);
        response.prettyPrint();
    }

    @Then("Verify that the response body for view messages.")
    public void verifyThatTheResponseBodyForViewMessages() {


        TestCase.assertEquals(getExpectedData.getName(),getActualData.getContent().get(0).getName());
        TestCase.assertEquals(getExpectedData.getEmail(),getActualData.getContent().get(0).getEmail());
        TestCase.assertEquals(getExpectedData.getSubject(),getActualData.getContent().get(0).getSubject());
        TestCase.assertEquals(getExpectedData.getMessage(),getActualData.getContent().get(0).getMessage());
        TestCase.assertEquals(getExpectedData.getDate(),getActualData.getContent().get(0).getDate());
    }

    @And("Verify that The Status Code is {int}.")
    public void verifyThatTheStatusCodeIs(int statusCode) {
        assertEquals(statusCode,response.statusCode());
    }

    // @Given("Login as Dean and set the URL for view message.")
    // public void loginAsDeanAndSetTheURLForViewMessage() {
    //     setUp("Team05Admin", "Project14");
    //     spec.pathParams("first","contactMessages","second","searchByEmail").queryParam("email","jkp@gmail.com");

    // }
}
