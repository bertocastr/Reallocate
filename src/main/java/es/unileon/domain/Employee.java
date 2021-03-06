package es.unileon.domain;

import es.unileon.handler.DNIHandler;
import es.unileon.handler.Handler;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author dorian
 */
@Entity
@Table(name="employee") 
public class Employee {

	private static final long serialVersionUID = 1L;

	/**
	 * Name of the employee
	 */
	private String name;
	/**
	 * Surname of the employee
	 */
	private String surname;
	/**
	 * Surname of the employee
	 */
	private String address;
	/**
	 * Salary of the employee
	 */
	private float salary;
	/**
	 * Office which belong
	 */
	private String office_idoffice;
	/**
	 * Identifier of the employee
	 */
	@Id
    @Column(name = "idemployee")
	private String idemployee;
	
	
	public Employee(){
		
	}

	/**
	 * Create a new employee with all data
	 * 
	 * @param name
	 *            his/her name
	 * @param surname
	 *            his/her surname
	 * @param idOffice
	 *            the office, can be null
	 * @param dniEmployee
	 *            the identifier of the employee
	 */
	public Employee(String name, String surname, String address, float salary,
			String idOffice, String dniEmployee) {
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.salary = salary;
		this.office_idoffice = idOffice;
		Handler idEmployee = new DNIHandler(dniEmployee);
		this.idemployee = dniEmployee;
	}

	/**
	 * Create a new employee without office
	 * 
	 * @param name
	 *            his/her name
	 * @param surname
	 *            his/her surname
	 * @param salary
	 *            his/her salary
	 * @param idEmployee
	 *            the identifier of the employee
	 */
	public Employee(String name, String surname, String address, float salary,
			String idEmployee) {
		this(name, surname, address, salary, null, idEmployee);
	}

	/**
	 * Get the identifier(NIF) of the employee
	 * 
	 * @return the employee's identifier
	 */
	public String getIdemployee() {
		return idemployee;
	}

	/**
	 * change the identifier(NIF) of the employee
	 * 
	 * @param name
	 *            the new identifier(NIF)
	 */
	public void setIdemployee(String idemployee) {
		this.idemployee = idemployee;
	}

	/**
	 * Get the name of the employee
	 * 
	 * @return the employee's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * change the name of the employee
	 * 
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		if (name != null) {
			if (name.length() > 0) {
				this.name = name;
			}
		}
	}

	/**
	 * Get the surname of the employee
	 * 
	 * @return the employee's surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Change the surname of the employee
	 * 
	 * @param surname
	 *            the new surname
	 */
	public void setSurname(String surname) {
		if (surname != null) {
			if (surname.length() > 0) {
				this.surname = surname;
			}
		}
	}

	/**
	 * Returns the address of the employee
	 * 
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address of the employee
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Get the salary of the employee
	 * 
	 * @return the employee's salary
	 */
	public float getSalary() {
		return salary;
	}

	/**
	 * Change the salary of the employee
	 * 
	 * @param salary
	 *            the new salary
	 */
	public void setSalary(float salary) {
		if (salary > 0) {
			this.salary = salary;
		}
	}

	/**
	 * Get the the office where the employee works
	 * 
	 * @return the office or null if not exists
	 */
	public String getIdOffice() {
		return office_idoffice;
	}

	/**
	 * Set the office
	 * 
	 * @param idOffice
	 */
	public void setIdOffice(String idOffice) {
		this.office_idoffice = idOffice;
	}

	/**
	 * Tell if this employee is an admin
	 * 
	 * @return true if is an admin
	 */
	public boolean isAdmin() {
		return false;
	}


}
