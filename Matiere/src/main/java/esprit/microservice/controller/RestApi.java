package esprit.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import esprit.microservice.entities.Matiere;
import esprit.microservice.service.MatiereService;

@RestController
@RequestMapping("api")
public class RestApi {
	
	@Autowired
	MatiereService serv;
	
	@GetMapping("/matieres")
	public List<Matiere> afficher() {
		return serv.afficherMatieres();
	}
	
	@PostMapping("/matieres")
	@ResponseStatus(HttpStatus.CREATED)
	public int ajouter(@RequestBody Matiere m) {
		return serv.ajouterMatiere(m);
	}
	
	
	@PutMapping("/matieres/{id}")
	public int update(@RequestBody Matiere m, @PathVariable int id) {
		return serv.updateMatiere(id, m);
	}
	
	@DeleteMapping("/matieres/{id}")
	public String supprimer(@PathVariable int id) {
		return serv.supprimerMatiere(id);
	}

}
