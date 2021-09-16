package ua.com.alevel;

import java.util.Scanner;

public class NameController {
    FindUniqueName uniqueName = new FindUniqueName();
    Scanner scanner = new Scanner(System.in);

    public void startApp() {
        System.out.println("-----------------------");
        System.out.println("Hello. Please, enter some names. And I try to find first unique of them");
        System.out.println("If you want to exit, enter:   exit");
        System.out.println("-----------------------");

        while (scanner.hasNext()) {
            uniqueName.findUniqueName(scanner.nextLine());
            scanner.next();
        }
    }
}
