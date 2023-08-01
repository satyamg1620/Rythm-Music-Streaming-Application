package com.rythm.musicDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rythm.musicDemo.dao.FollowerRepository;
import com.rythm.musicDemo.dao.LikesRepository;
import com.rythm.musicDemo.dao.PlaylistRepository;
import com.rythm.musicDemo.dao.UserRepository;
import com.rythm.musicDemo.entity.Follower;
import com.rythm.musicDemo.entity.Like;
import com.rythm.musicDemo.entity.Playlist;
import com.rythm.musicDemo.entity.User;

@Service
public class UserServiceImpl implements UserService {

//	private UserDAO userDAO;
//	@Autowired
//	public UserServiceImpl(UserDAO theUserDAO) {
//		userDAO = theUserDAO;
//	}
	
	private UserRepository userRepository;
	private PlaylistRepository playlistRepository;
	private LikesRepository likesRepository;
	private FollowerRepository followerRepository;
	@Autowired
	public UserServiceImpl(UserRepository userRepository, PlaylistRepository playlistRepository, LikesRepository likesRepository, FollowerRepository followerRepository) {
		
		this.userRepository = userRepository;
		this.playlistRepository = playlistRepository;
		this.likesRepository = likesRepository;
		this.followerRepository = followerRepository;
	}
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
//		return userDAO.findAll();
		System.out.println("fkjhbfnkrnnoknom");
		return userRepository.findAll();
	}

	@Override
	public User findByUsername(String theUsername) {
		// TODO Auto-generated method stub
//		return userDAO.findUserByUsername(theUsername);
		return userRepository.findById(theUsername).get();
	}

	@Override
	public void save(User theUser) {
		// TODO Auto-generated method stub
		userRepository.save(theUser);
				
	}

	@Override
	public void deleteByUsername(String theUsername) {
		// TODO Auto-generated method stub
		userRepository.deleteById(theUsername);
	}

	@Override
	public List<Follower> getYourFollowers(String username) {
//		return userRepository.getYourFollowers();
		return followerRepository.findByIdUsername(username);
	}

	@Override
	public List<Like> getYourLikes(String username) {
		// TODO Auto-generated method stub
//		return userDAO.getYourLikes();
		return likesRepository.findByIdUsername(username);
	}

	@Override
	public List<Playlist> getYourPlaylists(User user) {
		// TODO Auto-generated method stub
		
		return playlistRepository.findByUser(user);
	}

	@Override
	public User findUserById(String username) {
		// TODO Auto-generated method stub
		return userRepository.findById(username).get();
	}

}
