package com.java.Experiment3;


// Base Class
class Person {
String name;
int age;
public Person(String name, int age) {
this.name = name;
this.age = age;
}
public void displayInfo() {
System.out.println("Name: " + name + ", Age: " + age);
}
}
// Employee Class
class Employee extends Person {
double baseSalary;
public Employee(String name, int age, double baseSalary) {
super(name, age);
this.baseSalary = baseSalary;
}
public double calculateSalary() {
return baseSalary;
}
// Method Overloading
public void updateEmployeeData(String newName) {
this.name = newName;
System.out.println("Updated Name: " + name);
}
public void updateEmployeeData(int newAge) {
this.age = newAge;
System.out.println("Updated Age: " + age);
}
public void updateEmployeeData(double newSalary) {
this.baseSalary = newSalary;
System.out.println("Updated Salary: " + baseSalary);
}
}
// Manager Class
class Manager extends Employee {
double bonus;
public Manager(String name, int age, double baseSalary, double bonus) {
super(name, age, baseSalary);
this.bonus = bonus;
}
// Method Overriding
@Override
public double calculateSalary() {
return baseSalary + bonus;
}
}
// Main Class
public class EmployeeManagement {
public static void main(String[] args) {
Employee emp = new Employee("Samiksha", 28, 50000);
Manager mngr = new Manager("Aniket", 23, 80000, 10000);
emp.displayInfo();
System.out.println("Employee Salary: " + emp.calculateSalary());
mngr.displayInfo();
System.out.println("Manager Salary: " + mngr.calculateSalary());
emp.updateEmployeeData("Sayali");
emp.updateEmployeeData(22);
emp.updateEmployeeData(60000);
}
}
