import io.restassured.response.Response;
import org.testng.Assert;

public class ResponseValidator {


    public void verifyResponseStatusCode(int expectedStatusCode, Response response) {
        Assert.assertEquals(expectedStatusCode,response.getStatusCode());
    }
}
