package FPL.SIDSD.Bean;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

import FPL.SIDSD.DAO.EtudiantDAO;
import FPL.SIDSD.DAO.FiliereDAO;
import FPL.SIDSD.DAO.IMPL.EtudiantDAOImpl;
import FPL.SIDSD.DAO.IMPL.FiliereDAOImpl;
import FPL.SIDSD.Entities.Etudiant;
import FPL.SIDSD.Entities.Filiere;


@SuppressWarnings("serial")
@ManagedBean(name="etudiantBean")
public class EtudiantBean implements Serializable{
	
	/**
	 * 
	 */
	EtudiantDAO etudiantDao ;
	FiliereDAO filiereDao;
	private Etudiant etudiant;
	private boolean modifyContext;
	

	public EtudiantBean() {
		this.etudiant=new Etudiant();
		this.etudiant.setFiliere(new Filiere());
		this.getEtudiant().getFiliere().setId(0);
		this.etudiantDao = new EtudiantDAOImpl();
		this.filiereDao= new FiliereDAOImpl();
		this.setModifyContext(false);
	}

	public FiliereDAO getFiliereDao() {
		return filiereDao;
	}


	public void setFiliereDao(FiliereDAO filiereDao) {
		this.filiereDao = filiereDao;
	}


	public EtudiantDAO getEtudiantDao() {
		return etudiantDao;
	}

	public void setEtudiantDao(EtudiantDAO etudiantDao) {
		this.etudiantDao = etudiantDao;
	}


	public Etudiant getEtudiant() {
		return etudiant;
	}


	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}


	public boolean isModifyContext() {
		return modifyContext;
	}


	public void setModifyContext(boolean modifyContext) {
		this.modifyContext = modifyContext;
	}
	 
    public List<Etudiant> getEtudiants() {
		
		return this.etudiantDao.getAll();
	}
	
	public String getLabel() {
		
		return modifyContext ? "Modification" : "Ajout";
	}
	
	public void save() {
		
		etudiantDao.create(this.etudiant);
		this.modifyContext=false;
		this.etudiant=new Etudiant();
	}
	
	public void modify(Etudiant e) {
		
		this.etudiant= e;
		this.modifyContext = true;
	}
	
	public void delete(Etudiant e) {
		
		this.etudiantDao.delete(e);
	}
	
	public String codeFiliere(int id) {
		 Filiere f =this.filiereDao.getById(id);
		 return f.getCode();
	}
	
   public List<Filiere> getFilieres() {
		
		return this.filiereDao.getAll();
	}
   
   public int getByCode(String code) {
	   return this.filiereDao.IDFiliere(code);
   }
   
   public ArrayList<Etudiant> getByIdFiliere(int id){
	   return (ArrayList<Etudiant>) this.etudiantDao.getByFiliere(id);
   }
   
}
