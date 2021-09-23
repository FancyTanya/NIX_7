package ua.com.alevel.db;

import ua.com.alevel.entity.StudentCourse;

public class StudentCourseDb {
    private static StudentCourseDb instance;
    private StudentCourse[] studentCourseDb = new StudentCourse[10];
    private int index;
    private final int MULTIPLIER = 2;

    public void createStudentCourse(int studentId, int courseId) {
        if (studentCourseDb[studentCourseDb.length - 1] != null) {
            increaseArray();
        }
        studentCourseDb[index] = new StudentCourse(studentId, courseId);
        index++;
    }

    public void deleteStudentCourse(int studentId, int courseId) {
        for (int i = 0; i < studentCourseDb.length; i++) {
            if (studentCourseDb[i].getStudentId() == studentId && studentCourseDb[i].getCourseId() == courseId) {
                studentCourseDb[i] = null;
            }
        }
        rebuildArray(studentCourseDb.length);
    }

    public int[] getStudentIdByCourseId(int courseId) {
        int count = 0;
        for (int i = 0; i < studentCourseDb.length; i++) {
            if (studentCourseDb[i].getCourseId() == courseId && studentCourseDb[i] != null) {
                count++;
            }
        }
        int[] studentsId = new int[count];
        int indexCount = 0;
        if (count > 0) {
            studentsId =new int[count];
            for (int i = 0; i < studentCourseDb.length; i++) {
                if (studentCourseDb[i].getCourseId() == courseId && studentCourseDb[i] != null) {
                    studentsId[indexCount] = studentCourseDb[i].getStudentId();
                    indexCount++;
                }
            }
        }
        return studentsId;
    }

    public int[] getCourseIdByStudentId(int studentId) {
        int count = 0;
        for (int i = 0; i < studentCourseDb.length; i++) {
            if (studentCourseDb[i].getStudentId() == studentId && studentCourseDb[i] != null) {
                count++;
            }
        }
        int[] coursesId = null;
        int indexCount = 0;
        if (count > 0) {
            coursesId = new int[count];
            for (int i = 0; i < studentCourseDb.length; i++) {
                if (studentCourseDb[i].getStudentId() == studentId && studentCourseDb[i] != null) {
                    coursesId[indexCount] =studentCourseDb[i].getCourseId();
                    indexCount++;
                }
            }
        }
        return coursesId;
    }

    public void updateStudentsListByCourseId(int courseId, int[] studentsList) {
        int studentsIndex = studentsList.length;
        for (int i = 0; i < studentCourseDb.length; i++) {
            if (studentCourseDb[i] != null && studentCourseDb[i].getCourseId() == courseId) {
                int indexInCourseList =getIndexById(studentCourseDb[i].getCourseId(), studentsList);
                if (indexInCourseList != -1) {
                    studentsList[indexInCourseList] = -1;
                    studentsIndex--;
                } else {
                    studentCourseDb[i] = null;
                }
            }
        }
        if (studentsIndex > 0) {
            for (int i = 0; i < studentsList.length; i++) {
                if (studentsList[i] != -1) {
                    createStudentCourse(studentsList[i], courseId);
                }
            }
        }
        rebuildArray(studentCourseDb.length);
    }

    public void updateCoursesListBYStudentId(int studentId, int[] coursesList) {
        int coursesIndex = coursesList.length;
        for (int i = 0; i < studentCourseDb.length; i++) {
            if (studentCourseDb[i] != null && studentCourseDb[i].getStudentId() == studentId) {
                int indexInStudentsList = getIndexById(studentCourseDb[i].getStudentId(), coursesList);
                if (indexInStudentsList != -1) {
                    coursesList[indexInStudentsList] = -1;
                    coursesIndex--;
                } else {
                    studentCourseDb[i] = null;
                }
            }
        }
        if (coursesIndex > 0) {
            for (int i = 0; i < coursesList.length; i++) {
                if (coursesList[i] != -1) {
                    createStudentCourse(coursesList[i], studentId);
                }
            }
        }
        rebuildArray(studentCourseDb.length);
    }

    private int getIndexById(int id, int[] listID) {
        for (int i = 0; i < listID.length; i++) {
            if (listID[i] == id) {
                return i;
            }
        }
        return -1;
    }

    private void increaseArray() {
        rebuildArray(studentCourseDb.length * MULTIPLIER);
    }

    private void rebuildArray(int length) {
        StudentCourse[] newStudentCourse = new StudentCourse[length];
        int count = 0;
        for (int i = 0; i < studentCourseDb.length; i++) {
            if (studentCourseDb[i] != null) {
                newStudentCourse[count] = studentCourseDb[i];
                count++;
            }
        }
        studentCourseDb = newStudentCourse;
        index = count;
    }
}
