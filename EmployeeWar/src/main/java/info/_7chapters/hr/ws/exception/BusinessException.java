package info._7chapters.hr.ws.exception;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.SERVER)
public class BusinessException extends Exception {
	
	public BusinessException(String message) {
		super(message);
	}
}
