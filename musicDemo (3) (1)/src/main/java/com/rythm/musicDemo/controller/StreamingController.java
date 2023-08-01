package com.rythm.musicDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rythm.musicDemo.entity.Playlist;
import com.rythm.musicDemo.entity.Track;
import com.rythm.musicDemo.service.PlaylistService;
import com.rythm.musicDemo.service.TrackService;
import com.rythm.musicDemo.service.UserService;

@Controller
public class StreamingController {
	
	private UserService userService;
	private PlaylistService playlistService;
	private TrackService trackService;
	@Autowired
	public StreamingController(UserService userService, PlaylistService playlistService, TrackService trackService) {
		this.userService = userService;
		this.playlistService = playlistService;
		this.trackService = trackService;
	}
	
	@GetMapping("/streamingPlaylist")
	public String playlist(@RequestParam("id") int theId, Model theModel) {
		// delete the employee
		Playlist playlist = playlistService.findPlaylistById(theId);
		List<Track> tracks = playlistService.findTracksByPlaylistId(theId);
		theModel.addAttribute("playlistId", playlist.getId());
		theModel.addAttribute("tracks", tracks);
		for(Track track: tracks)
				System.out.println(track);
		// redirect to /user/list
		return "library/playlist";
	}
	
	@GetMapping("/streamingMyLikes")
	public String myLikes(Model theModel) {
		// delete the employee
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		System.out.println(username);
//		Playlist playlist = playlistService.findPlaylistById(theId);
		List<Track> tracks = trackService.findLikedTracksOfPlayListByUsername(username);
//		theModel.addAttribute("playlistId", playlist.getId());
//		theModel.addAttribute("tracks", tracks);
//		for(Track track: tracks)
//				System.out.println(track);
		// redirect to /user/list
		return "library/likes";
	}

}
