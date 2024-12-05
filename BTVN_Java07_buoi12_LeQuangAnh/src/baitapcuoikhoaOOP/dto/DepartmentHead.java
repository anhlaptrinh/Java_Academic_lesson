package baitapcuoikhoaOOP.dto;

import java.util.ArrayList;
import java.util.List;

public class DepartmentHead extends Employee {
	private int numberOfEmployees;
	private List<Staff> employeesUnderManagement;

	public DepartmentHead(String name, String phoneNumber, int workDays) {
		super(name, phoneNumber, workDays, DailyWage.HEADER_DAILYWAGE); // Lương 1 ngày của trưởng phòng là 200
		this.employeesUnderManagement = new ArrayList<>();
		this.numberOfEmployees = 0;
	}
	

	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}


	public void setNumberOfEmployees(int numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}


	public void setEmployeesUnderManagement(List<Staff> employeesUnderManagement) {
		this.employeesUnderManagement = employeesUnderManagement;
	}


	@Override
	public double calculateSalary() {
		return dailyWage * workDays + 100 * numberOfEmployees;
	}

	public void addEmployeeUnderManagement(Staff employee) {
		employeesUnderManagement.add(employee);
		setNumberOfEmployees(employeesUnderManagement.size());
	}
	public void removeDepartmentHeader(Staff employee) {
		employeesUnderManagement.remove(employee);
		setNumberOfEmployees(employeesUnderManagement.size());
	}

	// Getters and setters (optional)
	public List<Staff> getEmployeesUnderManagement() {
		return employeesUnderManagement;
		
	}

	@Override
	protected String getIdPrefix() {
		// TODO Auto-generated method stub
		return "HEA";
	}

	@Override
	public String toString() {
	    // Chuyển danh sách các nhân viên dưới quyền thành một chuỗi
	    String employeesList = employeesUnderManagement.isEmpty() 
	        ? "None" 
	        : String.join(", ", employeesUnderManagement.stream()
	                                                     .map(Employee::getName)
	                                                     .toArray(String[]::new));
	    
	    return String.format(
	        "Department Head Information:\n" +
	        "Employee ID               : %s\n" +
	        "Name                      : %s\n" +
	        "Phone Number              : %s\n" +
	        "Work Days                 : %d\n" +
	        "Daily Wage                : %.2f\n" +
	        "Number of Employees       : %d\n" +
	        "Employees Under Management: %s\n",
	        empId, 
	        name, 
	        phoneNumber, 
	        workDays, 
	        dailyWage, 
	        numberOfEmployees, 
	        employeesList
	    );
	}

}
