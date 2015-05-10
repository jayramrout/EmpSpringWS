package info._7chapters.hr.mapper;

import info._7chapters.hr.domain.Employee;
import org.springframework.stereotype.Component;

@Component
public interface EmployeeMapper {
	Employee getEmployeeDetails(int id);
}
