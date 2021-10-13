package ua.com.alevel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.exceptions.IncorrectInput;
import ua.com.alevel.service.AddNewOperationByUser;
import ua.com.alevel.service.ExportListOfOperationsToCSV;
import ua.com.alevel.util.InitTables;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Controller {
    private static final Logger logger = LoggerFactory.getLogger(Controller.class);
    String login;
    String password;
    String url = "jdbc:mysql://localhost:3306/finance_app";
    Scanner scanner = new Scanner(System.in);
    String select;
    ExportListOfOperationsToCSV operationsToCSV;
    private static Connection connection;

    public void run(){
        connectionToDb();
        new InitTables().initTables();
        menu();
    }

    private void connectionToDb(){
        System.out.println("Please, enter LOGIN to database");
        login = scanner.nextLine().trim();
        System.out.println("Please, enter PASSWORD to database");
        password = scanner.nextLine().trim();
        try {
            connection = DriverManager.getConnection(url, login, password);
        } catch (SQLException e) {
            logger.error("SQL exception: wrong parameters for connection" + e.getMessage());
        }
    }

    private void menu() {
        select = scanner.nextLine();
        System.out.println("------------------------------");
        System.out.println("If you want to add new operation, please enter 1");
        System.out.println("If you want to print get a statement of transactions for the period, please enter 2");
        System.out.println("------------------------------");
    }

    private void selectOperation() {
        switch (select) {
            case "1" : createOperation(scanner); break;
            case "2" : listOfOperations(scanner); break;

        }
    }

    private void createOperation(Scanner scanner) {
        AddNewOperationByUser addNewOperation = new AddNewOperationByUser();
        String email = scanner.nextLine();
        System.out.println("Please, enter user's email");
        String firstName = scanner.nextLine();
        System.out.println("Please, enter user's firstname");
        String lastName = scanner.nextLine();
        System.out.println("Please, enter user's lastname");
        String category = scanner.nextLine();
        System.out.println("Please, specify the category of the operation");
        int currency = Integer.parseInt(scanner.nextLine());
        System.out.println("Please, specify the category of the operation");
        Long accountId = Long.parseLong(scanner.nextLine());
        System.out.println("Please, specify the category of the operation");

        addNewOperation.newOperation(currency, category, email , accountId);
    }

    private void listOfOperations(Scanner scanner) {
        String start = scanner.nextLine();
        System.out.println("Enter START data of operations, format: dd/MM/yyyy");
        String end = scanner.nextLine();
        System.out.println("Enter END data of operations, format: dd/MM/yyyy");

        operationsToCSV.operationsByPeriodToCSV(start, end);
    }

}
