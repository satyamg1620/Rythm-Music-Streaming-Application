package com.rythm.musicDemo.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rythm.musicDemo.service.StreamingService;

import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/streaming")
public class StreamingRestController {
	
	
    private StreamingService service;
    @Autowired
	public StreamingRestController(StreamingService service) {
		System.out.println("Inside StreamingController constructor");
		this.service = service;
	}
	
	@GetMapping(value = "audio/{title}", produces = "audio/mpeg")
    public Mono<Resource> getAudios(@PathVariable String title, @RequestHeader("Range") String range) {
        System.out.println("range in bytes() : " + range);
        return service.getAudio(title);
    }

}
