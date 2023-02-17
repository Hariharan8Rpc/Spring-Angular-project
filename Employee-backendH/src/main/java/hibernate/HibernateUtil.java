package hibernate;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import com.employee.model.Employee;

public class HibernateUtil {

//	  private static final SessionFactory sessionFactory = buildSessionFactory();
//
//	  private static SessionFactory buildSessionFactory() {
//	    try {
//	      // Create the SessionFactory from hibernate.cfg.xml
//	      return new Configuration().configure().buildSessionFactory();
//	    }
//	    catch (Throwable ex) {
//	      // Make sure you log the exception, as it might be swallowed
//	      System.err.println("Initial SessionFactory creation failed." + ex);
//	      throw new ExceptionInInitializerError(ex);
//	    }
//	  }
//
//	  public static SessionFactory getSessionFactory() {
//	    return sessionFactory;
//	  }
//
//	  public static void shutdown() {
//	    // Close caches and connection pools
//	    getSessionFactory().close();
//	  }

	
	
	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();

				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();
				settings.put(AvailableSettings.DRIVER, "com.mysql.cj.jdbc.Driver");

//				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/employee_management?useSSL=false");
				settings.put(AvailableSettings.URL, "jdbc:mysql://localhost:3306/employee_management1?useSSL=false");
				settings.put(AvailableSettings.USER, "root");
				settings.put(AvailableSettings.PASS, "hari123");
				settings.put(AvailableSettings.DIALECT, "org.hibernate.dialect.MySQL8Dialect");

				settings.put(AvailableSettings.SHOW_SQL, "true");

				settings.put(AvailableSettings.CURRENT_SESSION_CONTEXT_CLASS, "thread");

				settings.put(AvailableSettings.HBM2DDL_AUTO, "create-drop");

				configuration.setProperties(settings);

				configuration.addAnnotatedClass(Employee.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();

				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
	
	
}
