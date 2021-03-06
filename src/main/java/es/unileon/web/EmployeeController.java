package es.unileon.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.service.ModifyOfficeManager;
import es.unileon.service.OfficeManager;;

@Controller
public class EmployeeController {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private ModifyOfficeManager modifyOfficeOperations;

    @RequestMapping(value="/hello.htm")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	String now = (new Date()).toString();
        logger.info("Returning hello view with " + now);

        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        myModel.put("allEmployees", this.modifyOfficeOperations.getAllEmployees());

        return new ModelAndView("hello", "model", myModel);
    }


    public void setEmployeeManager(ModifyOfficeManager modifyOfficeOperations) {
        this.modifyOfficeOperations = modifyOfficeOperations;
    }
}