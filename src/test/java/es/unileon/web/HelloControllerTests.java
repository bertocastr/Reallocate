package es.unileon.web;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.web.EmployeeController;


public class HelloControllerTests {

    @Test
    public void testHandleRequestView() throws Exception{		
        EmployeeController controller = new EmployeeController();
        ModelAndView modelAndView = controller.handleRequest(null, null);		
        assertEquals("hello", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        String nowValue = (String) modelAndView.getModel().get("now");
        assertNotNull(nowValue);

    }

}