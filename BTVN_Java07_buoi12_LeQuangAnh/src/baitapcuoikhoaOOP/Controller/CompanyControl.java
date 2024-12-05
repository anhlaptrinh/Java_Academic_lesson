package baitapcuoikhoaOOP.Controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import baitapcuoikhoaOOP.dto.Director;
import baitapcuoikhoaOOP.dto.Employee;
import baitapcuoikhoaOOP.dto.Staff;
import baitapcuoikhoaOOP.dto.Company;
import baitapcuoikhoaOOP.dto.DepartmentHead;

public class CompanyControl implements CompanyManagement {
	public List<Employee> employees = new ArrayList<>();
	List<Company> comList = new ArrayList<>();
	List<Staff> staffs=new ArrayList<>();
	List<DepartmentHead> headers=new ArrayList<>();
//	List<Director> director=new ArrayList<>();
	public Company com = null;
	static Scanner scanner = new Scanner(System.in);
	
	public CompanyControl() {
	}

	@Override
	public Company addCompany(Company newcom) {
		// TODO Auto-generated method stub
		com = newcom;
		com.setEmployees(employees);
		return com;
	}

	@Override
	public void addEmployee(int role, String name, String phone,double profitshare) {
		// TODO Auto-generated method stub
		switch (role) {
		case 1: {
			Staff staff=new Staff(name,phone,0,null);
			staffs.add(staff);
			employees.add(staff);
			System.out.println("Thêm Nhân sự thành công. Vui lòng nhấn exit và sử dụng chức năng 4 để in ra");
			break;
		}
		case 2: {
			DepartmentHead header=new DepartmentHead(name,phone,0);
			headers.add(header);
			employees.add(header);
			System.out.println("Thêm Nhân sự thành công. Vui lòng nhấn exit và sử dụng chức năng 4 để in ra");
			break; 
		}
		case 3: {
			Director dir=new Director(name, phone, 0, profitshare);
			employees.add(dir);
			System.out.println("Thêm Nhân sự thành công. Vui lòng nhấn exit và sử dụng chức năng 4 để in ra");
			break;
		}
		default:
			System.out.println("Out of function");
		}
	}

	@Override
	public void removeEmployee(String employeeId) {
	    Employee employeeToRemove = null;

	    // Find the employee to remove
	    for (Employee employee : employees) {
	        if (employee.getEmpId().equals(employeeId)) {
	            employeeToRemove = employee;
	            break;
	        }
	    }

	    if (employeeToRemove != null) {
	        // If the employee is a DepartmentHead, remove the department head
	        if (employeeToRemove instanceof DepartmentHead) {
	            DepartmentHead departmentHeadToRemove = (DepartmentHead) employeeToRemove;

	            // Unassign all employees managed by this department head
	            for (Staff staff : departmentHeadToRemove.getEmployeesUnderManagement()) {
	                staff.setDepartmentHead(null);
	            }

	            // Remove from headers list (if you have a separate list)
	            headers.remove(departmentHeadToRemove);
	        }

	        // If the employee is a Staff member, remove them from their DepartmentHead's list
	        if (employeeToRemove instanceof Staff) {
	            Staff staffToRemove = (Staff) employeeToRemove;
	            DepartmentHead manager = staffToRemove.getDepartmentHead();
	            if (manager != null) {
	                manager.getEmployeesUnderManagement().remove(staffToRemove);
	            }

	            // Remove from staff list (if you have a separate list)
	            staffs.remove(staffToRemove);
	        }

	        // Finally, remove the employee from the main employees list
	        employees.remove(employeeToRemove);
	        System.out.println("Xóa Nhân sự thành công. Vui lòng Exit và sử dụng chức năng 4 ở Menu chính để in ra");
	    } else {
	        System.out.println("Không tìm thấy Nhân sự.");
	    }
	}


	@Override
	public double calculateTotalCompanySalary() {
		// TODO Auto-generated method stub
		return employees.stream()
                .mapToDouble(Employee::calculateSalary)
                .sum();
	}

	@Override
	public List<Staff> findHighestSalaryEmployee() {
		// TODO Auto-generated method stub
		  double maxSalary = employees.stream()
		            .filter(e -> e instanceof Staff)
		            .mapToDouble(Employee::calculateSalary)
		            .max()
		            .orElse(0);

		    // Lọc danh sách các Staff có lương bằng với mức lương cao nhất
		    return employees.stream()
		            .filter(e -> e instanceof Staff)
		            .map(e -> (Staff) e)
		            .filter(staff -> staff.calculateSalary() == maxSalary)
		            .collect(Collectors.toList());
	}

	@Override
	public List<DepartmentHead> findDepartmentHeadsWithMostEmployees() {
	    // Tìm số lượng nhân viên quản lý lớn nhất
	    int maxEmployees = employees.stream()
	            .filter(e -> e instanceof DepartmentHead)
	            .map(e -> (DepartmentHead) e)
	            .mapToInt(DepartmentHead::getNumberOfEmployees)
	            .max()
	            .orElse(0);

	    // Lọc danh sách các DepartmentHead có số lượng nhân viên quản lý bằng với maxEmployees
	    return employees.stream()
	            .filter(e -> e instanceof DepartmentHead)
	            .map(e -> (DepartmentHead) e)
	            .filter(head -> head.getNumberOfEmployees() == maxEmployees)
	            .collect(Collectors.toList());
	}

