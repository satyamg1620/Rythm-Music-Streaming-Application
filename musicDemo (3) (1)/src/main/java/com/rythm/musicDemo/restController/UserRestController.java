package com.rythm.musicDemo.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rythm.musicDemo.entity.Follower;
import com.rythm.musicDemo.entity.Like;
import com.rythm.musicDemo.entity.Playlist;
import com.rythm.musicDemo.entity.User;
import com.rythm.musicDemo.service.UserService;

@RestController
@RequestMapping("/restUser")
public class UserRestController {

	private UserService userService;

	@Autowired
	public UserRestController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to user page";
	}

	public User findUserById(String username) {
		return userService.findUserById(username);
	}

	@GetMapping("/userList")
	public String userList() {
		System.out.println("INSIDE USER LIST");
		List<User> users = userService.findAll();
		for (User user : users) {
			System.out.println(user.getFollowers());
		}
		return "USERS";
	}

	@GetMapping("/myMusic")
	public List<Playlist> myMusic() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		System.out.println(username);
		User user = userService.findByUsername(username);
		List<Playlist> playlists = userService.getYourPlaylists(user);
		return playlists;
	}

	@GetMapping("/followerOfUser/{username}")
	public String followerOfUser(@PathVariable("username") String username) {
		System.out.println("INSIDE followerOfUser LIST ");
		User user = userService.findByUsername(username);
		List<Follower> followers = userService.getYourFollowers(username);
		System.out.println("FOLLOWERS:" + followers);
		for (Follower follower : followers) {
			System.out.println(follower);
		}
		return "followerOfUser";
	}

	@GetMapping("/likesOfUser/{username}")
	public String likesOfUser(@PathVariable("username") String username) {
		System.out.println("INSIDE likesOfUser LIST ");
		User user = userService.findByUsername(username);
		List<Like> likes = userService.getYourLikes(username);
		System.out.println("LIKES:" + likes);
		for (Like like : likes) {
			System.out.println("Inside Like by users list");

			System.out.println(like);
		}
		return "likeOfUser";
	}

	@GetMapping("/playlistsOfUser/{username}")
	public String playlistsOfUser(@PathVariable("username") String username) {
		System.out.println("INSIDE playlistsOfUser LIST ");
		User user = userService.findByUsername(username);
		List<Playlist> playlists = userService.getYourPlaylists(user);
		for (Playlist playlist : playlists) {
			System.out.println(playlist);
		}
		return "playlistsOfUser";
	}

}
