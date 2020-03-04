package com.example.wsec.model;

import javax.persistence.GenerationType;


import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="role")
public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="role_id")
	private int roleId;
	
	@Column(name="role_name")
	private String roleName;
	
		
	@ManyToMany(mappedBy="roles")
	private List<User> users;
	
	@ManyToMany(mappedBy="roles")
	
	private List<Page> pages;
	
	public Role() {
		super();
	}


	public Role( String roleName) {
		super();
		
	this.roleName=roleName;
		
	}


	public int getRoleId() {
		return roleId;
	}


	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}


	public List<Page> getPages() {
		return pages;
	}


	public void setPages(List<Page> pages) {
		this.pages = pages;
	}


	
	
	
	
	
}
