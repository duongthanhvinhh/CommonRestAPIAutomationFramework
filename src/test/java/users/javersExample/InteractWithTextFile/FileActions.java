package users.javersExample.InteractWithTextFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileActions {
    //Creating the file
    public static void createFile(String filePath) {
        File myObj = new File(filePath);
        try {
            if (myObj.createNewFile()){
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File is already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Writing data into file
    public static void writeFile(String filePath, String contentInput){
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(contentInput);
            fileWriter.close();
            System.out.println("Successfully wrote to the file...");
        } catch (IOException e) {
            System.out.println("An error occured...");
            e.printStackTrace();
        }
    }

    //Reading data from file
    public static void readFile(String filePath){
        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e){
            System.out.println("An error occured while reading...");
            e.printStackTrace();
        }
    }

    //Renaming the file
    public static void renameFile(String oldFilePath, String newFilePath){
        File oldFile = new File(oldFilePath);
        File newFile = new File(newFilePath);

        if (oldFile.renameTo(newFile)){
            System.out.println("File is renamed.");
        } else System.out.println("The file cannot be renamed...");
    }

    //Deleting the file
    public static void deleteFile(String filePath){
        File myObj = new File(filePath);
        if (myObj.delete()){
            System.out.println("Deleted the file: " + myObj.getName());
        } else System.out.println("Failed to delete the file.");
    }

    public static void main(String[] args) {
        String filePath = System.getProperty("user.dir")+"/src/test/java/users/javersExample/InteractWithTextFile/text.txt";
        createFile(filePath);
        writeFile(filePath,"Hi, This is Foden !");
        readFile(filePath);
        String newPath = System.getProperty("user.dir")+"/src/test/java/users/javersExample/InteractWithTextFile/rename.txt";
        renameFile(filePath,newPath);
        deleteFile(newPath);
        deleteFile(filePath);
    }
}
