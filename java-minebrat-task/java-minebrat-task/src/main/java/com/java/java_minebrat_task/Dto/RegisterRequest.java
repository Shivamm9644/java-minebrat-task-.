package com.java.java_minebrat_task.Dto;

public record RegisterRequest(
	    String username,
	    String password,
	    String email,
	    String street,
	    String city,
	    String state,
	    String pinCode
	) {}

