package com.bridgelabz.fundoonotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bridgelabz.fundoonotes.model.UserInfo;

@Repository
public interface UserDAO extends JpaRepository<UserInfo, Integer>
{
	@Query(value="select * from user_info where email_id= ?", nativeQuery = true)
	UserInfo findOneByemailId(String emailId);
	

}