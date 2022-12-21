package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.usermodel;

public interface IuserRepo<AddUser> {
	
	public usermodel login(usermodel usermodel);
	public usermodel insertusermodel(usermodel usermodel);
	
	public usermodel insertUser(usermodel usermodel);
	public List<usermodel> getAlluser();
	public usermodel updateUser (long id, usermodel user);
	public usermodel deleteUser (long id);
}

