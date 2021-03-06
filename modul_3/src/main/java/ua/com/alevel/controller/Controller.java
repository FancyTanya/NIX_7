package ua.com.alevel.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.com.alevel.service.AddNewOperationByUser;
import ua.com.alevel.service.ExportListOfOperationsToCSV;
import ua.com.alevel.util.HibernateSessionFactoryUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import static ua.com.alevel.util.HibernateSessionFactoryUtil.getSessionFactory;


public class Controller {

    private final Scanner scanner = new Scanner(System.in);
    private String select;


    public void run(String login, String password) {
        menu();
        selectOperation(login, password);
    }

    public void menu() {
        System.out.println("------------------------------");
        System.out.println("If you want to add new operation, please enter 1");
        System.out.println("If you want to print get a statement of transactions for the period, please enter 2");
        System.out.println("------------------------------");
        select = scanner.nextLine();

    }

    private void selectOperation(String login, String password) {
        switch (select) {
            case "1":
                createOperation(scanner, login, password);
                break;
            case "2":
                listOfOperations(scanner, login, password);
                break;
        }
    }

    private void createOperation(Scanner scanner, String login, String password) {

        System.out.println("Please, specify the category of the operation");
        String category = scanner.nextLine();

        System.out.println("Please, enter the transaction amount");
        int currency = Integer.parseInt(scanner.nextLine());

        System.out.println("Please, enter user's email");
        String email = scanner.nextLine();

        Configuration configuration = new Configuration().configure();
        configuration.setProperty("hibernate.connection.username", login);
        configuration.setProperty("hibernate.connection.password", password);

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            AddNewOperationByUser addNewOperation = new AddNewOperationByUser(login, password);

            addNewOperation.newOperation(currency, category, email);
        }
    }

    private void listOfOperations(Scanner scanner, String login, String password) {
        Properties properties = new Properties();
        try(InputStream input = Controller.class.getResourceAsStream("/jdbc.properties")) {
            properties.load(input);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        String url = properties.getProperty("url");

        System.out.println("Enter START data of operations, format: dd/MM/yyyy");
        String start = scanner.nextLine();
        System.out.println("Enter END data of operations, format: dd/MM/yyyy");
        String end = scanner.nextLine();

        try(Connection connection = DriverManager.getConnection(url, login, password)) {
            var operationsToCSV = new ExportListOfOperationsToCSV(() -> connection);
            operationsToCSV.operationsByPeriodToCSV(start, end);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
