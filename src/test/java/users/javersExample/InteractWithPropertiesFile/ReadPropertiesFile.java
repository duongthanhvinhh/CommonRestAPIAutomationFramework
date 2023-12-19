package users.javersExample.InteractWithPropertiesFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class ReadPropertiesFile {

    public static void main(String[] args) throws IOException {

        Properties properties = new Properties();
        String filePath = System.getProperty("user.dir")+"/src/test/java/users/javersExample/InteractWithPropertyFile/system.properties";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        //Before reading the file, we need to load the file
        properties.load(fileInputStream);
        fileInputStream.close();

        //Read data from properties file
        //Read all the properties and their values
        for (String key : properties.stringPropertyNames()){
            System.out.println(key + " " + properties.getProperty(key));
        }

        //Capture all the properties: Approach 1
        Set<String> keys = properties.stringPropertyNames();
        System.out.println(keys);
        //Capture all the properties: Approach 2
        Set<Object> allKeys = properties.keySet();
        System.out.println(allKeys);

        //Capture all the values:
        Collection<Object> values = properties.values();
        System.out.println(values);


    }
}
