package FPL.SIDSD.DAO.IMPL;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import FPL.SIDSD.DAO.HibernateSession;
import FPL.SIDSD.DAO.UserDAO;
import FPL.SIDSD.Entities.User;

public class UserDAOImpl implements UserDAO{
    
	private static SessionFactory FPL = HibernateSession.getSessionFactory();
	
	@Override
	public boolean create(User o) {
		Session session = FPL.openSession();
		Transaction tx = session.beginTransaction();
		
		try {
			System.out.println("id d'ajout : " + o.getIdUser());
			session.saveOrUpdate(o);
			tx.commit();
		} catch (Exception e) {
			
			tx.rollback();
			System.out.println("Probleme de creation User : " + e.getMessage());
			return false;
		}
		
		session.close();
		return true;
	}
	
	public User Login(String login , String password) {
		Session session = FPL.openSession();
			
	    if(!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		 Query query = (Query) session.createQuery("from User u where u.login=: login and u.password =:password");
		 query.setString("login", login);
		 query.setString("password", password);
		 return (User) query.uniqueResult();
	}


	@Override
	public boolean delete(User o) {
		Session session = FPL.openSession();
		Transaction tx = session.beginTransaction();
		
		try {
			System.out.println("id de suppression: " + o.getIdUser());
			session.delete(o);
			System.out.println("done");
			tx.commit();
		} catch (Exception e) {
			
			tx.rollback();
			System.out.println("Probleme de supprime User : " + e.getMessage());
			return false;
		}
		
		session.close();
		return true;
	}

	@Override
	public User getById(int id) {
		Session session = FPL.openSession();
		User u = session.get(User.class, id);
		session.close();
		return u;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll() {
		Session session = FPL.openSession();
		List<User> users = session.createQuery("from User").list();
		
		session.close();
		return users;
	}
  
}
