package es.unileon.service;

import java.io.Serializable;
import java.util.List;

import es.unileon.domain.Employee;
import es.unileon.domain.Office;
import es.unileon.handler.Handler;
import es.unileon.repository.OfficeManagerDAO;

public interface OfficeManager extends Serializable {

    public void reallocate(String employee, String idNewOffice);
    
    public List<Employee> getAllEmployees();
    
    public List<Office> getOffices();
    
    public void setOfficeManagerDAO(OfficeManagerDAO officeManagerDAO);
    
    public OfficeManagerDAO getOfficeManagerDAO();

}