package com.pharmawizard.domain;

import java.io.Serializable;
import java.sql.Date;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "comment")
public class Comment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5343137081532275884L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idComment;

	@Column(name = "text", nullable = false, unique = false)
	private String text;

	@Column(name = "created_date", nullable = false, unique = false)
	private String date;

	@Column(name = "update_date", nullable = false, unique = false)
	private String updateDate;

	@Column(name = "edited_by", nullable = true, unique = false)
	private String editedBy;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private UserProfile user;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "topic_id")
	private Topic topic;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_user")
	private Comment parent;

	@OneToMany(mappedBy = "parent")
	private List<Comment> children;

	public Comment(long idComment, String text, String date, String updateDate, String editedBy, UserProfile user,
			Topic topic, Comment parent, List<Comment> children) {
		this.idComment = idComment;
		this.text = text;
		this.date = date;
		this.updateDate = updateDate;
		this.editedBy = editedBy;
		this.user = user;
		this.topic = topic;
		this.parent = parent;
		this.children = children;
	}

	public Comment() {

	}

	public long getIdComment() {
		return idComment;
	}

	public void setIdComment(long idComment) {
		this.idComment = idComment;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getEditedBy() {
		return editedBy;
	}

	public void setEditedBy(String editedBy) {
		this.editedBy = editedBy;
	}

	public UserProfile getUser() {
		return user;
	}

	public void setUser(UserProfile user) {
		this.user = user;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Comment getParent() {
		return parent;
	}

	public void setParent(Comment parent) {
		this.parent = parent;
	}

	public List<Comment> getChildren() {
		return children;
	}

	public void setChildren(List<Comment> children) {
		this.children = children;
	}

}
