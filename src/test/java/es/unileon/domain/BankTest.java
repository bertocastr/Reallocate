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

		bank = new Bank("0000");
	}

	@Test
	public void testGetBank() {
		assertEquals("0000", bank.getIdBank());
		Office newOffice = new Office("Plaza", "Calle larga", 987541028, 24007, "4560");
		bank.setIdBank("0123");
		assertEquals("0123", bank.getIdBank());
	}

}
