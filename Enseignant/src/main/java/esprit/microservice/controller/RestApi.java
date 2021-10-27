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

import esprit.microservice.entities.Enseignant;
import esprit.microservice.service.EnseignantService;

@RestController
@RequestMapping("api")
public class RestApi {
	@Autowired
	EnseignantService serv;
	
	@GetMapping("/enseignants")
	public List<Enseignant> listeEnseignant(){
		return serv.afficherEnseignants();
	}
	
	@PostMapping("/enseignants")
	public int ajouter(@RequestBody Enseignant e) {
		return serv.ajouterEnseignant(e);
	}
	
	
	@PutMapping("/enseignants/{id}")
	public int update(@RequestBody Enseignant e, @PathVariable int id) {
		return serv.updateEnseignant(id, e);
	}
	
	@DeleteMapping("/enseignants/{id}")
	public String supprimer(@PathVariable int id) {
		return serv.supprimerEnseignant(id);
	}
	
	@GetMapping("/enseignants/{specialite}")
	public List<Enseignant> listerEnsSpe(@PathVariable String specialite){
		return serv.afficherEnseignantParSpecialite(specialite);
	}
	

}
