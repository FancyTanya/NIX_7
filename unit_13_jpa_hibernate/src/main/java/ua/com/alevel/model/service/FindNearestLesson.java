package ua.com.alevel.model.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.function.Supplier;

public class FindNearestLesson {

    private static final Logger logger = LoggerFactory.getLogger(FindNearestLesson.class);
    private final Supplier<EntityManager> persistence;
    private Student student;

    public FindNearestLesson(Supplier<EntityManager> persistence) {
        this.persistence = persistence;
    }

    public void findNextLessonForStudentByCellNumber(String number) {
        if (!number.equals(student.getCellNumber())) {
            logger.error("You insert incorrect cell number");
            throw new IllegalArgumentException("Input incorrect cell number");
        }

        EntityManager entityManager = persistence.get();
        entityManager.getTransaction().begin();

        logger.info("Begin transaction");
//        TypedQuery<Student> studentTypedQuery = entityManager.createQuery()
    }
}
