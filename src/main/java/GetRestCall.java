import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GetRestCall {

   public static Response getRestCallMethod(){

      //Read property from property file
      Properties prop=new Properties();
      try {
         FileInputStream fis=new FileInputStream("C:\\Users\\pashi\\Documents\\RestAPITesting\\RestAssured_ToolsQA\\src\\main\\resources\\prop.properties");
         prop.load(fis);
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }

      //Define base uri
      String baseURI=prop.getProperty("baseurl");
      RestAssured.baseURI=baseURI;

      //Define request specification--how is the request and will be sent to server
      //In get call request is required but its use to habitual of general practice
      RequestSpecification httprequest = RestAssured.given();

      //send request to server and capture response from server
     // Response httpResponse = httprequest.request(Method.GET, prop.getProperty("geturi"));
      Response httpResponse=httprequest.get(prop.getProperty("geturi"));

      return httpResponse;
   }
}
