package esprit.microservice.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import esprit.microservice.entities.Enseignant;


@Repository
public interface EnseignantRepository extends CrudRepository<Enseignant, Integer>{
	public List<Enseignant> findBySpecialite(String specialite);

}
