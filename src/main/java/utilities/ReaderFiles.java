package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderFiles {
    //Create list of string arrays.
    public static List<String[]> read(String file) {
        List<String[]> data = new ArrayList<>();
        //Create the variable to add line there from file
        String newLine;
        //Read file. Continue loop until file has next line. Create array what name is data to add there line of file and then split it by "space".
        //Add our string array to list. Return our list "Data".
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((newLine = br.readLine()) != null) {
                String[] dataBase = newLine.split(",");
                data.add(dataBase);
            }
            new FileReader(file).close();
        } catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}
