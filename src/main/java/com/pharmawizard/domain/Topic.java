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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "topic")
public class Topic implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6872625241983976407L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idTopic;

	@Column(name = "title", nullable = false, unique = true)
	private String title;

	@Column(name = "created_date", nullable = false, unique = false)
	private String date;

	@Column(name = "views", nullable = false, unique = false)
	private Long views;

	@Column(name = "last_comment", nullable = false, unique = false)
	private String lastComment;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", nullable = false, updatable = false)
	private UserProfile user;

	@OneToMany(mappedBy = "topic")
	private List<Comment> comment;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "topic_category", nullable = false, updatable = false)
	private Category category;

	public Topic() {
	}

	public Topic(Long idTopic, String title, String date, Long views, String lastComment, UserProfile user,
			List<Comment> comment, Category category) {
		super();
		this.idTopic = idTopic;
		this.title = title;
		this.date = date;
		this.views = views;
		this.lastComment = lastComment;
		this.user = user;
		this.comment = comment;
		this.category = category;
	}

	public Long getIdTopic() {
		return idTopic;
	}

	public void setIdTopic(Long idTopic) {
		this.idTopic = idTopic;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Long getViews() {
		return views;
	}

	public void setViews(Long views) {
		this.views = views;
	}

	public String getLastComment() {
		return lastComment;
	}

	public void setLastComment(String lastComment) {
		this.lastComment = lastComment;
	}

	public UserProfile getUser() {
		return user;
	}

	public void setUser(UserProfile user) {
		this.user = user;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
