package management_on_school.stepDefinitions.db_step_defs.Admin.US_24;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import management_on_school.pojos.teacher_management.TeacherSavePostPojo_hu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AdminShouldBeAbleToCreateTeachers_StepDef_DB {
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    static int userId;
    TeacherSavePostPojo_hu expectedData;


    @Given("Connect to the Database_hu.")
    public void ConnectToTheDatabase_hu()throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgresql://managementonschools.com:5432/school_management",
                                                "select_user", "43w5ijfso");
    }


    @Then("Vice Dean creates Expected Response Body for get_DB_hu.")
    public void Vice_Dean_creates_Expected_Response_Body_for_get_DB_hu()  {
        List<Integer> lessonIdList = new ArrayList<>();
        lessonIdList.add(3524);
        expectedData = new TeacherSavePostPojo_hu(
                "1983-01-01",
                "Mersin",
                "hgulnarli33@gmail.com",
                "MALE",
                true,
                lessonIdList,
                "Halil",
                "Karaman1",
                "336-633-9718",
                "633-01-4215",
                "USLU",
                "TeacherH.Uslu"
        );
    }


    @And("send a Query to get the Vice Dean Get Manager ById_hu.")
    public void SendAQueryToGetTheViceDeanGetManagerById_hu() throws SQLException{
        statement = connection.createStatement();
        resultSet = statement.executeQuery("select * from teacher where username='TeacherH.Uslu'");
    }

    @And("verify registered teacher information_hu.")
    public void VerifyRegisteredTeacherInformation_hu() throws SQLException{
        resultSet.next();
        assertEquals(expectedData.getBirthDay(), resultSet.getString("birth_day"));
        assertEquals(expectedData.getBirthPlace(), resultSet.getString("birth_place"));
        assertEquals(0, resultSet.getInt("gender"));
        assertEquals(expectedData.getName(), resultSet.getString("name"));
        assertEquals(expectedData.getPhoneNumber(), resultSet.getString("phone_number"));
        assertEquals(expectedData.getSsn(), resultSet.getString("ssn"));
        assertEquals(expectedData.getSurname(), resultSet.getString("surname"));
        assertEquals(expectedData.getUsername(), resultSet.getString("username"));
    }

    @And("Cut the connection_hu.")
    public void cutTheConnection() throws SQLException {
        statement.close();
        connection.close();
    }
}
