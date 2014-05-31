package es.unileon.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import es.unileon.handler.*;
import es.unileon.domain.Employee;

@Entity
@Table(name="office")
public class Office implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
    @Column(name = "idOffice")
	
	private String idOffice;
	


	private String name, street;
    private int zip, phone;
//    private List<Employee> listOfEmployees;
    
  
	public void setListOfEmployees(List<Employee> listOfEmployees) {
//		this.listOfEmployees = listOfEmployees;
	}
	
	public Office(){
		
	}

	public Office (String name, String street, int phone, int zip, String idOffice){
    	this.name = name;
    	this.street = street;
    	this.phone = phone;
    	this.zip = zip;
    	Handler id = new OfficeHandler(idOffice);
    	this.idOffice = idOffice;
//    	this.listOfEmployees = new ArrayList<Employee>();
    }

    public String getIdOffice() {
		return idOffice;
	}

	public void setIdOffice(String idOffice) {
		this.idOffice = idOffice;
	}

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getStreet() {
		return street;
	}



	public void setStreet(String street) {
		this.street = street;
	}



	public int getZip() {
		return zip;
	}



	public void setZip(int zip) {
		this.zip = zip;
	}



	public double getPhone() {
		return phone;
	}


	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Name: " + name + ";");
        buffer.append("Street: " + street +";");
        buffer.append("Zip" + zip + ";");
        buffer.append("Phone" + phone);
        return buffer.toString();
    }
	
	public void add(Employee employee ){
//		if(! listOfEmployees.contains(employee))
//			listOfEmployees.add(employee);		
	}
	
	//TODO CREAR SEEKEMPLOYEE
	public boolean seek(Employee employee){
//		boolean found = false;
//		int cont = 0;
//		while(cont<this.listOfEmployees.size() && !found){
//			if(this.listOfEmployees.get(cont).getIdemployee().compareTo(employee.getIdemployee())==0)
//				found=true;
//			cont++;
//		}
//		return found;
		return false;
	}
	//TODO HACER REFACTOR A TODOOOOOOOOSSSSS LOS NOMBRES
	public boolean removeEmployee(Employee employee){
		int count=0;
		boolean remove = false;
//		while(!remove &&count<this.listOfEmployees.size()){
//			if(this.listOfEmployees.get(count).getIdemployee().compareTo(employee.getIdemployee())==0){
//				this.listOfEmployees.remove(count);
//				remove=true;
//			}
//			count++;
//		}
		return remove;
	}
	
	public List<Employee> getListOfEmployees(){
		//TODO devolver una copia
		List<Employee> copyOfList = null;
//		= new ArrayList<Employee>(this.listOfEmployees);
		return copyOfList;
	}
	

}
