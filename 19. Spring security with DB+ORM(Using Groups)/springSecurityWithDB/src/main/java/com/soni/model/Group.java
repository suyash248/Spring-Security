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
@Table(name="groups")
@Getter @Setter
public class Group {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="GROUP_ID")
	private Integer groupId;
	
	@Column(name="GROUP_NAME")
	private String groupName;
	
	@OneToMany(mappedBy="group")
	private Set<GroupAuthority> groupAuthorities;
}
