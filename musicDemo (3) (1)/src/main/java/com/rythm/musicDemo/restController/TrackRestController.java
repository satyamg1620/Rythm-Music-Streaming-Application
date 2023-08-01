package com.rythm.musicDemo.restController;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rythm.musicDemo.entity.Playlist;
import com.rythm.musicDemo.entity.Track;
import com.rythm.musicDemo.service.PlaylistService;
import com.rythm.musicDemo.service.TrackService;

@RestController
@RequestMapping("/restTrack")
public class TrackRestController {

	private TrackService trackService;
	private PlaylistService playlistService;

	@Autowired
	public TrackRestController(TrackService trackService, PlaylistService playlistService) {
		this.trackService = trackService;
		this.playlistService = playlistService;
	}

	@GetMapping("/welcome")
	@RequestMapping(value = "/welcome/{characterId}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_OCTET_STREAM_VALUE })
	public String welcome(Model theModel) throws IOException {

		System.out.println("Working Directory = " + System.getProperty("user.dir"));
		ClassPathResource companyDataResource = new ClassPathResource("/musicFileSystem/Coldplay_Hymn.mp3");

		File file = companyDataResource.getFile();
		theModel.addAttribute("theSong", file.getCanonicalPath());
		System.out.println("Canonical Path: " + file.getCanonicalPath());
		System.out.println("Path: " + file.getPath());
		System.out.println("Absolute Path: " + file.getAbsolutePath());

		System.out.println("Filename: " + file.getName());

		System.out.println("Executable: " + file.canExecute());

		System.out.println("Readable: " + file.canRead());

//	    String content = new String(Files.readAllBytes(file.toPath()));

//	    System.out.println(content);
		return "index";
	}

//	@GetMapping("/trackList")
//	public String trackList(Model model) {
//		System.out.println("INSIDE TRACK LIST");
//		List<String> trackNames = new ArrayList<String>();
//		List<String> trackPaths = new ArrayList<String>();
//		List<Track> tracks = trackService.findAll();
//		for (Track track : tracks) {
//			System.out.println(track);
//			trackNames.add(track.getTrackName());
//			trackPaths.add(track.getTrackPath());
//		}
//
//		model.addAttribute("trackNames", trackNames);
//		model.addAttribute("trackPaths", trackPaths);
//		return "index";
//	}
	
//	@GetMapping("/trackList")
//	public ResponseEntity<List<Track>> trackList() {
//		System.out.println("INSIDE TRACK LIST");
//		List<Track> tracks = trackService.findAll();
//		for (Track track : tracks) {
//			System.out.println(track);
//		}
//		return ResponseEntity.ok(tracks);
//	}
	
	@GetMapping("/tracks")
	public List<Track> getTracks() {
		System.out.println("INSIDE TRACK LIST");
		List<Track> tracks = trackService.findAll();
		for (Track track : tracks) {
			System.out.println(track);
			
		}
		return tracks;
	}
	
	@GetMapping("/playlist/{id}")
	public List<Track> playListTracks(@PathVariable("id") int theId) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		System.out.println(username);
		Playlist playlist = playlistService.findPlaylistById(theId);
		List<Track> tracks = playlistService.findTracksByPlaylistId(theId);
	
		return tracks;
	}
	@GetMapping("/likes")
	public List<Track> getLikedTracks() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		System.out.println(username);
		List<Track> tracks = trackService.findLikedTracksOfPlayListByUsername(username);
		
		return tracks;
	}
	@GetMapping("/likesId")
	public List<Integer> getLikedTracksId() {
		System.out.println("INSIDE LIKED IS");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		System.out.println(username);
		List<Track> tracks = trackService.findLikedTracksOfPlayListByUsername(username);
		List<Integer> likedTracksId = new ArrayList<Integer>();
		for(Track track: tracks) {
			likedTracksId.add(track.getId());
			System.out.println(track.getId());
		}
			
		return likedTracksId;
	}
	
	
	
//	@GetMapping("/tracks")
//	public Track getTracks() {
//		System.out.println("INSIDE TRACK LIST");
//		List<Track> tracks = trackService.findAll();
//		List<Track> tracks2 = new ArrayList<Track>();
//		for (Track track : tracks) {
//			System.out.println(track);
//			
//		}
//		tracks2.add(tracks.get(0));
//		return tracks.get(8);
//	}

}
