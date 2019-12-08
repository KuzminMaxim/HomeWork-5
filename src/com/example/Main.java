package com.example;

import com.example.classesfortest.Student;
import com.example.classesfortest.TestClass;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){

        MyLinkedList<Student> test = new MyLinkedList<>();

        //size
        System.out.println("Size: " + test.size());
        System.out.println();

        //add
        for (int i = 0; i < 5; i++){
            test.add(new Student("studentName", "studentAddress", "studentProgram", i+1,300.23*(i+1)));
        }

        //toString
        System.out.println(test.toString());
        System.out.println();

        //add(Element, index)
        for (int i = 0; i < 2; i++){
            test.add(i, new Student("NewName", "NewAdress", "NewProgram", (i+1)*2, 123.33*(i+1)));
        }

        //Iterator
        System.out.println("Iterator");
        for(Student student : test){
            System.out.println(student.toString());
        }
        System.out.println();

        //size
        System.out.println("Size: " + test.size());
        System.out.println();

        //remove(index)
        for (int i=0;i<3;i++){
            test.remove(i);
        }
        System.out.println("Size after remove: " + test.size());

        //toArray
        System.out.println();
        System.out.println("toArray");
        System.out.println(Arrays.toString(test.toArray()));

        //set
        Student student = new Student("John", "City", "Old", 6, 500);
        test.set(1,student);
        System.out.println(test.toString());
        System.out.println();

        //get
        System.out.println("get(): " + test.get(1));
        System.out.println();

        //indexOf
        Student lastStudent = new Student("Smith", "Town", "New", 5, 500);
        test.add(lastStudent);
        System.out.println("indexOf(): " + test.indexOf(lastStudent));
        System.out.println();

        //clear
        test.clear();
        System.out.println(test.toString());
        System.out.println("Size after clear: "+test.size());
        System.out.println();

        //Comparison
        System.out.println("Compare MyLinkedList and LinkedList");
        ComparisonLinkedListAndMyLinkedList comparisonLinkedListAndMyLinkedList =
                new ComparisonLinkedListAndMyLinkedList(500000);

        comparisonLinkedListAndMyLinkedList.compareList();
        System.out.println();

        TestClass testClass = new TestClass(500000);

        //Add and remove for lists begin
        testClass.compareAddForListBegin("Some element");
        testClass.compareRemoveForListBegin();
        System.out.println();

        //Add and remove for lists middle
        testClass.compareAddForList("Some element", 250000);
        testClass.compareRemoveForList(250000);
        System.out.println();

        //Add and remove for lists end
        testClass.compareAddForList("Some element", 500000);
        testClass.compareRemoveForListEnd();
        System.out.println();

        //Compare for Sets
        testClass.compareAddForSet("Some element");
        System.out.println();
        testClass.compareContainsForSet("Some element");
        System.out.println();
        testClass.compareRemoveForSet("Some element");
        System.out.println();

        //Compare for Maps
        testClass.comparePutForMap("Some element");
        System.out.println();
        testClass.compareGetForMap("Some element");
        System.out.println();
        testClass.compareRemoveForMap("Some element");
        System.out.println();

    }
}
