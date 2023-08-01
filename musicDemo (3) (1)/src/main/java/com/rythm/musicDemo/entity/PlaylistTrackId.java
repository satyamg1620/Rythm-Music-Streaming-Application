package com.rythm.musicDemo.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class PlaylistTrackId implements Serializable {

	private static final long serialVersionUID = 1L;

	private int playlistId;
	private int trackId;

	public PlaylistTrackId() {

	}

	public PlaylistTrackId(int playlistId, int trackId) {
		super();
		this.playlistId = playlistId;
		this.trackId = trackId;
	}

	public int getPlaylistId() {
		return playlistId;
	}

	public void setPlaylistId(int playlistId) {
		this.playlistId = playlistId;
	}

	public int getTrackId() {
		return trackId;
	}

	public void setTrackId(int trackId) {
		this.trackId = trackId;
	}

	@Override
	public String toString() {
		return "PlaylistTrackId [playlistId=" + playlistId + ", trackId=" + trackId + "]";
	}

}
