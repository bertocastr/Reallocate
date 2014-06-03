package es.unileon.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.unileon.domain.Bank;
import es.unileon.domain.Employee;
import es.unileon.domain.Office;
import es.unileon.handler.DNIHandler;
import es.unileon.handler.Handler;
import es.unileon.handler.OfficeHandler;
import es.unileon.repository.OfficeManagerDAO;
import es.unlieon.repository.InMemoryOfficeManagerDAO;

public class ModifyOfficeManagerTest {
	
	ModifyOfficeManager operations;
	Employee Juan;
	Employee Pepe;
	Employee Maria;
	Handler dni;
	Handler anotherDNI;
	Handler mariaDNI;
	Handler EncinaId;
	Handler LeonId;
	Office Encina;
	Office Leon;
	Bank bank;
	float salary;
	private List<Employee> employees;
	private List<Office> offices;
	
	@Before
	public void setUp() throws Exception {
		employees = new ArrayList<Employee>();
		offices = new ArrayList<Office>();
		
		operations = new ModifyOfficeManager();
		salary = 5000;

		bank = new Bank("0000");

		dni = new DNIHandler("71463395A");
		anotherDNI = new DNIHandler("36167364W");
		mariaDNI = new DNIHandler("10059705B");

		EncinaId = new OfficeHandler(1234);
		LeonId = new OfficeHandler(9876);

		Encina = new Office("Encina", "Paseo San Antonio", 987400001, 24401,
				"1234");
		Leon = new Office("Leon", "Plaza Espolon", 987402051, 24007, "9876");

		Juan = new Employee("name", "surname", "address", salary, Encina.getIdOffice(), "71463395A");
		Pepe = new Employee("name2", "surname2", "address2", salary, Leon.getIdOffice(),
				"36167364W");
		Maria = new Employee("maria", "castro", "Calle bosco", salary, Encina.getIdOffice(), "10059705B");
		
		offices.add(Encina);
		offices.add(Leon);
		
		employees.add(Pepe);
		employees.add(Juan);
		employees.add(Maria);
		
		OfficeManagerDAO officeManagerDao = new InMemoryOfficeManagerDAO(employees, offices);
		operations.setOfficeManagerDAO(officeManagerDao);
	}

	@Test
	public void testGetAllEmployees() {
		assertEquals(operations.getAllEmployees().size(), 3);
	}

	@Test
	public void testGetOffices() {
		assertEquals(operations.getOffices().size(), 2);
	}

	@Test
	public void testReallocate() {
		String expectedIdOffice="";
		operations.reallocate(Pepe.getIdemployee(), Encina.getIdOffice());
		List<Employee> employee = operations.getAllEmployees();
		for(int i = 0; i<employee.size(); i++){
			if(employee.get(i).getIdemployee().compareTo(Pepe.getIdemployee())==0){
				expectedIdOffice = employee.get(i).getIdOffice();
			}
		}
		assertTrue(expectedIdOffice.compareTo(Encina.getIdOffice())==0);
	}

}
