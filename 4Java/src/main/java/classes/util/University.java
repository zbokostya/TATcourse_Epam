package classes.util;

import classes.model.Student;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class University {
    private List<Student> students;

    public University() {
        students = new ArrayList<>();
    }

    public University(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
                return;
            }
        }
    }


    public List<Student> findStudentsInGroup(int group) {
        List<Student> rez = new ArrayList<>();
        for (Student student : students) {
            if (student.getGroup() == group) rez.add(student);
        }
        return rez;
    }

    public List<Student> findStudentsInCurs(int curs) {
        List<Student> rez = new ArrayList<>();
        for (Student student : students) {
            if (student.getCurs() == curs) rez.add(student);
        }
        return rez;
    }

    public List<Student> findStudentsBetweenDate(Date from, Date to) {
        List<Student> rez = new ArrayList<>();
        long dateFrom = from.getTime();
        long toFrom = from.getTime();
        for (Student student : students) {
            if (student.getBirthDate() > dateFrom && student.getBirthDate() < toFrom) {
                rez.add(student);
            }
        }
        return rez;
    }


}
