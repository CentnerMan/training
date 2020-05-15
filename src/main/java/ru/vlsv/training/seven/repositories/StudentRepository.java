package ru.vlsv.training.seven.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vlsv.training.seven.entities.Student;

/**
 * GeekBrains Java, training.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 14.05.2020
 * @link https://github.com/Centnerman
 */

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findOneByName(String name);
    Student findOneById(Integer id);
    boolean existsByName(String name);
}
