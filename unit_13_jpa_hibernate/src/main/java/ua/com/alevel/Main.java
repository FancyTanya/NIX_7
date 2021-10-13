package ua.com.alevel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.com.alevel.service.FindNearestLesson;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();

        try(SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            FindNearestLesson nearestLesson = new FindNearestLesson(() -> session);
            System.out.println("Enter phone number");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            nearestLesson.findNextLessonForStudentByCellNumber(input);
        }
    }
}
