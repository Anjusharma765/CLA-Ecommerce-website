package com.UserProfile.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class changeName {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	//private String username;
    private String oldName;
    private String newName;
    public changeName(Long id, String oldName, String newName) {
		super();
		this.id = id;
		//this.username = username;
		this.oldName = oldName;
		this.newName = newName;
	}
	public changeName() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	/*public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}*/
	public String getOldName() {
		return oldName;
	}
	public void setOldName(String oldName) {
		this.oldName = oldName;
	}
	public String getNewName() {
		return newName;
	}
	public void setNewName(String newName) {
		this.newName = newName;
	}
	

}
