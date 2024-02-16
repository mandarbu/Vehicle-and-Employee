package com.employee;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class TestFile {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Scanner scanner = new Scanner(System.in);

	        // Step a) Ask the user to enter the total number of employees
	        System.out.print("Enter the total number of employees: ");
	        int n = scanner.nextInt();

	        // Create an array to store Employee objects
	        Employee[] employees = new Employee[n];

	        try {
	            // Step b) Create and store Employee objects in an array
	            for (int i = 0; i < n; i++) {
	                System.out.println("Enter details for Employee " + (i + 1) + ":");
	                System.out.print("Employee ID: ");
	                int empId = scanner.nextInt();
	                scanner.nextLine(); // Consume newline
	                System.out.print("Employee Name: ");
	                String empName = scanner.nextLine();
	                System.out.print("Grade (U1,U2,U3,U4,P1,P2): ");
	                String grade = scanner.nextLine();

	                // Validate grade
	                if (!grade.matches("U[1-4]|P[1-2]")) {
	                    throw new InvalidGradeException("Invalid grade entered for Employee " + (i + 1));
	                }

	                // Create Employee object and store in array
	                employees[i] = new Employee(empId, empName, grade);
	            }

	            // Step c) Write the Array of objects into a file empdetails.txt
	            try (BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/mandarjm/eclipse-workspace/Alltech/src/empdetails.txt"))) {
	                for (Employee employee : employees) {
	                    writer.write(employee.getEmpId() + "|" + employee.getEmpName() + "|" + employee.getGrade());
	                    writer.newLine();
	                }
	            }

	            System.out.println("Employee details written to empdetails.txt successfully.");

	            // Step d) Read the Array of objects from the file and display the information to the console
	            try (BufferedReader reader = new BufferedReader(new FileReader("/Users/mandarjm/eclipse-workspace/Alltech/src/empdetails.txt"))) {
	                String line;
	                System.out.println("\nEmployee Details from File:");
	                while ((line = reader.readLine()) != null) {
	                    String[] parts = line.split("\\|");
	                    int empId = Integer.parseInt(parts[0]);
	                    String empName = parts[1];
	                    String grade = parts[2];
	                    System.out.println(new Employee(empId, empName, grade));
	                }
	            }
	        } catch (IOException | InvalidGradeException e) {
	            System.out.println("Error: " + e.getMessage());
	        } finally {
	            scanner.close(); // Close scanner
	        }

	}

}
