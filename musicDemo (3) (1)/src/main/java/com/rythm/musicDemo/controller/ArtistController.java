package com.rythm.musicDemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rythm.musicDemo.dao.ArtistRepository;
import com.rythm.musicDemo.entity.Artist;

@Controller
@RequestMapping("artists")
public class ArtistController {
	
	private ArtistRepository artistRepository;
	@Autowired
	public ArtistController(ArtistRepository artistRepository) {
		this.artistRepository = artistRepository;
	}
	
	@GetMapping("/list")
	public String listArtists(Model theModel) {
		// add to the spring model
		List<Artist> theArtists = artistRepository.findAll();
		theModel.addAttribute("artists", theArtists);
		System.out.println(theArtists);
		return "artists/list-artists";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Artist theArtist = new Artist();
		theModel.addAttribute("artist", theArtist);
		return "artists/artist-form";
	}

	@PostMapping("/save")
	public String saveArtist(@ModelAttribute("artist") Artist theArtist) {
		// save the employee
		artistRepository.save(theArtist);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/artists/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int id, Model theModel) {
		// get the employee for the service
		Optional<Artist> theArtist = artistRepository.findById(id);

		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("artist", theArtist);

		// send over to our form
		return "artists/artist-form";

	}

	@GetMapping("/delete")
	public String delete(@RequestParam("id") int theId) {
		// delete the employee
		artistRepository.deleteById(theId);

		// redirect to /user/list
		return "redirect:/artists/list";
	}


}
