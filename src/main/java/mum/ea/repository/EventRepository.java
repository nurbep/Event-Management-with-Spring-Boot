package mum.ea.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.ea.domain.Event;
import mum.ea.domain.Facility;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {
	
	public List<Event> findAllByOrderByIdDesc();

	public List<Event> findAllByNameLikeOrderByStartDateDesc(String name);

	public List<Event> findAllByIdNotAndFacilityAndStartDateBetween(int id, Facility f, Date s, Date e);

	public List<Event> findAllByIdNotAndFacilityAndEndDateBetween(int id, Facility f, Date s, Date e);
}