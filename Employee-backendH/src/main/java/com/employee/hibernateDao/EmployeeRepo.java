package com.employee.hibernateDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.beans.JavaBean;
import java.io.Serializable;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.employee.model.Employee;

import hibernate.HibernateUtil;
import jakarta.persistence.Query;
@Repository
public class EmployeeRepo {
	
	
	public List<Employee> getAllEmployee() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from employee ", Employee.class).list();
		}
	}
	
	public void addEmployee(Employee employee) {
	    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    Transaction transaction = session.beginTransaction();
	    session.save(employee);
	    transaction.commit();
	    session.close();
	  }

	  public Employee getEmployee(int id) {
	    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    Employee employee = session.get(Employee.class, id);
	    session.close();
	    return employee;
	  }

	  public void updateEmployee(Employee employee) {
	    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    Transaction transaction = session.beginTransaction();
	    session.update(employee);
	    transaction.commit();
	    session.close();
	  }

	  public void deleteEmployee(int id) {
	    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    Transaction transaction = session.beginTransaction();
	    Employee employee = session.get(Employee.class, id);
	    session.delete(employee);
	    transaction.commit();
	    session.close();
	  }
//
//	public void saveEmployee(Employee employee) {
//		Transaction transaction = null;
//		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//			// start a transaction
//			transaction = session.beginTransaction();
//
//			// operation 1
//			Object object = session.save(employee);
//
//			// operation 2
//			session.get(Employee.class, (Serializable) object);
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
//
//	public void insertEmployee() {
//		Transaction transaction = null;
//		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//			// start a transaction
//			transaction = session.beginTransaction();
//
//			String hql = "INSERT INTO Student (firstName, lastName, email) "
//					+ "SELECT firstName, lastName, email FROM Student";
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
//
//	public void updateEmployee(Employee employee) {
//		Transaction transaction = null;
//		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//			// start a transaction
//			transaction = session.beginTransaction();
//
//			// save the student object
//			String hql = "UPDATE Student set firstName = :firstName " + "WHERE id = :studentId";
//			Query query = session.createQuery(hql);
//			query.setParameter("firstName", employee.getFirstName());
//			query.setParameter("studentId", 1);
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
//
//	public void deleteEmployee(int id) {
//
//		Transaction transaction = null;
//		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//			// start a transaction
//			transaction = session.beginTransaction();
//
//			// Delete a student object
//			Employee employee= session.get(Employee.class, id);
//			if (employee != null) {
//				String hql = "DELETE FROM Student " + "WHERE id = :studentId";
//				Query query = session.createQuery(hql);
//				query.setParameter("studentId", id);
//				int result = query.executeUpdate();
//				System.out.println("Rows affected: " + result);
//			}
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
//
//	public Employee getEmployee(int id) {
//
//		Transaction transaction = null;
//		Employee employee = null;
//		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//			// start a transaction
//			transaction = session.beginTransaction();
//
//			// get an student object
//			String hql = " FROM Student S WHERE S.id = :studentId";
//			Query query = session.createQuery(hql);
//			query.setParameter("studentId", id);
//			List results = query.getResultList();
//
//			if (results != null && !results.isEmpty()) {
//				employee = (Employee) results.get(0);
//			}
//			// commit transaction
//			transaction.commit();
//		} catch (Exception e) {
//			if (transaction != null) {
//				transaction.rollback();
//			}
//			e.printStackTrace();
//		}
//		return employee;
//	}
//
//	public List<Employee> getAllEmployee() {
//		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//			return session.createQuery("from employee ", Employee.class).list();
//		}
//	}
}
