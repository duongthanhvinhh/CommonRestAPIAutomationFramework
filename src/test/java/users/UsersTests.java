package users;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import reporting.Setup;
import restUtils.AssertionUtils;
import restUtils.RestUtils;
import users.pojos.Users;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Listeners(Setup.class)
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
        Assert.assertEquals(response.statusCode(),200);

    }

    @Test
    public void createUserWithDataFaker() throws IOException {

        Map<String, Object> requestPayload = Payloads.getCreateUserPayloadFromMap();
        Response response = createUser(requestPayload);
        Assert.assertEquals(response.statusCode(),200);

    }

    @Test
    public void createUserWithPojo() throws IOException {

//        Users requestPayload = Payloads.getCreateUserPayloadFromPojo();
        //Serialize
        Users requestPayload = new Users();
//        Users requestPayload = new Users().toBuilder().userName("To Builder").build(); //xai toBuilder nếu muốn set lại giá trị 1 field nào đó khi ko muốn dùng default value
//        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(requestPayload));
        Response response = createUser(requestPayload);
        Assert.assertEquals(response.statusCode(),200);

    }

    @Test
    public void createUserAndVerifyResponse() throws IOException {

//        Users payload = new Users();
        Users payload = Payloads.getCreateUserPayloadFromPojo();
        Response response = createUser(payload);

        //first way
//        Assert.assertEquals(response.jsonPath().getString("passWord"),payload.getPassWord());

        //second way: parse the response to object
        //Deserialize response payload to pojo object
        ObjectMapper objectMapper = new ObjectMapper();
        Users createUsersResponse = objectMapper.readValue(response.getBody().asString(), Users.class);
        Assert.assertEquals(createUsersResponse,payload);
//        Optional userID = Optional.ofNullable(response.jsonPath().get("idd"));
//        if (userID.isPresent()){
//            System.out.println("Id is: " + userID);
//        } else System.out.println("Field not found");
    }

    @Test
    public void createUserAndVerifyResponseWithAssertionsUtil() throws IOException {

        Users payload = Payloads.getCreateUserPayloadFromPojo();
        Response response = createUser(payload);

        Map<String,Object> expectedValuesMap = new HashMap<>();
        expectedValuesMap.put("userName",payload.getUserName());
        expectedValuesMap.put("passWord",payload.getPassword());
        AssertionUtils.assertExpectedValuesWithJsonPath(response,expectedValuesMap);
    }
}
