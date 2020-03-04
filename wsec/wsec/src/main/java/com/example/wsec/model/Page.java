package com.example.wsec.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="page")
public class Page {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="page_id")
	private int pageId;
	
	public int getMessageId() {
		return pageId;
	}

	public void setMessageId(int messageId) {
		this.pageId = messageId;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Column(name="page_name")
	private String pageName;
	
	@ManyToMany
	@JoinTable(name="page_role", 
	joinColumns=@JoinColumn(name="page_id"),
	inverseJoinColumns=@JoinColumn(name="role_id"))
	private List<Role> roles;
	
	
	public Page() {
		super();
	}

	public Page( String pageName) {
		super();
		this.pageName=pageName;
	}

	
}
