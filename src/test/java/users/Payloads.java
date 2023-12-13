package users;

import java.util.HashMap;
import java.util.Map;

public class Payloads {

    public static String getCreateUserPayloadFromString(String userName, String passWord){
        String payload = "{\n" +
                "  \"userName\": \""+userName+"\",\n" +
                "  \"password\": \""+passWord+"\"\n" +
                "}";
        return payload;
    }

    public static Map<String, Object> getCreateUserPayloadFromMap(String userName, String passWord){
        Map<String, Object> payload = new HashMap<>();
        payload.put("userName",userName);
        payload.put("passWord",passWord);
        return payload;
    }
}
