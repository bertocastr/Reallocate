package es.unileon.service;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.unileon.domain.Employee;
import es.unileon.handler.Handler;

public class ChangeOffice {
	/** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    
    private String idOffice;
    private String dniEmployee;

	public String getDniEmployee() {
		return dniEmployee;
	}

	public void setDniEmployee(String dniEmployee) {
		this.dniEmployee = dniEmployee;
	}

	public String getIdOffice() {
		return idOffice;
	}

	public void setIdOffice(String idOffice) {
		this.idOffice = idOffice;
	}
    
    
}
