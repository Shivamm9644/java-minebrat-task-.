package com.java.java_minebrat_task.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity

public class Address {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String street;
	    private String city;
	    private String state;
	    private String pinCode;

	    @OneToOne
	    @JoinColumn(name = "user_id")
	    private UserEntity user;
	    

		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getStreet() {
			return street;
		}


		public void setStreet(String street) {
			this.street = street;
		}


		public String getCity() {
			return city;
		}


		public void setCity(String city) {
			this.city = city;
		}


		public String getState() {
			return state;
		}


		public void setState(String state) {
			this.state = state;
		}


		public String getPinCode() {
			return pinCode;
		}


		public void setPinCode(String pinCode) {
			this.pinCode = pinCode;
		}


		public UserEntity getUser() {
			return user;
		}


		public void setUser(UserEntity user) {
			this.user = user;
		}


		
	}

