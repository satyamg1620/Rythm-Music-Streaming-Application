package com.rythm.musicDemo.service;

import java.util.List;

import com.rythm.musicDemo.entity.Playlist;
import com.rythm.musicDemo.entity.Track;

public interface PlaylistService {

	void save(Playlist thePlaylist);

	Playlist findPlaylistById(int theId);

	List<Playlist> findAll();
	
	List<Track> findTracksByPlaylistId(int playlistId);

}
