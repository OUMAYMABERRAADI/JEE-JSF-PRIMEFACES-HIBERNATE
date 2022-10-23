package FPL.SIDSD.Service.IMPL;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import FPL.SIDSD.DAO.EtudiantDAO;
import FPL.SIDSD.DAO.IMPL.EtudiantDAOImpl;
import FPL.SIDSD.Entities.Etudiant;
import FPL.SIDSD.Service.IEtudiantService;

public class EtudiantServiceImpl implements IEtudiantService {

	private EtudiantDAO etudiantDao = new EtudiantDAOImpl() ;
	@Override
	public List<Etudiant> getSorted() {
		List<Etudiant> etudiants = this.etudiantDao.getAll();
		
		  Collections.sort(etudiants, new Comparator<Etudiant>() {

			@Override
			public int compare(Etudiant o1, Etudiant o2) {
				
				return o1.getId() - o2.getId();
			}
		});
		
		return etudiants;
	}
	@Override
	public String getFKey(int i) {
		// TODO Auto-generated method stub
		String code =  this.etudiantDao.getById(i).getFiliere().getCode();
		return code;
	}

}
