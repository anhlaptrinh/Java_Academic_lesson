package baitapcuoikhoaOOP.Controller;

import java.util.List;

import baitapcuoikhoaOOP.dto.Company;
import baitapcuoikhoaOOP.dto.DepartmentHead;
import baitapcuoikhoaOOP.dto.Director;
import baitapcuoikhoaOOP.dto.Employee;
import baitapcuoikhoaOOP.dto.Staff;

public interface CompanyManagement {
	 	Company addCompany(Company com);
	 	void assignEmployeeToDepartmentHead();
	 	void addEmployee(int role, String name, String phone, double profitshare);
	    void removeEmployee(String employeeId);
	    double calculateTotalCompanySalary();
//	    void displayAllEmployees();
	    List<Staff> findHighestSalaryEmployee();
	    List<DepartmentHead> findDepartmentHeadsWithMostEmployees();
	    List<Director> findDirectorWithHighestProfitShare();
	    void calculateDirectorIncome();
	    void sortEmployeesByName();
	    void sortEmployeesBySalary();
	    List<Employee> generateFakeData();
	    void printAllEmployee();
	    
}
