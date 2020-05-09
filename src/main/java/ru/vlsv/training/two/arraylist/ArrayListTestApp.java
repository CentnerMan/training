package ru.vlsv.training.two.arraylist;

/**
 * GeekBrains Java, training.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 27.04.2020
 * @link https://github.com/Centnerman
 */

public class ArrayListTestApp {


    public static void main(String[] args) {
        ArrayList<String> stringArrayList = new ArrayListImpl<>();
        stringArrayList.add("AAAAA");
        stringArrayList.add("BBBBB");
        stringArrayList.add("CCCCC");
        stringArrayList.add("AAAAA");
        stringArrayList.add("BBBBB");
        stringArrayList.add("CCCCC");
        stringArrayList.add("AAAAA");
        stringArrayList.add("BBBBB");
        stringArrayList.add("CCCCC");
        stringArrayList.add("AAAAA");
        stringArrayList.add("BBBBB");
        stringArrayList.add("CCCCC");
        stringArrayList.add("AAAAA");
        stringArrayList.add("BBBBB");
        stringArrayList.add("CCCCC");

        System.out.println(stringArrayList.size());
        System.out.println(stringArrayList.get(1));
        System.out.println(stringArrayList.get(2));

        System.out.println("-----------------");
        for (int i = 0; i < stringArrayList.size(); i++) {
            System.out.println(stringArrayList.get(i));
        }

        stringArrayList.remove(1);
        System.out.println("-----------------");
        for (int i = 0; i < stringArrayList.size(); i++) {
            System.out.println(stringArrayList.get(i));
        }
        System.out.println(stringArrayList.size());

    }
}
