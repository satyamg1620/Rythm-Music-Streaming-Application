package com.rythm.musicDemo.dao;

import java.util.List;

import com.rythm.musicDemo.entity.Album;

public interface AlbumDAO {
	
	void save(Album theAlbum);
	Album findAlbumById(int theId);
	List<Album> findAll();

}
