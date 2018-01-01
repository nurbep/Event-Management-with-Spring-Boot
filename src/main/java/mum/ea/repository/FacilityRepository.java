package mum.ea.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.ea.domain.Building;
import mum.ea.domain.Facility;
import mum.ea.domain.Room;

@Repository
public interface FacilityRepository extends CrudRepository<Facility, Integer> {

	//List<Facility> findByIdNotEqualsAndCode(int id, String code);
	List<Facility> findByCode(String code);
	public List<Facility> findByBuilding(Building building);
	public List<Facility> findAllByOrderByCode();


}
