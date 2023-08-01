package com.rythm.musicDemo.service;

import java.util.List;

import com.rythm.musicDemo.entity.Like;

public interface LikeService {
	
	public List<Like> findByIdUsername(String username);
	
	public void deleteTrackLike(int trackId, String username); 
	
	public void insertTrackLike(int trackId, String username);
	
	public Like getLike(int trackId, String username);

}
