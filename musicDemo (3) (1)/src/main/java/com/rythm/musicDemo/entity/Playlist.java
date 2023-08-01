package com.rythm.musicDemo.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "playlist")
public class Playlist implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "playlist_name")
	private String playlistName;
	@JsonBackReference
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "username")
	private User user;
	@Column(name = "image")
	private byte[] image;

	@JsonIgnore
	@OneToMany(mappedBy = "playlist", cascade = CascadeType.ALL)
	private List<PlaylistTrack> playlistTracks;

	public Playlist() {

	}

	public Playlist(String playlistName, User user, byte[] image) {
		super();
		this.playlistName = playlistName;
		this.user = user;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlaylistName() {
		return playlistName;
	}

	public void setPlaylistName(String playlistName) {
		this.playlistName = playlistName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public List<PlaylistTrack> getPlaylistTracks() {
		return playlistTracks;
	}

	public void setPlaylistTracks(List<PlaylistTrack> playlistTracks) {
		this.playlistTracks = playlistTracks;
	}

	@Override
	public String toString() {
		return "Playlist [id=" + id + ", playlistName=" + playlistName + ", user=" + user + "]";
	}

}
