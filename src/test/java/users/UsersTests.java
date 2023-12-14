package users;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import restUtils.RestUtils;
import utils.JsonUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UsersTests extends UsersAPIs{

    @Test
    public void createUserWithPayloadFromString(){

        String endPoint = "https://fakerestapi.azurewebsites.net/api/v1/Users";
        String requestPayload = Payloads.getCreateUserPayloadFromString("Foden Duong","Helloworld");
        Response response = RestUtils.performPost(endPoint,requestPayload,new HashMap<>()); //Don't need to pass header, so just add the new Empty Map here
        Assert.assertEquals(response.statusCode(),200);

    }

    @Test
    public void createUserWithPayloadFromMap(){

        String endPoint = "https://fakerestapi.azurewebsites.net/api/v1/Users";
        Map<String, Object> requestPayload = Payloads.getCreateUserPayloadFromMap("Foden Duong","Helloworld");
        Response response = RestUtils.performPost(endPoint,requestPayload,new HashMap<>()); //Don't need to pass header, so just add the new Empty Map here
        Assert.assertEquals(response.statusCode(),200);

    }

    @Test
    public void createUserWithURLFromJsonFile() throws IOException {

        Map<String, Object> requestPayload = Payloads.getCreateUserPayloadFromMap("Foden Duong","Helloworld");
        Response response = createUser(requestPayload);
        Assert.assertEquals(response.statusCode(),404);

    }
}
