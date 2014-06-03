package es.unileon.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.unileon.domain.Employee;
import es.unileon.domain.Office;
import es.unileon.handler.Handler;
import es.unileon.repository.OfficeManagerDAO;

@Repository(value = "officeManagerDAO")
public class JPAOfficeManagerDAO implements OfficeManagerDAO {

    private EntityManager em = null;
    /*
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    /**
     * Save the employee into the database.
     */
    @Transactional(readOnly = false)
	public void saveEmployee(Employee employee) {
		em.merge(employee);
	}

    /**
     * Get the list of the all employees.
     */
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {
		return em.createQuery("select e from Employee e order by e.office_idoffice").getResultList();
	}
	
	/**
	 * Get the list of the all offices.
	 */
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Office> getOffices() {
		return em.createQuery("select o from Office o order by o.idOffice").getResultList();
	}

	/**
	 * Get the employee who have this NIF.
	 */
	@Transactional(readOnly = true)
	public Employee getEmployee(String dniEmployee) {
		dniEmployee = dniEmployee.trim();
		return (Employee) em.createQuery("select e from Employee e where e.idemployee='"+dniEmployee+"'").getResultList().get(0);
	}

}