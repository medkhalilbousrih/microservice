package esprit.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import esprit.microservice.entities.Matiere;
import esprit.microservice.repository.IMatiereRepository;

@Service
public class MatiereService implements IMatiereService {
	
	@Autowired
	IMatiereRepository matiereRepo;

	@Override
	public int ajouterMatiere(Matiere m) {
		matiereRepo.save(m);
		return 0;
	}

	@Override
	public int updateMatiere(int id, Matiere m) {
		Matiere mat = matiereRepo.findById(id).get();
		mat.setCoeff(m.getCoeff());
		mat.setDuree(m.getDuree());
		mat.setEvaluation(m.getEvaluation());
		mat.setUnite(m.getUnite());
		matiereRepo.save(mat);
		return 0;
	}

	@Override
	public String supprimerMatiere(int id) {
		if(matiereRepo.existsById(id)) {
			matiereRepo.deleteById(id);
			return "Matiere supprimé";
		}
		return "Matiere n'existe pas";
	}

	@Override
	public List<Matiere> afficherMatieres() {
		return (List<Matiere>) matiereRepo.findAll();
	}
	
}
