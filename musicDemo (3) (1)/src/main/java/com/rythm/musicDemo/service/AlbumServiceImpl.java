package com.rythm.musicDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rythm.musicDemo.dao.AlbumDAO;
import com.rythm.musicDemo.entity.Album;
@Service
public class AlbumServiceImpl implements AlbumService {
	
	private AlbumDAO albumDAO;
	@Autowired
	public AlbumServiceImpl(AlbumDAO albumDAO) {
		this.albumDAO = albumDAO;
	}
	
	
	@Override
	public void save(Album theAlbum) {
		// TODO Auto-generated method stub

	}

	@Override
	public Album findAlbumById(int theId) {
		// TODO Auto-generated method stub
		return albumDAO.findAlbumById(theId);
	}

	@Override
	public List<Album> findAll() {
		// TODO Auto-generated method stub
		return albumDAO.findAll();
	}

}
