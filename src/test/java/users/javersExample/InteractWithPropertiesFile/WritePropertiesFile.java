package users.javersExample.InteractWithPropertiesFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WritePropertiesFile {

    public static void main(String[] args) throws IOException {

        Properties properties = new Properties();
        properties.setProperty("name","Foden Duong");
        properties.setProperty("email","foden@gmail.com");
        properties.setProperty("age","25");

        String filePath = System.getProperty("user.dir")+"/src/test/java/users/javersExample/InteractWithPropertyFile/system.properties";
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);

        properties.store(fileOutputStream,"Adding system properties file");
        fileOutputStream.close();
        System.out.println("File system.properties have been created at: " + filePath);
    }
}
