package com.bridgelabz.fundoonotes.serviceImpl;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundoonotes.dto.LoginDTO;
import com.bridgelabz.fundoonotes.dto.UserDTO;
import com.bridgelabz.fundoonotes.model.UserInfo;
import com.bridgelabz.fundoonotes.repository.UserDAO;
import com.bridgelabz.fundoonotes.service.UserService;
import com.bridgelabz.fundoonotes.utility.Utility;

@Service
public class UserServiceImpl implements UserService 
{
	@Autowired
	private UserDAO userDAO;
	
	private ModelMapper mapper = new ModelMapper();

	public boolean Register(UserDTO userdto) 
	{
		mapper.getConfiguration()
        .setMatchingStrategy(MatchingStrategies.STRICT);
		UserInfo user = mapper.map(userdto, UserInfo.class);
		user.setPassword(Utility.encoder(user.getPassword()));
		user.setCreatedate();
		userDAO.save(user);
		return true;
	}

	@Override
	public boolean Login(LoginDTO dto)
	{
		
		UserInfo u=userDAO.findOneByemailId(dto.getEmailId());

		if(u!=null)
		{
			if(u.getEmailId().equals(dto.getEmailId()) && Utility.passwordMatcher(dto.getPassword(), u.getPassword()))
			{				
				return true;
			}
			else
			{
				return false;
			}
		}
		
		return false;
	}

	@Override
	public UserInfo getUser(String username) {
		return userDAO.findOneByemailId(username);
	}

	
}
