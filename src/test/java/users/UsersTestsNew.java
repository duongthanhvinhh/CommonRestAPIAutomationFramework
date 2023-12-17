package users;

import io.restassured.response.Response;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import reporting.Setup;
import users.pojos.Users;

import java.util.Optional;

@Listeners(Setup.class)
public class UsersTestsNew extends UsersAPIs{

    @Test
    public void createUserAndVerify(){
        Users request = Payloads.getCreateUserPayloadFromPojo();
        Response response = createUser(request);
        System.out.println(response.jsonPath().getInt("id"));
        Optional idd = Optional.ofNullable(response.jsonPath().get("idd"));
        if (idd.isPresent()){
            System.out.println("Id is " + idd);
        } else System.out.println("Field not found");
    }
}
