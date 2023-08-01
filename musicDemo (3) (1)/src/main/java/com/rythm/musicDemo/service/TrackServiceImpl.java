package com.rythm.musicDemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rythm.musicDemo.dao.TrackDAO;
import com.rythm.musicDemo.dao.TrackRepository;
import com.rythm.musicDemo.entity.Track;

@Service
public class TrackServiceImpl implements TrackService {
	private TrackRepository trackRepository;

	@Autowired
	public TrackServiceImpl(TrackRepository trackRepository) {
		this.trackRepository = trackRepository;
	}

	@Override
	public void save(Track theTrack) {
		trackRepository.save(theTrack);
	}

	@Override
	public Track findTrackById(int theId) {
		return trackRepository.findById(theId).get();
	}

	@Override
	public List<Track> findAll() {
		return trackRepository.findAll();
	}

	@Override
	public void deleteById(int theId) {
		trackRepository.deleteById(null);
	}

	@Override
	public List<Track> findLikedTracksOfPlayListByUsername(String username) {
		// TODO Auto-generated method stub
		List<Object[]> trackIds = trackRepository.findLikedTracksOfPlayListByUsername(username);
		List<Track> trackList = new ArrayList<Track>();
		trackIds.forEach(trackId -> {
			Track track = trackRepository.findById(Integer.valueOf(trackId[0] + "")).get();
			trackList.add(track);
		});

		return trackList;
	}

}
