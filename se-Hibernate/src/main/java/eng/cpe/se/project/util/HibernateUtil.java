package eng.cpe.se.project.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.jboss.logging.Logger;

public class HibernateUtil {
	private static final Logger log = Logger.getLogger("");

	private static SessionFactory  sessionFactory = null;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
        	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()//
                    .configure("hibernate.cfg.xml").build();

            // Create a metadata sources using the specified service registry.
            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
            
            sessionFactory = metadata.buildSessionFactory();

        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Exception stack Trace ************** begin");
            System.err.println("Hibernate : Initial SessionFactory creation failed." + ex);
            ex.printStackTrace();
            System.err.println("Exception Stack Trace ********* END");
            throw new ExceptionInInitializerError(ex);
          
            
        }
    }


	public static Session openSession() {
		return sessionFactory.openSession();
	}
	
	public static void closeSession() {
		sessionFactory.close();
	}
}
