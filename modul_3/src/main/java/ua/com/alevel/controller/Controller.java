package ua.com.alevel.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.com.alevel.dao.AccountDao;
import ua.com.alevel.service.AddNewOperationByUser;
import ua.com.alevel.service.ExportListOfOperationsToCSV;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;


public class Controller {

    Scanner scanner = new Scanner(System.in);
    String select;
    ExportListOfOperationsToCSV operationsToCSV;
    Supplier<EntityManager> persistence = null;


    public void run(String login, String password) {
        menu();
        selectOperation();
        if (select.equals("1")) {
            createOperation(scanner);
        }
        if (select.equals("2")) {
            listOfOperations(scanner);
        }
    }

    public void menu() {
        select = scanner.nextLine();
        System.out.println("------------------------------");
        System.out.println("If you want to add new operation, please enter 1");
        System.out.println("If you want to print get a statement of transactions for the period, please enter 2");
        System.out.println("------------------------------");
    }

    private void selectOperation() {
        switch (select) {
            case "1":
                createOperation(scanner);
                break;
            case "2":
                listOfOperations(scanner);
                break;
        }
    }

    private void createOperation(Scanner scanner) {
        AddNewOperationByUser addNewOperation = new AddNewOperationByUser();

        String category = scanner.nextLine();
        System.out.println("Please, specify the category of the operation");
        int currency = Integer.parseInt(scanner.nextLine());
        System.out.println("Please, enter the transaction amount");


        String email = scanner.nextLine();
        System.out.println("Please, enter user's email");

        addNewOperation.newOperation(currency, category, email);
    }

//    private void showAllAccounts(AddNewOperationByUser addNewOperation) {
//        List<Long> accounts = addNewOperation.findAllAccounts();
//        for (Long acc : accounts) {
//            System.out.println("Active accounts:");
//            System.out.println(acc);
//        }
//    }


    private void listOfOperations(Scanner scanner) {
        String start = scanner.nextLine();
        System.out.println("Enter START data of operations, format: dd/MM/yyyy");
        String end = scanner.nextLine();
        System.out.println("Enter END data of operations, format: dd/MM/yyyy");

        operationsToCSV.operationsByPeriodToCSV(start, end);
    }

}
