package com.rythm.musicDemo.dao;

import java.util.List;

import com.rythm.musicDemo.entity.Artist;

public interface ArtistDAO {

	void save(Artist theArtist);

	Artist findArtistById(int theId);

	List<Artist> findAll();

}
