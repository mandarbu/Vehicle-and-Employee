package com.employee;

public class Employee {

	private int empId;
    private String empName;
    private String grade;
    
    // Constructor
    public Employee(int empId, String empName, String grade) {
        this.empId = empId;
        this.empName = empName;
        this.grade = grade;
    }

    // Accessor methods
    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public String getGrade() {
        return grade;
    }

    // Mutator methods
    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    // Override toString method
    @Override
    public String toString() {
        return "Employee ID: " + empId + ", Employee Name: " + empName + ", Grade: " + grade;
    }
	
}
