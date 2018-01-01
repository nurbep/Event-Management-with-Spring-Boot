package mum.ea.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class EventGroup implements Serializable{
	@Id
	@GeneratedValue
	private int id;
	@Column
	@NotNull
	private String name;
	@Column 
	private String description;
	@NotNull
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	
	@OneToMany
	
	private List<Category> categoryList=new ArrayList<Category>();
	@ManyToOne
	private User createdBy;
	
	public List<Category> getCategoryList() {
		return categoryList;
	}
	
	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}
	
	public User getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}	
}