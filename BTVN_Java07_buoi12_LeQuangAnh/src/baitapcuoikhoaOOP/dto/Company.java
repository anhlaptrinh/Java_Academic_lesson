package baitapcuoikhoaOOP.dto;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;
    private String taxCode;
    private double monthlyRevenue;
    private List<Employee> employees;

    public Company(String name, String taxCode, double monthlyRevenue) {
        this.name = name;
        this.taxCode = taxCode;
        this.monthlyRevenue = monthlyRevenue;
        this.employees = new ArrayList<>();
    }
    

    public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTaxCode() {
		return taxCode;
	}


	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}


	public double getMonthlyRevenue() {
		return monthlyRevenue;
	}


	public void setMonthlyRevenue(double monthlyRevenue) {
		this.monthlyRevenue = monthlyRevenue;
	}


	public List<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}


	public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(String employeeId) {
        employees.removeIf(employee -> employee.getEmpId().equals(employeeId));
    }

    public double calculateTotalSalary() {
        double totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary += employee.calculateSalary();
        }
        return totalSalary;
    }

    public Employee findHighestSalaryEmployee() {
        Employee highestSalaryEmployee = null;
        for (Employee employee : employees) {
            if (highestSalaryEmployee == null || employee.calculateSalary() > highestSalaryEmployee.calculateSalary()) {
                highestSalaryEmployee = employee;
            }
        }
        return highestSalaryEmployee;
    }

    public void displayAllEmployees() {
        for (Employee employee : employees) {
            System.out.println("ID: " + employee.getEmpId() + ", Name: " + employee.getName() + ", Salary: " + employee.calculateSalary());
        }
    }


	@Override
	public String toString() {
		 StringBuilder sb = new StringBuilder();
		    sb.append("Company Information:\n");
		    sb.append("Name: ").append(name).append("\n");
		    sb.append("Tax Code: ").append(taxCode).append("\n");
		    sb.append("Monthly Revenue: ").append(String.format("%.2f", monthlyRevenue)).append("\n");
		    sb.append("Employees:\n");
		    
		    if (employees.isEmpty()) {
		        sb.append("  No employees in the company.\n");
		    } else {
		        for (Employee employee : employees) {
		            sb.append("  - ").append(employee.toString()).append("\n");
		        }
		    }

		    return sb.toString();
	}
    
}

