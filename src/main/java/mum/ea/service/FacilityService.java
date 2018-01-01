package mum.ea.service;

import java.util.List;

import mum.ea.domain.Facility;

public interface FacilityService {

	public List<Facility> getAllFacilities();

	public Facility getFacility(int facilityId) ;

	public void addFacility(Facility facility) ;

	public void updateFacility(Facility facility) ;

	public void deleteFacility(Facility facility) ;

	public void deleteFacility(int facilityId) ;

	public boolean existFacilityCode(Facility facility) ;
	
	public int existingFacilityCode(Facility facility) ;
	
	public List<Facility> findByBuilding(int buildingId);
}
