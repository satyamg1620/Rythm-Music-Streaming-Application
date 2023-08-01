package com.rythm.musicDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/library")
public class LibraryController {
	
	@RequestMapping("/myMusic")
	public String myMusic(Model theModel) {
		
		return "library/myMusic";
	}
	
	@RequestMapping("/likes")
	public String myPodcast(Model theModel) {
		
		return "library/myPodcast";
	}
	

}
