package ru.vlsv.training.five;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * GeekBrains Java, training.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 08.05.2020
 * @link https://github.com/Centnerman
 */

public class StudentsSessionFactory {

        private static SessionFactory sessionFactory;

        private StudentsSessionFactory() {}

        public static SessionFactory getSessionFactory() {
            if (sessionFactory == null) {
                try {
                    Configuration configuration = new Configuration()
                            .configure("five/hibernate.cfg.xml");
                    configuration.addAnnotatedClass(Student.class);
                    StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                            .applySettings(configuration.getProperties());
                    sessionFactory = configuration.buildSessionFactory(builder.build());

                } catch (Exception e) {
                    System.out.println("Исключение!" + e);
                }
            }
            return sessionFactory;
        }
}
