package com.example.demo.service;

import java.util.List;

import com.example.demo.model.usermodel;
public interface IuserService {
	public usermodel insertusermodel(usermodel usermodel);
	public usermodel login(usermodel usermodel);
	
	public usermodel insertUser(usermodel usermodel);
	public List<usermodel> getAlluser();
	public usermodel updateUser (long id, usermodel user);
	public usermodel deleteUser (long id);
}
