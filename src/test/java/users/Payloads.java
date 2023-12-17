package users;

import users.pojos.Users;
import utils.RandomDataGenerator;
import utils.RandomDataTypeNames;

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

    public static Map<String, Object> getCreateUserPayloadFromMap(){
        Map<String, Object> payload = new HashMap<>();
        payload.put("userName", RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.FULLNAME));
//        payload.put("passWord",faker.number().digits(5));
        payload.put("passWord", RandomDataGenerator.getRandomAlphabets(5));
        return payload;
    }

    public static Users getCreateUserPayloadFromPojo(){
        return  Users
                .builder()
                .userName(RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.FULLNAME))
                .passWord(RandomDataGenerator.getRandomAlphabets(5))
                .build();
    }
}
