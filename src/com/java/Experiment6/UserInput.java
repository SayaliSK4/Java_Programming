package com.java.Experiment6;
import java.util.Scanner;
public class UserInput {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Input from user
	        System.out.print("Enter a number: ");
	        int num = scanner.nextInt();

	        // Display multiplication table
	        System.out.println("\nMultiplication Table of " + num + ":");
	        for (int i = 1; i <= 10; i++) {
	            System.out.println(num + " x " + i + " = " + (num * i));
	        }

	        // Display square
	        int square = num * num;
	        System.out.println("\nSquare of " + num + " is: " + square);

	        scanner.close();
	    }
}
