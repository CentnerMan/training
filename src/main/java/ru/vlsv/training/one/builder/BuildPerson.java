package ru.vlsv.training.one.builder;

/**
 * GeekBrains Java, training.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 23.04.2020
 * @link https://github.com/Centnerman
 */

public class BuildPerson {
    public static void main(String[] args) {
        Person personBob = new Person.Builder().addFirstName("Bob").addLastName("Marley")
                .addAddress("USA").addGender("male").build();
        System.out.println(personBob.toString());
    }
}
