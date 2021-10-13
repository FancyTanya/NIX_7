package ua.com.alevel.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PrintToCSV {


    public static void printToCSV(List<String> resultArray) throws IOException {
        File csvOutputFile = new File("csvOutputFile.csv");
        FileWriter fileWriter = new FileWriter(csvOutputFile, false);

        for (String mapping: resultArray) {
            fileWriter.write(mapping + "\n");
        }
        fileWriter.close();
    }
}
