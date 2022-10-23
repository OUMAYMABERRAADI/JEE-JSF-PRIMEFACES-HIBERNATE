package FPL.SIDSD.Bean;


import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import FPL.SIDSD.DAO.FiliereDAO;
import FPL.SIDSD.DAO.IMPL.FiliereDAOImpl;
import FPL.SIDSD.Entities.Filiere;

@ManagedBean(name="filiereBean")
@SessionScoped
public class FiliereBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FiliereDAO filiereDao;
	private  Filiere filiere;
	private boolean modifyContext;
	
	 public FiliereBean() {
			
			this.filiereDao = new FiliereDAOImpl();
			this.filiere = new Filiere();
			this.modifyContext = false;
		}

	public FiliereDAO getFiliereDao() {
		return filiereDao;
	}

	public void setFiliereDao(FiliereDAO filiereDao) {
		this.filiereDao = filiereDao;
	}

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiiere(Filiere filiere) {
		this.filiere = filiere;
	}

	public boolean isModifyContext() {
		return modifyContext;
	}

	public void setModifyContext(boolean modifyContext) {
		this.modifyContext = modifyContext;
	}

    public List<Filiere> getFilieres() {
		
		return this.filiereDao.getAll();
	}
	
	public String getLabel() {
		
		return modifyContext ? "Modification" : "Ajout";
	}
	
	public void save() {
		
		this.filiereDao.create(this.filiere);
		this.modifyContext = false;
		this.filiere=new Filiere();
	}
	
	public void modify(Filiere f) {
		
		this.filiere= f;
		this.modifyContext = true;
	}
	
	public void delete(Filiere f) {
		
		this.filiereDao.delete(f);
	}
}
