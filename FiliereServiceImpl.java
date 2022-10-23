package FPL.SIDSD.Service.IMPL;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import FPL.SIDSD.DAO.FiliereDAO;
import FPL.SIDSD.DAO.IMPL.FiliereDAOImpl;
import FPL.SIDSD.Entities.Filiere;
import FPL.SIDSD.Service.IFiliereService;

public class FiliereServiceImpl implements IFiliereService{
    
	private FiliereDAO filiereDao = new FiliereDAOImpl() ;
	
	@Override
	public List<Filiere> getSorted() {
		List<Filiere> filieres = this.filiereDao.getAll();
		
		  Collections.sort(filieres, new Comparator<Filiere>() {

			@Override
			public int compare(Filiere o1, Filiere o2) {
				
				return o1.getId() - o2.getId();
			}
		});
		
		return filieres;
	}
	public String getFKey(int i) {
		// TODO Auto-generated method stub
		return null;
	}
 
}
