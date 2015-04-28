package com.soni.service;

import java.util.List;

import com.soni.model.Group;
import com.soni.model.GroupAuthority;
import com.soni.model.GroupMember;

public interface GroupService {
	public List<GroupAuthority> getGroupAuthorities(int groupId);
	public List<GroupMember> getUserGroups(String userName);
}
