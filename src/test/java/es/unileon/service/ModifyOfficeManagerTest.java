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
	
	@Before
	public void setUp() throws Exception {
		operations = new ModifyOfficeManager();
		salary = 5000;

		bank = new Bank();

		dni = new DNIHandler("71463395A");
		anotherDNI = new DNIHandler("36167364W");
		mariaDNI = new DNIHandler("10059705B");

		EncinaId = new OfficeHandler(1234);
		LeonId = new OfficeHandler(9876);

		Encina = new Office("Encina", "Paseo San Antonio", 987400001, 24401,
				"1234");
		Leon = new Office("Leon", "Plaza Espolon", 987402051, 24007, "9876");

		Juan = new Employee("name", "surname", "address", salary, Encina, "71463395A");
		Pepe = new Employee("name2", "surname2", "address2", salary, Leon,
				"36167364W");
		Maria = new Employee("maria", "castro", "Calle bosco", salary, Encina, "10059705B");

		Encina.add(Juan);
		Encina.add(Maria);
		
		Leon.add(Pepe);

		bank.addOffice(Encina);
		bank.addOffice(Leon);
		
		bank.getAllEmployees();
		
		operations.setListOfOffice(bank.getListOfOffice());
	}

	@Test
	public void testGetAllEmployees() {
		assertEquals(operations.getAllEmployees().size(), 3);
	}

	@Test
	public void testGetOffices() {
		List<Office> listOfOffice = new ArrayList<Office>();
		listOfOffice.add(Encina);
		operations.setListOfOffice(listOfOffice);
		assertEquals(operations.getOffices().size(), 1);
	}

	@Test
	public void testReallocate() {
		assertTrue(Pepe.getOffice().getId().compareTo(LeonId)==0);
		assertTrue(Leon.seek(Pepe));
		
		Pepe.reallocateEmployee(Encina);
		
		assertTrue(Pepe.getOffice().getId().compareTo(EncinaId)==0);
		assertTrue(Encina.seek(Pepe));
		
		assertFalse(Pepe.getOffice().getId().compareTo(LeonId)==0);
		assertFalse(Leon.seek(Pepe));
	}

}
