package com.rythm.musicDemo.custom;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class FollowingsCount {
	@Id
	private Integer artistId;
	private Integer count;

	public FollowingsCount(Integer artistId, Integer count) {
		super();
		this.artistId = artistId;
		this.count = count;
	}

	public Integer getArtistId() {
		return artistId;
	}

	public void setArtistId(Integer artistId) {
		this.artistId = artistId;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "FollowingsCount [artistId=" + artistId + ", count=" + count + "]";
	}
	
}
