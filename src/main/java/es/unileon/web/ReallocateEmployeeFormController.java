package es.unileon.web;

import org.springframework.beans.factory.annotation.Autowired;

import es.unileon.exceptions.*;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.unileon.domain.Employee;
import es.unileon.domain.Office;
import es.unileon.handler.DNIHandler;
import es.unileon.handler.Handler;
import es.unileon.handler.OfficeHandler;
import es.unileon.service.OfficeManager;
import es.unileon.service.ChangeOffice;;

@Controller
@RequestMapping(value="/reallocateEmployee.htm")
public class ReallocateEmployeeFormController {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private OfficeManager officeOperations;

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@Valid ChangeOffice changeOffice, BindingResult result) 
    {
        if (result.hasErrors()) {
            return "reallocateEmployee";
        }
        String idOffice = changeOffice.getIdOffice();
        String dniEmployee = changeOffice.getDniEmployee();
        
        Handler idOfficeHandler = new OfficeHandler(idOffice);
        Handler dniEmployeeHandler = new DNIHandler(dniEmployee);
        
        logger.info("Change "+dniEmployee+" to the office " + idOffice);
        
        officeOperations.reallocate(dniEmployeeHandler, idOfficeHandler);
        
        return "redirect:/hello.htm";
    }

    @RequestMapping(method = RequestMethod.GET)
    protected ChangeOffice formBackingObject(HttpServletRequest request) throws ServletException {
    	ChangeOffice changeOffice = new ChangeOffice();
        String idOffice = request.getParameter("id2");
        String dniEmployee = request.getParameter("id1");

        changeOffice.setIdOffice(idOffice);
        changeOffice.setDniEmployee(dniEmployee);
        return changeOffice;
    }

    public void setOfficeOperations(OfficeManager officeOperations) {
        this.officeOperations = officeOperations;
    }

    public OfficeManager getOfficeOperations() {
        return officeOperations;
    }

}
