package es.unileon.domain;

import es.unileon.domain.Employee;
import es.unileon.domain.Office;
import es.unileon.exceptions.MalformedHandlerException;
import es.unileon.handler.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 
 * @author dorian
 */
public class EmployeeTest {
	Employee oneEmployee;
	Employee anotherEmployee;
	Handler dni;
	Handler anotherDNI;
	Handler oneIdOffice;
	Handler anotherIdOffice;
	Office oneOffice;
	Office anotherOffice;
	float salary;
        
	@Before
	public void setUp() throws MalformedHandlerException{
		salary = 5000;
		
		dni = new DNIHandler("71463395A");
		anotherDNI = new DNIHandler("36167364W");

		oneIdOffice = new OfficeHandler(1234);
		anotherIdOffice = new OfficeHandler(9876);

		oneOffice = new Office("Encina", "Paseo San Antonio", 987400001, 24401, "1234");
		anotherOffice = new Office("Leon", "Plaza Espolol", 987402051, 24007, "9876");

		oneEmployee = new Employee("name", "surname", "address", salary,
				oneOffice.getIdOffice(), "71463395A");
		anotherEmployee = new Employee("name2", "surname2", "address2", salary,
				anotherOffice.getIdOffice(), "36167364W");
	}

	/**
	 * Test of getName method, of class Employee.
	 */
	@Test
	public void testGetName() {
		String expResult = "name";
		String result = oneEmployee.getName();
		assertEquals(expResult, result);

		expResult = "name2";
		result = anotherEmployee.getName();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setName method, of class Employee.
	 */
	@Test
	public void testSetName() {
		String name = "nameChanged";
		oneEmployee.setName(name);

		assertEquals(name, oneEmployee.getName());
	}

	/**
	 * Test of getSursursurname method, of class Employee.
	 */
	@Test
	public void testGetSurname() {
		String expResult = "surname";
		String result = oneEmployee.getSurname();
		assertEquals(expResult, result);

		expResult = "surname2";
		result = anotherEmployee.getSurname();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setSursurname method, of class Employee.
	 */
	@Test
	public void testSetSurname() {
		String surname = "surnameChanged";
		oneEmployee.setSurname(surname);

		assertEquals(surname, oneEmployee.getSurname());
	}

	/**
	 * Test of getIdOffice method, of class Employee.
	 */
	@Test
	public void testGetIdOffice() {
		assertEquals("9876", this.anotherEmployee.getIdOffice());
		this.anotherEmployee.setIdOffice("0123");
		assertEquals("0123", this.anotherEmployee.getIdOffice());
	}
	
	/**
	 * Test of getIdEmployee method, of class Employee.
	 */
	@Test
	public void testGetIdEmployee() {
		Handler expResult = dni;
		Handler result = new DNIHandler(oneEmployee.getIdemployee());

		assertTrue(expResult.compareTo(result)==0);

		expResult = anotherDNI;
		result = new DNIHandler(anotherEmployee.getIdemployee());
		assertTrue(expResult.compareTo(result)==0);
	}

	/**
	 * Test of setIdEmployee method, of class Employee.
	 */
	@Test
	public void testSetIdEmployee() throws MalformedHandlerException {
		Handler idEmployee = new DNIHandler("71517234E");
		oneEmployee.setIdemployee(idEmployee.toString().trim());

		Handler result = new DNIHandler(oneEmployee.getIdemployee());
		
		assertEquals(idEmployee.toString(), result.toString());
	}

	/**
	 * Test to set an invalid surname, surname must not be changed
	 */
	@Test
	public void testSetNullName() {
		String name = null;
		oneEmployee.setName(name);

		assertEquals("name", oneEmployee.getName());

		name = "";
		oneEmployee.setName(name);

		assertEquals("name", oneEmployee.getName());
	}

	/**
	 * Test to set an invalid surname, surname must not be changed
	 */
	@Test
	public void testSetNullSurname() {
		String surname = null;
		oneEmployee.setName(surname);

		assertEquals("surname", oneEmployee.getSurname());

		surname = "";
		oneEmployee.setSurname(surname);

		assertEquals("surname", oneEmployee.getSurname());
	}


	/**
	 * Test the method getSalary()
	 */
	@Test
	public void testGetSalary() {
		assertEquals(5000, oneEmployee.getSalary(), 0);
	}

	/**
	 * Test the set salary a negative salary is not acepted
	 */
	@Test
	public void testSetSalary() {
		float newSalary = 3000;
		float badSalary = -1000;
		assertEquals(5000, oneEmployee.getSalary(), 0);
		oneEmployee.setSalary(newSalary);
		assertEquals(newSalary, oneEmployee.getSalary(), 0);
		oneEmployee.setSalary(badSalary);
		assertEquals(newSalary, oneEmployee.getSalary(), 0);
	}

	/**
	 * Test the method getAddress()
	 */
	@Test
	public void testGetAddress() {
		assertEquals("address", oneEmployee.getAddress());
	}

	/**
	 * Test the method setAddress()
	 */
	@Test
	public void testSetAddress() {
		String address = "3th avenue";
		oneEmployee.setAddress(address);
		assertEquals(oneEmployee.getAddress(), address);
	}

}
