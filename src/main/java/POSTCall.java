import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;

public class POSTCall {

    public Response postCallMethod(){

        RestAssured.baseURI = "https://reqres.in/";

        RequestSpecification httprequest = RestAssured.given();

        JSONObject js = new JSONObject();

        js.put("name", "morpheus");
        js.put("job", "leader");

        httprequest.header("Content-Type", "application/json");
        httprequest.body(js.toJSONString());
        Response response = httprequest.post("/api/users");


        return response;
    }
}