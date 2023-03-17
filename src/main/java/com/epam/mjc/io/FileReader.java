package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        String fullText = "";
        String name;
        Integer age;
        String email;
        Long phone;

        // Reading the file with FileInputStream
        String fileName = file.getAbsolutePath();
        try (FileInputStream fileInputStream = new FileInputStream(fileName)){
            int ch;
            while((ch = fileInputStream.read()) != -1){
                fullText += (char)ch;
            }
        }
        catch (FileNotFoundException e){
            System.err.println("An FNF error occurred.");
        }
        catch (IOException e){
            System.err.println("An IO error occurred.");
        }

        // Parsing the string
        String[] keyValues = fullText.split(System.lineSeparator());
        for(int i=0; i < keyValues.length; i++){
            if (keyValues[i].split(": ").length > 1){
                keyValues[i] = keyValues[i].split(": ")[1];
            } else {
                keyValues[i] = "";
            }
        }
        name = keyValues[0];
        age = Integer.parseInt(keyValues[1]);
        email = keyValues[2];
        phone = Long.parseLong(keyValues[3]);
        return new Profile(name, age, email, phone);
    }
}
