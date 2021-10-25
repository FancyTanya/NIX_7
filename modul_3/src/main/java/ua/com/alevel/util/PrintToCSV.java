package ua.com.alevel.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PrintToCSV {

    private static final Logger logger = LoggerFactory.getLogger(PrintToCSV.class);

    public static void printToCSV(List<String> resultArray) {

        File csvOutputFile = new File("csvOutputFile.csv");

        try (FileWriter fileWriter = new FileWriter(csvOutputFile, false)) {

            for (String mapping : resultArray) {
                fileWriter.write(mapping + "\n");
            }
        } catch (IOException e) {
            logger.warn("IO Exception", e);
        }
    }
}
