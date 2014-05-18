package es.unileon.service;

import java.io.Serializable;
import java.util.List;

import es.unileon.domain.Employee;
import es.unileon.domain.Office;
import es.unileon.handler.Handler;

public interface OfficeOperations extends Serializable {

    public void modifyEmployee(Employee employee, Handler idNewOffice);
    
    public List<Employee> getEmployees();
    
    public List<Office> getOffices();

}