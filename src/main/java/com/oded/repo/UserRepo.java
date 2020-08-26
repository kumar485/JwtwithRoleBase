package com.oded.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oded.model.Users;

public interface UserRepo extends JpaRepository<Users,Integer> {
	@Query("from Users where username=:username")
	Users findByUserName(@Param("username") String username);

	

}
