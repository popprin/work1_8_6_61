package com.example.pop1.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "pop1")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createAt", "updateAt" }, allowGetters = true)
public class MemberModel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String firstName;

	@NotBlank
	private String lastName;

	@NotBlank
	private String username;

	@NotNull
	private Integer password;

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate// type createDate on database
	private Date createAt;

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updateAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public Integer getPassword() {
		return password;
	}

	public void setPassword(Integer password) {
		this.password = password;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

}
