package com.rythm.musicDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rythm.musicDemo.entity.Playlist;
import com.rythm.musicDemo.entity.Track;
import com.rythm.musicDemo.entity.User;
import com.rythm.musicDemo.service.PlaylistService;
import com.rythm.musicDemo.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	private UserService userService;
	private PlaylistService playlistService;
	@Autowired
	public UserController(UserService userService, PlaylistService playlistService) {
		this.userService = userService;
		this.playlistService = playlistService;
	}
	
	@GetMapping("/list")
	public String listUsers(Model theModel) {
		// add to the spring model
		List<User> theUsers = userService.findAll();
		theModel.addAttribute("users", theUsers);

		return "users/list-users";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		User theUser = new User();
		theModel.addAttribute("user", theUser);
		return "users/user-form";
	}

	@PostMapping("/save")
	public String saveUser(@ModelAttribute("user") User theUser) {
		// save the employee
		userService.save(theUser);

		// use a redirect to prevent duplicate submissions
		return "redirect:/users/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("username") String username, Model theModel) {
		// get the employee for the service
		User theUser = userService.findByUsername(username);

		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("user", theUser);

		// send over to our form
		return "users/user-form";

	}

	@GetMapping("/delete")
	public String delete(@RequestParam("username") String theId) {
		// delete the employee
		userService.deleteByUsername(theId);

		// redirect to /user/list
		return "redirect:/users/list";
	}
	
	@RequestMapping("/myMusic")
	public String myMusic(Model theModel) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		System.out.println(username);
		User user = userService.findByUsername(username);
		List<Playlist> playlists = userService.getYourPlaylists(user);
		theModel.addAttribute("playlists", playlists);
		return "library/myMusic";
	}
	
	
	@RequestMapping("/myPodcast")
	public String myPodcast(Model theModel) {
		
		return "library/myPodcast";
	}

}
