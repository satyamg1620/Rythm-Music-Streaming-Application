package com.rythm.musicDemo.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class LikeId implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;
	private int trackId;

	public LikeId() {

	}

	public LikeId(String username, int trackId) {
		super();
		this.username = username;
		this.trackId = trackId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getTrackId() {
		return trackId;
	}

	public void setTrackId(int trackId) {
		this.trackId = trackId;
	}

	@Override
	public String toString() {
		return "LikeId [username=" + username + ", trackId=" + trackId + "]";
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof LikeId))
			return false;
		LikeId that = (LikeId) o;
		return Objects.equals(getUsername(), that.getUsername())
				&& Objects.equals(getTrackId(), that.getTrackId());
	}

}
