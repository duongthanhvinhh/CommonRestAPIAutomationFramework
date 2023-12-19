package users.javersExample.InteractWithJsonFile.UsingGson;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadJsonFileUsingGson {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader reader = new FileReader("src/test/java/users/javersExample/InteractWithJsonFile/UsingGson/data.json");
        Gson gson = new Gson();
        Person person = gson.fromJson(reader,Person.class);
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        for(Address address : person.getAddress()){
            System.out.println("Street: " + address.getStreet());
            System.out.println("City: " + address.getCity());
            System.out.println("State: " + address.getState());
        }
    }
}
