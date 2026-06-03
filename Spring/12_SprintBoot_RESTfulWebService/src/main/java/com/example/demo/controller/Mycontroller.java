package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api")
public class Mycontroller 
{
	@Autowired
	private UserService service;
	
	@PostMapping("/user")
	public User addUser( @RequestBody User user)
	{
		return service.createUser(user);
	}
	
	@GetMapping("/user")
	public List<User> getAllUserDetails()
	{
		return service.getAllUsers();
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserDetail(@PathVariable int id)
	{
		User user = service.getUserDetail(id).orElse(null);
		
		if(user != null)
		{
			return ResponseEntity.ok().body(user);
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUserDetails(@PathVariable int id, @RequestBody User user)
	{
		User updateduser = service.updateuserDetails(id, user);
		
		if(updateduser != null)
		{
			return ResponseEntity.ok(updateduser);
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable int id)
	{
		service.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
}
