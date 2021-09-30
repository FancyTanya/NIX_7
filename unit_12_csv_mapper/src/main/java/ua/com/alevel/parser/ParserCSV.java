package ua.com.alevel.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ParserCSV {

    String pathFile = "FileCSV.txt";

    public String[] read() throws IOException {
        List<String> fileLines = Files.readAllLines(Paths.get("FileCSV.txt"));

        return null;
    }
}
