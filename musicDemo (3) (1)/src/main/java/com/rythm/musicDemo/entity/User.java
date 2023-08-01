package com.rythm.musicDemo.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "username")
	private String username;
	@Column(name = "full_name")
	private String fullName;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "mobile_no")
	private String mobileNo;
	@Column(name = "is_premium")
	private boolean isPremium;
	@Column(name = "profile_image")
	private byte[] profileImage;

	@JsonManagedReference
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Playlist> playlists;

	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Follower> followers;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Like> likes;

	public User() {

	}

	public User(String username, String fullName, String email, String password, String mobileNo, boolean isPremium
//			, byte[] profileImage
	) {
		super();
		this.username = username;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.mobileNo = mobileNo;
		this.isPremium = isPremium;
//		this.profileImage = profileImage;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", fullName=" + fullName + ", email=" + email + ", password=" + password
				+ ", mobileNo=" + mobileNo + ", isPremium=" + isPremium + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public boolean isPremium() {
		return isPremium;
	}

	public void setPremium(boolean isPremium) {
		this.isPremium = isPremium;
	}

	public byte[] getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(byte[] profileImage) {
		this.profileImage = profileImage;
	}

	public List<Playlist> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(List<Playlist> playlists) {
		this.playlists = playlists;
	}

	public List<Follower> getFollowers() {
		return followers;
	}

	public void setFollowers(List<Follower> followers) {
		this.followers = followers;
	}

	public List<Like> getLikes() {
		return likes;
	}

	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}

}
