package FPL.SIDSD.DAO;



import java.util.List;

import FPL.SIDSD.Entities.Etudiant;

public interface EtudiantDAO extends Idao<Etudiant>{
	 List<Etudiant> getByFiliere(int idFiliere) ;
}
