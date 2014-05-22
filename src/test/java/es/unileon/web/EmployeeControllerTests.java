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


	
    @Test 
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