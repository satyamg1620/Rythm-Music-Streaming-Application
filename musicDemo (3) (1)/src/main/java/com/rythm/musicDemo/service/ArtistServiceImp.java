package com.rythm.musicDemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rythm.musicDemo.custom.FollowingsCount;
import com.rythm.musicDemo.dao.ArtistDAO;
import com.rythm.musicDemo.dao.FollowerRepository;
import com.rythm.musicDemo.entity.Artist;

@Service
public class ArtistServiceImp implements ArtistService {

	private ArtistDAO artistDAO;
	private FollowerRepository followerRepository;
	
	@Autowired
	public ArtistServiceImp(ArtistDAO artistDAO, FollowerRepository followerRepository) {
		super();
		this.artistDAO = artistDAO;
		this.followerRepository = followerRepository;
	}

	@Override
	public List<Artist> findAll() {
		// TODO Auto-generated method stub
		return artistDAO.findAll();
	}

	@Override
	public Artist findById(int theId) {
		// TODO Auto-generated method stub
		return artistDAO.findArtistById(theId);
	}

	@Override
	public void save(Artist theArtist) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<FollowingsCount> countTotalFollowersByIdArtistId() {
		List<Object[]> followersByArtistId = followerRepository.countTotalFollowersByIdArtistId();
		List<FollowingsCount> followingsByArtistId = new ArrayList<>();
		followersByArtistId.forEach(following ->{
			FollowingsCount fc = new FollowingsCount(Integer.valueOf(following[0]+""), Integer.valueOf(following[1]+""));
			followingsByArtistId.add(fc);
		});
		return followingsByArtistId;
	}

}
