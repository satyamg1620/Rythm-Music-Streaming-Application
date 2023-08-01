package com.rythm.musicDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rythm.musicDemo.entity.Like;
import com.rythm.musicDemo.service.LikeService;

@Controller
@RequestMapping("/likes")
public class LikesController {

	private LikeService likeService;

	@Autowired
	public LikesController(LikeService likeService) {
		this.likeService = likeService;
	}

	public List<Like> findByIdUsername(String username) {
		return likeService.findByIdUsername(username);
	}

	public void deleteTrackLike(int trackId, String username) {
		likeService.deleteTrackLike(trackId, username);

	}

	public void insertTrackLike(int trackId, String username) {
		likeService.insertTrackLike(trackId, username);
	}

	public Like getLike(int trackId, String username) {
		return likeService.getLike(trackId, username);
	}

}
