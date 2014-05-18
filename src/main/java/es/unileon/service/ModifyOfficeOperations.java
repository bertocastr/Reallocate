package es.unileon.service;

import java.util.List;

import es.unileon.domain.Employee;
import es.unileon.domain.Office;
import es.unileon.domain.Bank;
import es.unileon.handler.Handler;

public class ModifyOfficeOperations implements OfficeOperations {

    private static final long serialVersionUID = 1L;
    
    private List<Employee> listOfEmployees;
    private List<Office> listOfOffice;
    private int positionEmployee;

	public void modifyEmployee(Employee employee, Handler idNewOffice ){
		this.positionEmployee = seekEmployee(employee);
		removeEmployee(positionEmployee);
		Office officeToModify = seekOffice(idNewOffice);
		if(!officeToModify.equals(null))
			officeToModify.getListOfEmployees().add(employee);
		
	}

	public List<Employee> getEmployees() {
		return listOfEmployees;
	}
	
	
	public void setListOfEmployees(List<Employee> listOfEmployees) {
		this.listOfEmployees = listOfEmployees;
	}
	
	public List<Office> getOffices() {
		return listOfOffice;
	}
	
	public void setListOfOffice(List<Office> listOfOffice) {
		this.listOfOffice = listOfOffice;
	}

	
	public int seekEmployee(Employee employee){
		boolean notFound = true;
		int count = 0;
		while(listOfEmployees.size()>count && notFound){
			if(listOfEmployees.get(count).getIdEmployee().equals(employee.getIdEmployee())){
				notFound=false;
			}
			count++;
		}
		return count;
	}
	
	public Office seekOffice(Handler officeId){
		int count = 0;
		Office office = null;
		while(count<this.listOfOffice.size() && this.listOfOffice.size()>1){
			if(this.listOfOffice.get(count).getId().equals(officeId))
				office = this.listOfOffice.get(count);
				
			count++;
		}
		return office;
	}

	public void removeEmployee(int positionEmployee){
		this.listOfEmployees.remove(positionEmployee);
	}


}