package com.rythm.musicDemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rythm.musicDemo.entity.Follower;
import com.rythm.musicDemo.entity.Like;
import com.rythm.musicDemo.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class UserDAOImpl implements UserDAO {

	private EntityManager entityManager;
	@Autowired
	public UserDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void save(User theUser) {
		// TODO Auto-generated method stub

	}

	@Override
	public User findUserByUsername(String userName) {
		// TODO Auto-generated method stub
		return entityManager.find(User.class, userName);
	}

	@Override
	public List<User> findAll() {
		TypedQuery<User> theQuery = entityManager.createQuery("from User where fullName='Satyam Gupta'", User.class);
		List<User> users = theQuery.getResultList();
		for (User user: users) {
			System.out.println(user);
		}
		return users;
	}

	@Override
	public List<Follower> getYourFollowers() {
		TypedQuery<Follower> theQuery = entityManager.createQuery("FROM Follower", Follower.class);
		return theQuery.getResultList();
	}

	@Override
	public List<Like> getYourLikes() {
		TypedQuery<Like> theQuery = entityManager.createQuery("FROM Like", Like.class);
		return theQuery.getResultList();
	}

}
