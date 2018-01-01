package mum.ea.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author Kisi1
 *
 */
@Entity
public class Facility implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue	
	private int id;
	
	@NotBlank
	@Column(unique=true)
	private String code;
	private String name;
	private int maxPeople;

	@OneToOne
	@JoinColumn(name = "buildingId", nullable = true)
	private Building building;

	@Enumerated(EnumType.STRING)
	private FacilityType type;

	private String description;

	private boolean isAvailable;
	
	private Date created;
	private Date updated;

	@PrePersist
	protected void onCreate() {
		setCreated(new Date());
	}

	@PreUpdate
	protected void onUpdate() {
		setUpdated(new Date());
	}

	public Facility() {
	}

	public Facility(int id, String code, String name, int maxPeople, Building building, boolean isAvailable) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.maxPeople = maxPeople;
		this.building = building;
		this.isAvailable = isAvailable;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxPeople() {
		return maxPeople;
	}

	public void setMaxPeople(int maxPeople) {
		this.maxPeople = maxPeople;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public FacilityType getType() {
		return type;
	}

	public void setType(FacilityType type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

}
