package esprit.microservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import esprit.microservice.entities.Matiere;

@Repository
public interface IMatiereRepository extends CrudRepository<Matiere, Integer>{
	
}
