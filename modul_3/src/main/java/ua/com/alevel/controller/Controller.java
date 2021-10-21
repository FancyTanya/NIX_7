package ua.com.alevel.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.com.alevel.dao.AccountDao;
import ua.com.alevel.service.AddNewOperationByUser;
import ua.com.alevel.service.ExportListOfOperationsToCSV;
import java.util.List;
import java.util.Scanner;


public class Controller {

    Scanner scanner = new Scanner(System.in);
    String select;
    ExportListOfOperationsToCSV operationsToCSV;
    SessionFactory sessionFactory;
    private final Session session = sessionFactory.getCurrentSession();


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
        AddNewOperationByUser addNewOperation = new AddNewOperationByUser(session);
        AccountDao accountDao = new AccountDao();

        String category = scanner.nextLine();
        System.out.println("Please, specify the category of the operation");
        int currency = Integer.parseInt(scanner.nextLine());
        System.out.println("Please, specify the amount of the operation");

        showAllAccounts(addNewOperation);

        Long accountId = Long.parseLong(scanner.nextLine());
        System.out.println("Please, enter account ID from list");

        addNewOperation.newOperation(currency, category, accountId);
    }

    private void showAllAccounts(AddNewOperationByUser addNewOperation) {
        List<Long> accounts = addNewOperation.findAllAccounts();
        for (Long acc : accounts) {
            System.out.println("Active accounts:");
            System.out.println(acc);
        }
    }


    private void listOfOperations(Scanner scanner) {
        String start = scanner.nextLine();
        System.out.println("Enter START data of operations, format: dd/MM/yyyy");
        String end = scanner.nextLine();
        System.out.println("Enter END data of operations, format: dd/MM/yyyy");

        operationsToCSV.operationsByPeriodToCSV(start, end);
    }

}
