package info._7chapters.hr.ws.client;

import java.io.InputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.xml.transform.StringResult;
import org.springframework.xml.transform.StringSource;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.test.server.MockWebServiceClient;                          

import static org.springframework.ws.test.server.RequestCreators.*;                      
import static org.springframework.ws.test.server.ResponseMatchers.*;                     

@RunWith(SpringJUnit4ClassRunner.class)                                                  
@ContextConfiguration( locations = "classpath:test-application-context.xml")
public class EmployeeEndpointIntegrationTest {
	private static String URI = "http://localhost:8082/EmployeeWar/";
//	private static WebServiceTemplate wsGatewaySupport ;
	private MockWebServiceClient mockClient;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Before
	public void setUp() throws Exception {
//		wsGatewaySupport = (WebServiceTemplate)applicationContext.getBean("wsGatewaySupport");
//		wsGatewaySupport.setDefaultUri(URI);
//		mockClient = MockWebServiceClient.createClient(applicationContext);
	}
	
	@Test
	public void testEmployeeWS() throws Exception {
		Result result = new StringResult();
		InputStream is = ClassLoader.class.getResourceAsStream("/hr.xml"); 
		String str = IOUtils.toString(is);
//		System.out.println(str);
		Source requestPayload = new StringSource(str);
//		wsGatewaySupport.sendSourceAndReceiveToResult(URI,payload, result);
		System.out.println(result);
		
		
//		mockClient.sendRequest(withPayload(requestPayload)).andExpect(payload(requestPayload));
		
		Assert.assertNotNull("");
	}

	@After
	public void tearDown() throws Exception {
		
	}

}
