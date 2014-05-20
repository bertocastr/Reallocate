package es.unileon.service;

import java.util.ArrayList;
import java.util.List;

import es.unileon.domain.Employee;
import es.unileon.domain.Office;
import es.unileon.domain.Bank;
import es.unileon.handler.DNIHandler;
import es.unileon.handler.Handler;
import es.unileon.handler.OfficeHandler;

public class ModifyOfficeManager implements OfficeManager {

	private static final long serialVersionUID = 1L;

	//private List<Employee> listOfEmployees;
	private List<Office> listOfOffice;
	

	/**
	 * @return the list of the employees
	 */
	public List<Employee> getAllEmployees() {
		int count = 0;
		int countEmployee = 0;
		List<Employee> listOfEmployees = new ArrayList<Employee>();
		
		while(count<listOfOffice.size()){
			countEmployee = 0;
			while(countEmployee<listOfOffice.get(count).getListOfEmployees().size()){
				listOfEmployees.add(listOfOffice.get(count).getListOfEmployees().get(countEmployee));
				countEmployee++;
			}
			count++;
		}
		return listOfEmployees;
	}

	public List<Office> getOffices() {
		return listOfOffice;
	}

	public void setListOfOffice(List<Office> listOfOffice) {
		this.listOfOffice = listOfOffice;
	}

	
	/**
	 * Modifiy the office of the employee.
	 * 
	 * @param employee
	 *            Employee to reallocate
	 * @param idNewOffice
	 */
	public void reallocate(Handler dniEmployee, Handler idNewOffice) {
		int count = 0;
		boolean found = false;
		Office office = null;
		Employee employee = null;
		while(!found && count<this.getAllEmployees().size()){
			if(this.getAllEmployees().get(count).getIdEmployee().compareTo(dniEmployee)==0){
				employee = this.getAllEmployees().get(count);
				found=true;
			}
			count++;
		}
		
		count=0;
		found=false;
		while(!found && count<this.listOfOffice.size()){
			if(this.listOfOffice.get(count).getId().compareTo(idNewOffice)==0){
				found=true;
				office = this.listOfOffice.get(count);
			}
			count++;
		}
		
		employee.reallocateEmployee(office);
	}
	
	

}