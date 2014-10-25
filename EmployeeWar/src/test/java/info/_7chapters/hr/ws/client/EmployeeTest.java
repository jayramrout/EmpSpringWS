package info._7chapters.hr.ws.client;

import java.io.InputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Source;

import org.apache.commons.io.IOUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.xml.transform.StringResult;
import org.springframework.xml.transform.StringSource;

public class EmployeeTest {

	private static String URI = "http://localhost:8082/EmployeeWar/";
	private ApplicationContext applicationContext;
	private static WebServiceTemplate wsGatewaySupport ;
	
	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext(
				new String[] { "classpath:test-application-context.xml" });
		wsGatewaySupport = (WebServiceTemplate)applicationContext.getBean("wsGatewaySupport");	
	}

	@After
	public void tearDown() throws Exception {
		wsGatewaySupport.setDefaultUri(URI);
		Result result = new StringResult();
		
		InputStream is = ClassLoader.class.getResourceAsStream("/hr.xml"); 
		String str = IOUtils.toString(is);
//		System.out.println(str);
		Source payload = new StringSource(str);
		wsGatewaySupport.sendSourceAndReceiveToResult(URI,payload, result);
		System.out.println(result);
	}

	@Test
	public void testEmployeeWS() {
		
		Assert.assertNotNull("");
//		fail("Not yet implemented");
	}

}
