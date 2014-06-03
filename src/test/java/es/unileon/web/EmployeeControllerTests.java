package es.unileon.web;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Map;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.domain.Employee;
import es.unileon.domain.Office;
import es.unileon.service.ModifyOfficeManager;
import es.unileon.web.EmployeeController;
import es.unlieon.repository.InMemoryOfficeManagerDAO;


public class EmployeeControllerTests {

    @Test 
    public void testHandleRequestView() throws Exception{		
        EmployeeController controller = new EmployeeController();
        ModifyOfficeManager mom = new ModifyOfficeManager();
        mom.setOfficeManagerDAO(new InMemoryOfficeManagerDAO(new ArrayList<Employee>(), new ArrayList<Office>()));
        controller.setEmployeeManager(mom);
        ModelAndView modelAndView = controller.handleRequest(null, null);		
        assertEquals("hello", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        @SuppressWarnings("unchecked")
        Map<String, Object> modelMap = (Map<String, Object>) modelAndView.getModel().get("model");
        String nowValue = (String) modelMap.get("now");
        assertNotNull(nowValue);

    }

}