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
	
	public Office(){
		
	}

	public Office (String name, String street, int phone, int zip, String idOffice){
    	this.name = name;
    	this.street = street;
    	this.phone = phone;
    	this.zip = zip;
    	Handler id = new OfficeHandler(idOffice);
    	this.idOffice = idOffice;
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

}
