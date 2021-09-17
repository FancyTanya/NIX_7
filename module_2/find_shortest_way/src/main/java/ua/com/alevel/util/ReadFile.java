package ua.com.alevel.util;

import ua.com.alevel.entity.Graph;

import java.io.*;
import java.util.HashMap;
import java.util.Set;
import java.util.regex.Pattern;

public class ReadFile {

    String inputString;
    String inputFileName = "src/main/resources/input.txt";
    int amountOfCities;
    String cityName;
    int numberOfNeighbors;
    public HashMap<String, Integer> citiesAndVerts;
    public HashMap<Integer, Integer> indexNeighbourAndCost;
    public Graph graph;
    int start;
    int end;
    int cost;
    int countRoutes;
    String startRoute;
    String endRoute;
    HashMap<String, String> routeStartEnd;

//    public void setInputFileName(String inputFileName) {
//        this.inputFileName = inputFileName;
//    }


    public String readingFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
               inputString = reader.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputString;
    }

    public void parseString(String inputString) {
        String parsingString;
        amountOfCities = Integer.parseInt(inputString.substring(0, 1));
        String[] split = inputString.substring(1).split("\n");
        for (int i = 0; i < split.length; i++) {
            if (Pattern.matches("a-zA-z", split[i])) {
                split[i] = cityName;
                numberOfNeighbors = Integer.parseInt(split[i+1]);
                while (numberOfNeighbors > 0) {
                    int count = 1;
                    int[] array = stringToIntArray(split[i + 1 + count]);
                    end = array[0];
                   cost = array[1];
                   graph.addEdge(start++, end, cost);
                   count--;
                }
            }
        }
        parsingString = inputString.substring(2,numberOfNeighbors);
        if (parsingString.startsWith(String.valueOf(Pattern.matches("a-zA-z",parsingString)))) {
            parseString(parsingString);
        }
        if (parsingString.startsWith(String.valueOf(Pattern.matches("[0-9]",parsingString)))) {
            String[] countPathsAndRoutes = parsingString.split("\n");
            countRoutes = Integer.parseInt(countPathsAndRoutes[0]);
            for (int i = countRoutes; i > countRoutes ; i--) {
                String[] routeNames = countPathsAndRoutes[i].split(" ");
                startRoute = routeNames[0];
                endRoute = routeNames[1];
                routeStartEnd.put(startRoute, endRoute);

            }
        }
    }

    private int[] stringToIntArray(String input) {
        String[] split = input.split(" ");
        int[] result = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            result[i] = Integer.parseInt(split[i]);
        }
        return result;
    }

    private void setVertex(HashMap<String, Integer> citiesAndVerts) {
        Set<String> setNames = citiesAndVerts.keySet();
        for (String value:setNames) {
            graph.addVertex(value);
        }
    }

    public void runGraph() {
        setVertex(citiesAndVerts);
        graph.path();
    }

    public void writeFile() {

    }

}
