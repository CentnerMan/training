package ru.vlsv.training.two.linkedlist;

public class LinkedListTestApp {

    public static void main(String[] args) {
        testLinkedList();

//        testTwoSideLinkedList();

    }

    private static void testTwoSideLinkedList() {
        TwoSideLinlkedList<Integer> linkedList = new TwoSideLinkedListImpl<>();
        linkedList.insertLeft(2);
        linkedList.insertLeft(3);
        linkedList.insertLeft(4);
        linkedList.insertLeft(5);
        linkedList.insertRight(1);

        linkedList.remove(3);
        linkedList.remove(33);

        linkedList.display();

        System.out.println("Find 2 = " + linkedList.find(2));
        System.out.println("Find 222 = " + linkedList.find(222));

        linkedList.remove();
        linkedList.remove();

        linkedList.display();
    }

    private static void testLinkedList() {
        LinkedList<Integer> linkedList = new LinkedListImpl<>();
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(4);
        linkedList.insert(5);
        linkedList.insert(1);

        linkedList.remove(3);
        linkedList.remove(33);

        linkedList.display();

        System.out.println("Find 2 = " + linkedList.find(2));
        System.out.println("Find 222 = " + linkedList.find(222));

        linkedList.remove();
        linkedList.remove();

        linkedList.display();
    }
}
