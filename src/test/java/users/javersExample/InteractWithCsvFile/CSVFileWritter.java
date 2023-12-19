package users.javersExample.InteractWithCsvFile;

import java.io.FileWriter;
import java.io.IOException;

public class CSVFileWritter {

    public static void main(String[] args) throws IOException {
        String csvFileName = "src/test/java/users/javersExample/InteractWithCsvFile/data.csv";

        //Write data to CSV file
        FileWriter writer = new FileWriter(csvFileName);
        writer.append("Name,Age,Email \n"); //optional: adding headers
        writer.append("John,30,john@gmail.com \n");
        writer.append("Smith,20,smith@gmail.com \n");
        writer.append("Foden,25,foden@gmail.com \n");
        writer.close();
        System.out.println("CSV file created at: " + csvFileName);
    }
}
