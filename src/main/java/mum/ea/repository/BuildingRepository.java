package mum.ea.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.ea.domain.Building;

@Repository
public interface BuildingRepository extends CrudRepository<Building, Integer> {

}
