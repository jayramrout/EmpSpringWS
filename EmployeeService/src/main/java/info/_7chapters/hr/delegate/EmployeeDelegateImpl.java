package info._7chapters.hr.delegate;

import info._7chapters.hr.dao.EmployeeDAO;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class EmployeeDelegateImpl implements EmployeeDelegate {

	@Autowired
	EmployeeDAO employeeDao;
	
	@Override
	public void getEmployeeDetails(int id) {
		System.out.println("EmployeeDelegateImpl.getEmployeeDetails()******************");
		System.out.println("EmployeeDelegateImpl.getEmployeeDetails()" + employeeDao.getEmployeeDetails(id));
	}
}
