package com.rythm.musicDemo.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class FollowerId implements Serializable {

private static final long serialVersionUID = 1L;
	//	@Column(name = "username")
	private String username;
//	@Column(name = "artist_id")
	private String artistId;

	public FollowerId() {
		System.out.println("Inside unparametrized constrctor Follower id");
	}

	public FollowerId(String username, String artistId) {
		super();
		this.username = username;
		this.artistId = artistId;
		System.out.println("Inside parametrized constrctor Follower id");
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getArtistId() {
		return artistId;
	}

	public void setArtistId(String artistId) {
		this.artistId = artistId;
	}

	@Override
	public String toString() {
		return "FollowerId [username=" + username + ", artistId=" + artistId + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof FollowerId))
			return false;
		FollowerId that = (FollowerId) o;
		return Objects.equals(getUsername(), that.getUsername())
				&& Objects.equals(getArtistId(), that.getArtistId());
	}

}
