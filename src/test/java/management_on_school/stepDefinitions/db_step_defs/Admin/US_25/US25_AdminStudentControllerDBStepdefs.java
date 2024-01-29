package management_on_school.stepDefinitions.db_step_defs.Admin.US_25;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import management_on_school.pojos.student_management.admin_student_management.StudentPostAdminPojo;


import java.sql.*;

import static org.junit.Assert.assertEquals;

public class US25_AdminStudentControllerDBStepdefs {
    Connection connection;
    StudentPostAdminPojo expectedData;
    ResultSet resultSet;

    @Given("Set up the  database connectionAdmin")
    public void setUpTheDatabaseConnectionAdmin() throws SQLException {
        connection= DriverManager.getConnection("jdbc:postgresql://managementonschools.com:5432/school_management", "select_user", "43w5ijfso");
    }

    @And("Generate the expected Admin Student data")
    public void generateTheExpectedAdminStudentData() {
        expectedData=new StudentPostAdminPojo(4004,"2019-09-05",
                "Ahal","wesson.andru@falkcia.com",
                "Maksat","FEMALE","Jumagul",
                "Maya","Baba12345","059-176-3275",
                "298-59-2092","Turkmen","maya2022");
    }

    @When("Sent the query to get registered Admin Student information")
    public void sentTheQueryToGetRegisteredAdminStudentInformation() throws SQLException {
        Statement statement= connection.createStatement();
        resultSet= statement.executeQuery("select * from student where username='maya2022'");
    }

    @Then("Verify registered Admin Student data")
    public void verifyRegisteredAdminStudentData() throws SQLException {
        resultSet.next();
        assertEquals(expectedData.getBirthDay(),resultSet.getString("birth_day"));
        assertEquals(expectedData.getBirthPlace(),resultSet.getString("birth_place"));
        assertEquals(1,resultSet.getInt("gender"));
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
