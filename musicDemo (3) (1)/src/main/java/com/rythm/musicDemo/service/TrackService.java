package com.rythm.musicDemo.service;

import java.util.List;

import com.rythm.musicDemo.entity.Track;

public interface TrackService {
	void save(Track theTrack);

	Track findTrackById(int theId);

	List<Track> findAll();

	void deleteById(int theId);
	
	public List<Track> findLikedTracksOfPlayListByUsername(String username);

}
