package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import ua.com.alevel.util.TimeParse;

public class ParseDateController {
    TimeParse timeParse = new TimeParse();
    Date inputDate = new Date();
    String output;

    public void run() {
        System.out.println("-------------------------------------");
        System.out.println("You can enter some Strings with dateFORMAT like:");
        System.out.println("yyyy/MM/dd, dd/MM/yyyy, MM-dd-yyyy");
        System.out.println("If you want to exit - enter: exit");
        System.out.println("-------------------------------------");
        BufferedReader reader = new BufferedReader((new InputStreamReader(System.in)));

        exit(reader);

        try {
            String inputDate;
            while ((inputDate = reader.readLine()) != null) {
                Date newDate = timeParse.parseString(inputDate);
                if (newDate == null)
                    break;
                output = timeParse.dateToString(newDate) + "\n";
            }
        } catch (IOException e) {
            System.err.println("Error: " + e);
        }

        System.out.println("Formatted strings:");
        System.out.println(output);
        run();
    }


    private void exit(BufferedReader reader) {

        try {
            if (reader.readLine().equals("exit")) {
                    System.exit(0);
            }
        } catch (IOException e) {
            System.err.println("Error: " + e);
        }
    }
}
