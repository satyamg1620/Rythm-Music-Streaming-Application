package com.rythm.musicDemo.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rythm.musicDemo.entity.Album;
import com.rythm.musicDemo.entity.Follower;
import com.rythm.musicDemo.entity.User;
import com.rythm.musicDemo.service.AlbumService;

@RestController
@RequestMapping("/restAlbum")
public class AlbumRestController {
	
private AlbumService albumService;
	
	@Autowired
	public AlbumRestController(AlbumService albumService) {
		this.albumService = albumService;
	}
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to Album page";
	}
	
	@GetMapping("/albumList")
	public String albumList() {
		System.out.println("INSIDE ALBUM LIST");
		List<Album> albums = albumService.findAll();
		for(Album album: albums) {
			System.out.println(album);
		}
		return "ALBUMS";
	}
	
//	@GetMapping("/followerOfUser")
//	public String followerOfUser() {
//		System.out.println("INSIDE followerOfUser LIST ");
//		List<Follower> followers = userService.getYourFollowers();
//		for(Follower follower: followers) {
//			System.out.println(follower);
//		}
//		return "followerOfUser";
//	}

}
