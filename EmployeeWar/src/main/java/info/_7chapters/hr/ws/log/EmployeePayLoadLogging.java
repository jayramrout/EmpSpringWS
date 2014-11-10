package info._7chapters.hr.ws.log;

import org.apache.log4j.Logger;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.EndpointInterceptor;

public class EmployeePayLoadLogging implements EndpointInterceptor {
	private static Logger logger = Logger.getLogger(EmployeePayLoadLogging.class);
	
	@Override
	public boolean handleRequest(MessageContext messageContext, Object endpoint)
			throws Exception {
		logger.debug("EmployeePayLoadLogging.handleRequest()");
		logger.debug("messageContext : "+ messageContext.getRequest().getPayloadSource().toString());
		logger.debug("EndPoint : "+ endpoint);
		return true;
	}

	@Override
	public boolean handleResponse(MessageContext messageContext, Object endpoint)
			throws Exception {
		logger.debug("EmployeePayLoadLogging.handleResponse()");
		return false;
	}

	@Override
	public boolean handleFault(MessageContext messageContext, Object endpoint)
			throws Exception {
		logger.debug("EmployeePayLoadLogging.handleFault()");
		return false;
	}

	@Override
	public void afterCompletion(MessageContext messageContext, Object endpoint,
			Exception ex) throws Exception {
		logger.debug("EmployeePayLoadLogging.afterCompletion()");

	}

}
