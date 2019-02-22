import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class RestPostCallTests {

    POSTCall postCall;
    Response httpResponse;

    @BeforeMethod
    public void setup() {
        postCall = new POSTCall();
        httpResponse = postCall.postCallMethod();
    }

    @Test
    public void displayPostCallResponse() {



        System.out.println("Response:"+httpResponse.getBody().prettyPrint());
}
@Test
public void validateStatusCode(){
    System.out.println("Response:" + httpResponse.getStatusCode());
    Assert.assertEquals(httpResponse.getStatusCode(),201);

}

@Test
public void validateName(){
    System.out.println("Response:" + httpResponse.getBody().jsonPath().get("name"));
    Assert.assertEquals("morpheus1",httpResponse.getBody().jsonPath().get("name"));

}

}
