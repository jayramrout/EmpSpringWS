package info._7chapters.hr.ws.client;

import info._7chapters.hr.schemas.EmployeeType;
import info._7chapters.hr.schemas.HolidayRequest;
import info._7chapters.hr.schemas.HolidayType;
import info._7chapters.hr.schemas.ObjectFactory;

import java.io.InputStream;
import java.math.BigInteger;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.transform.Result;
import javax.xml.transform.Source;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.xml.transform.StringResult;
import org.springframework.xml.transform.StringSource;

public class EmployeeTest {

	private static String URI = "http://localhost:8081/EmployeeWar/";
	private ApplicationContext applicationContext;
	private static WebServiceTemplate wsGatewaySupport ;
	
	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext(
				new String[] { "classpath:test-application-context.xml" });
		wsGatewaySupport = (WebServiceTemplate)applicationContext.getBean("wsGatewaySupport");	
	}
//	@Test
	public void testEmployeeWS() throws Exception {
		wsGatewaySupport.setDefaultUri(URI);
		Result result = new StringResult();
		
		InputStream is = ClassLoader.class.getResourceAsStream("/hr.xml"); 
		String str = IOUtils.toString(is);
//		System.out.println(str);
		Source payload = new StringSource(str);
		wsGatewaySupport.sendSourceAndReceiveToResult(URI,payload, result);
		System.out.println(result);		
		Assert.assertNotNull("");
//		fail("Not yet implemented");
	}
	
	@Test
	public void testWS() throws Exception {
		Result inputResult = new StringResult();
		JAXBContext jaxbContext = JAXBContext.newInstance(HolidayRequest.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.marshal(getHolidayRequest(), inputResult);
		System.out.println(inputResult);
		
		Result result = new StringResult();
		wsGatewaySupport.setDefaultUri(URI);
		Source payload = new StringSource(inputResult.toString());
		wsGatewaySupport.sendSourceAndReceiveToResult(URI,payload, result);
		System.out.println(result);
	}

	//	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public HolidayRequest getHolidayRequest() throws Exception {
		ObjectFactory factory = new ObjectFactory();
		EmployeeType employeeType = factory.createEmployeeType();
		employeeType.setNumber(new BigInteger("100"));
		employeeType.setFirstName("Jayram");
		employeeType.setLastName("Rout");
		
		HolidayType holidayType = factory.createHolidayType();
		GregorianCalendar gcal = new GregorianCalendar();
	      XMLGregorianCalendar xgcal = DatatypeFactory.newInstance()
	            .newXMLGregorianCalendar(gcal);
		holidayType.setStartDate(xgcal);
		holidayType.setEndDate(xgcal);
		
		
		HolidayRequest holidayRequest = factory.createHolidayRequest();
		holidayRequest.setEmployee(employeeType);
		holidayRequest.setHoliday(holidayType);
		return holidayRequest;
	}
}
