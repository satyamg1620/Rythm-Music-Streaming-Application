package com.rythm.musicDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class StreamingService {

	private static final String FORMAT = "classpath:musicFileSystem/%s.mp3";

	private ResourceLoader resourceLoader;

	@Autowired
	public StreamingService(ResourceLoader resourceLoader) {
		System.out.println("Inside StreamingService constructor");
		this.resourceLoader = resourceLoader;

	}

	public Mono<Resource> getAudio(String title) {
		Mono<Resource> a = Mono.fromSupplier(() -> resourceLoader.getResource(String.format(FORMAT, title)));
		System.out.println("Mono<Resource>" + a);
		return a;
	}
}
