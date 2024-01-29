package management_on_school.stepDefinitions.db_step_defs.Admin.US_02;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.sql.*;

import static management_on_school.stepDefinitions.api_step_defs.Admin.US_02.US_02_AdminGuestUserManager_StepDef_API.expectedData;
import static org.junit.Assert.assertEquals;

public class US_02_AdminGuestUserManagement_StepDef_DB {
    Connection connection;
    Statement statement;
    ResultSet resultSet;

    @Given("dj Connect to the Database for GuestUser")
    public void djConnectToTheDatabaseForGuestUser() throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgresql://managementonschools.com:5432/school_management",
                "select_user", "43w5ijfso");
    }

    @And("dj send a Query to get the GuestUser GetManagerById")
    public void djSendAQueryToGetTheGuestUserGetManagerById() throws SQLException {
        statement = connection.createStatement();
        resultSet = statement.executeQuery("select * from guest_user where username='00GuestDuyguJ'");

    }

    @And("dj verify registered GuestUser information")
    public void djVerifyRegisteredGuestUserInformation() throws SQLException {
        resultSet.next();
        assertEquals(expectedData.getUsername(),resultSet.getString("username"));
        assertEquals(expectedData.getName(),resultSet.getString("name"));
        assertEquals(expectedData.getSurname(),resultSet.getString("surname"));
        assertEquals(expectedData.getBirthDay(),resultSet.getString("birth_day"));
        assertEquals(expectedData.getSsn(),resultSet.getString("ssn"));
        assertEquals(expectedData.getBirthPlace(),resultSet.getString("birth_place"));
        assertEquals(expectedData.getPhoneNumber(),resultSet.getString("phone_number"));
        assertEquals(1,resultSet.getInt("gender"));

    }

    @And("Cut the connection for GuestUser")
    public void cutTheConnectionForGuestUser() throws SQLException {
        statement.close();
        connection.close();
    }
}
