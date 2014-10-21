package info._7chapters.hr.ws.log;

import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.EndpointInterceptor;

public class EmployeePayLoadLogging implements EndpointInterceptor {

	@Override
	public boolean handleRequest(MessageContext messageContext, Object endpoint)
			throws Exception {
		System.out.println("EmployeePayLoadLogging.handleRequest()");
		System.out.println("messageContext : "+ messageContext.getRequest().getPayloadSource().toString());
		System.out.println("EndPoint : "+ endpoint);
		return true;
	}

	@Override
	public boolean handleResponse(MessageContext messageContext, Object endpoint)
			throws Exception {
		System.out.println("EmployeePayLoadLogging.handleResponse()");
		return false;
	}

	@Override
	public boolean handleFault(MessageContext messageContext, Object endpoint)
			throws Exception {
		System.out.println("EmployeePayLoadLogging.handleFault()");
		return false;
	}

	@Override
	public void afterCompletion(MessageContext messageContext, Object endpoint,
			Exception ex) throws Exception {
		// TODO Auto-generated method stub

	}

}
