package esprit.microservice.service;

import java.util.List;

import esprit.microservice.entities.Etudiant;

public interface IEtudiantService {
	int ajouterEtudiant(Etudiant e);
	int updateEtudiant(int id, Etudiant e);
	String supprimerEtudiant(int id);
	List<Etudiant> afficherEtudiants();
	List<Etudiant> afficherEtudiantParClasse(int id);
	List<Etudiant> afficherEtudiantsReussi();
	
}
