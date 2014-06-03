package es.unlieon.repository;

import java.util.List;

import es.unileon.domain.Employee;
import es.unileon.domain.Office;
import es.unileon.repository.OfficeManagerDAO;

public class InMemoryOfficeManagerDAO implements OfficeManagerDAO{

	private List<Employee> employees;
	private List<Office> offices;
	
	
	public InMemoryOfficeManagerDAO(List<Employee> employees, List<Office> offices) {
		this.employees = employees;
		this.offices = offices;
	}
	
	
	public void saveEmployee(Employee employee) {
	}

	public List<Employee> getAllEmployees() {
		return employees;
	}

	public List<Office> getOffices() {
		return offices;
	}

	public Employee getEmployee(String dniEmployee) {
		Employee employee = null;
		boolean found = false;
		int count=0;
		while(!false && employees.size()>count){
			if(employees.get(count).getIdemployee().compareTo(dniEmployee)==0){
				employee = employees.get(count);
			}
			count++;
		}
		return employee;
	}

}
