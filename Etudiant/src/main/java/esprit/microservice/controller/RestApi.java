package esprit.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import esprit.microservice.entities.Etudiant;
import esprit.microservice.service.EtudiantService;

@RestController
@RequestMapping("api")
public class RestApi {
	@Autowired
	EtudiantService serv;
	
	@GetMapping("/etudiants")
	public List<Etudiant> afficher() {
		return serv.afficherEtudiants();
	}
	
	@PostMapping("/etudiants")
	public int ajouter(@RequestBody Etudiant e) {
		return serv.ajouterEtudiant(e);
	}
	
	
	@PutMapping("/etudiants/{id}")
	public int update(@RequestBody Etudiant e, @PathVariable int id) {
		return serv.updateEtudiant(id, e);
	}
	
	@DeleteMapping("/etudiants/{id}")
	public String supprimer(@PathVariable int id) {
		return serv.supprimerEtudiant(id);
	}
	
	@GetMapping("/etudiants/classe/{id}")
	public List<Etudiant> listerEtudiansParClasse(@PathVariable int id){
		return serv.afficherEtudiantParClasse(id);
	}
	
	@GetMapping("/etudiants/reussi")
	public List<Etudiant> listerEtudiansReussi(){
		return serv.afficherEtudiantsReussi();
	}
	

}
