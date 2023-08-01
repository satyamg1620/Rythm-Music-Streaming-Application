package com.rythm.musicDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rythm.musicDemo.dao.LikesRepository;
import com.rythm.musicDemo.entity.Like;

import jakarta.transaction.Transactional;
@Service
public class LikeServiceImpl implements LikeService {
	
	private LikesRepository likesRepository;
	
	@Autowired
	public LikeServiceImpl(LikesRepository likesRepository) {
		this.likesRepository = likesRepository;
	}

	@Override
	@Transactional
	public List<Like> findByIdUsername(String username) {
		return likesRepository.findByIdUsername(username);
	}

	@Override
	@Transactional
	public void deleteTrackLike(int trackId, String username) {
		likesRepository.deleteTrackLike(trackId, username);

	}

	@Override
	@Transactional
	public void insertTrackLike(int trackId, String username) {
		likesRepository.insertTrackLike(trackId, username);
	}

	@Override
	@Transactional
	public Like getLike(int trackId, String username) {
		return likesRepository.getLike(trackId, username);
	}

}
