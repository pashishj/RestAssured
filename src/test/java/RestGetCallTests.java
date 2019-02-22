import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.xml.ws.Response;

public class RestGetCallTests {
    GetRestCall getCall;
    io.restassured.response.Response httpResponse;
 @BeforeMethod
  public void setup(){
      getCall=new GetRestCall();
      httpResponse = getCall.getRestCallMethod();

  }

  @Test
   public void validateGetResponseCode(){
      int statusCode=httpResponse.getStatusCode();
      Assert.assertEquals(statusCode,200);


  }

@Test
    public void getHeaders(){
    Headers headers = httpResponse.getHeaders();
    for(Header header:headers){
        System.out.println("Header Name:"+header.getName()+"Header value:"+header.getValue());
    }

}

}
