package users.javersExample.InteractWithCsvFile;

import java.io.FileWriter;
import java.io.IOException;

public class CSVFileWritter {

    public static void main(String[] args) throws IOException {
        String csvFileName = "src/test/java/users/javersExample/InteractWithCsvFile/data.csv";
        FileWriter writer = new FileWriter(csvFileName);
    }
}
