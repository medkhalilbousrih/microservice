package esprit.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import esprit.microservice.entities.Enseignant;
import esprit.microservice.repository.EnseignantRepository;

@Service
public class EnseignantService implements IEnseignantService {
	@Autowired
	EnseignantRepository enseignantRepo;

	@Override
	public int ajouterEnseignant(Enseignant e) {
		enseignantRepo.save(e);
		return 0;
	}

	@Override
	public int updateEnseignant(int id, Enseignant e) {
		Enseignant ens = enseignantRepo.findById(id).get();
		ens.setNom(e.getNom());
		ens.setPrenom(e.getPrenom());
		ens.setDateNaissance(e.getDateNaissance());
		ens.setSpecialite(e.getSpecialite());
		ens.setExperience(e.getExperience());
		enseignantRepo.save(ens);
		return 0;
	}

	@Override
	public String supprimerEnseignant(int id) {
		if (enseignantRepo.findById(id).isPresent()) {
			enseignantRepo.deleteById(id);
			return "Enseignant supprimé";
		} else {
			return "Cet enseignat n'existe pas";
		}
	}

	@Override
	public List<Enseignant> afficherEnseignants() {
		return (List<Enseignant>) enseignantRepo.findAll();
	}

	@Override
	public List<Enseignant> afficherEnseignantParSpecialite(String specialite) {
		return (List<Enseignant>) enseignantRepo.findBySpecialite(specialite);
	}
}
