package baitapcuoikhoaOOP.dto;

import java.util.UUID;

public abstract class Employee {
	protected String empId;
	protected String name;
	protected String phoneNumber;
	protected int workDays;
	protected double dailyWage;
	public Employee(String name, String phoneNumber, int workDays, double dailyWage) {
		this.empId = generateUniqueId();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.workDays = workDays;
		this.dailyWage = dailyWage;
	}
	
	public abstract double calculateSalary();
	protected abstract String getIdPrefix();
	 private String generateUniqueId() {
		 return getIdPrefix() + UUID.randomUUID().toString().replace("-", "i").substring(0, 8);
	    }
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getWorkDays() {
		return workDays;
	}
	public void setWorkDays(int workDays) {
		this.workDays = workDays;
	}
	public double getDailyWage() {
		return dailyWage;
	}
	public void setDailyWage(double dailyWage) {
		this.dailyWage = dailyWage;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", phoneNumber=" + phoneNumber + ", workDays=" + workDays
				+ ", dailyWage=" + dailyWage + "]";
	}
	
	
	
}
