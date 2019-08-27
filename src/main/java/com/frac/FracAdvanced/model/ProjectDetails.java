package com.frac.FracAdvanced.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.frac.FracAdvanced.domain.security.User;


@Entity
@Table(name="project_details")
public class ProjectDetails implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	@Column(name="project_name", nullable=true, unique=false)
	private String projectName;
	
	@Column(name="well_name", nullable=true, unique=false)
	private String wellName;
	
	@Column(name="cmpany_name", nullable=true, unique=false)
	private String companyName;
	
	@Column(name="date_Created", nullable=true, unique=false)
	private String dateCreated;
	
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(cascade= {CascadeType.ALL},
			fetch=FetchType.LAZY,
			mappedBy="details") 
	private Set<MiniFracModel> mini=new HashSet<>();   
	
	
	@OneToMany(cascade= {CascadeType.ALL},
	fetch=FetchType.LAZY,
	mappedBy="prodetails") 
private List<OutputMiniFrac> output;
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getWellName() {
		return wellName;
	}

	public void setWellName(String wellName) {
		this.wellName = wellName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	
    public ProjectDetails() {
		// TODO Auto-generated constructor stub
	}

	public ProjectDetails(String projectName, String wellName, String companyName, String dateCreated) {
		this.projectName = projectName;
		this.wellName = wellName;
		this.companyName = companyName;
		this.dateCreated = dateCreated;
	}
}
