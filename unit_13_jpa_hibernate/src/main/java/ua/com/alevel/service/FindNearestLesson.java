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

        try {

            logger.info("Begin transaction");
            TypedQuery<Student> studentTypedQuery = entityManager.createQuery("select s FROM Student s WHERE s.cellNumber LIKE :cellNumber", Student.class)
                    .setMaxResults(1)
                    .setParameter("cellNumber", number);

            studentTypedQuery.getResultStream().findAny().ifPresentOrElse(student -> {
                Long groupId = student.getGroup().getId();

                TypedQuery<Lesson> lessonTypedQuery = entityManager.createQuery("select l FROM Lesson l WHERE l.group = :groupId AND l.startTime > :now ORDER BY l.startTime", Lesson.class)
                        .setParameter("groupId", groupId).setMaxResults(1);
                List<Lesson> lessons = lessonTypedQuery.getResultList();
                if (!lessons.isEmpty()) {
                    Lesson lesson = lessons.get(0);
                    logger.info("{} has lesson, at {}, with teacher {}", student.getFullName(), lesson.getStartTime()
                            , lesson.getTeacher());
                } else {
                    logger.info("You don't have any lesson");
                }
            }, () -> logger.error("There is no student"));

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            logger.error("Unexpected error", e);
            entityManager.getTransaction().rollback();
        }

    }
}
