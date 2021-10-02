package ua.com.alevel.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.entity.Table;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ParserCSV {

    private static final Logger logger = LoggerFactory.getLogger(ParserCSV.class);

    public Table readFile(String fileName) {
        Table table = new Table();
        List<String> header = new ArrayList<>();
        List<String>  rows = new ArrayList<>();
        String lineRead;
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            if (Files.notExists(Path.of(fileName))) {
                throw new FileNotFoundException();
            }
            lineRead = Files.readString(Paths.get(fileName)).trim();
            String[] split = lineRead.split("\n");
            String[] firstLine = split[0].replaceAll("\r", "").trim().split(",");
            header = Arrays.asList(firstLine);

            for (int i = 1; i < split.length; i++) {
                rows.add(split[i].replaceAll("\r", "").trim());
            }

        } catch (FileNotFoundException e) {
            logger.warn(e.getMessage());
        } catch (IOException e) {
            logger.warn(e.getMessage());
        }
        table.setHeader(header);
        table.setRows(rows);
        return table;
    }

}
