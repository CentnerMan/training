package ru.vlsv.training.five;

import lombok.NoArgsConstructor;

import java.util.List;

/**
 * GeekBrains Java, training.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 09.05.2020
 * @link https://github.com/Centnerman
 */

@NoArgsConstructor
public class StudentService {

    private final StudentDao studentDao = new StudentDao();

    public Student findStudent(Integer id) {
        return studentDao.findById(id);
    }

    public void saveStudent(Student student) {
        studentDao.save(student);
    }

    public void deleteStudent(Student student) {
        studentDao.delete(student);
    }

    public void updateStudent(Student student) {
        studentDao.update(student);
    }

    public List<Student> findAllStudents() {
        return studentDao.findAll();
    }

}
