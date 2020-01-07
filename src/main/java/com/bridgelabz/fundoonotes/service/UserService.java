package com.bridgelabz.fundoonotes.service;


import org.springframework.stereotype.Component;

import com.bridgelabz.fundoonotes.dto.LoginDTO;
import com.bridgelabz.fundoonotes.dto.UserDTO;
import com.bridgelabz.fundoonotes.model.UserInfo;

@Component
public interface UserService 
{
	
boolean Register(UserDTO userdto);

boolean Login(LoginDTO dto);

UserInfo getUser(String username);


}
