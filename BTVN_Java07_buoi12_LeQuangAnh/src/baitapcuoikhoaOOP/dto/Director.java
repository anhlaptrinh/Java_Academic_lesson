package baitapcuoikhoaOOP.dto;

public class Director extends Employee {
	 private double profitShare; // Cổ phần trong công ty

	    public Director(String name, String phoneNumber, int workDays, double profitShare) {
	        super(name, phoneNumber, workDays, DailyWage.DIRECTOR_DAILYWAGE); // Lương 1 ngày của giám đốc là 300
	        this.profitShare = Math.min(profitShare, 100); // Đảm bảo cổ phần không vượt quá 100%
	    }

	    public double getProfitShare() {
			return profitShare;
		}

		public void setProfitShare(double profitShare) {
			this.profitShare = profitShare;
		}

		@Override
	    public double calculateSalary() {
	        return dailyWage * workDays;
	    }

	    public double calculateTotalIncome(double companyRevenue) {
	        return calculateSalary() + (profitShare * companyRevenue / 100);
	    }

		@Override
		protected String getIdPrefix() {
			// TODO Auto-generated method stub
			 return "DIR";
		}

		@Override
		public String toString() {
		    return String.format(
		        "Director Information:\n" +
		        "Employee ID      : %s\n" +
		        "Name             : %s\n" +
		        "Phone Number     : %s\n" +
		        "Work Days        : %d\n" +
		        "Daily Wage       : %.2f\n" +
		        "Profit Share     : %.2f%%\n",
		        empId, 
		        name, 
		        phoneNumber, 
		        workDays, 
		        dailyWage, 
		        profitShare
		    );
		}

}

