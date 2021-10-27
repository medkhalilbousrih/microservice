package esprit.microservice.service;

import java.util.List;

import esprit.microservice.entities.Matiere;

public interface IMatiereService {
	int ajouterMatiere(Matiere m);
	int updateMatiere(int id, Matiere m);
	String supprimerMatiere(int id);
	List<Matiere> afficherMatieres();

}
