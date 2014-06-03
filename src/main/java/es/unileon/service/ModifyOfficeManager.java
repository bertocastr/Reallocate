package es.unileon.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.unileon.domain.Employee;
import es.unileon.domain.Office;
import es.unileon.domain.Bank;
import es.unileon.handler.DNIHandler;
import es.unileon.handler.Handler;
import es.unileon.handler.OfficeHandler;
import es.unileon.repository.OfficeManagerDAO;

public class ModifyOfficeManager implements OfficeManager {

	private static final long serialVersionUID = 1L;

	@Autowired
	private OfficeManagerDAO officeManagerDAO;

	public OfficeManagerDAO getOfficeManagerDAO() {
		return officeManagerDAO;
	}

	public void setOfficeManagerDAO(OfficeManagerDAO officeManagerDAO) {
		this.officeManagerDAO = officeManagerDAO;
	}

	/**
	 * @return the list of the employees
	 */
	public List<Employee> getAllEmployees() {
		return officeManagerDAO.getAllEmployees();
	}

	public List<Office> getOffices() {
		return officeManagerDAO.getOffices();
	}

	
	/**
	 * Modifiy the office of the employee.
	 * 
	 * @param employee
	 *            Employee to reallocate
	 * @param idNewOffice
	 */
	public void reallocate(String idEmployee, String idNewOffice) {
		Employee employee = officeManagerDAO.getEmployee(idEmployee);
		employee.setIdOffice(idNewOffice);
		officeManagerDAO.saveEmployee(employee);
	}	

}