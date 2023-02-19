package com.employee.hibernateDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.beans.JavaBean;
import java.io.Serializable;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.model.Employee;

import hibernate.HibernateUtil;
import jakarta.persistence.Query;
//@Repository
public class EmployeeRepo implements EmployeeRepoI {
//	@Autowired
//	private SessionFactory sessionFactory;
//	SessionFactory factory=HibernateUtil.getSessionFactory();
	
//	public List<Employee> getAllEmployee() {
//		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//			return session.createQuery("from employee ", Employee.class).list();
//		}
//	}
//	
//	public void addEmployee(Employee employee) {
//	    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//	    Session session = sessionFactory.openSession();
//	    Transaction transaction = session.beginTransaction();
//	    session.save(employee);
//	    transaction.commit();
//	    session.close();
//	  }
//
//	  public Employee getEmployee(int id) {
//	    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//	    Session session = sessionFactory.openSession();
//	    Employee employee = session.get(Employee.class, id);
//	    session.close();
//	    return employee;
//	  }
//
//	  public void updateEmployee(Employee employee) {
//	    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//	    Session session = sessionFactory.openSession();
//	    Transaction transaction = session.beginTransaction();
//	    session.update(employee);
//	    transaction.commit();
//	    session.close();
//	  }
//
//	  public void deleteEmployee(int id) {
//	    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//	    Session session = sessionFactory.openSession(); 
//	    Transaction transaction = session.beginTransaction();
//	    Employee employee = session.get(Employee.class, id);
//	    session.delete(employee);
//	    transaction.commit();
//	    session.close();
//	  }
	  
	  
	@Override
	public Employee saveEmployee(Employee employee) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// operation 1
		      session.persist(employee);

			// operation 2
			session.get(Employee.class, (Serializable).oblx ;

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return employee;
	}

//	@Override
//	public void insertEmployee() {
//		Transaction transaction = null;
//		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//			// start a transaction
//			transaction = session.beginTransaction();
//
//			String hql = "INSERT INTO employee (department, first_name,last_name) "
//					+ "SELECT department, first_name, last_name FROM employee";
//			Query query = session.createQuery(hql);
//			int result = query.executeUpdate();
//			System.out.println("Rows affected: " + result);
//
//			// commit transaction
//			transaction.commit();
//		} catch (Exception e) {
//			if (transaction != null) {
//				transaction.rollback();
//			}
//			e.printStackTrace();
//		}
//	}

	@Override
	public void updateEmployee(Employee employee) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// save the student object
			String hql = "UPDATE employee set first_name = :first_name,last_name=:last_name,department=:department " + "WHERE id = :address_id";
			Query query = session.createQuery(hql);
			query.setParameter("first_name", employee.getFirstName());
			query.setParameter("last_name", employee.getLastName());
			query.setParameter("department", employee.getDepartment());
			query.setParameter("address_id", employee.getId());
			int result = query.executeUpdate();
			System.out.println("Rows affected: " + result);

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public Employee getEmployee(long id) {

		Transaction transaction = null;
		Employee employee = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// get an student object
			String hql = " FROM employee e WHERE e.address_id = :address_id";
			Query query = session.createQuery(hql);
			query.setParameter("address_id", id);
			List results = query.getResultList();

			if (results != null && !results.isEmpty()) {
				employee = (Employee) results.get(0);
			}
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public List<Employee> getAllEmployee() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from employee ", Employee.class).list();
		}
	}

	@Override
	public void deleteEmployee(long id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a student object
			Employee employee= session.get(Employee.class, id);
			if (employee != null) {
				String hql = "DELETE FROM employee " + "WHERE address_id = :id";
				@SuppressWarnings("deprecation")
				Query query = session.createQuery(hql);
				query.setParameter("address_id", id);
				int result = query.executeUpdate();
				System.out.println("Rows affected: " + result);
			}

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
}
