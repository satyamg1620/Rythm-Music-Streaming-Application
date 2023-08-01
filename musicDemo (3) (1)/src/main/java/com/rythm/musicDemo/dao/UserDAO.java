package com.rythm.musicDemo.dao;

import java.util.List;

import com.rythm.musicDemo.entity.Follower;
import com.rythm.musicDemo.entity.Like;
import com.rythm.musicDemo.entity.User;


public interface UserDAO {
	
	void save(User theUser);
	User findUserByUsername(String userName);
	List<User> findAll();
	List<Follower> getYourFollowers();
	List<Like> getYourLikes();
	

}
