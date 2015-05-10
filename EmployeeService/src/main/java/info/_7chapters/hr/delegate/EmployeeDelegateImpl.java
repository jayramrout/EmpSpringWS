package info._7chapters.hr.delegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import info._7chapters.hr.mapper.EmployeeMapper;

import javax.annotation.Resource;

@Component
public class EmployeeDelegateImpl implements EmployeeDelegate {

	@Resource
	EmployeeMapper employeeDao;
	
	@Override
	public void getEmployeeDetails(int id) {
		System.out.println("EmployeeDelegateImpl.getEmployeeDetails()******************");
		System.out.println("EmployeeDelegateImpl.getEmployeeDetails()" + employeeDao.getEmployeeDetails(id));
	}
}
