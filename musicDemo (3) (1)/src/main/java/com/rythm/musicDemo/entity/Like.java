package com.rythm.musicDemo.entity;
import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "likes")
public class Like implements Serializable{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LikeId id;
	
	@Column(name ="like_Date_Time")
	private Timestamp likeDateTime;
	
	@MapsId("trackId")
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, 
			CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "track_id")
//	@JsonIgnore
	private Track track;
	
	@MapsId("username")
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, 
			CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "username")
//	@JsonIgnore
	private User user;
	
	public Like() {
		
	}

	public Like(Track track, User user) {
		super();
//		this.id = likeId;
		this.id = new LikeId(user.getUsername(), track.getId());
//		this.likeDateTime = likeDateTime;
		this.track = track;
		this.user = user;
	}

	public LikeId getLikeId() {
		return id;
	}

	public void setLikeId(LikeId likeId) {
		this.id = likeId;
	}

	public Timestamp getLikeDateTime() {
		return likeDateTime;
	}

	public void setLikeDateTime(Timestamp likeDateTime) {
		this.likeDateTime = likeDateTime;
	}

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Like [likeId=" + id + ", likeDateTime=" + likeDateTime + ", track=" + track + ", user=" + user
				+ "]";
	}
	
	
	
	

}
