package esprit.microservice.service;

import java.util.List;

import esprit.microservice.entities.Enseignant;

public interface IEnseignantService {
	int ajouterEnseignant(Enseignant e);
	int updateEnseignant(int id, Enseignant e);
	String supprimerEnseignant(int id);
	List<Enseignant> afficherEnseignants();
	List<Enseignant> afficherEnseignantParSpecialite(String specialite);
}
