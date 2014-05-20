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
	Handler CalleId;
	Office Encina;
	Office Leon;
	Bank bank;
	float salary;

	@Before
	public void setUp() throws MalformedHandlerException {
		salary = 5000;

		bank = new Bank();

		dni = new DNIHandler("71463395A");
		anotherDNI = new DNIHandler("36167364W");

		EncinaId = new OfficeHandler(1234);
		LeonId = new OfficeHandler(9876);
		CalleId = new OfficeHandler(4560);

		Encina = new Office("Encina", "Paseo San Antonio", 987400001, 24401,
				"1234");
		Leon = new Office("Leon", "Plaza Espolon", 987402051, 24007, "9876");

		Juan = new Employee("name", "surname", "address", salary, Encina, "71463395A");
		Pepe = new Employee("name2", "surname2", "address2", salary, Leon,
				"36167364W");

		Encina.add(Juan);

		Leon.add(Pepe);

		bank.addOffice(Encina);
		bank.addOffice(Leon);
	}

	@Test
	public void testAddOffice() {
		assertEquals(2, bank.getListOfOffice().size());
		Office newOffice = new Office("Plaza", "Calle larga", 987541028, 24007, "4560");
		bank.addOffice(newOffice);
		assertEquals(3, bank.getListOfOffice().size());
	}

	@Test
	public void testFoundOffice() {
		assertTrue(bank.seekOffice(EncinaId));
	}
	
	@Test
	public void testNotFoundOffice(){
		assertFalse(bank.seekOffice(dni));
	}
	
	

}
