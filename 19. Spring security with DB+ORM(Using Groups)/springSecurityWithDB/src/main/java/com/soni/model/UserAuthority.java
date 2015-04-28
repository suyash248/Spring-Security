package com.soni.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="authorities")
@Getter @Setter
public class UserAuthority {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="AUTH_ID")
	private Integer authId;
	
	@JoinColumn(name="USER_ID")
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;
	
	@Column(name="AUTHORITY")
	private String authority;
}
