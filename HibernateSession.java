package FPL.SIDSD.DAO;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import FPL.SIDSD.Entities.Etudiant;
import FPL.SIDSD.Entities.Filiere;
import FPL.SIDSD.Entities.User;


public class HibernateSession {
private static SessionFactory FPL;
	
	static {
		
		FPL = new Configuration().configure("hibernate.cfg.xml") 
								.addAnnotatedClass(Filiere.class)
								.addAnnotatedClass(Etudiant.class)
								.addAnnotatedClass(User.class)
								.buildSessionFactory();
	}
	
	
	public static SessionFactory getSessionFactory() {
		
		return FPL;
	}
}
