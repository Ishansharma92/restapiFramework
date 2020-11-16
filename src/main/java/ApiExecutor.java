import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.with;

public class ApiExecutor {

    private static RequestSpecification requestSpecification;

    public ApiExecutor() {
        requestSpecification = with().baseUri("https://restcountries.eu/rest/v2")
                .contentType("application/json")
                .log().all();
    }

    public static Response getAllCountriesExecutor(){
        Response response = given(requestSpecification).
                                when().
                                    headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                                    get("/all").
                                then().
                                    contentType(ContentType.JSON).extract().response();;
        //response.prettyPrint();
        return response;
    }
}
