package ru.vlsv.training.seven.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vlsv.training.seven.entities.Student;
import ru.vlsv.training.seven.repositories.StudentRepository;

import java.util.List;

/**
 * GeekBrains Java, training.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 14.05.2020
 * @link https://github.com/Centnerman
 */

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student findByName(String name) {
        return studentRepository.findOneByName(name);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(Integer id) {
        return studentRepository.findOneById(id);
    }

    public void update(Student student) {
        studentRepository.save(student);
    }

    public void delete(Integer id) {
        studentRepository.deleteById(id);
    }
}
