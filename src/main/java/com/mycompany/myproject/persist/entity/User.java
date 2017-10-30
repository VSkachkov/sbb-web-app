package com.mycompany.myproject.persist.entity;


import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
@ToString
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "users", schema="SBB_DB")
public class User implements Serializable {

	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	@Column(name = "user_id", nullable = false)
	private Long userId;

	@Basic
	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Basic
	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Basic
	@Column(name = "birthday")
	private Date birthday;

	@Basic
	@Column(name = "email")
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	private String email;

	@Basic
	@Column(name = "login")
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	private String login;

	@Basic
	@Column(name = "password")
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	private String password;

	@Basic
	@Column(name = "phone_number")
	private String phone;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ROLE_ID")
	private Role role;
}





















//
//
//import java.util.Date;
//import java.util.HashSet;
//import java.util.Set;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.Table;
//
//import org.hibernate.annotations.GenericGenerator;
//
//@Entity
//@Table(name = "user")
//public class User {
//
//	@Id
//	@GenericGenerator(name = "generator", strategy = "increment")
//	@GeneratedValue(generator = "generator")
//	@Column(name = "id", nullable = false)
//	private Long id;
//
//	@Column(name = "first_name", nullable = false)
//	private String firstName;
//
//	@Column(name = "family_name", nullable = false)
//	private String familyName;
//
//	@Column(name = "e_mail", nullable = false)
//	private String email;
//
//	@Column(name = "phone", nullable = false)
//	private String phone;
////
////	@Column(name = "language", nullable = false)
////	private String language;
//
////	@Column(name = "id_picture")
////	private String pictureId;
//
//	@Column(name = "login", nullable = false)
//	private String login;
//
//	@Column(name = "password", nullable = false)
//	private String password;
//
//	@Column(name = "burth_date")
//	private Date burthDate;
//
////	@Column(name = "enabled")
////	private Boolean enabled;
//
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "users_authority", joinColumns = { @JoinColumn(name = "id_user", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "id_authority", table = "authority", referencedColumnName = "id") })
//	private Set<Authority> authorities = new HashSet<Authority>();
//
//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	public String getFamilyName() {
//		return familyName;
//	}
//
//	public void setFamilyName(String familyName) {
//		this.familyName = familyName;
//	}
//
//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}
//
//	public String getLogin() {
//		return login;
//	}
//
//	public void setLogin(String login) {
//		this.login = login;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public Date getBurthDate() {
//		return burthDate;
//	}
//
//	public void setBurthDate(Date burthDate) {
//		this.burthDate = burthDate;
//	}
//
//	public Set<Authority> getAuthorities() {
//		return authorities;
//	}
//
//	public void setAuthorities(Set<Authority> authorities) {
//		this.authorities = authorities;
//	}
//
////	public Boolean getEnabled() {
////		return enabled;
////	}
////
////	public void setEnabled(Boolean enabled) {
////		this.enabled = enabled;
////	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
////	public String getLanguage() {
////		return language;
////	}
////
////	public void setLanguage(String language) {
////		this.language = language;
////	}
//
//	public String getPhone() {
//		return phone;
//	}
//
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//
////	public String getPictureId() {
////		return pictureId;
////	}
////
////	public void setPictureId(String pictureId) {
////		this.pictureId = pictureId;
////	}
//
//
//
///*
//package com.mycompany.myproject.persist.entity;
//
//
// */
//
//
//}
