package com.softserve.edu.opencart.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {

    Scanner scanner;

    public FileManager() {
    }

    public List <String> readFromFile (String filePathname) {

        try {
            scanner = new Scanner(new File(filePathname));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<String> result = new ArrayList<String>();
        while (scanner.hasNextLine()) {
            result.add(scanner.nextLine());
        }
        scanner.close();
        return result;
    }



}
