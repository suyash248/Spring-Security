package com.soni.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.acls.domain.BasePermission;
import org.springframework.security.acls.domain.GrantedAuthoritySid;
import org.springframework.security.acls.domain.ObjectIdentityImpl;
import org.springframework.security.acls.domain.PrincipalSid;
import org.springframework.security.acls.model.MutableAcl;
import org.springframework.security.acls.model.MutableAclService;
import org.springframework.security.acls.model.ObjectIdentity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.soni.model.Post;
import com.soni.model.User;
import com.soni.service.AuthServiceImpl.SecureUser;

/**
 * @author Suyash Soni
 *
 */
@Repository
@Transactional(propagation=Propagation.REQUIRED, timeout=300)
public class ForumServiceImpl extends AbstractServiceImpl implements ForumService {
	
	@Autowired
	private MutableAclService mutableAclService;
	
	@Transactional
	@Secured({"ROLE_USER"})
	public void createPost(Post post) {
		SecureUser secUser = (SecureUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		post.setUser(secUser.getUser());
		getSession().persist(post);
		ObjectIdentity oid = new ObjectIdentityImpl(Post.class, post.getId());
		
		MutableAcl acl = mutableAclService.createAcl(oid);
		
		acl.insertAce(0, BasePermission.ADMINISTRATION,new PrincipalSid(secUser.getUser().getUserName()), true);
		acl.insertAce(1, BasePermission.DELETE, new GrantedAuthoritySid("ROLE_ADMIN"), true);
		acl.insertAce(2, BasePermission.READ, new GrantedAuthoritySid("ROLE_USER"), true);
		
		mutableAclService.updateAcl(acl);
	}
	
	@Transactional
	@Secured("ACL_POST_DELETE")
	public void deletePost(Post post) {
		Post delPost = getPostDetail(post.getId());
		getSession().delete(delPost);
		
		ObjectIdentity oid = new ObjectIdentityImpl(Post.class, post.getId());
		mutableAclService.deleteAcl(oid, true);
	}
	
	public List<Post> getAllPosts(){
		List<Post> posts = new ArrayList<Post>();
		String sql = "select p from Post p "
				+ " left join fetch p.user usr";
		Query query = getSession().createQuery(sql);
		posts = query.list();
		return posts;
	}
	
	public Post getPostDetail(int postId){
		Post post = new Post();
		String sql = "select p from Post p "
				+ " left join fetch p.user usr "
				+ " where p.id=:postId ";
		Query query = getSession().createQuery(sql);
		query.setParameter("postId", postId);
		post = (Post)query.uniqueResult();
		return post;
	}
	
	public void setMutableAclService(MutableAclService mutableAclService) {
		this.mutableAclService = mutableAclService;
	}
}
