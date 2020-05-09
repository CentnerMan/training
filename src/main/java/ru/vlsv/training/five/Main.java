package ru.vlsv.training.five;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * GeekBrains Java, training.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 09.05.2020
 * @link https://github.com/Centnerman
 */

public class Main {
    public static void main(String[] args) throws SQLException {

        StudentService studentService = new StudentService();

        Student student;
        List<Student> allStudents = new ArrayList<>();

        System.out.println("CREATE");

        for (int i = 0; i < 1000; i++) {
            student = new Student("Masha - " + i, (int) (Math.random() * 11));
            studentService.saveStudent(student);
        }

        System.out.println("READ");

        allStudents = studentService.findAllStudents();
        for (Student st : allStudents) {
            System.out.println(st);
        }

        System.out.println("UPDATE");

        student = studentService.findStudent(6);
        student.setName("Dasha");
        studentService.updateStudent(student);

        System.out.println("DELETE");

        student = studentService.findStudent(111);
        studentService.deleteStudent(student);

    }
}
