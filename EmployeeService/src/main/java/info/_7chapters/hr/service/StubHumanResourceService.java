package info._7chapters.hr.service;

import info._7chapters.hr.delegate.EmployeeDelegate;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StubHumanResourceService implements HumanResourceService {
	
	@Autowired
	EmployeeDelegate employeeDelegate;
	
    public void bookHoliday(Date startDate, Date endDate, String name) {
        System.out.println("Booking holiday for [" + startDate + "-" + endDate + "] for [" + name + "] ");
        employeeDelegate.getEmployeeDetails(100);
    }
}