package users.javersExample.InteractWithCsvFile;

import java.io.*;
import java.util.Scanner;

public class CSVFileReader {

    public static void main(String[] args) throws IOException {
        /* Approach1: Using scanner class
        File file = new File(System.getProperty("user.dir")+"/src/test/java/users/javersExample/InteractWithCsvFile/data.csv");
        System.out.println(System.getProperty("user.dir"));

        Scanner scanner = new Scanner(file);
        scanner.useDelimiter(",");
        while (scanner.hasNext()){
            System.out.println(scanner.next() + "\t");
        }
        scanner.close();
        */

        //Approach2: Using java split() method
        String csvFileName = System.getProperty("user.dir")+"/src/test/java/users/javersExample/InteractWithCsvFile/data.csv";
        FileReader fileReader = new FileReader(csvFileName);
        BufferedReader bfr = new BufferedReader(fileReader);
        String line;
        while ((line = bfr.readLine())!=null){
            String[] data = line.split(",");
            for (String value: data){
                System.out.print(value+"\t");
            }
            System.out.println();
        }
    }

}
