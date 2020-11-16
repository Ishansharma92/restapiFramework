import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.with;

public class RestCountriesApis extends GlobalConstant{

    private RequestSpecification requestSpecification;


    @BeforeTest
    void preSetup(){
        ae = new ApiExecutor();
        rv = new ResponseValidator();
    }

    @Test
    void getAllCountries() throws Exception {
        Response response = ae.getAllCountriesExecutor();
        rv.verifyResponseStatusCode(200,response);

        List<String> jsonResponse = response.jsonPath().getList("$");
        System.out.println("Count of Countries: "+jsonResponse.size());

        String names = response.jsonPath().getString("name");
        System.out.println(names);
        FileIOUtil.writeToFile(names);
    }

    @Test
    void getCountry(){
        Response response = given(requestSpecification).headers("ContentType",ContentType.JSON)
                                .when().get("/name/"+"Afganistan")
                                    .then().contentType(ContentType.JSON).extract().response();
        response.prettyPrint();
    }
}
