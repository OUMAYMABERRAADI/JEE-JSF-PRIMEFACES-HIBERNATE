package FPL.SIDSD.DAO.IMPL;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import FPL.SIDSD.DAO.FiliereDAO;
import FPL.SIDSD.DAO.HibernateSession;
import FPL.SIDSD.Entities.Filiere;


public class FiliereDAOImpl implements FiliereDAO{

	private static SessionFactory FPL = HibernateSession.getSessionFactory();
	
	@Override
	public boolean create(Filiere o) {
		Session session = FPL.openSession();
		Transaction tx = session.beginTransaction();
		
		try {
			System.out.println("id d'ajout : " + o.getId());
			session.saveOrUpdate(o);
			tx.commit();
		} catch (Exception e) {
			
			tx.rollback();
			System.out.println("Probleme de creation filiere : " + e.getMessage());
			return false;
		}
		
		session.close();
		return true;
	}

	@Override
	public boolean delete(Filiere o) {
		Session session = FPL.openSession();
		Transaction tx = session.beginTransaction();
		
		try {
			System.out.println("id de suppression : " + o.getId());
			session.delete(o);
			System.out.println("done");
			tx.commit();
		} catch (Exception e) {
			
			tx.rollback();
			System.out.println("Probleme de supprime filiere : " + e.getMessage());
			return false;
		}
		
		session.close();
		return true;
	}

	@Override
	public Filiere getById(int id) {
		Session session = FPL.openSession();
		Filiere f = session.get(Filiere.class, id);
		session.close();
		return f;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Filiere> getAll() {
		Session session = FPL.openSession();
		List<Filiere> filieres = session.createQuery("from Filiere").list();
		
		session.close();
		return filieres;
	}
	
    @SuppressWarnings("unchecked")
    @Override
	public int  IDFiliere(String Code) {
    	Session session = FPL.openSession();
		List<Filiere> filieres = session.createQuery("from Filiere").list();
		 for(Filiere F : filieres) {
		      if( F.getCode().equalsIgnoreCase(Code))
		      {
		    	  return F.getId();
		      }
		  }
	     return -1;
    }

}
