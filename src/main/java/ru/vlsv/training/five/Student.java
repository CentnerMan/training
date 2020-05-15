package ru.vlsv.training.five;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

/**
 * GeekBrains Java, training.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 08.05.2020
 * @link https://github.com/Centnerman
 */

@Entity
@Data
@NoArgsConstructor
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private Integer mark;

    public Student(String name, Integer mark) {
        this.name = name;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", mark=" + mark +
                '}';
    }
}
