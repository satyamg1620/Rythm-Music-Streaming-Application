package com.rythm.musicDemo.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rythm.musicDemo.custom.FollowingsCount;
import com.rythm.musicDemo.entity.Artist;
import com.rythm.musicDemo.service.ArtistService;

@RestController
@RequestMapping("/restArtist")
public class ArtistRestController {
	
private ArtistService artistService;
	
	@Autowired
	public ArtistRestController(ArtistService artistService) {
		this.artistService = artistService;
	}
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to Artist page";
	}
	
	@GetMapping("/artistList")
	public String artistList() {
		System.out.println("INSIDE ARTIST LIST");
		List<Artist> artists = artistService.findAll();
		for(Artist artist: artists) {
			System.out.println(artist);
		}
		return "ARTISTS";
	}
	@GetMapping("/artistFollowers")
	public List<FollowingsCount> artistFollowers() {
		return artistService.countTotalFollowersByIdArtistId();
	}
	

}
