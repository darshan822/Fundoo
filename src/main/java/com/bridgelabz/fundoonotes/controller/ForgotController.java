package com.bridgelabz.fundoonotes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bridgelabz.fundoonotes.dto.ForgotDTO;
import com.bridgelabz.fundoonotes.model.UserInfo;
import com.bridgelabz.fundoonotes.repository.UserDAO;
import com.bridgelabz.fundoonotes.service.ForgotService;

public class ForgotController 
{
	@Autowired
	private UserDAO userdao;
	
	@Autowired
	private ForgotService forgotservice;
	
	@PostMapping("/forgot")
	public String response(@RequestBody ForgotDTO forgotdto)
	{
		boolean is_forgot=forgotservice.getmail(forgotdto);
		if(is_forgot)
		{
			UserInfo user=userdao.findOneByemailId(forgotdto.getEmailId());
			
		return null;
		}
		else
		
		return "something went wrong";
	}

}
