package users;

import io.restassured.response.Response;
import restUtils.RestUtils;
import users.pojos.CreateUser;
import users.pojos.Users;

import java.util.HashMap;
import java.util.Map;

public class UsersAPIs {

    public Response createUser(Map<String,Object> createUserPayload){
        String endPoint = (String) Base.dataFromJsonFile.get("createUsersEndPoint");
        return RestUtils.performPost(endPoint,createUserPayload,new HashMap<>()); //Don't need to pass header, so just add the new Empty Map here
    }

    public Response createUser(Users createUserPayload){
        String endPoint = (String) Base.dataFromJsonFile.get("createUsersEndPoint");
        return RestUtils.performPost(endPoint,createUserPayload,new HashMap<>()); //Don't need to pass header, so just add the new Empty Map here
    }

    public Response createUser(CreateUser createUserPayload){
        String endPoint = (String) Base.dataFromJsonFile.get("createUsersEndPoint");
        return RestUtils.performPost(endPoint,createUserPayload,new HashMap<>()); //Don't need to pass header, so just add the new Empty Map here
    }
}
