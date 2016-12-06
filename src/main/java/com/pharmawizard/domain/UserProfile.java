package com.pharmawizard.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_profile")
public class UserProfile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1784967393489677968L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idUser;

	@Column(name = "name", nullable = false, unique = false)
	private String name;

	@Column(name = "username", nullable = false, unique = true)
	private String username;

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "ROLE")
	@Enumerated(EnumType.STRING)
	private Role role;

	@OneToMany(mappedBy = "user")
	private List<Topic> topics;

	@OneToMany(mappedBy = "user")
	private List<Comment> comment;

	@OneToOne
	private Inbox inbox;

	public UserProfile() {

	}

	public UserProfile(Long idUser, String name, String username, String email, String password, Role role,
			List<Topic> topics, List<Comment> comment, Inbox inbox) {
		this.idUser = idUser;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
		this.topics = topics;
		this.comment = comment;
		this.inbox = inbox;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	public Inbox getInbox() {
		return inbox;
	}

	public void setCart(Inbox inbox) {
		this.inbox = inbox;
	}

}
