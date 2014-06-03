package es.unileon.service;

import java.io.Serializable;
import java.util.List;

import es.unileon.domain.Employee;
import es.unileon.domain.Office;
import es.unileon.handler.Handler;

public interface OfficeManager extends Serializable {

    public void reallocate(String employee, String idNewOffice);
    
    public List<Employee> getAllEmployees();
    
    public List<Office> getOffices();

}