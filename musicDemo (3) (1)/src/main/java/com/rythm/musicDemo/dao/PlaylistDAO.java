package com.rythm.musicDemo.dao;

import java.util.List;

import com.rythm.musicDemo.entity.Playlist;

public interface PlaylistDAO {

	void save(Playlist thePlaylist);

	Playlist findPlaylistById(int theId);

	List<Playlist> findAll();

}
