package mum.ea.service;

import java.util.List;

import org.springframework.context.annotation.Bean;

import mum.ea.domain.Building;


public interface BuildingService {

	public List<Building> getAllBuildings() ;

	public Building getBuilding(int buildingId) ;

	public void addBuilding(Building building) ;

	public void updateBuilding(Building building) ;

	public void deleteBuilding(Building building);
	
	public void deleteBuilding(int buildingId);
}
