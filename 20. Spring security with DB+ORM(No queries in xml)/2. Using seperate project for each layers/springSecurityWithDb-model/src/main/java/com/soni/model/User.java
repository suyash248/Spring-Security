package com.soni.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter @Setter
public class User {
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private Integer userId;

	@Id
	@Column(name="USER_NAME")
	private String userName;
	
	@Column(name="USER_PASS")
	private String userPass;
	
	@Column(name="ACTIVE")
	private Boolean active;
}
