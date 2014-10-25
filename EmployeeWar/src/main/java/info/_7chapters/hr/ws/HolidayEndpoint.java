package info._7chapters.hr.ws;

import info._7chapters.hr.schemas.HolidayRequest;
import info._7chapters.hr.service.HumanResourceService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jdom2.JDOMException;
//import org.jdom2.Namespace;
//import org.jdom2.filter.Filters;
import org.jdom2.xpath.XPathExpression;
//import org.jdom2.xpath.XPathFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
//import org.springframework.ws.server.endpoint.annotation.XPathParam;
import org.springframework.ws.soap.SoapHeader;
//import org.springframework.ws.transport.context.TransportContext;
//import org.springframework.ws.transport.context.TransportContextHolder;
//import org.springframework.ws.transport.http.HttpServletConnection;
//import javax.servlet.http.HttpServletRequest;
import org.jdom2.Element;

@Endpoint
public class HolidayEndpoint {
	private static final String NAMESPACE_URI = "http://_7chapters.info/hr/schemas";

/*    private XPathExpression<Element> startDateExpression;
    private XPathExpression<Element> endDateExpression;
    private XPathExpression<Element> firstNameExpression;
    private XPathExpression<Element> lastNameExpression;
*/    
	private HumanResourceService humanResourceService;
    
                                                                              
    @Autowired
    public HolidayEndpoint(HumanResourceService humanResourceService) throws JDOMException {
        this.humanResourceService = humanResourceService;

/*        Namespace namespace = Namespace.getNamespace("hr", NAMESPACE_URI);
        XPathFactory xPathFactory = XPathFactory.instance();
        startDateExpression = xPathFactory.compile("//hr:StartDate", Filters.element(), null, namespace);
        endDateExpression = xPathFactory.compile("//hr:EndDate", Filters.element(), null, namespace);
        firstNameExpression = xPathFactory.compile("//hr:FirstName", Filters.element(), null, namespace);
        lastNameExpression = xPathFactory.compile("//hr:LastName", Filters.element(), null, namespace);
*/    }

   /* @PayloadRoot(namespace = NAMESPACE_URI, localPart = "HolidayRequest")     
    public void handleHolidayRequest(@RequestPayload Element holidayRequest) throws Exception {                        
        Date startDate = parseDate(startDateExpression, holidayRequest);
        Date endDate = parseDate(endDateExpression, holidayRequest);
        String name = firstNameExpression.evaluateFirst(holidayRequest).getText() + " " + lastNameExpression.evaluateFirst(holidayRequest).getText();

        humanResourceService.bookHoliday(startDate, endDate, name);
        
        TransportContext context = TransportContextHolder.getTransportContext();
        HttpServletConnection connection = (HttpServletConnection )context.getConnection();
        HttpServletRequest request = connection.getHttpServletRequest();
        String ipAddress = request.getRemoteAddr();
        System.out.println("ipAddress "+ ipAddress);
    }*/
    
    
   /* @PayloadRoot(namespace = NAMESPACE_URI, localPart = "HolidayRequest")  
    @ResponsePayload
    public HolidayRequest handleHolidayRequestWithJAXB2(@RequestPayload HolidayRequest holidayRequest) throws Exception {                        
        System.out.println("holidayRequest.getEmployee().getFirstName() "+ holidayRequest.getEmployee().getFirstName());
        return holidayRequest;
    }*/

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "HolidayRequest")  
    public void handleHolidayRequestWithSoapHeader(@RequestPayload HolidayRequest holidayRequest , SoapHeader header) throws Exception {
    	System.out.println(header);
        System.out.println("holidayRequest.getEmployee().getFirstName() "+ holidayRequest.getEmployee().getFirstName());
        humanResourceService.bookHoliday(null, null, holidayRequest.getEmployee().getFirstName());
    }

    /**
     * handleHolidayRequestWithXPathParam Does not work..need to check
     * @param expression
     * @param element
     * @return
     * @throws ParseException
     */
    /*@PayloadRoot(namespace = NAMESPACE_URI, localPart = "HolidayRequest")  
    @org.springframework.ws.server.endpoint.annotation.Namespace(prefix="h" , uri=NAMESPACE_URI)
    public void handleHolidayRequestWithXPathParam(@XPathParam("/h:HolidayRequest/EmployeeType/@Number") BigInteger number) throws Exception {
    	System.out.println(number);
    }*/
    
    private Date parseDate(XPathExpression<Element> expression, Element element) throws ParseException {
        Element result = expression.evaluateFirst(element);
        if (result != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.parse(result.getText());
        } else {
            throw new IllegalArgumentException("Could not evaluate [" + expression + "] on [" + element + "]");
        }
    }
}
