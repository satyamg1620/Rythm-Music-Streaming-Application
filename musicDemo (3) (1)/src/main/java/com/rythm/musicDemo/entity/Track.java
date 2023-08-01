package com.rythm.musicDemo.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "track")
public class Track implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "track_name")
	private String trackName;
	@Column(name = "duration")
	private int duration;
	@Column(name = "track_path")
	private String trackPath;
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "album_id")
	@JsonIgnore
	private Album album;

	@OneToMany(mappedBy = "track", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Like> likes;

	@OneToMany(mappedBy = "track", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<PlaylistTrack> playlistTracks;

	

	public Track() {

	}

	public Track(String trackName, int duration, String trackPath, Album album) {
		super();
		this.trackName = trackName;
		this.duration = duration;
		this.trackPath = trackPath;
		this.album = album;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTrackName() {
		return trackName;
	}

	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getTrackPath() {
		return trackPath;
	}

	public void setTrackPath(String trackPath) {
		this.trackPath = trackPath;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public List<Like> getLikes() {
		return likes;
	}

	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}
	
	public List<PlaylistTrack> getPlaylistTracks() {
		return playlistTracks;
	}

	public void setPlaylistTracks(List<PlaylistTrack> playlistTracks) {
		this.playlistTracks = playlistTracks;
	}

	@Override
	public String toString() {
		return "Track [id=" + id + ", trackName=" + trackName + ", duration=" + duration + ", trackPath=" + trackPath
				+ ", album=" + album + "]";
	}

}
