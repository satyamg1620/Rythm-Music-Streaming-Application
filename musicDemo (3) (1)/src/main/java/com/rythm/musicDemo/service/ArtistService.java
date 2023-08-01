package com.rythm.musicDemo.service;

import java.util.List;

import com.rythm.musicDemo.custom.FollowingsCount;
import com.rythm.musicDemo.entity.Artist;

public interface ArtistService {
	List<Artist> findAll();

	Artist findById(int theId);

	void save(Artist theArtist);

	void deleteById(int theId);
	
	public List<FollowingsCount> countTotalFollowersByIdArtistId();

}
