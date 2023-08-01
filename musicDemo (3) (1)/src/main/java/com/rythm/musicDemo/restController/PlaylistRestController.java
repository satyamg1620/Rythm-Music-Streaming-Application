package com.rythm.musicDemo.restController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rythm.musicDemo.entity.Playlist;
import com.rythm.musicDemo.entity.User;
import com.rythm.musicDemo.service.PlaylistService;

@RestController
@RequestMapping("/restPlaylist")
public class PlaylistRestController {
	
	private PlaylistService  playlistService;
	
	public PlaylistRestController(PlaylistService  playlistService) {
		this.playlistService = playlistService;
	}
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome To PlayList page";
	}
	
	@GetMapping("/playlistList")
	public String playlistList() {
		System.out.println("INSIDE PLAYLIST LIST");
		List<Playlist> playlists = playlistService.findAll();
		for (Playlist playlist : playlists) {
			System.out.println("COUNT");
			System.out.println(playlist.getPlaylistTracks());
		}
		return "PLAYLISTS";
	}

}
