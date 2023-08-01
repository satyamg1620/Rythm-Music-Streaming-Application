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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "artist")
public class Artist implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int artistId;
	@Column(name = "full_name")
	private String fullName;
	@Column(name = "genre")
	private String genre;
	@Column(name = "Image")
	private byte[] photo;
	
	@JsonIgnore
	@OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
	private List<Follower> followings;
	@JsonIgnore
	@OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
	private List<Album> albums;

	public Artist() {

	}

	public Artist(String fullName, String genre) {
		super();
		this.fullName = fullName;
		this.genre = genre;
//		this.photo = photo;
	}

	public int getArtistId() {
		return artistId;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public List<Follower> getFollowings() {
		return followings;
	}

	public void setFollowings(List<Follower> followings) {
		this.followings = followings;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	@Override
	public String toString() {
		return "Artist [artistId=" + artistId + ", fullName=" + fullName + ", genre=" + genre + "]";
	}

}
