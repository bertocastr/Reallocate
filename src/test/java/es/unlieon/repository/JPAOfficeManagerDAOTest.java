package es.unlieon.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.unileon.domain.*;
import es.unileon.handler.DNIHandler;
import es.unileon.handler.Handler;
import es.unileon.handler.OfficeHandler;
import es.unileon.repository.OfficeManagerDAO;

public class JPAOfficeManagerDAOTest {

	private ApplicationContext context;
    private OfficeManagerDAO officeManagerDao;
    
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
		officeManagerDao = (OfficeManagerDAO) context.getBean("officeManagerDao");
	}

	@Test
	public void testReallocate() {
		Handler dniEmployee = new DNIHandler("71517234E");
		Handler idNewOffice = new OfficeHandler("1234");
		List<Employee> employees = officeManagerDao.getAllEmployees();
		assertEquals(employees.get(0).getIdemployee(), 0);
		assertEquals(employees.get(0).getOffice().getIdOffice(), 0);
		officeManagerDao.reallocate(dniEmployee, idNewOffice);
		assertEquals(employees.get(0).getIdemployee(), 0);
		assertEquals(employees.get(0).getOffice().getIdOffice(), 0);
	}

	@Test
	public void testGetAllEmployees() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOffices() {
		fail("Not yet implemented");
	}

}
