package com.bridgelabz.fundoonotes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.fundoonotes.dto.LoginDTO;
import com.bridgelabz.fundoonotes.model.UserInfo;
import com.bridgelabz.fundoonotes.repository.UserDAO;
import com.bridgelabz.fundoonotes.response.Response;
import com.bridgelabz.fundoonotes.service.UserService;

@RestController
public class LoginController 
{
	@Autowired
	private UserService service;
	
	@Autowired
	private UserDAO repo;

	@GetMapping("/hi")
	public void getHi() 
	{
		
	}

	@PostMapping("/login")
	public String response(@RequestBody LoginDTO dto)
	{
		boolean is_Login=service.Login(dto);
		if(is_Login) 
		{
		UserInfo user=repo.findOneByemailId(dto.getEmailId());
		
		return new Response().getToken(user);
		}
		else
			
		return  "login failed";
		
	}

}
