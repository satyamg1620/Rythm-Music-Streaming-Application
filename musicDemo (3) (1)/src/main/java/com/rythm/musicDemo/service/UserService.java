package com.rythm.musicDemo.service;

import java.util.List;

import com.rythm.musicDemo.entity.Follower;
import com.rythm.musicDemo.entity.Like;
import com.rythm.musicDemo.entity.Playlist;
import com.rythm.musicDemo.entity.User;

public interface UserService {

	List<User> findAll();

	User findByUsername(String theUsername);

	void save(User theUser);

	void deleteByUsername(String theUsername);

	List<Follower> getYourFollowers(String username);

	List<Like> getYourLikes(String username);

	List<Playlist> getYourPlaylists(User user);

	User findUserById(String username);

}
