package baitapcuoikhoaOOP.dto;

public class Staff extends Employee {
	private DepartmentHead departmentHead;
	 
	public Staff(String name, String phoneNumber, int workDays, DepartmentHead departmentHead) {
		super(name, phoneNumber, workDays, DailyWage.STAFF_DAILYWAGE);
		// TODO Auto-generated constructor stub
		this.departmentHead = departmentHead;
	}
	

	public DepartmentHead getDepartmentHead() {
		return departmentHead;
	}


	public void setDepartmentHead(DepartmentHead departmentHead) {
		this.departmentHead = departmentHead;
	}


	@Override
	public double calculateSalary() {
		// TODO Auto-generated method stub
		 return dailyWage * workDays;
	}


	@Override
	protected String getIdPrefix() {
		// TODO Auto-generated method stub
		 return "STA";
	}


	@Override
	public String toString() {
	    return String.format(
	        "Staff Information:\n" +
	        "Employee ID      : %s\n" +
	        "Name             : %s\n" +
	        "Phone Number     : %s\n" +
	        "Work Days        : %d\n" +
	        "Daily Wage       : %.2f\n" +
	        "Department Head  : %s\n",
	        empId, 
	        name, 
	        phoneNumber, 
	        workDays, 
	        dailyWage, 
	        departmentHead != null ? departmentHead.getName() : "None"
	    );
	}
	

}
