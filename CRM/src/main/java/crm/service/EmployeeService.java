package crm.service;

import crm.entity.EmployeeEntity;
import crm.repository.EmployeeRepository;
import crm.utils.MD5;

public class EmployeeService {
	private EmployeeRepository emr=new EmployeeRepository();
	public EmployeeEntity getAccount(String email, String password) {
		String hashpassword=MD5.getMd5(password);
		return emr.getAccount(email, hashpassword);
	}
}
