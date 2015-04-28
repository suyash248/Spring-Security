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
@Table(name="group_authorities")
@Getter @Setter
public class GroupAuthority {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="GROUP_AUTHORITY_ID")
	private Integer groupAuthorityId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="GROUP_ID")
	private Group group;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="AUTHORITY")
	private UserAuthority authority;
	
}
