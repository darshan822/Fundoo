package com.bridgelabz.fundoonotes.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.bridgelabz.fundoonotes.dto.ForgotDTO;
import com.bridgelabz.fundoonotes.model.UserInfo;
import com.bridgelabz.fundoonotes.repository.UserDAO;
import com.bridgelabz.fundoonotes.service.ForgotService;

public class ForgotServiceImpl implements ForgotService
{
	@Autowired
	private UserDAO userdao;

	@Override
	public boolean getmail(ForgotDTO forgotDTO) 
	{
		UserInfo u=userdao.findOneByemailId(forgotDTO.getEmailId());
		if(u!=null)
		{
			if(u.getEmailId().equals(forgotDTO.getEmailId()))
					return true;
			else 
				return false;
		}
		return false;
		
	}

	
}
