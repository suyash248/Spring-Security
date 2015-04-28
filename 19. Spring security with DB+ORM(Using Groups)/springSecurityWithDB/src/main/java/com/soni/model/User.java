package com.soni.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter @Setter
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private Integer userId;

	@Column(name="USER_NAME")
	private String userName;
	
	@Column(name="USER_PASS")
	private String userPass;
	
	@Column(name="ACTIVE")
	private Boolean active;
	
	@OneToMany(mappedBy="user")
	private Set<UserAuthority> authorities;
}
