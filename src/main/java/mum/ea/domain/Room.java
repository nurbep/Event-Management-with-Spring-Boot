package mum.ea.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Room implements Serializable{
	@Id
	@GeneratedValue
	private int id;	
	private String number;
	
	@NotNull
	private String name;
	private int maxNoOfOccupants;
	
	@NotNull
	@ManyToOne
	private Building building;
	private String description;
	
	public Room() {}

	public Room(int id, String number, String name, int maxNoOfOccupants, Building building) {
		super();
		this.id = id;
		this.number = number;
		this.name = name;
		this.maxNoOfOccupants = maxNoOfOccupants;
		this.building = building;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxNoOfOccupants() {
		return maxNoOfOccupants;
	}

	public void setMaxNoOfOccupants(int maxNoOfOccupants) {
		this.maxNoOfOccupants = maxNoOfOccupants;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
