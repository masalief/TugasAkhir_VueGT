package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.usermodel;
import com.example.demo.repository.IuserRepo;
import com.example.demo.service.IuserService;

@Service
public class userService implements IuserService{
	@Autowired
	IuserRepo iuserRepo;
	
	@Override
	public usermodel insertUser(usermodel usermodel) {
		// TODO Auto-generated method stub
		return iuserRepo.insertUser(usermodel) ;
	}

	@Override
	public List<usermodel> getAlluser() {
		// TODO Auto-generated method stub
		return iuserRepo.getAlluser();
	}

	@Override
	public usermodel updateUser(long id, usermodel user) {
		// TODO Auto-generated method stub
		return iuserRepo.updateUser(id, user);
	}

	@Override
	public usermodel deleteUser(long id) {
		// TODO Auto-generated method stub
		return iuserRepo.deleteUser(id);
	}

	@Override
	public usermodel insertusermodel(usermodel usermodel) {
		// TODO Auto-generated method stub
		return iuserRepo.insertusermodel(usermodel);
	}

	@Override
	public usermodel login(usermodel usermodel) {
		// TODO Auto-generated method stub
		return iuserRepo.login(usermodel);
	}

}
