package esprit.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import esprit.microservice.entities.Etudiant;
import esprit.microservice.repository.EtudiantRepository;

@Service
public class EtudiantService implements IEtudiantService {
	@Autowired
	EtudiantRepository etudiantRepo;

	@Override
	public int ajouterEtudiant(Etudiant e) {
		etudiantRepo.save(e);
		return 0;
	}

	@Override
	public int updateEtudiant(int id, Etudiant e) {
		Etudiant etu = etudiantRepo.findById(id).get();
		etu.setNom(e.getNom());
		etu.setPrenom(e.getPrenom());
		etu.setClasse(e.getClasse());
		etu.setDateNaissance(e.getDateNaissance());
		etu.setMoyenne(e.getMoyenne());
		etudiantRepo.save(etu);
		return 0;
	}

	@Override
	public String supprimerEtudiant(int id) {
		if (etudiantRepo.findById(id).isPresent()) {
			etudiantRepo.deleteById(id);
			return "Etudiant supprimé";
		} else {
			return "Cet Etudiant n'existe pas";
		}
	}

	@Override
	public List<Etudiant> afficherEtudiants() {
		return (List<Etudiant>) etudiantRepo.findAll();
	}

	@Override
	public List<Etudiant> afficherEtudiantParClasse(int id) {
		return (List<Etudiant>) etudiantRepo.findByClasse(id);
	}

	@Override
	public List<Etudiant> afficherEtudiantsReussi() {
		return etudiantRepo.findEtudiantResussi();
	}
	
	

}
