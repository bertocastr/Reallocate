package es.unileon.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



import es.unileon.handler.Handler;
import es.unileon.handler.OfficeHandler;

@Entity
@Table(name = "Bank")
public class Bank {
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "idBank")
	private String idBank;

//	private List<Office> listOfOffice;
//	private List<Employee> listAllEmployees;	
	public Bank(){
		
	}
	
	public Bank(String idBank){
		this.idBank = idBank;
	}
	
	public void addOffice(Office office){
//		Handler officeId = new OfficeHandler(office.getIdOffice());
//		if(!seekOffice(this.officeId))
//			this.listOfOffice.add(office);
	}
	
	public boolean seekOffice(Handler officeId){
		return false;
//		int count = 0;
//		boolean found = false;
//		while(count<this.listOfOffice.size() && this.listOfOffice.size()>1 && !found){
//			if(this.listOfOffice.get(count).getId().compareTo(officeId) == 0)
//				found = true;
//				
//			count++;
//		}
//		return found;
	}
	
	public List<Office> getListOfOffice() {
		return null;
//		return listOfOffice;
	}
	
	public void setListOfOffice(List<Office> listOfOffice) {
//		this.listOfOffice = listOfOffice;
	}

	public void setListAllEmployees(List<Employee> listAllEmployees) {
//		this.listAllEmployees = listAllEmployees;
	}

	public List<Employee> getListAllEmployees() {
		return null;
//		return listAllEmployees;
	}
	
	//TODO cambiar void por return list
	public void getAllEmployees(){
//		this.listAllEmployees = new ArrayList<Employee>();
//		
//		for(int i = 0; i<this.listOfOffice.size(); i++){
//			for(int j = 0; j<this.listOfOffice.get(i).getListOfEmployees().size(); j++){
//				this.listAllEmployees.add(this.listOfOffice.get(i).getListOfEmployees().get(j));
//			}
//		}
	}
	
}
