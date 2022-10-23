
package FPL.SIDSD.DAO.IMPL;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import FPL.SIDSD.DAO.EtudiantDAO;
import FPL.SIDSD.Entities.Etudiant;
import FPL.SIDSD.DAO.HibernateSession;

public class EtudiantDAOImpl implements EtudiantDAO{

private static SessionFactory FPL = HibernateSession.getSessionFactory();
	
	@Override
	
	public boolean create(Etudiant o) {
		// TODO Auto-generated method stub
		Session session = FPL.openSession();
		Transaction tx = session.beginTransaction();
		
		try {
			System.out.println("id d'ajout : " + o.getId());
			session.saveOrUpdate(o);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println("Probleme de creation Etudiant : " + e.getMessage());
			return false;
		}
		session.close();
		return true;
	}


	@Override
	public boolean delete(Etudiant o) {
		Session session = FPL.openSession();
		Transaction tx = session.beginTransaction();
		
		try {
			session.delete(o);
			tx.commit();
		} catch (Exception e) {
			
			tx.rollback();
			System.out.println("Probleme de supprime Etudiant : " + e.getMessage());
			return false;
		}
		
		session.close();
		return true;
	}

	@Override
	public Etudiant getById(int id) {
		Session session = FPL.openSession();
		Etudiant E = session.get(Etudiant.class, id);
		session.close();
		return E;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Etudiant> getAll() {
		Session session = FPL.openSession();
		List<Etudiant> etudiants = session.createQuery("from Etudiant").list();
		
		session.close();
		return etudiants;
	}


	@Override
	public List<Etudiant> getByFiliere(int idFiliere) {
		List<Etudiant> e = new ArrayList<Etudiant>();
		Session session = FPL.openSession();
		List<Etudiant> etudiants = session.createQuery("from Etudiant").list();
		for(Etudiant E : etudiants) {
			if(E.getFiliere().getId() == idFiliere) {
				e.add(E);
			}
		}
		return e;
	}
}
