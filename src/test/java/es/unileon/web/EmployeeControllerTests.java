package es.unileon.web;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.domain.Bank;
import es.unileon.domain.Employee;
import es.unileon.domain.Office;
import es.unileon.exceptions.MalformedHandlerException;
import es.unileon.handler.DNIHandler;
import es.unileon.handler.Handler;
import es.unileon.handler.OfficeHandler;
import es.unileon.service.ModifyOfficeManager;
import es.unileon.web.EmployeeController;


public class EmployeeControllerTests {

	Employee Juan;
	Employee Pepe;
	Handler dni;
	Handler anotherDNI;
	Handler EncinaId;
	Handler LeonId;
	Handler CalleId;
	Office Encina;
	Office Leon;
	Bank bank;
	float salary;

	@Before
	public void setUp() throws MalformedHandlerException {
		salary = 5000;

		bank = new Bank();

		dni = new DNIHandler("71463395A");
		anotherDNI = new DNIHandler("36167364W");

		EncinaId = new OfficeHandler(1234);
		LeonId = new OfficeHandler(9876);
		CalleId = new OfficeHandler(4560);

		Encina = new Office("Encina", "Paseo San Antonio", 987400001, 24401,
				"1234");
		Leon = new Office("Leon", "Plaza Espolon", 987402051, 24007, "9876");

		Juan = new Employee("name", "surname", "address", salary, Encina, "71463395A");
		Pepe = new Employee("name2", "surname2", "address2", salary, Leon,
				"36167364W");

		Encina.add(Juan);

		Leon.add(Pepe);

		bank.addOffice(Encina);
		bank.addOffice(Leon);
	}
	
    @Test (expected=NullPointerException.class)
    public void testHandleRequestView() throws Exception{		
        EmployeeController controller = new EmployeeController();
        controller.setEmployeeManager(new ModifyOfficeManager());
        ModelAndView modelAndView = controller.handleRequest(null, null);		
        assertEquals("hello", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        @SuppressWarnings("unchecked")
        Map<String, Object> modelMap = (Map<String, Object>) modelAndView.getModel().get("model");
        String nowValue = (String) modelMap.get("now");
        assertNotNull(nowValue);

    }

}