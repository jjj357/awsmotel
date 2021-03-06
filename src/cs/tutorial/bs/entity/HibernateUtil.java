package cs.tutorial.bs.entity;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;


public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	static {
		try {
			sessionFactory =  new AnnotationConfiguration().configure().buildSessionFactory();
			
	} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}