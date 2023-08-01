package com.rythm.musicDemo.entity;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "playlist_track")
public class PlaylistTrack implements Serializable{

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PlaylistTrackId playlistTrackId;

//	@Column(name = "Order")
//	private int order;

	@MapsId("playlistId")
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "playlist_id")
	private Playlist playlist;

	@MapsId("trackId")
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "track_id")
	private Track track;

	public PlaylistTrack() {

	}

	public PlaylistTrack(PlaylistTrackId playlistTrackId, Playlist playlist, Track track) {
		super();
		this.playlistTrackId = playlistTrackId;
//		this.order = order;
		this.playlist = playlist;
		this.track = track;
	}

	public PlaylistTrackId getPlaylistTrackId() {
		return playlistTrackId;
	}

	public void setPlaylistTrackId(PlaylistTrackId playlistTrackId) {
		this.playlistTrackId = playlistTrackId;
	}

//	public int getOrder() {
//		return order;
//	}
//
//	public void setOrder(int order) {
//		this.order = order;
//	}

	public Playlist getPlaylist() {
		return playlist;
	}

	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
	}

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

	@Override
	public String toString() {
		return "PlaylistTrack [playlistTrackId=" + playlistTrackId + ", order=" + "order" + ", playlist=" + playlist
				+ ", track=" + track + "]";
	}

}
