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
		officeManagerDao = (OfficeManagerDAO) context.getBean("officeManagerDAO");
	}

	@Test
	public void testSaveEmployee() {
		List<Employee> employees = officeManagerDao.getAllEmployees();
		Employee e = employees.get(0);
		e.setIdOffice("1234");
		officeManagerDao.saveEmployee(e);
		
		List<Employee> updateEmployees = officeManagerDao.getAllEmployees();
		Employee updateE = updateEmployees.get(0);
		assertEquals(updateE.getIdOffice(), "1234");
		
		updateE.setIdOffice("1111");
		officeManagerDao.saveEmployee(e);
	}

	@Test
	public void testGetAllEmployees() {
		List<Employee> employees = officeManagerDao.getAllEmployees();
		assertEquals(employees.size(), 3, 0);
	}

	@Test
	public void testGetOffices() {
		List<Office> offices = officeManagerDao.getOffices();
		assertEquals(offices.size(), 2, 0);	
	}

	@Test
	public void testGetEmployee(){
		assertTrue(officeManagerDao.getEmployee("71517234E").getName().compareTo("Alberto")==0);
	}
}
