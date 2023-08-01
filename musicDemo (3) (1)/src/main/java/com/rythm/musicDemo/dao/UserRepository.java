package com.rythm.musicDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rythm.musicDemo.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

	
	@Modifying
	@Query(value="INSERT INTO Rythm.members (username, password, active) VALUES (:username, :password, 1)", nativeQuery = true)
	public void saveMember(@Param("username") String username, @Param("password") String password);

	@Modifying
	@Query(value="INSERT INTO Rythm.roles (username, role) VALUES (:username, :role)", nativeQuery = true)
	public void saveUserRole(@Param("username") String username, @Param("role") String role);
		
}
