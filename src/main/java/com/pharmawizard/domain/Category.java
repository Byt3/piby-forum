package com.pharmawizard.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category implements Serializable {

	private static final long serialVersionUID = -5614559377777283207L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idCategory;

	@Column(name = "name", nullable = false, unique = true)
	private String name;

	@Column(name = "description", nullable = false, unique = false)
	private String description;

	public Category() {
	}

	public Category(long idCategory, String name, String description, List<Topic> topic) {
		super();
		this.idCategory = idCategory;
		this.name = name;
		this.description = description;
		this.topic = topic;
	}

	@OneToMany(mappedBy = "category")
	private List<Topic> topic;

	public long getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(long idCategory) {
		this.idCategory = idCategory;
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

	public List<Topic> getTopic() {
		return topic;
	}

	public void setTopic(List<Topic> topic) {
		this.topic = topic;
	}

}
