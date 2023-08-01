package com.rythm.musicDemo.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rythm.musicDemo.entity.Like;
import com.rythm.musicDemo.service.LikeService;
import com.rythm.musicDemo.service.TrackService;
import com.rythm.musicDemo.service.UserService;

@CrossOrigin(origins = "**")
@RestController
@RequestMapping("/likeRest")
public class LikeRestController {

	private UserService userService;
	private TrackService trackService;
	private LikeService likeService;

	@Autowired
	public LikeRestController(UserService userService, TrackService trackService, LikeService likeService) {
		this.userService = userService;
		this.trackService = trackService;
		this.likeService = likeService;
	}

//	@PostMapping("/likes/{id}")
//	public Like addTrackToLiked(@PathVariable("id") int theId) {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		String username = authentication.getName();
//		User user = userService.findByUsername(username);
//		Track track = trackService.findTrackById(theId);
//		Like like = new Like(track, user);
//		return like;
//	}

	@GetMapping("/likesList")
	public List<Like> findByIdUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		return likeService.findByIdUsername(username);
	}

	@GetMapping("/likes/del/{id}")
	public ResponseEntity<?> deleteTrackLike(@PathVariable("id") int trackId) {
		System.out.println("Inside deleteTrackLike");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		likeService.deleteTrackLike(trackId, username);
		if (likeService.getLike(trackId, username) == null)
			return ResponseEntity.ok("Success");
		return ResponseEntity.badRequest().body("Failure");

	}

	@GetMapping("/likes/in/{id}")
	public ResponseEntity<?> insertTrackLike(@PathVariable("id") int trackId) {
		System.out.println("Inside insertTrackLike");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		likeService.insertTrackLike(trackId, username);
		if (likeService.getLike(trackId, username) != null)
			return ResponseEntity.ok("Success");
		return ResponseEntity.badRequest().body("Failure");
	}

	@GetMapping("/likes/find")
	public ResponseEntity<?> getLike(@RequestBody int trackId) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		return ResponseEntity.ok(likeService.getLike(trackId, username));
	}

}
