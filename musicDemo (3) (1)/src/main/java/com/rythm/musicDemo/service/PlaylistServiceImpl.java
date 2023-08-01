package com.rythm.musicDemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rythm.musicDemo.dao.PlaylistRepository;
import com.rythm.musicDemo.dao.TrackRepository;
import com.rythm.musicDemo.entity.Playlist;
import com.rythm.musicDemo.entity.Track;

@Service
public class PlaylistServiceImpl implements PlaylistService {

	private PlaylistRepository playlistRepository;
	private TrackRepository trackRepository;

	public PlaylistServiceImpl(PlaylistRepository playlistRepository, TrackRepository trackRepository) {
		this.playlistRepository = playlistRepository;
		this.trackRepository = trackRepository;
	}

	@Override
	public void save(Playlist thePlaylist) {
		// TODO Auto-generated method stub

	}

	@Override
	public Playlist findPlaylistById(int theId) {
		return playlistRepository.findById(theId).get();
	}

	@Override
	public List<Playlist> findAll() {
		return playlistRepository.findAll();
	}

	@Override
	public List<Track> findTracksByPlaylistId(int playlistId) {
		// TODO Auto-generated method stub
		List<Object[]> trackIds = playlistRepository.findTracksOfPlayList(playlistId);
		List<Track> trackList = new ArrayList<Track>();
		trackIds.forEach(trackId -> {
			Track track = trackRepository.findById(Integer.valueOf(trackId[0]+"")).get();
			trackList.add(track);
		});
		
		return trackList;
	}

}
