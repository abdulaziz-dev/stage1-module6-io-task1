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
        String names[] = new String[5];
        int k = 0;
        while (fullText.indexOf('\n') > 0){
            names[k] = fullText.substring( fullText.indexOf(':')+2, fullText.indexOf('\n')-1);
            fullText = fullText.substring( fullText.indexOf('\n')+1 );
            k += 1;
        }

        name = names[0];
        age = Integer.valueOf(names[1]);
        email = names[2];
        phone = Long.valueOf(names[3]);
        return new Profile(name, age, email, phone);
    }
}
