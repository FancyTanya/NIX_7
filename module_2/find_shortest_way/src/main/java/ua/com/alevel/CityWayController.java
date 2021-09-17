package ua.com.alevel;

import ua.com.alevel.entity.Graph;
import ua.com.alevel.entity.Vertex;
import ua.com.alevel.util.ReadFile;

public class CityWayController {
    ReadFile readFile = new ReadFile();
    String inputString;


    public void startApplication() {
        System.out.println("***************************");
        System.out.println("Hello, put txt-file with information about cities in the resources");
        System.out.println("***************************");

        inputString = readFile.readingFile();
        readFile.parseString(inputString);

        readFile.runGraph();
    }

}
