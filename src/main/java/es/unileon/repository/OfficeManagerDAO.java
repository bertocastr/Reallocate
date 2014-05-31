package es.unileon.repository;

import java.util.List;

import es.unileon.domain.Employee;
import es.unileon.domain.Office;
import es.unileon.handler.Handler;

public interface OfficeManagerDAO {

    public void saveEmployee(Employee employee);
    
    public List<Employee> getAllEmployees();
    
    public List<Office> getOffices();

}