package management_on_school.stepDefinitions.db_step_defs.ViceDean.US_15;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import management_on_school.pojos.student_management.vicedean_student_management.StudentPostVDPojo;


import java.sql.*;

import static org.junit.Assert.assertEquals;

public class US15_VD_StudentControllerDBStepdefs {
    Connection connection;
    StudentPostVDPojo expectedData;
    ResultSet resultSet;


    @Given("Set up the  database connectionVD.")
    public void setUpTheDatabaseConnectionVD() throws SQLException {
        connection= DriverManager.getConnection("jdbc:postgresql://managementonschools.com:5432/school_management", "select_user", "43w5ijfso");
    }

    @And("Generate the expected Vice Dean Student data")
    public void generateTheExpectedViceDeanStudentData() {
        expectedData=new StudentPostVDPojo(4004,"2017-05-05",
                "impedit","branda.beier@yahoo.com",
                "Laree","MALE","Anne",
                "Courtney","Baba12345","059-166-0285",
                "086-95-1091","Hilpert","2443gakky");

    }


    @When("Sent the query to get registered Vice Dean Student information")
    public void sentTheQueryToGetRegisteredViceDeanStudentInformation() throws SQLException {
        Statement statement= connection.createStatement();
        resultSet= statement.executeQuery("select * from student where username='2443gakky'");
    }

    @Then("Verify registered Vice Dean Student data")
    public void verifyRegisteredViceDeanStudentData() throws SQLException {
        resultSet.next();
        assertEquals(expectedData.getBirthDay(),resultSet.getString("birth_day"));
        assertEquals(expectedData.getBirthPlace(),resultSet.getString("birth_place"));
        assertEquals(0,resultSet.getInt("gender"));
        assertEquals(expectedData.getName(),resultSet.getString("name"));
        assertEquals(expectedData.getPhoneNumber(),resultSet.getString("phone_number"));
        assertEquals(expectedData.getSsn(),resultSet.getString("ssn"));
        assertEquals(expectedData.getSurname(),resultSet.getString("surname"));
        assertEquals(expectedData.getUsername(),resultSet.getString("username"));
        assertEquals(expectedData.getEmail(),resultSet.getString("email"));
        assertEquals(expectedData.getFatherName(),resultSet.getString("father_name"));
        assertEquals(expectedData.getMotherName(),resultSet.getString("mother_name"));
        assertEquals(4004,resultSet.getInt("advisor_teacher_id"));
    }


}
