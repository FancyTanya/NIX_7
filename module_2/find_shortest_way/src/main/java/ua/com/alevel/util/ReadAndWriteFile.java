package ua.com.alevel.util;

import ua.com.alevel.entity.Graph;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class ReadAndWriteFile {

    String inputString = "";
    String inputFileName = "input.txt";
    public Graph graph;

    public String readingFile(BufferedReader reader) {
        try {
            String line;
            while ((line = reader.readLine()) != null) {
               inputString = reader.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputString;
    }

    public String parseString(String inputString) {
        StringBuilder resultOutput = new StringBuilder();
        Map<String, Integer> cities = new HashMap<>();
        final String[] split = inputString.split("\n");
        int valueCities = Integer.parseInt(split[0]);
        int[][] inputMatrix = new int[valueCities][valueCities];
        for (int i = 0; i < inputMatrix.length; i++) {
            for (int j = 0; j < inputMatrix[i].length; j++) {
                if (i == j) {
                    inputMatrix[i][j] = 0;
                    continue;
                }
                inputMatrix[i][j] = -1;
            }
        }
        int inputMatrixCount = -1;
        int countCities = 1;
        for (String s : split) {
            if (s.matches("[^0-9]*") && !(s.matches("[^0-9]*\\s[^0-9]*"))) {
                cities.put(s, countCities);
                countCities++;
                inputMatrixCount++;
                continue;
            }
            if (s.matches("[^0-9]*\\s[^0-9]*")) {
                final String[] split1 = s.split(" ");
                int start = cities.get(split1[0]);
                int stop = cities.get(split1[1]);
                int step = inputMatrix.length - (stop - start + 1);
                int[][] adjMatrix = new int[stop - start + 1][stop - start + 1];
                for (int i = 0; i <= stop - start; i++) {
                    if (stop - start + 1 >= 0)
                        System
                                .arraycopy(inputMatrix[start - 1 + i], step, adjMatrix[i], 0, stop - start + 1);
                }
                graph.path(adjMatrix);
                resultOutput = graph.displayPaths();
                continue;
            }
        }
        return resultOutput.toString();
    }

    public void findShortestWay() {
       try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
               BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
           String readedFile = readingFile(reader);
           String shortestWay = parseString(readedFile);
           writer.write(shortestWay);
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

}
