package es.unileon.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import es.unileon.handler.*;
import es.unileon.domain.Employee;

public class Office implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private final Handler id;


	private String name, street;
    private int zip, phone;
    private List<Employee> listOfEmployees;
    

	public Office (String name, String street, int phone, int zip, Handler id){
    	this.name = name;
    	this.street = street;
    	this.phone = phone;
    	this.zip = zip;
    	this.id = id;
    	listOfEmployees = new ArrayList<Employee>();
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

	
    public List<Employee> getListOfEmployees() {
		return listOfEmployees;
	}


	public void setListOfEmployees(List<Employee> listOfEmployees) {
		this.listOfEmployees = listOfEmployees;
	}
	
    public Handler getId() {
		return id;
	}

	
	
	public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Name: " + name + ";");
        buffer.append("Street: " + street +";");
        buffer.append("Zip" + zip + ";");
        buffer.append("Phone" + phone);
        return buffer.toString();
    }
	
	public void addEmployee(Employee employee ){
		
		if(! listOfEmployees.contains(employee))
			listOfEmployees.add(employee);
		
	}
	
	

}
