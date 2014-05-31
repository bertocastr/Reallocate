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

    @Transactional(readOnly = false)
	public void saveEmployee(Employee employee) {
		em.merge(employee);
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {
		return em.createQuery("select e from Employee e order by e.office_idoffice").getResultList();
	}
	
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Office> getOffices() {
		// TODO Auto-generated method stub
		return em.createQuery("select o from Office o order by o.idOffice").getResultList();
	}

}