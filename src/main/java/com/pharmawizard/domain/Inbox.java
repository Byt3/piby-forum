package com.pharmawizard.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@Entity
@Table(name = "inbox")
public class Inbox implements Serializable {

	private static final long serialVersionUID = 2494256931783559035L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "inbox")
	private List<PrivateMessage> privateMessage;

	@OneToOne
	private UserProfile user;

	public Inbox(Long id, List<PrivateMessage> privateMessage, UserProfile user) {
		this.id = id;
		this.privateMessage = privateMessage;
		this.user = user;
	}

	public Inbox() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<PrivateMessage> getPrivateMessage() {
		return privateMessage;
	}

	public void setPrivateMessage(List<PrivateMessage> privateMessage) {
		this.privateMessage = privateMessage;
	}

	public UserProfile getUser() {
		return user;
	}

	public void setUser(UserProfile user) {
		this.user = user;
	}

}
