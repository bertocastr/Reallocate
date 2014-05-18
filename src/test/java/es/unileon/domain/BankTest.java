package es.unileon.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.unileon.exceptions.MalformedHandlerException;
import es.unileon.handler.DNIHandler;
import es.unileon.handler.Handler;
import es.unileon.handler.OfficeHandler;

public class BankTest {

	Employee Juan;
	Employee Pepe;
	Handler dni;
	Handler anotherDNI;
	Handler EncinaId;
	Handler LeonId;
	Office Encina;
	Office Leon;
	float salary;

	@Before
	public void setUp() throws MalformedHandlerException {
		salary = 5000;
		
		Bank bank = new Bank("Banco Alberto");
		
		bank.addOffice(Encina);
		bank.addOffice(Leon);
		
		Encina.addEmployee(Juan);
		
		Leon.addEmployee(Pepe);
		
		dni = new DNIHandler("71463395A");
		anotherDNI = new DNIHandler("36167364W");

		EncinaId = new OfficeHandler(1234);
		LeonId = new OfficeHandler(9876);

		Encina = new Office("Encina", "Paseo San Antonio", 987400001, 24401,
				EncinaId);
		Leon = new Office("Leon", "Plaza Espolol", 987402051, 24007,
				LeonId);

		Juan = new Employee("name", "surname", "address", salary,
				Encina, dni);
		Pepe = new Employee("name2", "surname2", "address2", salary,
				Leon, anotherDNI);
	}

	@Test
	public void testAddOffice() {
		fail("Not yet implemented");
	}

	@Test
	public void testSeekOffice() {
		fail("Not yet implemented");
	}

}
