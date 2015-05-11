package into._7chapters.hr.test;

import info._7chapters.hr.domain.Employee;
import info._7chapters.hr.mapper.EmployeeMapper;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import javax.annotation.Resource;

/**
 * Created by Jayram on 5/10/2015.
 */
@ContextConfiguration("classpath:employee-dao-context.xml")
public class EmployeeTest extends AbstractJUnit4SpringContextTests {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeTest.class);

    @Resource
    EmployeeMapper employeeMapper;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testGetEmployeeDetails() {
        Employee employee = employeeMapper.getEmployeeDetails(100);
        LOGGER.info("Employee Details : First Name is " + employee.getFirstName());
    }
}
