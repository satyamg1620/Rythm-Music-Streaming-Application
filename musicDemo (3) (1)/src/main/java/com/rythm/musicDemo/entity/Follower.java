package com.rythm.musicDemo.entity;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "follower")
public class Follower implements Serializable{
	private static final long serialVersionUID = 1L;


	@EmbeddedId
	private FollowerId id;
	
	
	@MapsId("artistId")
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, 
			CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "artist_id")
	private Artist artist;
	
	@MapsId("username")
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, 
			CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "username")
	private User user;
	
	public Follower() {
		
	}
	@Autowired
	public Follower(FollowerId followerId, Artist artist, User user) {
		super();
		this.id = followerId;
		this.artist = artist;
		this.user = user;
	}

	public FollowerId getFollowerId() {
		return id;
	}

	public void setFollowerId(FollowerId followerId) {
		this.id = followerId;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public User getUsername() {
		return user;
	}

	public void setUsername(User username) {
		this.user = username;
	}

	@Override
	public String toString() {
		return "Follower [followerId=" + id + ", artist=" + artist + ", username=" + user + "]";
	}
	
	
	
}
