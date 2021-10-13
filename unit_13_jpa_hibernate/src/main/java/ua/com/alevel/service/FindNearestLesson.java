package ua.com.alevel.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.model.Lesson;
import ua.com.alevel.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.function.Supplier;

public class FindNearestLesson {

    private static final Logger logger = LoggerFactory.getLogger(FindNearestLesson.class);
    private final Supplier<EntityManager> persistence;
    private Student student;
    private static final String SELECT_ALL_STUDENTS_BY_NUMBER = "FROM Student s WHERE s.cell_number LIKE: cellNumber";
    private static final String SELECT_ALL_LESSONS_BY_NOW = "FROM Lesson l WHERE l.group = :groupId AND l.startTime > now() ORDER BY l.startTime";

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
        TypedQuery<Student> studentTypedQuery = entityManager.createQuery(SELECT_ALL_STUDENTS_BY_NUMBER, Student.class)
                .setParameter("cellNumber", number);

        Student student = studentTypedQuery.getSingleResult();

        if (student == null) {
            logger.error("There is no student");
        } else {

            Long groupId = student.getGroup().getId();

            TypedQuery<Lesson> lessonTypedQuery = entityManager.createQuery(SELECT_ALL_LESSONS_BY_NOW, Lesson.class)
                    .setParameter("groupId", groupId).setMaxResults(1);
            List<Lesson> lessons = lessonTypedQuery.getResultList();
            if (!lessons.isEmpty()) {
                Lesson lesson = lessons.get(0);
                logger.info("{} has lesson, at {}, with teacher {}", student.getFullName(), lesson.getStartTime()
                        , lesson.getTeacher());
            } else {
                logger.info("You don't have any lesson");
            }
        }
        entityManager.getTransaction().commit();
    }
}
