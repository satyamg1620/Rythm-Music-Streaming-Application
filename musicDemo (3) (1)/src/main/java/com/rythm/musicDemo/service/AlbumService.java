package com.rythm.musicDemo.service;

import java.util.List;

import com.rythm.musicDemo.entity.Album;

public interface AlbumService {
	void save(Album theAlbum);
	Album findAlbumById(int theId);
	List<Album> findAll();
}
