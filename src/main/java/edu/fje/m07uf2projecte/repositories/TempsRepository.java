package edu.fje.m07uf2projecte.repositories;

import edu.fje.m07uf2projecte.model.Temps;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TempsRepository extends CrudRepository<Temps, Long> {
}
