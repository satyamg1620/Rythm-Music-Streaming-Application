package com.rythm.musicDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rythm.musicDemo.entity.Artist;

public interface ArtistRepository  extends JpaRepository<Artist, Integer>  {
	
}
