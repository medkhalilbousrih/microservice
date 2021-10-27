package esprit.microservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import esprit.microservice.entities.Etudiant;

@Repository
public interface EtudiantRepository extends CrudRepository<Etudiant, Integer>{
	@Query("select e from Etudiant e where e.moyenne >= 10")
	public List<Etudiant> findEtudiantResussi();
	public List<Etudiant> findByClasse(int id);

}
