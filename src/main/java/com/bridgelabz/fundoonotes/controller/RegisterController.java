package com.bridgelabz.fundoonotes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.fundoonotes.dto.UserDTO;
import com.bridgelabz.fundoonotes.response.Response;
import com.bridgelabz.fundoonotes.service.UserService;

@RestController
public class RegisterController {

	@Autowired
	private UserService service;

	@PostMapping("/User")
	public Response userresponse(@RequestBody UserDTO userdto)
	{
		boolean is_created = false;
		
	
		if (userdto.getPassword().equals(userdto.getPassword2())) 
		{
			is_created = service.Register(userdto);
		}
		if (is_created)
			return new Response("successfully created", 200, userdto);
		else
			return new Response("Error found", 400, userdto);

	}

}
