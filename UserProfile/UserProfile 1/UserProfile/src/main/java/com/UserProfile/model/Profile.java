package com.UserProfile.model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="Profile")
public class Profile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//private String userName;
	private String phone;

	//private String password;
	@NotBlank(message = "Birthdate is required")
	private String birthdate;
	 @NotNull(message = "Age is required")
    private int age;
	 @NotBlank(message = "Gender is required")
    private String gender;
    private String nationality;
 
    private String interests;
    private String languagesSpoken;
	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Profile(Long id, String phone,String birthdate, int age, String gender, String nationality, String interests, String languagesSpoken) {
		super();
		this.id = id;
		//this.userName = userName;
		this.phone = phone;
		
		this.birthdate = birthdate;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.nationality = nationality;
        this.interests = interests;
        this.languagesSpoken = languagesSpoken;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	/*public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}*/
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/*public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}*/
	 public String getBirthdate() {
	        return birthdate;
	    }

	    public void setBirthdate(String birthdate) {
	        this.birthdate = birthdate;
	    }

	    public int getAge() {
	        return age;
	    }

	    public void setAge(int age) {
	        this.age = age;
	    }

	    public String getGender() {
	        return gender;
	    }

	    public void setGender(String gender) {
	        this.gender = gender;
	    }

	    public String getNationality() {
	        return nationality;
	    }

	    public void setNationality(String nationality) {
	        this.nationality = nationality;
	    }

	    public String getInterests() {
	        return interests;
	    }

	    public void setInterests(String interests) {
	        this.interests = interests;
	    }

	    public String getLanguagesSpoken() {
	        return languagesSpoken;
	    }

	    public void setLanguagesSpoken(String languagesSpoken) {
	        this.languagesSpoken = languagesSpoken;
	    }
}
	

