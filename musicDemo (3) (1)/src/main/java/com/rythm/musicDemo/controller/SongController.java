package com.rythm.musicDemo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.rythm.musicDemo.entity.Track;
import com.rythm.musicDemo.service.StreamingService;
import com.rythm.musicDemo.service.TrackService;

import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/songs")
public class SongController {

	private TrackService trackService;
	private StreamingService service;
	private static final String PATH = "/musicFileSystem";
	private static final Path ROOT = Paths.get("/home/satya/ACAD/PLAC/spring-dev/musicDemo/src/main/resources/musicFileSystem");
	

	@Autowired
	public SongController(TrackService trackService, StreamingService service) {
		this.trackService = trackService;
		System.out.println("Inside SongController constructor");
		this.service = service;
	}

	@GetMapping("/list")
	public String listTracks(Model theModel) {
		// add to the spring model
		List<Track> theTracks = trackService.findAll();
		theModel.addAttribute("tracks", theTracks);

		return "tracks/list-tracks";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Track theTrack = new Track();
		theModel.addAttribute("track", theTrack);
		return "tracks/track-form";
	}

	@PostMapping("/save")
	public String saveTrack(@ModelAttribute("track") Track theTrack, @RequestParam("trackFile") MultipartFile file)
			throws IllegalStateException, IOException {
		// save the employee
		System.out.println("INSIDE SAVE TRACK########");
		String dir = System.getProperty("user.dir");

		// directory from where the program was launched
		// e.g /home/mkyong/projects/core-java/java-io
		System.out.println(dir);
		
//		file.transferTo(new File(PATH + file.getOriginalFilename()));
		Files.copy(file.getInputStream(), ROOT.resolve(file.getOriginalFilename()));
		theTrack.setTrackPath(file.getOriginalFilename().replace(".mp3", ""));
		trackService.save(theTrack);
		// use a redirect to prevent duplicate submissions
		return "redirect:/tracks/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int id, Model theModel) {
		// get the employee for the service
		Track theTrack = trackService.findTrackById(id);

		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("track", theTrack);

		// send over to our form
		return "tracks/track-form";

	}

	@GetMapping("/delete")
	public String delete(@RequestParam("id") int theId) {
		// delete the employee
		trackService.deleteById(theId);

		// redirect to /user/list
		return "redirect:/songs/list";
	}
	
	@GetMapping("/home")
	public String home(Model theModel) {
		// delete the employee
//		trackService.deleteById(theId);

		// redirect to /user/list
		return "redirect:/";
	}
	

//	@GetMapping("/download/{fileName}")
//	public ResponseEntity<byte[]> downloadImage(@PathVariable String fileName) throws IOException {
//		byte[] image = productImageService.downloadImage(fileName);
//		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
//	}
	
//	@GetMapping("/datetime")
//	public ModelAndView getCurrentDateAndTime() {
//		ModelAndView mav = new ModelAndView("home");
//		mav.addObject("currentDateAndTime", new Date());
//		return mav;
//	}

	@GetMapping(value = "audio/{title}", produces = "audio/mpeg")
	public Mono<Resource> getAudios(@PathVariable String title, @RequestHeader("Range") String range) {
		System.out.println("Inside song controller wala :range in bytes() : " + range);
		return service.getAudio(title);
	}

}