	@Override
	public List<Director> findDirectorWithHighestProfitShare() {
	    double highestProfitShare = employees.stream()
	            .filter(e -> e instanceof Director)
	            .map(e -> (Director) e)
	            .mapToDouble(Director::getProfitShare)
	            .max()
	            .orElse(Double.MIN_VALUE);

	    return employees.stream()
	            .filter(e -> e instanceof Director)
	            .map(e -> (Director) e)
	            .filter(d -> d.getProfitShare() == highestProfitShare)
	            .collect(Collectors.toList());
	}


	@Override
	public void sortEmployeesByName() {
		// TODO Auto-generated method stub
		 employees.sort(Comparator.comparing(Employee::getName));

	}

	@Override
	public void sortEmployeesBySalary() {
		// TODO Auto-generated method stub
		employees.sort(Comparator.comparingDouble(Employee::calculateSalary).reversed());

	}

	@Override
	public void assignEmployeeToDepartmentHead() {
	    Staff employee = null;
	    DepartmentHead head = null;

	    while (employee == null || head == null) {
	        System.out.print("Enter Regular Employee ID: ");
	        String employeeId = scanner.nextLine();
	        employee = employees.stream()
	                .filter(e -> e instanceof Staff && e.getEmpId().equals(employeeId))
	                .map(e -> (Staff) e)
	                .findFirst()
	                .orElse(null);

	        if (employee == null) {
	            System.out.println("Regular Employee not found! Please enter a valid Employee ID.");
	            continue;
	        }

	        System.out.print("Enter Department Head ID: ");
	        String headId = scanner.nextLine();
	        head = employees.stream()
	                .filter(e -> e instanceof DepartmentHead && e.getEmpId().equals(headId))
	                .map(e -> (DepartmentHead) e)
	                .findFirst()
	                .orElse(null);

	        if (head == null) {
	            System.out.println("Department Head not found! Please enter a valid Department Head ID.");
	        } else if (head.getEmployeesUnderManagement().contains(employee)) {
	            System.out.println("This employee is already managed by the selected Department Head. Please enter a different Employee ID.");
	            employee = null;  // Reset employee to allow re-entry
	            head = null;      // Reset head to allow re-entry
	        }
	    }

	    // Remove employee from the current Department Head (if any)
	    DepartmentHead currentHead = employee.getDepartmentHead();
	    if (currentHead != null) {
	        currentHead.removeDepartmentHeader(employee);
	    }

	    // Assign employee to the new Department Head
	    head.addEmployeeUnderManagement(employee);
	    employee.setDepartmentHead(head);
	    System.out.println("Employee assigned to Department Head successfully.");
	}



	@Override
	public List<Employee> generateFakeData() {
		// TODO Auto-generated method stub
		// Tạo dữ liệu giả cho các nhân viên thường
		employees.add(new Staff("John Doe", "0123456789", 20, null));
		employees.add(new Staff("Jane Smith", "0987654321", 22, null));
		employees.add(new Staff("David Johnson", "0123987456", 18, null));
		employees.add(new Staff("Emily Davis", "0167892345", 25, null));

		// Tạo dữ liệu giả cho các trưởng phòng
		DepartmentHead head1 = new DepartmentHead("Michael Brown", "0172839465", 20);
		DepartmentHead head2 = new DepartmentHead("Sarah Wilson", "0157382910", 22);
		employees.add(head1);
		employees.add(head2);

		// Phân bổ một số nhân viên thường vào trưởng phòng
		head1.addEmployeeUnderManagement((Staff) employees.get(0));
		head1.addEmployeeUnderManagement((Staff) employees.get(1));
		head2.addEmployeeUnderManagement((Staff) employees.get(2));

		((Staff) employees.get(0)).setDepartmentHead(head1);
		((Staff) employees.get(1)).setDepartmentHead(head1);
		((Staff) employees.get(2)).setDepartmentHead(head2);

		// Tạo dữ liệu giả cho các giám đốc
		employees.add(new Director("Richard Taylor", "0192837465", 18, 10));
		employees.add(new Director("Jessica White", "0182738495", 20, 15));
		for (Employee emp : employees) {
		    if (emp instanceof Staff && emp.getEmpId().startsWith("STA")) {
		        staffs.add((Staff) emp);
		    } else if (emp instanceof DepartmentHead && emp.getEmpId().startsWith("HEA")) {
		        headers.add((DepartmentHead) emp);
		    }
		}


		return employees;
	}

	@Override
	public void printAllEmployee() {
		if (employees.isEmpty())
			generateFakeData();
		System.out.println("Danh sách nhân viên");
		// TODO Auto-generated method stub
		for (Employee emp : employees) {
			System.out.println(emp);
			System.out.println("=================================================================");
		}
	}

	@Override
	public void calculateDirectorIncome() {
		// TODO Auto-generated method stub
		if(com==null) System.out.println("Vui Lòng nhập thông tin công ty");
		else if(employees.isEmpty()) System.out.println("Vui Lòng nhập thông tin Nhân viên");
		else {
			employees.stream()
	        .filter(e -> e instanceof Director)
	        .map(e -> (Director) e)
	        .forEach(director -> {
	            
	            System.out.println("Director ID: " + director.getEmpId());
	            System.out.println("Name: " + director.getName());
	            System.out.println("Total Income: " + director.calculateTotalIncome(com.getMonthlyRevenue()*calculateTotalCompanySalary()));
	            System.out.println("-----------------------------");
	        });
		}
		
	}

}
