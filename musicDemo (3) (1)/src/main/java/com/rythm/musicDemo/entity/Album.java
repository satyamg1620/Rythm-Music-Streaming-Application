package com.rythm.musicDemo.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

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
@Table(name = "album")
public class Album implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "album_name")
	private String albumName;
	@Column(name = "release_date")
	private Date releaseDate;
	@Column(name = "photo")
	private byte[] photo;
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, 
							CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "artist_id")
	private Artist artist;
	@OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
	private List<Track> tracks;
	
	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}

	public Album() {
		
	}

	public Album(String albumName, Date releaseDate, Artist artist) {
		super();
		this.albumName = albumName;
		this.releaseDate = releaseDate;
		this.artist = artist;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	@Override
	public String toString() {
		return "Album [id=" + id + ", albumName=" + albumName + ", releaseDate=" + releaseDate + ", artist=" + artist
				+ "]";
	}
	
	

}
