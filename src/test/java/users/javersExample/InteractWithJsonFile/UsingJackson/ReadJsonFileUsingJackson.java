package users.javersExample.InteractWithJsonFile.UsingJackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ReadJsonFileUsingJackson {
    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src/test/java/users/javersExample/InteractWithJsonFile/UsingJackson/employee.json");

        //Read Json data from the file and map to person class
        Person person = objectMapper.readValue(file,Person.class);

        //Access data
        System.out.println("Person: " + person.getName());
        System.out.println("Age: " + person.getAge());
        for (Address address : person.getAddress()){
            System.out.println(address.getCity());
            System.out.println(address.getStreet());
            System.out.println(address.getState());
        }
    }
}
