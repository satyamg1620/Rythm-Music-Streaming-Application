package com.rythm.musicDemo.dao;

import java.util.List;

import com.rythm.musicDemo.entity.Track;

public interface TrackDAO {
	void save(Track theTrack);

	Track findTrackById(int theId);

	List<Track> findAll();

}
