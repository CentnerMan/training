package ru.vlsv.training.five;

import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * GeekBrains Java, training.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 08.05.2020
 * @link https://github.com/Centnerman
 */

@NoArgsConstructor
public class StudentDao {

    public Student findById(Integer id) {
        return StudentsSessionFactory.getSessionFactory().openSession().get(Student.class, id);
    }

    public void save(Student student) {
        Session session = StudentsSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(student);
        tx1.commit();
        session.close();
    }

    public void update(Student student) {
        Session session = StudentsSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(student);
        tx1.commit();
        session.close();
    }

    public void delete(Student student) {
        Session session = StudentsSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(student);
        tx1.commit();
        session.close();
    }

    public List<Student> findAll() {
        List<Student> students = (List<Student>) StudentsSessionFactory
                .getSessionFactory().openSession().createQuery("From Student").list();
        return students;
    }

}


