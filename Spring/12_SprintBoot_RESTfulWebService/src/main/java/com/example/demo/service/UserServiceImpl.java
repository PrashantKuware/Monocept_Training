package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService
{	
	@Autowired
	private UserRepository repository;
	
	@Override
	public User createUser(User user)
	{
		return repository.save(user);
	}


	@Override
	public List<User> getAllUsers() 
	{
		return repository.findAll();
	}


	@Override
	public Optional<User> getUserDetail(int id) 
	{
		
		return repository.findById(id);
	}


	@Override
	public User updateuserDetails(int id, User newUser) 
	{
		User userData = repository.findById(id).orElse(null);
		
		if(userData != null)
		{
			return repository.save(newUser);
		}
		else
		{
			  throw new RuntimeException("User not found with id : "+id);
		}
	}


	@Override
	public void deleteUser(int id) 
	{
		repository.deleteById(id);
	}
}
