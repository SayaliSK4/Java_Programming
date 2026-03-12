package com.java.Experiment2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Student {
    int id;
    String name;
    double marks;
    String course;

    Student(int id, String name, double marks, String course) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.course = course;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks + ", Course: " + course;
    }
}

public class StudentRecord {

    Map<Integer, Student> studentMap = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        studentMap.put(id, new Student(id, name, marks, course));
        System.out.println("Student added successfully.");
    }

    void searchStudent() {
        System.out.print("Enter ID to search: ");
        int id = sc.nextInt();

        Student s = studentMap.get(id);

        if (s != null) {
            System.out.println(s);
        } else {
            System.out.println("Student not found.");
        }
    }

    void updateStudent() {
        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        Student s = studentMap.get(id);

        if (s != null) {
            System.out.print("Enter new Name: ");
            s.name = sc.nextLine();

            System.out.print("Enter new Marks: ");
            s.marks = sc.nextDouble();
            sc.nextLine();

            System.out.print("Enter new Course: ");
            s.course = sc.nextLine();

            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    void displayAll() {
        if (studentMap.isEmpty()) {
            System.out.println("No records found.");
        } else {
            for (Student s : studentMap.values()) {
                System.out.println(s);
            }
        }
    }

    void sortByMarks() {
        if (studentMap.isEmpty()) {
            System.out.println("No records to sort.");
            return;
        }

        List<Student> list = new ArrayList<>(studentMap.values());
        list.sort((a, b) -> Double.compare(b.marks, a.marks));

        System.out.println("Students Sorted by Marks (High to Low):");
        for (Student s : list) {
            System.out.println(s);
        }
    }

    void displayStudents() {
        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Update Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Sort Students by Marks");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    addStudent();
                    break;

                case 2:
                    searchStudent();
                    break;

                case 3:
                    updateStudent();
                    break;

                case 4:
                    displayAll();
                    break;

                case 5:
                    sortByMarks();
                    break;

                case 6:
                    System.out.println("Exiting program...");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void main(String[] args) {
        StudentRecord obj = new StudentRecord();
        obj.displayStudents();
    }
}








