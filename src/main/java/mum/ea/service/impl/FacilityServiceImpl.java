package mum.ea.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.ea.domain.Facility;
import mum.ea.domain.Room;
import mum.ea.repository.BuildingRepository;
import mum.ea.repository.FacilityRepository;
import mum.ea.service.FacilityService;

@Service
@Transactional
public class FacilityServiceImpl implements FacilityService {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private FacilityRepository facilityRepository;
	
	@Autowired
	private BuildingRepository buildingRepository;

	public List<Facility> getAllFacilities() {
		List<Facility> facilities = new ArrayList<>();
		facilityRepository.findAllByOrderByCode().forEach(facilities::add);
		return facilities;
	}

	public Facility getFacility(int facilityId) {
		return facilityRepository.findOne(facilityId);
	}

	public void addFacility(Facility facility) {
		facilityRepository.save(facility);
	}

	public void updateFacility(Facility facility) {
		facilityRepository.save(facility);
	}

	public void deleteFacility(Facility facility) {
		facilityRepository.delete(facility);
	}

	public void deleteFacility(int facilityId) {
		facilityRepository.delete(facilityId);
	}

	public boolean existFacilityCode(Facility facility) {
		if (facilityRepository.findByCode(facility.getCode()).size() < 1)
			return false;
		else
			return true;
	}
	
	public int existingFacilityCode(Facility facility) {
		List<Facility> lst =facilityRepository.findByCode(facility.getCode());
		if (lst.size() < 1)
			return 0;
		else
			return lst.get(0).getId();
	}
	
	public List<Facility> findByBuilding(int buildingId) {
		return facilityRepository.findByBuilding(buildingRepository.findOne(buildingId));
	}
}
