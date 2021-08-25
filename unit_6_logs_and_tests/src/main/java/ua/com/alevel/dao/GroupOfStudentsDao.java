package ua.com.alevel.dao;

import ua.com.alevel.entity.GroupOfStudents;
import ua.com.alevel.entity.Student;


public class GroupOfStudentsDao {
    private static final GroupOfStudents[] groupOfStudents = new GroupOfStudents[1];
    private static final GroupOfStudentsDao instance = new GroupOfStudentsDao();

    public static GroupOfStudentsDao getInstance() {
        return instance;
    }

    public void create (String course, Student[] students) {
        Student[] studentsByCourse = new Student[students.length];
        for (Student student: students) {
            if (student != null) {
                if (student.getCourse().equals(course)) {
                    for (int i = 0; i < studentsByCourse.length; i++) {
                        studentsByCourse[i] = student;
                    }
                }
            }
        }
    }
    
    public void update(GroupOfStudents group) {
        for( GroupOfStudents value: groupOfStudents) {
            if (value != null) {
                if (value.getIdCourse().equals(group.getIdCourse())) {
                    group.setIdCourse(value.getIdCourse());
                    return;
                }
            }
        }
        GroupOfStudents inDbGroupOfStudents = findGroupById(group.getIdCourse());
    }

    private GroupOfStudents findGroupById(String idCourse) {
        if (groupOfStudents.length >0) {
            for(GroupOfStudents value: groupOfStudents) {
                    if (value == null) {
                        break;
                    }
                    if (value.getIdCourse().equals(idCourse)) {
                        return value;
                    }
                }
            }
        return null;
        }

        public void delete(String idCourse) {
            for (int i = 0; i < groupOfStudents.length; i++) {
                if (groupOfStudents[i].getIdCourse().equals(idCourse)) {
                    groupOfStudents[i].setIsNotActive();
                }
            }
        }

        public GroupOfStudents[] findAllActiveGroups() {
        GroupOfStudents[] result = new GroupOfStudents[groupOfStudents.length];
            for (int i = 0; i < groupOfStudents.length; i++) {
                if (groupOfStudents[i].isActive()) {
                    result[i] = groupOfStudents[i];
            }
        }
            return result;
        }

}
