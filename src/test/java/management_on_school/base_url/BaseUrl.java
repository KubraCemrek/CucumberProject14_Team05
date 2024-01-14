package management_on_school.base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static management_on_school.utilities.Authentication.generateToken;

public class BaseUrl {
    public static RequestSpecification spec;

    public static void setUp(String username, String password){
        spec = new RequestSpecBuilder()
                .setBaseUri("https://managementonschools.com/app")
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", generateToken(username, password))
                .build();
    }
}